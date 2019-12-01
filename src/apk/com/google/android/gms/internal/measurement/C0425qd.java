package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.google.android.gms.internal.measurement.qd reason: case insensitive filesystem */
public final class C0425qd {

    /* renamed from: a reason: collision with root package name */
    private final ByteBuffer f5342a;

    /* renamed from: b reason: collision with root package name */
    private zzee f5343b;

    /* renamed from: c reason: collision with root package name */
    private int f5344c;

    private C0425qd(byte[] bArr, int i2, int i3) {
        this(ByteBuffer.wrap(bArr, 0, i3));
    }

    public static C0425qd a(byte[] bArr) {
        return new C0425qd(bArr, 0, bArr.length);
    }

    public static int c(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int c(int i2, int i3) {
        return a(i2) + b(i3);
    }

    private final void e(int i2) throws IOException {
        byte b2 = (byte) i2;
        if (this.f5342a.hasRemaining()) {
            this.f5342a.put(b2);
            return;
        }
        throw new zzin(this.f5342a.position(), this.f5342a.limit());
    }

    public final void b(int i2, int i3) throws IOException {
        a(i2, 0);
        if (i3 >= 0) {
            d(i3);
        } else {
            a((long) i3);
        }
    }

    public final void d(int i2) throws IOException {
        while ((i2 & -128) != 0) {
            e((i2 & 127) | 128);
            i2 >>>= 7;
        }
        e(i2);
    }

    private C0425qd(ByteBuffer byteBuffer) {
        this.f5342a = byteBuffer;
        this.f5342a.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static C0425qd a(byte[] bArr, int i2, int i3) {
        return new C0425qd(bArr, 0, i3);
    }

    public static int b(int i2, String str) {
        int a2 = a(i2);
        int a3 = a((CharSequence) str);
        return a2 + c(a3) + a3;
    }

    public final void a(int i2, boolean z) throws IOException {
        a(i2, 0);
        byte b2 = z ? (byte) 1 : 0;
        if (this.f5342a.hasRemaining()) {
            this.f5342a.put(b2);
            return;
        }
        throw new zzin(this.f5342a.position(), this.f5342a.limit());
    }

    public static int b(int i2, C0466xd xdVar) {
        int a2 = a(i2);
        int b2 = xdVar.b();
        return a2 + c(b2) + b2;
    }

    public final void a(int i2, String str) throws IOException {
        a(i2, 2);
        try {
            int c2 = c(str.length());
            if (c2 == c(str.length() * 3)) {
                int position = this.f5342a.position();
                if (this.f5342a.remaining() >= c2) {
                    this.f5342a.position(position + c2);
                    a((CharSequence) str, this.f5342a);
                    int position2 = this.f5342a.position();
                    this.f5342a.position(position);
                    d((position2 - position) - c2);
                    this.f5342a.position(position2);
                    return;
                }
                throw new zzin(position + c2, this.f5342a.limit());
            }
            d(a((CharSequence) str));
            a((CharSequence) str, this.f5342a);
        } catch (BufferOverflowException e2) {
            zzin zzin = new zzin(this.f5342a.position(), this.f5342a.limit());
            zzin.initCause(e2);
            throw zzin;
        }
    }

    public static int b(int i2) {
        if (i2 >= 0) {
            return c(i2);
        }
        return 10;
    }

    public final void b(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f5342a.remaining() >= length) {
            this.f5342a.put(bArr, 0, length);
            return;
        }
        throw new zzin(this.f5342a.position(), this.f5342a.limit());
    }

    public final void a(int i2, C0466xd xdVar) throws IOException {
        a(i2, 2);
        if (xdVar.f5419a < 0) {
            xdVar.b();
        }
        d(xdVar.f5419a);
        xdVar.a(this);
    }

    public final void a(int i2, C0400mc mcVar) throws IOException {
        if (this.f5343b == null) {
            this.f5343b = zzee.a(this.f5342a);
            this.f5344c = this.f5342a.position();
        } else if (this.f5344c != this.f5342a.position()) {
            this.f5343b.b(this.f5342a.array(), this.f5344c, this.f5342a.position() - this.f5344c);
            this.f5344c = this.f5342a.position();
        }
        zzee zzee = this.f5343b;
        zzee.a(i2, mcVar);
        zzee.a();
        this.f5344c = this.f5342a.position();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) >= 65536) {
                                i3++;
                            } else {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i3);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = ((long) i4) + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        if (!byteBuffer.isReadOnly()) {
            String str = "Unpaired surrogate at index ";
            int i4 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i5 = remaining + arrayOffset;
                    while (i4 < length) {
                        int i6 = i4 + arrayOffset;
                        if (i6 >= i5) {
                            break;
                        }
                        char charAt = charSequence.charAt(i4);
                        if (charAt >= 128) {
                            break;
                        }
                        array[i6] = (byte) charAt;
                        i4++;
                    }
                    if (i4 == length) {
                        i2 = arrayOffset + length;
                    } else {
                        i2 = arrayOffset + i4;
                        while (i4 < length) {
                            char charAt2 = charSequence.charAt(i4);
                            if (charAt2 < 128 && i2 < i5) {
                                i3 = i2 + 1;
                                array[i2] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i2 <= i5 - 2) {
                                int i7 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 6) | 960);
                                i2 = i7 + 1;
                                array[i7] = (byte) ((charAt2 & '?') | 128);
                                i4++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i2 <= i5 - 3) {
                                int i8 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 12) | 480);
                                int i9 = i8 + 1;
                                array[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i3 = i9 + 1;
                                array[i9] = (byte) ((charAt2 & '?') | 128);
                            } else if (i2 <= i5 - 4) {
                                int i10 = i4 + 1;
                                if (i10 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i11 = i2 + 1;
                                        array[i2] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        array[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i2 = i13 + 1;
                                        array[i13] = (byte) ((codePoint & 63) | 128);
                                        i4 = i10;
                                        i4++;
                                    } else {
                                        i4 = i10;
                                    }
                                }
                                int i14 = i4 - 1;
                                StringBuilder sb = new StringBuilder(39);
                                sb.append(str);
                                sb.append(i14);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i2);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i2 = i3;
                            i4++;
                        }
                    }
                    byteBuffer.position(i2 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e2) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e2);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    if (charAt4 < 128) {
                        byteBuffer.put((byte) charAt4);
                    } else if (charAt4 < 2048) {
                        byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else if (charAt4 < 55296 || 57343 < charAt4) {
                        byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                        byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else {
                        int i15 = i4 + 1;
                        if (i15 != charSequence.length()) {
                            char charAt5 = charSequence.charAt(i15);
                            if (Character.isSurrogatePair(charAt4, charAt5)) {
                                int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                i4 = i15;
                            } else {
                                i4 = i15;
                            }
                        }
                        int i16 = i4 - 1;
                        StringBuilder sb3 = new StringBuilder(39);
                        sb3.append(str);
                        sb3.append(i16);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    i4++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public final void a(int i2, int i3) throws IOException {
        d((i2 << 3) | i3);
    }

    public static int a(int i2) {
        return c(i2 << 3);
    }

    public final void a(long j2) throws IOException {
        while ((-128 & j2) != 0) {
            e((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        e((int) j2);
    }
}
