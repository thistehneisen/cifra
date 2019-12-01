package io.intercom.okhttp3.internal.ws;

import e.a.b.h;
import e.a.b.i;
import e.a.b.j;
import io.intercom.okhttp3.Call;
import io.intercom.okhttp3.Callback;
import io.intercom.okhttp3.EventListener;
import io.intercom.okhttp3.OkHttpClient;
import io.intercom.okhttp3.Protocol;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.WebSocket;
import io.intercom.okhttp3.WebSocketListener;
import io.intercom.okhttp3.internal.Internal;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.connection.StreamAllocation;
import io.intercom.okhttp3.internal.ws.WebSocketReader.FrameCallback;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class RealWebSocket implements WebSocket, FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<j> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final j reason;

        Close(int i2, j jVar, long j2) {
            this.code = i2;
            this.reason = jVar;
            this.cancelAfterCloseMillis = j2;
        }
    }

    static final class Message {
        final j data;
        final int formatOpcode;

        Message(int i2, j jVar) {
            this.formatOpcode = i2;
            this.data = jVar;
        }
    }

    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final h sink;
        public final i source;

        public Streams(boolean z, i iVar, h hVar) {
            this.client = z;
            this.source = iVar;
            this.sink = hVar;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random2, long j2) {
        if ("GET".equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random2;
            this.pingIntervalMillis = j2;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            this.key = j.a(bArr).a();
            this.writerRunnable = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (IOException e2) {
                            RealWebSocket.this.failWebSocket(e2, null);
                            return;
                        }
                    } while (RealWebSocket.this.writeOneFrame());
                }
            };
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Request must be GET: ");
        sb.append(request.method());
        throw new IllegalArgumentException(sb.toString());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    /* access modifiers changed from: 0000 */
    public void awaitTermination(int i2, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination((long) i2, timeUnit);
    }

    public void cancel() {
        this.call.cancel();
    }

    /* access modifiers changed from: 0000 */
    public void checkResponse(Response response) throws ProtocolException {
        String str = "'";
        if (response.code() == 101) {
            String header = response.header("Connection");
            String str2 = "Upgrade";
            if (str2.equalsIgnoreCase(header)) {
                String header2 = response.header(str2);
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.key);
                    sb.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
                    String a2 = j.c(sb.toString()).d().a();
                    if (!a2.equals(header3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected 'Sec-WebSocket-Accept' header value '");
                        sb2.append(a2);
                        sb2.append("' but was '");
                        sb2.append(header3);
                        sb2.append(str);
                        throw new ProtocolException(sb2.toString());
                    }
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Expected 'Upgrade' header value 'websocket' but was '");
                sb3.append(header2);
                sb3.append(str);
                throw new ProtocolException(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Expected 'Connection' header value 'Upgrade' but was '");
            sb4.append(header);
            sb4.append(str);
            throw new ProtocolException(sb4.toString());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Expected HTTP 101 response but was '");
        sb5.append(response.code());
        sb5.append(" ");
        sb5.append(response.message());
        sb5.append(str);
        throw new ProtocolException(sb5.toString());
    }

    public boolean close(int i2, String str) {
        return close(i2, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        String str = "Upgrade";
        final Request build2 = this.originalRequest.newBuilder().header(str, "websocket").header("Connection", str).header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        this.call = Internal.instance.newWebSocketCall(build, build2);
        this.call.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.listener.onOpen(RealWebSocket.this, response);
                        StringBuilder sb = new StringBuilder();
                        sb.append("OkHttp WebSocket ");
                        sb.append(build2.url().redact());
                        RealWebSocket.this.initReaderAndWriter(sb.toString(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e2) {
                        RealWebSocket.this.failWebSocket(e2, null);
                    }
                } catch (ProtocolException e3) {
                    RealWebSocket.this.failWebSocket(e3, response);
                    Util.closeQuietly((Closeable) response);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.listener.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        io.intercom.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r4;
     */
    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            if (!this.failed) {
                this.failed = true;
                Streams streams2 = this.streams;
                this.streams = null;
                if (this.cancelFuture != null) {
                    this.cancelFuture.cancel(false);
                }
                if (this.executor != null) {
                    this.executor.shutdown();
                }
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams2) throws IOException {
        synchronized (this) {
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.client, streams2.sink, this.random);
            this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            if (this.pingIntervalMillis != 0) {
                this.executor.scheduleAtFixedRate(new PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams2.client, streams2.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    public void onReadClose(int i2, String str) {
        Closeable closeable;
        if (i2 != -1) {
            synchronized (this) {
                if (this.receivedCloseCode == -1) {
                    this.receivedCloseCode = i2;
                    this.receivedCloseReason = str;
                    if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                        closeable = null;
                    } else {
                        closeable = this.streams;
                        this.streams = null;
                        if (this.cancelFuture != null) {
                            this.cancelFuture.cancel(false);
                        }
                        this.executor.shutdown();
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.listener.onClosing(this, i2, str);
                if (closeable != null) {
                    this.listener.onClosed(this, i2, str);
                }
            } finally {
                Util.closeQuietly(closeable);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage((WebSocket) this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    public synchronized void onReadPing(j jVar) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(jVar);
                runWriter();
                this.receivedPingCount++;
            }
        }
    }

    public synchronized void onReadPong(j jVar) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean pong(j jVar) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(jVar);
                runWriter();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean processNextFrame() throws IOException {
        boolean z = false;
        try {
            this.reader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            failWebSocket(e2, null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    /* access modifiers changed from: 0000 */
    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    /* access modifiers changed from: 0000 */
    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public Request request() {
        return this.originalRequest;
    }

    public boolean send(String str) {
        if (str != null) {
            return send(j.c(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    /* access modifiers changed from: 0000 */
    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    /* access modifiers changed from: 0000 */
    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r2 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if ((r5 instanceof io.intercom.okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        r1 = ((io.intercom.okhttp3.internal.ws.RealWebSocket.Message) r5).data;
        r0 = e.a.b.t.a(r0.newMessageSink(((io.intercom.okhttp3.internal.ws.RealWebSocket.Message) r5).formatOpcode, (long) r1.size()));
        r0.a(r1);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r11.queueSize -= (long) r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        if ((r5 instanceof io.intercom.okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        r5 = (io.intercom.okhttp3.internal.ws.RealWebSocket.Close) r5;
        r0.writeClose(r5.code, r5.reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0093, code lost:
        if (r4 == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0095, code lost:
        r11.listener.onClosed(r11, r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
        io.intercom.okhttp3.internal.Util.closeQuietly(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a6, code lost:
        io.intercom.okhttp3.internal.Util.closeQuietly(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a9, code lost:
        throw r0;
     */
    public boolean writeOneFrame() throws IOException {
        String str;
        Object obj;
        int i2;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            j jVar = (j) this.pongQueue.poll();
            Closeable closeable = null;
            if (jVar == null) {
                obj = this.messageAndCloseQueue.poll();
                if (obj instanceof Close) {
                    i2 = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i2 != -1) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                        closeable = streams2;
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) obj).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                } else {
                    str = null;
                }
            } else {
                obj = null;
                str = null;
            }
            i2 = -1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1 == -1) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("sent ping but didn't receive pong within ");
        r2.append(r7.pingIntervalMillis);
        r2.append("ms (after ");
        r2.append(r1 - 1);
        r2.append(" successful ping/pongs)");
        failWebSocket(new java.net.SocketTimeoutException(r2.toString()), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.writePing(e.a.b.j.f7892b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        failWebSocket(r0, null);
     */
    public void writePingFrame() {
        synchronized (this) {
            if (!this.failed) {
                WebSocketWriter webSocketWriter = this.writer;
                int i2 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean close(int i2, String str, long j2) {
        WebSocketProtocol.validateCloseCode(i2);
        j jVar = null;
        if (str != null) {
            jVar = j.c(str);
            if (((long) jVar.size()) > 123) {
                StringBuilder sb = new StringBuilder();
                sb.append("reason.size() > 123: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (!this.failed) {
            if (!this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i2, jVar, j2));
                runWriter();
                return true;
            }
        }
        return false;
    }

    public void onReadMessage(j jVar) throws IOException {
        this.listener.onMessage((WebSocket) this, jVar);
    }

    public boolean send(j jVar) {
        if (jVar != null) {
            return send(jVar, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    private synchronized boolean send(j jVar, int i2) {
        if (!this.failed) {
            if (!this.enqueuedClose) {
                if (this.queueSize + ((long) jVar.size()) > MAX_QUEUE_SIZE) {
                    close(1001, null);
                    return false;
                }
                this.queueSize += (long) jVar.size();
                this.messageAndCloseQueue.add(new Message(i2, jVar));
                runWriter();
                return true;
            }
        }
    }
}
