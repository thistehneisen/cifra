package e.a.b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString */
public class j implements Serializable, Comparable<j> {

    /* renamed from: a reason: collision with root package name */
    static final char[] f7891a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b reason: collision with root package name */
    public static final j f7892b = a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: c reason: collision with root package name */
    transient int f7893c;

    /* renamed from: d reason: collision with root package name */
    transient String f7894d;
    final byte[] data;

    j(byte[] bArr) {
        this.data = bArr;
    }

    public static j a(byte... bArr) {
        if (bArr != null) {
            return new j((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static j c(String str) {
        if (str != null) {
            j jVar = new j(str.getBytes(E.f7872a));
            jVar.f7894d = str;
            return jVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        j a2 = a((InputStream) objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = j.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.data);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public String b() {
        byte[] bArr = this.data;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f7891a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public j d() {
        return d("SHA-1");
    }

    public j e() {
        return d("SHA-256");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r6.a(0, r3, 0, r3.length) != false) goto L_0x001d;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            int size = jVar.size();
            byte[] bArr = this.data;
            if (size == bArr.length) {
            }
        }
        z = false;
        return z;
    }

    public j f() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new j(bArr2);
            }
        }
    }

    public byte[] g() {
        return (byte[]) this.data.clone();
    }

    public String h() {
        String str = this.f7894d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, E.f7872a);
        this.f7894d = str2;
        return str2;
    }

    public int hashCode() {
        int i2 = this.f7893c;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.f7893c = hashCode;
        return hashCode;
    }

    public int size() {
        return this.data.length;
    }

    public String toString() {
        String str;
        String str2;
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String h2 = h();
        int a2 = a(h2, 64);
        String str3 = "…]";
        String str4 = "[size=";
        String str5 = "]";
        if (a2 == -1) {
            if (this.data.length <= 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[hex=");
                sb.append(b());
                sb.append(str5);
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(this.data.length);
                sb2.append(" hex=");
                sb2.append(a(0, 64).b());
                sb2.append(str3);
                str2 = sb2.toString();
            }
            return str2;
        }
        String replace = h2.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a2 < h2.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append(this.data.length);
            sb3.append(" text=");
            sb3.append(replace);
            sb3.append(str3);
            str = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[text=");
            sb4.append(replace);
            sb4.append(str5);
            str = sb4.toString();
        }
        return str;
    }

    private j d(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static j a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new j(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public j c() {
        return d("MD5");
    }

    public static j b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((a(str.charAt(i3)) << 4) + a(str.charAt(i3 + 1)));
            }
            return a(bArr);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected hex string: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public String a() {
        return C0710d.a(this.data);
    }

    public static j a(String str) {
        if (str != null) {
            byte[] a2 = C0710d.a(str);
            if (a2 != null) {
                return new j(a2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected hex digit: ");
                sb.append(c2);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (c2 - c3) + 10;
    }

    public static j a(InputStream inputStream, int i2) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i2 >= 0) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i3, i2 - i3);
                if (read != -1) {
                    i3 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new j(bArr);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public byte b(int i2) {
        return this.data[i2];
    }

    public final boolean b(j jVar) {
        return a(0, jVar, 0, jVar.size());
    }

    public j a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.data;
            if (i3 <= bArr.length) {
                int i4 = i3 - i2;
                if (i4 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i2 == 0 && i3 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(this.data, i2, bArr2, 0, i4);
                    return new j(bArr2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("endIndex > length(");
                sb.append(this.data.length);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar) {
        byte[] bArr = this.data;
        gVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i2, j jVar, int i3, int i4) {
        return jVar.a(i3, this.data, i2, i4);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.data;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && E.a(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public int compareTo(j jVar) {
        int size = size();
        int size2 = jVar.size();
        int min = Math.min(size, size2);
        int i2 = 0;
        while (true) {
            int i3 = -1;
            if (i2 < min) {
                byte b2 = b(i2) & 255;
                byte b3 = jVar.b(i2) & 255;
                if (b2 == b3) {
                    i2++;
                } else {
                    if (b2 >= b3) {
                        i3 = 1;
                    }
                    return i3;
                }
            } else if (size == size2) {
                return 0;
            } else {
                if (size >= size2) {
                    i3 = 1;
                }
                return i3;
            }
        }
    }

    static int a(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
