package io.intercom.com.bumptech.glide.load.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ExifOrientationStream */
public final class f extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f9450a = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: b reason: collision with root package name */
    private static final int f9451b = f9450a.length;

    /* renamed from: c reason: collision with root package name */
    private static final int f9452c = (f9451b + 2);

    /* renamed from: d reason: collision with root package name */
    private final byte f9453d;

    /* renamed from: e reason: collision with root package name */
    private int f9454e;

    public f(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot add invalid orientation: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f9453d = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    public int read() throws IOException {
        int i2;
        int i3 = this.f9454e;
        if (i3 >= 2) {
            int i4 = f9452c;
            if (i3 <= i4) {
                if (i3 == i4) {
                    i2 = this.f9453d;
                } else {
                    i2 = f9450a[i3 - 2] & 255;
                }
                if (i2 != -1) {
                    this.f9454e++;
                }
                return i2;
            }
        }
        i2 = super.read();
        if (i2 != -1) {
        }
        return i2;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.f9454e = (int) (((long) this.f9454e) + skip);
        }
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f9454e;
        int i6 = f9452c;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f9453d;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f9450a, this.f9454e - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f9454e += i4;
        }
        return i4;
    }
}
