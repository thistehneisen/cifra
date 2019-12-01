package io.intercom.okhttp3.internal.http2;

import e.a.b.g;
import e.a.b.h;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import io.intercom.okhttp3.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final g hpackBuffer = new g();
    final Writer hpackWriter = new Writer(this.hpackBuffer);
    private int maxFrameSize = 16384;
    private final h sink;

    Http2Writer(h hVar, boolean z) {
        this.sink = hVar;
        this.client = z;
    }

    private void writeContinuationFrames(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j2);
            long j3 = (long) min;
            j2 -= j3;
            frameHeader(i2, min, 9, j2 == 0 ? (byte) 4 : 0);
            this.sink.write(this.hpackBuffer, j3);
        }
    }

    private static void writeMedium(h hVar, int i2) throws IOException {
        hVar.writeByte((i2 >>> 16) & 255);
        hVar.writeByte((i2 >>> 8) & 255);
        hVar.writeByte(i2 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException(Action.CLOSED);
        } else if (this.client) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.b()));
            }
            this.sink.write(Http2.CONNECTION_PREFACE.g());
            this.sink.flush();
        }
    }

    public synchronized void data(boolean z, int i2, g gVar, int i3) throws IOException {
        if (!this.closed) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            dataFrame(i2, b2, gVar, i3);
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    /* access modifiers changed from: 0000 */
    public void dataFrame(int i2, byte b2, g gVar, int i3) throws IOException {
        frameHeader(i2, i3, 0, b2);
        if (i3 > 0) {
            this.sink.write(gVar, (long) i3);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public void frameHeader(int i2, int i3, byte b2, byte b3) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i2, i3, b2, b3));
        }
        int i4 = this.maxFrameSize;
        if (i3 > i4) {
            Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            writeMedium(this.sink, i3);
            this.sink.writeByte(b2 & 255);
            this.sink.writeByte(b3 & 255);
            this.sink.writeInt(i2 & Integer.MAX_VALUE);
        } else {
            Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    public synchronized void goAway(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IOException(Action.CLOSED);
        } else if (errorCode.httpCode != -1) {
            frameHeader(0, bArr.length + 8, 7, 0);
            this.sink.writeInt(i2);
            this.sink.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        } else {
            Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    public synchronized void headers(int i2, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(false, i2, list);
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z, int i2, int i3) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, 6, z ? (byte) 1 : 0);
            this.sink.writeInt(i2);
            this.sink.writeInt(i3);
            this.sink.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void pushPromise(int i2, int i3, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min((long) (this.maxFrameSize - 4), size);
            long j2 = (long) min;
            int i4 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
            frameHeader(i2, min + 4, 5, i4 == 0 ? (byte) 4 : 0);
            this.sink.writeInt(i3 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j2);
            if (i4 > 0) {
                writeContinuationFrames(i2, size - j2);
            }
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException(Action.CLOSED);
        } else if (errorCode.httpCode != -1) {
            frameHeader(i2, 4, 3, 0);
            this.sink.writeInt(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        if (!this.closed) {
            int i2 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i2 < 10) {
                if (settings.isSet(i2)) {
                    int i3 = i2 == 4 ? 3 : i2 == 7 ? 4 : i2;
                    this.sink.writeShort(i3);
                    this.sink.writeInt(settings.get(i2));
                }
                i2++;
            }
            this.sink.flush();
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void synReply(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z, i2, list);
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void synStream(boolean z, int i2, int i3, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z, i2, list);
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    public synchronized void windowUpdate(int i2, long j2) throws IOException {
        if (this.closed) {
            throw new IOException(Action.CLOSED);
        } else if (j2 == 0 || j2 > 2147483647L) {
            Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
            throw null;
        } else {
            frameHeader(i2, 4, 8, 0);
            this.sink.writeInt((int) j2);
            this.sink.flush();
        }
    }

    /* access modifiers changed from: 0000 */
    public void headers(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min((long) this.maxFrameSize, size);
            long j2 = (long) min;
            int i3 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            frameHeader(i2, min, 1, b2);
            this.sink.write(this.hpackBuffer, j2);
            if (i3 > 0) {
                writeContinuationFrames(i2, size - j2);
                return;
            }
            return;
        }
        throw new IOException(Action.CLOSED);
    }
}
