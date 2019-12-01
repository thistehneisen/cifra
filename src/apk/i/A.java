package i;

import i.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Headers */
public final class A {

    /* renamed from: a reason: collision with root package name */
    private final String[] f8420a;

    /* compiled from: Headers */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        final List<String> f8421a = new ArrayList(20);

        /* access modifiers changed from: 0000 */
        public a a(String str) {
            String str2 = ":";
            int indexOf = str.indexOf(str2, 1);
            if (indexOf != -1) {
                b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            }
            String str3 = "";
            if (str.startsWith(str2)) {
                b(str3, str.substring(1));
                return this;
            }
            b(str3, str);
            return this;
        }

        /* access modifiers changed from: 0000 */
        public a b(String str, String str2) {
            this.f8421a.add(str);
            this.f8421a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            A.a(str);
            A.a(str2, str);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i2 = 0;
            while (i2 < this.f8421a.size()) {
                if (str.equalsIgnoreCase((String) this.f8421a.get(i2))) {
                    this.f8421a.remove(i2);
                    this.f8421a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            A.a(str);
            A.a(str2, str);
            b(str, str2);
            return this;
        }

        public A a() {
            return new A(this);
        }
    }

    A(a aVar) {
        List<String> list = aVar.f8421a;
        this.f8420a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(int i2) {
        return this.f8420a[i2 * 2];
    }

    public String b(String str) {
        return a(this.f8420a, str);
    }

    public List<String> c(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < b2; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof A) && Arrays.equals(((A) obj).f8420a, this.f8420a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8420a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f8421a, this.f8420a);
        return aVar;
    }

    public int b() {
        return this.f8420a.length / 2;
    }

    private A(String[] strArr) {
        this.f8420a = strArr;
    }

    public String b(int i2) {
        return this.f8420a[(i2 * 2) + 1];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static A a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i2 = 0;
            while (i2 < strArr2.length) {
                if (strArr2[i2] != null) {
                    strArr2[i2] = strArr2[i2].trim();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                String str = strArr2[i3];
                String str2 = strArr2[i3 + 1];
                a(str);
                a(str2, str);
            }
            return new A(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }

    static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(e.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(e.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("value for name ");
        sb.append(str2);
        sb.append(" == null");
        throw new NullPointerException(sb.toString());
    }
}
