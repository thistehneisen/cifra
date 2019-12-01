package io.intercom.okhttp3.internal.ws;

import e.a.b.A;
import e.a.b.D;
import e.a.b.g;
import e.a.b.g.a;
import e.a.b.h;
import e.a.b.j;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter {
    boolean activeWriter;
    final g buffer = new g();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final a maskCursor;
    private final byte[] maskKey;
    final Random random;
    final h sink;
    final g sinkBuffer;
    boolean writerClosed;

    final class FrameSink implements A {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException(Action.CLOSED);
        }

        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException(Action.CLOSED);
        }

        public D timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void write(g gVar, long j2) throws IOException {
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(gVar, j2);
                boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.size() > this.contentLength - 8192;
                long b2 = WebSocketWriter.this.buffer.b();
                if (b2 > 0 && !z) {
                    WebSocketWriter.this.writeMessageFrame(this.formatOpcode, b2, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                return;
            }
            throw new IOException(Action.CLOSED);
        }
    }

    WebSocketWriter(boolean z, h hVar, Random random2) {
        if (hVar == null) {
            throw new NullPointerException("sink == null");
        } else if (random2 != null) {
            this.isClient = z;
            this.sink = hVar;
            this.sinkBuffer = hVar.n();
            this.random = random2;
            a aVar = null;
            this.maskKey = z ? new byte[4] : null;
            if (z) {
                aVar = new a();
            }
            this.maskCursor = aVar;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    private void writeControlFrame(int i2, j jVar) throws IOException {
        if (!this.writerClosed) {
            int size = jVar.size();
            if (((long) size) <= 125) {
                this.sinkBuffer.writeByte(i2 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long size2 = this.sinkBuffer.size();
                        this.sinkBuffer.a(jVar);
                        this.sinkBuffer.a(this.maskCursor);
                        this.maskCursor.h(size2);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.a(jVar);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException(Action.CLOSED);
    }

    /* access modifiers changed from: 0000 */
    public A newMessageSink(int i2, long j2) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink2 = this.frameSink;
            frameSink2.formatOpcode = i2;
            frameSink2.contentLength = j2;
            frameSink2.isFirstFrame = true;
            frameSink2.closed = false;
            return frameSink2;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: 0000 */
    public void writeClose(int i2, j jVar) throws IOException {
        j jVar2 = j.f7892b;
        if (!(i2 == 0 && jVar == null)) {
            if (i2 != 0) {
                WebSocketProtocol.validateCloseCode(i2);
            }
            g gVar = new g();
            gVar.writeShort(i2);
            if (jVar != null) {
                gVar.a(jVar);
            }
            jVar2 = gVar.d();
        }
        try {
            writeControlFrame(8, jVar2);
        } finally {
            this.writerClosed = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void writeMessageFrame(int i2, long j2, boolean z, boolean z2) throws IOException {
        if (!this.writerClosed) {
            int i3 = 0;
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.sinkBuffer.writeByte(i2);
            if (this.isClient) {
                i3 = 128;
            }
            if (j2 <= 125) {
                this.sinkBuffer.writeByte(((int) j2) | i3);
            } else if (j2 <= 65535) {
                this.sinkBuffer.writeByte(i3 | 126);
                this.sinkBuffer.writeShort((int) j2);
            } else {
                this.sinkBuffer.writeByte(i3 | 127);
                this.sinkBuffer.k(j2);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.write(this.maskKey);
                if (j2 > 0) {
                    long size = this.sinkBuffer.size();
                    this.sinkBuffer.write(this.buffer, j2);
                    this.sinkBuffer.a(this.maskCursor);
                    this.maskCursor.h(size);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j2);
            }
            this.sink.v();
            return;
        }
        throw new IOException(Action.CLOSED);
    }

    /* access modifiers changed from: 0000 */
    public void writePing(j jVar) throws IOException {
        writeControlFrame(9, jVar);
    }

    /* access modifiers changed from: 0000 */
    public void writePong(j jVar) throws IOException {
        writeControlFrame(10, jVar);
    }
}
