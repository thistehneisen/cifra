package okhttp3.internal.publicsuffix;

import i.a.d.e;
import j.A;
import j.h;
import j.m;
import j.r;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f10687a = {42};

    /* renamed from: b reason: collision with root package name */
    private static final String[] f10688b = new String[0];

    /* renamed from: c reason: collision with root package name */
    private static final String[] f10689c = {"*"};

    /* renamed from: d reason: collision with root package name */
    private static final PublicSuffixDatabase f10690d = new PublicSuffixDatabase();

    /* renamed from: e reason: collision with root package name */
    private final AtomicBoolean f10691e = new AtomicBoolean(false);

    /* renamed from: f reason: collision with root package name */
    private final CountDownLatch f10692f = new CountDownLatch(1);

    /* renamed from: g reason: collision with root package name */
    private byte[] f10693g;

    /* renamed from: h reason: collision with root package name */
    private byte[] f10694h;

    public static PublicSuffixDatabase a() {
        return f10690d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r1 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        r0.close();
     */
    private void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(io.intercom.okhttp3.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            h a2 = r.a((A) new m(r.a(resourceAsStream)));
            byte[] bArr = new byte[a2.readInt()];
            a2.readFully(bArr);
            byte[] bArr2 = new byte[a2.readInt()];
            a2.readFully(bArr2);
            if (a2 != null) {
                a2.close();
            }
            synchronized (this) {
                this.f10693g = bArr;
                this.f10694h = bArr2;
            }
            this.f10692f.countDown();
            return;
        }
        return;
        throw th;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0025 */
    private void c() {
        boolean z;
        z = false;
        while (true) {
            try {
                b();
            } catch (InterruptedIOException ) {
                Thread.interrupted();
                z = true;
            } catch (IOException e2) {
                e.a().a(5, "Failed to read public suffix list", (Throwable) e2);
                if (z) {
                    Thread.currentThread().interrupt();
                }
                return;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
            Thread.interrupted();
            z = true;
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public String a(String str) {
        int i2;
        int i3;
        if (str != null) {
            String str2 = "\\.";
            String[] split = IDN.toUnicode(str).split(str2);
            String[] a2 = a(split);
            if (split.length == a2.length && a2[0].charAt(0) != '!') {
                return null;
            }
            if (a2[0].charAt(0) == '!') {
                i3 = split.length;
                i2 = a2.length;
            } else {
                i3 = split.length;
                i2 = a2.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split(str2);
            for (int i4 = i3 - i2; i4 < split2.length; i4++) {
                sb.append(split2[i4]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b  */
    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        int i2 = 0;
        if (this.f10691e.get() || !this.f10691e.compareAndSet(false, true)) {
            try {
                this.f10692f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            c();
        }
        synchronized (this) {
            if (this.f10693g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            bArr[i3] = strArr[i3].getBytes(StandardCharsets.UTF_8);
        }
        int i4 = 0;
        while (true) {
            if (i4 >= bArr.length) {
                str = null;
                break;
            }
            str = a(this.f10693g, bArr, i4);
            if (str != null) {
                break;
            }
            i4++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i5 = 0;
            while (true) {
                if (i5 >= bArr2.length - 1) {
                    break;
                }
                bArr2[i5] = f10687a;
                str2 = a(this.f10693g, bArr2, i5);
                if (str2 != null) {
                    break;
                }
                i5++;
            }
        }
        str2 = null;
        if (str2 != null) {
            while (true) {
                if (i2 >= bArr.length - 1) {
                    break;
                }
                str3 = a(this.f10694h, bArr, i2);
                if (str3 != null) {
                    break;
                }
                i2++;
            }
            if (str3 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("!");
                sb.append(str3);
                return sb.toString().split("\\.");
            } else if (str == null && str2 == null) {
                return f10689c;
            } else {
                if (str != null) {
                    strArr2 = str.split("\\.");
                } else {
                    strArr2 = f10688b;
                }
                if (str2 != null) {
                    strArr3 = str2.split("\\.");
                } else {
                    strArr3 = f10688b;
                }
                if (strArr2.length <= strArr3.length) {
                    strArr2 = strArr3;
                }
                return strArr2;
            }
        }
        str3 = null;
        if (str3 == null) {
        }
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        byte b2;
        int i4;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr3[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i3 = i7 + i8;
                if (bArr3[i3] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i3 - i7;
            int i10 = i2;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    b2 = 46;
                } else {
                    b2 = bArr4[i10][i11] & 255;
                }
                i4 = b2 - (bArr3[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr4[i10].length == i11) {
                        if (i10 == bArr4.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr4[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr3, i7, i9, StandardCharsets.UTF_8);
                        }
                    }
                }
                i5 = i3 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }
}
