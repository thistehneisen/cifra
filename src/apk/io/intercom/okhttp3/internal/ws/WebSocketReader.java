package io.intercom.okhttp3.internal.ws;

import e.a.b.g;
import e.a.b.g.a;
import e.a.b.i;
import e.a.b.j;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class WebSocketReader {
    boolean closed;
    private final g controlFrameBuffer = new g();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final a maskCursor;
    private final byte[] maskKey;
    private final g messageFrameBuffer = new g();
    int opcode;
    final i source;

    public interface FrameCallback {
        void onReadClose(int i2, String str);

        void onReadMessage(j jVar) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(j jVar);

        void onReadPong(j jVar);
    }

    WebSocketReader(boolean z, i iVar, FrameCallback frameCallback2) {
        byte[] bArr;
        if (iVar == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback2 != null) {
            this.isClient = z;
            this.source = iVar;
            this.frameCallback = frameCallback2;
            a aVar = null;
            if (z) {
                bArr = null;
            } else {
                bArr = new byte[4];
            }
            this.maskKey = bArr;
            if (!z) {
                aVar = new a();
            }
            this.maskCursor = aVar;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    private void readControlFrame() throws IOException {
        String str;
        long j2 = this.frameLength;
        if (j2 > 0) {
            this.source.a(this.controlFrameBuffer, j2);
            if (!this.isClient) {
                this.controlFrameBuffer.a(this.maskCursor);
                this.maskCursor.h(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                long size = this.controlFrameBuffer.size();
                if (size != 1) {
                    if (size != 0) {
                        s = this.controlFrameBuffer.readShort();
                        str = this.controlFrameBuffer.e();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.frameCallback.onReadClose(s, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.d());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.d());
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown control opcode: ");
                sb.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(sb.toString());
        }
    }

    /* JADX INFO: finally extract failed */
    private void readHeader() throws IOException {
        if (!this.closed) {
            long timeoutNanos = this.source.timeout().timeoutNanos();
            this.source.timeout().clearTimeout();
            try {
                byte readByte = this.source.readByte() & 255;
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.opcode = readByte & 15;
                boolean z = true;
                this.isFinalFrame = (readByte & 128) != 0;
                this.isControlFrame = (readByte & 8) != 0;
                if (!this.isControlFrame || this.isFinalFrame) {
                    boolean z2 = (readByte & 64) != 0;
                    boolean z3 = (readByte & 32) != 0;
                    boolean z4 = (readByte & 16) != 0;
                    if (z2 || z3 || z4) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.source.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    boolean z5 = this.isClient;
                    if (z == z5) {
                        throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    this.frameLength = (long) (readByte2 & Byte.MAX_VALUE);
                    long j2 = this.frameLength;
                    if (j2 == 126) {
                        this.frameLength = ((long) this.source.readShort()) & 65535;
                    } else if (j2 == 127) {
                        this.frameLength = this.source.readLong();
                        if (this.frameLength < 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Frame length 0x");
                            sb.append(Long.toHexString(this.frameLength));
                            sb.append(" > 0x7FFFFFFFFFFFFFFF");
                            throw new ProtocolException(sb.toString());
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.source.readFully(this.maskKey);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException(Action.CLOSED);
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j2 = this.frameLength;
            if (j2 > 0) {
                this.source.a(this.messageFrameBuffer, j2);
                if (!this.isClient) {
                    this.messageFrameBuffer.a(this.maskCursor);
                    this.maskCursor.h(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected continuation opcode. Got: ");
                    sb.append(Integer.toHexString(this.opcode));
                    throw new ProtocolException(sb.toString());
                }
            } else {
                return;
            }
        }
        throw new IOException(Action.CLOSED);
    }

    private void readMessageFrame() throws IOException {
        int i2 = this.opcode;
        if (i2 == 1 || i2 == 2) {
            readMessage();
            if (i2 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.e());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.d());
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown opcode: ");
            sb.append(Integer.toHexString(i2));
            throw new ProtocolException(sb.toString());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
