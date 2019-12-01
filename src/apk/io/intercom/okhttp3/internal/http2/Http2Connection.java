package io.intercom.okhttp3.internal.http2;

import e.a.b.g;
import e.a.b.h;
import e.a.b.i;
import e.a.b.j;
import e.a.b.t;
import io.intercom.okhttp3.Protocol;
import io.intercom.okhttp3.internal.NamedRunnable;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.platform.Platform;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor;
    /* access modifiers changed from: private */
    public boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests = new LinkedHashSet();
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings = new Settings();
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    boolean receivedInitialPeerSettings = false;
    boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final Http2Writer writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        h sink;
        Socket socket;
        i source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pingIntervalMillis(int i2) {
            this.pingIntervalMillis = i2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), t.a(t.b(socket2)), t.a(t.a(socket2)));
        }

        public Builder socket(Socket socket2, String str, i iVar, h hVar) {
            this.socket = socket2;
            this.hostname = str;
            this.source = iVar;
            this.sink = hVar;
            return this;
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i2), Integer.valueOf(i3));
            this.reply = z;
            this.payload1 = i2;
            this.payload2 = i3;
        }

        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Handler {
        final Http2Reader reader;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        private void applyAndAckSettings(final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) {
                    public void execute() {
                        try {
                            Http2Connection.this.writer.applyAndAckSettings(settings);
                        } catch (IOException unused) {
                            Http2Connection.this.failConnection();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public void ackSettings() {
        }

        public void alternateService(int i2, String str, j jVar, String str2, int i3, long j2) {
        }

        public void data(boolean z, int i2, i iVar, int i3) throws IOException {
            if (Http2Connection.this.pushedStream(i2)) {
                Http2Connection.this.pushDataLater(i2, iVar, i3, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i2);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i2, ErrorCode.PROTOCOL_ERROR);
                long j2 = (long) i3;
                Http2Connection.this.updateConnectionFlowControl(j2);
                iVar.skip(j2);
                return;
            }
            stream.receiveData(iVar, i3);
            if (z) {
                stream.receiveFin();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1 = io.intercom.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r0 = io.intercom.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r4.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001c */
        public void execute() {
            ErrorCode errorCode;
            Http2Connection http2Connection;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                errorCode2 = ErrorCode.CANCEL;
                try {
                    http2Connection = Http2Connection.this;
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                errorCode = errorCode2;
            } catch (Throwable th) {
                th = th;
                errorCode = errorCode2;
                try {
                    Http2Connection.this.close(errorCode, errorCode2);
                } catch (IOException unused3) {
                }
                Util.closeQuietly((Closeable) this.reader);
                throw th;
            }
            http2Connection.close(errorCode, errorCode2);
            Util.closeQuietly((Closeable) this.reader);
        }

        public void goAway(int i2, ErrorCode errorCode, j jVar) {
            Http2Stream[] http2StreamArr;
            jVar.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i2 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
            r0.receiveHeaders(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
            if (r10 == false) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
            return;
         */
        public void headers(boolean z, int i2, int i3, List<Header> list) {
            if (Http2Connection.this.pushedStream(i2)) {
                Http2Connection.this.pushHeadersLater(i2, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream stream = Http2Connection.this.getStream(i2);
                if (stream == null) {
                    if (!Http2Connection.this.shutdown) {
                        if (i2 > Http2Connection.this.lastGoodStreamId) {
                            if (i2 % 2 != Http2Connection.this.nextStreamId % 2) {
                                final Http2Stream http2Stream = new Http2Stream(i2, Http2Connection.this, false, z, list);
                                Http2Connection.this.lastGoodStreamId = i2;
                                Http2Connection.this.streams.put(Integer.valueOf(i2), http2Stream);
                                Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.hostname, Integer.valueOf(i2)}) {
                                    public void execute() {
                                        try {
                                            Http2Connection.this.listener.onStream(http2Stream);
                                        } catch (IOException e2) {
                                            Platform platform = Platform.get();
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Http2Connection.Listener failure for ");
                                            sb.append(Http2Connection.this.hostname);
                                            platform.log(4, sb.toString(), e2);
                                            try {
                                                http2Stream.close(ErrorCode.PROTOCOL_ERROR);
                                            } catch (IOException unused) {
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }

        public void ping(boolean z, int i2, int i3) {
            if (z) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.awaitingPong = false;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new PingRunnable(true, i2, i3));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void priority(int i2, int i3, int i4, boolean z) {
        }

        public void pushPromise(int i2, int i3, List<Header> list) {
            Http2Connection.this.pushRequestLater(i3, list);
        }

        public void rstStream(int i2, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i2)) {
                Http2Connection.this.pushResetLater(i2, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i2);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j2;
            int i2;
            synchronized (Http2Connection.this) {
                int initialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                if (z) {
                    Http2Connection.this.peerSettings.clear();
                }
                Http2Connection.this.peerSettings.merge(settings);
                applyAndAckSettings(settings);
                int initialWindowSize2 = Http2Connection.this.peerSettings.getInitialWindowSize();
                http2StreamArr = null;
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    j2 = 0;
                } else {
                    j2 = (long) (initialWindowSize2 - initialWindowSize);
                    if (!Http2Connection.this.receivedInitialPeerSettings) {
                        Http2Connection.this.receivedInitialPeerSettings = true;
                    }
                    if (!Http2Connection.this.streams.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                    }
                }
                Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.hostname) {
                    public void execute() {
                        Http2Connection http2Connection = Http2Connection.this;
                        http2Connection.listener.onSettings(http2Connection);
                    }
                });
            }
            if (http2StreamArr != null && j2 != 0) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(j2);
                    }
                }
            }
        }

        public void windowUpdate(int i2, long j2) {
            if (i2 == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.bytesLeftInWriteWindow += j2;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i2);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j2);
                }
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
        listenerExecutor = threadPoolExecutor;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        this.pushObserver = builder2.pushObserver;
        boolean z = builder2.client;
        this.client = z;
        this.listener = builder2.listener;
        this.nextStreamId = z ? 1 : 2;
        if (builder2.client) {
            this.nextStreamId += 2;
        }
        if (builder2.client) {
            this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.hostname = builder2.hostname;
        this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.hostname), false));
        if (builder2.pingIntervalMillis != 0) {
            ScheduledExecutorService scheduledExecutorService = this.writerExecutor;
            PingRunnable pingRunnable = new PingRunnable(false, 0, 0);
            int i2 = builder2.pingIntervalMillis;
            scheduledExecutorService.scheduleAtFixedRate(pingRunnable, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.hostname), true));
        this.pushExecutor = threadPoolExecutor;
        this.peerSettings.set(7, 65535);
        this.peerSettings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new Http2Writer(builder2.sink, this.client);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder2.source, this.client));
    }

    /* access modifiers changed from: private */
    public void failConnection() {
        try {
            close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitingPong) {
            wait();
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    /* access modifiers changed from: 0000 */
    public synchronized Http2Stream getStream(int i2) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i2));
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return newStream(0, list, z);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: 0000 */
    public void pushDataLater(int i2, i iVar, int i3, boolean z) throws IOException {
        final g gVar = new g();
        long j2 = (long) i3;
        iVar.e(j2);
        iVar.read(gVar, j2);
        if (gVar.size() == j2) {
            final int i4 = i2;
            final int i5 = i3;
            final boolean z2 = z;
            AnonymousClass5 r0 = new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.pushObserver.onData(i4, gVar, i5, z2);
                        if (onData) {
                            Http2Connection.this.writer.rstStream(i4, ErrorCode.CANCEL);
                        }
                        if (onData || z2) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i4));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            };
            pushExecutorExecute(r0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(gVar.size());
        sb.append(" != ");
        sb.append(i3);
        throw new IOException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void pushHeadersLater(int i2, List<Header> list, boolean z) {
        try {
            final int i3 = i2;
            final List<Header> list2 = list;
            final boolean z2 = z;
            AnonymousClass4 r0 = new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public void execute() {
                    boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(i3, list2, z2);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.writer.rstStream(i3, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z2) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                        }
                    }
                }
            };
            pushExecutorExecute(r0);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3 = r8;
        r6 = r9;
        r7 = r10;
        r2 = new io.intercom.okhttp3.internal.http2.Http2Connection.AnonymousClass3(r3, "OkHttp %s Push Request[%s]", new java.lang.Object[]{r8.hostname, java.lang.Integer.valueOf(r9)});
        pushExecutorExecute(r2);
     */
    public void pushRequestLater(int i2, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i2))) {
                writeSynResetLater(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: 0000 */
    public void pushResetLater(int i2, ErrorCode errorCode) {
        final int i3 = i2;
        final ErrorCode errorCode2 = errorCode;
        AnonymousClass6 r0 = new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i3, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                }
            }
        };
        pushExecutorExecute(r0);
    }

    public Http2Stream pushStream(int i2, List<Header> list, boolean z) throws IOException {
        if (!this.client) {
            return newStream(i2, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* access modifiers changed from: 0000 */
    public boolean pushedStream(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    /* access modifiers changed from: 0000 */
    public synchronized Http2Stream removeStream(int i2) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i2));
        notifyAll();
        return http2Stream;
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i2 = this.lastGoodStreamId;
                    this.writer.goAway(i2, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void start() throws IOException {
        start(true);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void updateConnectionFlowControl(long j2) {
        this.unacknowledgedBytesRead += j2;
        if (this.unacknowledgedBytesRead >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.bytesLeftInWriteWindow), r8.writer.maxDataLength());
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    public void writeData(int i2, boolean z, g gVar, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.writer.data(z, i2, gVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    if (this.bytesLeftInWriteWindow > 0) {
                        break;
                    } else if (this.streams.containsKey(Integer.valueOf(i2))) {
                        wait();
                    } else {
                        throw new IOException("stream closed");
                    }
                }
            }
            j2 -= j3;
            this.writer.data(z && j2 == 0, i2, gVar, min);
        }
    }

    /* access modifiers changed from: 0000 */
    public void writePing(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection();
                return;
            }
        }
        try {
            this.writer.ping(z, i2, i3);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* access modifiers changed from: 0000 */
    public void writePingAndAwaitPong() throws InterruptedException {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    /* access modifiers changed from: 0000 */
    public void writeSynReply(int i2, boolean z, List<Header> list) throws IOException {
        this.writer.synReply(z, i2, list);
    }

    /* access modifiers changed from: 0000 */
    public void writeSynReset(int i2, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i2, errorCode);
    }

    /* access modifiers changed from: 0000 */
    public void writeSynResetLater(int i2, ErrorCode errorCode) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.writerExecutor;
            final int i3 = i2;
            final ErrorCode errorCode2 = errorCode;
            AnonymousClass1 r1 = new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i3, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            };
            scheduledExecutorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    public void writeWindowUpdateLater(int i2, long j2) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.writerExecutor;
            final int i3 = i2;
            final long j3 = j2;
            AnonymousClass2 r1 = new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i3, j3);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            };
            scheduledExecutorService.execute(r1);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    private Http2Stream newStream(int i2, List<Header> list, boolean z) throws IOException {
        int i3;
        Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.writer) {
            synchronized (this) {
                if (this.nextStreamId > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (!this.shutdown) {
                    i3 = this.nextStreamId;
                    this.nextStreamId += 2;
                    http2Stream = new Http2Stream(i3, this, z3, false, list);
                    if (z && this.bytesLeftInWriteWindow != 0) {
                        if (http2Stream.bytesLeftInWriteWindow != 0) {
                            z2 = false;
                            if (http2Stream.isOpen()) {
                                this.streams.put(Integer.valueOf(i3), http2Stream);
                            }
                        }
                    }
                    z2 = true;
                    if (http2Stream.isOpen()) {
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            if (i2 == 0) {
                this.writer.synStream(z3, i3, i2, list);
            } else if (!this.client) {
                this.writer.pushPromise(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.writer.flush();
        }
        return http2Stream;
    }

    /* access modifiers changed from: 0000 */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    public void start(boolean z) throws IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - 65535));
            }
        }
        new Thread(this.readerRunnable).start();
    }
}
