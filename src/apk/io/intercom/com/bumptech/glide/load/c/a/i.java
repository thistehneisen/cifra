package io.intercom.com.bumptech.glide.load.c.a;

import android.util.Log;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.e;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser */
public final class i implements e {

    /* renamed from: a reason: collision with root package name */
    static final byte[] f9588a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b reason: collision with root package name */
    private static final int[] f9589b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser */
    private static final class a implements c {

        /* renamed from: a reason: collision with root package name */
        private final ByteBuffer f9590a;

        a(ByteBuffer byteBuffer) {
            this.f9590a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws IOException {
            return ((c() << 8) & 65280) | (c() & 255);
        }

        public short b() throws IOException {
            return (short) (c() & 255);
        }

        public int c() throws IOException {
            if (this.f9590a.remaining() < 1) {
                return -1;
            }
            return this.f9590a.get();
        }

        public long skip(long j2) throws IOException {
            int min = (int) Math.min((long) this.f9590a.remaining(), j2);
            ByteBuffer byteBuffer = this.f9590a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }

        public int a(byte[] bArr, int i2) throws IOException {
            int min = Math.min(i2, this.f9590a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f9590a.get(bArr, 0, min);
            return min;
        }
    }

    /* compiled from: DefaultImageHeaderParser */
    private static final class b {

        /* renamed from: a reason: collision with root package name */
        private final ByteBuffer f9591a;

        b(byte[] bArr, int i2) {
            this.f9591a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        /* access modifiers changed from: 0000 */
        public void a(ByteOrder byteOrder) {
            this.f9591a.order(byteOrder);
        }

        /* access modifiers changed from: 0000 */
        public int b(int i2) {
            if (a(i2, 4)) {
                return this.f9591a.getInt(i2);
            }
            return -1;
        }

        /* access modifiers changed from: 0000 */
        public int a() {
            return this.f9591a.remaining();
        }

        /* access modifiers changed from: 0000 */
        public short a(int i2) {
            if (a(i2, 2)) {
                return this.f9591a.getShort(i2);
            }
            return -1;
        }

        private boolean a(int i2, int i3) {
            return this.f9591a.remaining() - i2 >= i3;
        }
    }

    /* compiled from: DefaultImageHeaderParser */
    private interface c {
        int a() throws IOException;

        int a(byte[] bArr, int i2) throws IOException;

        short b() throws IOException;

        int c() throws IOException;

        long skip(long j2) throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser */
    private static final class d implements c {

        /* renamed from: a reason: collision with root package name */
        private final InputStream f9592a;

        d(InputStream inputStream) {
            this.f9592a = inputStream;
        }

        public int a() throws IOException {
            return ((this.f9592a.read() << 8) & 65280) | (this.f9592a.read() & 255);
        }

        public short b() throws IOException {
            return (short) (this.f9592a.read() & 255);
        }

        public int c() throws IOException {
            return this.f9592a.read();
        }

        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f9592a.skip(j3);
                if (skip <= 0) {
                    if (this.f9592a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }

        public int a(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int read = this.f9592a.read(bArr, i2 - i3, i3);
                if (read == -1) {
                    break;
                }
                i3 -= read;
            }
            return i2 - i3;
        }
    }

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private static boolean a(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private int b(c cVar) throws IOException {
        String str;
        short b2;
        int a2;
        long j2;
        long skip;
        do {
            short b3 = cVar.b();
            str = "DfltImageHeaderParser";
            if (b3 != 255) {
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append(b3);
                    Log.d(str, sb.toString());
                }
                return -1;
            }
            b2 = cVar.b();
            if (b2 == 218) {
                return -1;
            }
            if (b2 == 217) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b2 == 225) {
                return a2;
            }
            j2 = (long) a2;
            skip = cVar.skip(j2);
        } while (skip == j2);
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append(b2);
            sb2.append(", wanted to skip: ");
            sb2.append(a2);
            sb2.append(", but actually skipped: ");
            sb2.append(skip);
            Log.d(str, sb2.toString());
        }
        return -1;
    }

    public io.intercom.com.bumptech.glide.load.e.a a(InputStream inputStream) throws IOException {
        h.a(inputStream);
        return a((c) new d(inputStream));
    }

    public io.intercom.com.bumptech.glide.load.e.a a(ByteBuffer byteBuffer) throws IOException {
        h.a(byteBuffer);
        return a((c) new a(byteBuffer));
    }

    public int a(InputStream inputStream, io.intercom.com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        h.a(inputStream);
        d dVar = new d(inputStream);
        h.a(bVar);
        return a((c) dVar, bVar);
    }

    private io.intercom.com.bumptech.glide.load.e.a a(c cVar) throws IOException {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return io.intercom.com.bumptech.glide.load.e.a.JPEG;
        }
        int a3 = ((a2 << 16) & -65536) | (cVar.a() & 65535);
        if (a3 == -1991225785) {
            cVar.skip(21);
            return cVar.c() >= 3 ? io.intercom.com.bumptech.glide.load.e.a.PNG_A : io.intercom.com.bumptech.glide.load.e.a.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return io.intercom.com.bumptech.glide.load.e.a.GIF;
        } else {
            if (a3 != 1380533830) {
                return io.intercom.com.bumptech.glide.load.e.a.UNKNOWN;
            }
            cVar.skip(4);
            if ((((cVar.a() << 16) & -65536) | (cVar.a() & 65535)) != 1464156752) {
                return io.intercom.com.bumptech.glide.load.e.a.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & -65536) | (cVar.a() & 65535);
            if ((a4 & -256) != 1448097792) {
                return io.intercom.com.bumptech.glide.load.e.a.UNKNOWN;
            }
            int i2 = a4 & 255;
            if (i2 == 88) {
                cVar.skip(4);
                return (cVar.c() & 16) != 0 ? io.intercom.com.bumptech.glide.load.e.a.WEBP_A : io.intercom.com.bumptech.glide.load.e.a.WEBP;
            } else if (i2 != 76) {
                return io.intercom.com.bumptech.glide.load.e.a.WEBP;
            } else {
                cVar.skip(4);
                return (cVar.c() & 8) != 0 ? io.intercom.com.bumptech.glide.load.e.a.WEBP_A : io.intercom.com.bumptech.glide.load.e.a.WEBP;
            }
        }
    }

    private int a(c cVar, io.intercom.com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        int a2 = cVar.a();
        String str = "DfltImageHeaderParser";
        if (!a(a2)) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parser doesn't handle magic number: ");
                sb.append(a2);
                Log.d(str, sb.toString());
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.b(b2, byte[].class);
        try {
            return a(cVar, bArr, b2);
        } finally {
            bVar.put(bArr);
        }
    }

    private int a(c cVar, byte[] bArr, int i2) throws IOException {
        int a2 = cVar.a(bArr, i2);
        String str = "DfltImageHeaderParser";
        if (a2 != i2) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(i2);
                sb.append(", actually read: ");
                sb.append(a2);
                Log.d(str, sb.toString());
            }
            return -1;
        } else if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        } else {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    private boolean a(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f9588a.length;
        if (!z) {
            return z;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f9588a;
            if (i3 >= bArr2.length) {
                return z;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short a2 = bVar.a(6);
        String str = "DfltImageHeaderParser";
        if (a2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append(a2);
                Log.d(str, sb.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a(byteOrder);
        int b2 = bVar.b(10) + 6;
        short a3 = bVar.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int a4 = a(b2, i2);
            short a5 = bVar.a(a4);
            if (a5 == 274) {
                short a6 = bVar.a(a4 + 2);
                if (a6 >= 1 && a6 <= 12) {
                    int b3 = bVar.b(a4 + 4);
                    if (b3 >= 0) {
                        String str2 = " tagType=";
                        if (Log.isLoggable(str, 3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(i2);
                            sb2.append(str2);
                            sb2.append(a5);
                            sb2.append(" formatCode=");
                            sb2.append(a6);
                            sb2.append(" componentCount=");
                            sb2.append(b3);
                            Log.d(str, sb2.toString());
                        }
                        int i3 = b3 + f9589b[a6];
                        if (i3 <= 4) {
                            int i4 = a4 + 8;
                            if (i4 < 0 || i4 > bVar.a()) {
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Illegal tagValueOffset=");
                                    sb3.append(i4);
                                    sb3.append(str2);
                                    sb3.append(a5);
                                    Log.d(str, sb3.toString());
                                }
                            } else if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                return bVar.a(i4);
                            } else {
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append(a5);
                                    Log.d(str, sb4.toString());
                                }
                            }
                        } else if (Log.isLoggable(str, 3)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb5.append(a6);
                            Log.d(str, sb5.toString());
                        }
                    } else if (Log.isLoggable(str, 3)) {
                        Log.d(str, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(str, 3)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code = ");
                    sb6.append(a6);
                    Log.d(str, sb6.toString());
                }
            }
        }
        return -1;
    }
}
