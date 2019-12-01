package io.intercom.okhttp3.internal.publicsuffix;

import e.a.b.B;
import e.a.b.i;
import e.a.b.n;
import e.a.b.t;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.platform.Platform;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublicSuffixDatabase {
    private static final String[] EMPTY_RULE = new String[0];
    private static final byte EXCEPTION_MARKER = 33;
    private static final String[] PREVAILING_RULE = {"*"};
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {42};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i2) {
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
                            return new String(bArr3, i7, i9, Util.UTF_8);
                        }
                    }
                }
                i5 = i3 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009b  */
    private String[] findMatchingRule(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        int i2 = 0;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            bArr[i3] = strArr[i3].getBytes(Util.UTF_8);
        }
        int i4 = 0;
        while (true) {
            if (i4 >= bArr.length) {
                str = null;
                break;
            }
            str = binarySearchBytes(this.publicSuffixListBytes, bArr, i4);
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
                bArr2[i5] = WILDCARD_LABEL;
                str2 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i5);
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
                str3 = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i2);
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
                return PREVAILING_RULE;
            } else {
                if (str != null) {
                    strArr2 = str.split("\\.");
                } else {
                    strArr2 = EMPTY_RULE;
                }
                if (str2 != null) {
                    strArr3 = str2.split("\\.");
                } else {
                    strArr3 = EMPTY_RULE;
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

    public static PublicSuffixDatabase get() {
        return instance;
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            i a2 = t.a((B) new n(t.a(resourceAsStream)));
            try {
                byte[] bArr = new byte[a2.readInt()];
                a2.readFully(bArr);
                byte[] bArr2 = new byte[a2.readInt()];
                a2.readFully(bArr2);
                synchronized (this) {
                    this.publicSuffixListBytes = bArr;
                    this.publicSuffixExceptionListBytes = bArr2;
                }
                this.readCompleteLatch.countDown();
            } finally {
                Util.closeQuietly((Closeable) a2);
            }
        }
    }

    private void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                readTheList();
                break;
            } catch (InterruptedIOException unused) {
                z = true;
            } catch (IOException e2) {
                Platform.get().log(5, "Failed to read public suffix list", e2);
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
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public String getEffectiveTldPlusOne(String str) {
        int i2;
        int i3;
        if (str != null) {
            String str2 = "\\.";
            String[] split = IDN.toUnicode(str).split(str2);
            String[] findMatchingRule = findMatchingRule(split);
            if (split.length == findMatchingRule.length && findMatchingRule[0].charAt(0) != '!') {
                return null;
            }
            if (findMatchingRule[0].charAt(0) == '!') {
                i3 = split.length;
                i2 = findMatchingRule.length;
            } else {
                i3 = split.length;
                i2 = findMatchingRule.length + 1;
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

    /* access modifiers changed from: 0000 */
    public void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
