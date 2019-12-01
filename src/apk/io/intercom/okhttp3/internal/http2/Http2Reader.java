package io.intercom.okhttp3.internal.http2;

import e.a.b.B;
import e.a.b.D;
import e.a.b.g;
import e.a.b.i;
import e.a.b.j;
import io.intercom.okhttp3.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation = new ContinuationSource(this.source);
    final Reader hpackReader = new Reader(CodedOutputStream.DEFAULT_BUFFER_SIZE, this.continuation);
    private final i source;

    static final class ContinuationSource implements B {
        byte flags;
        int left;
        int length;
        short padding;
        private final i source;
        int streamId;

        ContinuationSource(i iVar) {
            this.source = iVar;
        }

        private void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, readByte, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (this.streamId != i2) {
                Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        public void close() throws IOException {
        }

        public long read(g gVar, long j2) throws IOException {
            while (true) {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(gVar, Math.min(j2, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public D timeout() {
            return this.source.timeout();
        }
    }

    interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, j jVar, String str2, int i3, long j2);

        void data(boolean z, int i2, i iVar, int i3) throws IOException;

        void goAway(int i2, ErrorCode errorCode, j jVar);

        void headers(boolean z, int i2, int i3, List<Header> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i2, long j2);
    }

    Http2Reader(i iVar, boolean z) {
        this.source = iVar;
        this.client = z;
    }

    static int lengthWithoutPadding(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }

    private void readData(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.source.readByte() & 255);
                }
                handler.data(z2, i3, this.source, lengthWithoutPadding(i2, b2, s));
                this.source.skip((long) s);
                return;
            }
            Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    private void readGoAway(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i4 = i2 - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                j jVar = j.f7892b;
                if (i4 > 0) {
                    jVar = this.source.b((long) i4);
                }
                handler.goAway(readInt, fromHttp2, jVar);
                return;
            }
            Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    private List<Header> readHeaderBlock(int i2, short s, byte b2, int i3) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i2;
        continuationSource.length = i2;
        continuationSource.padding = s;
        continuationSource.flags = b2;
        continuationSource.streamId = i3;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.source.readByte() & 255);
            }
            if ((b2 & 32) != 0) {
                readPriority(handler, i3);
                i2 -= 5;
            }
            handler.headers(z, i3, -1, readHeaderBlock(lengthWithoutPadding(i2, b2, s), s, b2, i3));
            return;
        }
        Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    static int readMedium(i iVar) throws IOException {
        return (iVar.readByte() & 255) | ((iVar.readByte() & 255) << 16) | ((iVar.readByte() & 255) << 8);
    }

    private void readPing(Handler handler, int i2, byte b2, int i3) throws IOException {
        boolean z = false;
        if (i2 != 8) {
            Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            if ((b2 & 1) != 0) {
                z = true;
            }
            handler.ping(z, readInt, readInt2);
        } else {
            Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    private void readPriority(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            readPriority(handler, i3);
        } else {
            Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void readPushPromise(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.source.readByte() & 255);
            }
            handler.pushPromise(i3, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i2 - 4, b2, s), s, b2, i3));
            return;
        }
        Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    private void readRstStream(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i3, fromHttp2);
                return;
            }
            Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void readSettings(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                handler.ackSettings();
                return;
            }
            Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            throw null;
        } else if (i2 % 6 == 0) {
            Settings settings = new Settings();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short readShort = this.source.readShort() & 65535;
                int readInt = this.source.readInt();
                switch (readShort) {
                    case 2:
                        if (!(readInt == 0 || readInt == 1)) {
                            Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt >= 0) {
                            break;
                        } else {
                            Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    case 5:
                        if (readInt >= 16384 && readInt <= 16777215) {
                            break;
                        } else {
                            Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                        break;
                }
                settings.set(readShort, readInt);
            }
            handler.settings(false, settings);
        } else {
            Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        }
    }

    private void readWindowUpdate(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 == 4) {
            long readInt = ((long) this.source.readInt()) & 2147483647L;
            if (readInt != 0) {
                handler.windowUpdate(i3, readInt);
                return;
            }
            Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        throw null;
    }

    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.e(9);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
                throw null;
            }
            byte readByte = (byte) (this.source.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.source.readByte() & 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.frameLog(true, readInt, readMedium, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        readData(handler, readMedium, readByte2, readInt);
                        break;
                    case 1:
                        readHeaders(handler, readMedium, readByte2, readInt);
                        break;
                    case 2:
                        readPriority(handler, readMedium, readByte2, readInt);
                        break;
                    case 3:
                        readRstStream(handler, readMedium, readByte2, readInt);
                        break;
                    case 4:
                        readSettings(handler, readMedium, readByte2, readInt);
                        break;
                    case 5:
                        readPushPromise(handler, readMedium, readByte2, readInt);
                        break;
                    case 6:
                        readPing(handler, readMedium, readByte2, readInt);
                        break;
                    case 7:
                        readGoAway(handler, readMedium, readByte2, readInt);
                        break;
                    case 8:
                        readWindowUpdate(handler, readMedium, readByte2, readInt);
                        break;
                    default:
                        this.source.skip((long) readMedium);
                        break;
                }
                return true;
            }
            Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (!this.client) {
            j b2 = this.source.b((long) Http2.CONNECTION_PREFACE.size());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", b2.b()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(b2)) {
                Http2.ioException("Expected a connection header but was %s", b2.h());
                throw null;
            }
        } else if (!nextFrame(true, handler)) {
            Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    private void readPriority(Handler handler, int i2) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i2, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
