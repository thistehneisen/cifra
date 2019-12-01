package kotlin.f;

import kotlin.a.t;

/* compiled from: Progressions.kt */
public class b implements Iterable<Integer>, kotlin.e.b.a.a {

    /* renamed from: a reason: collision with root package name */
    public static final a f10311a = new a(null);

    /* renamed from: b reason: collision with root package name */
    private final int f10312b;

    /* renamed from: c reason: collision with root package name */
    private final int f10313c;

    /* renamed from: d reason: collision with root package name */
    private final int f10314d;

    /* compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        public final b a(int i2, int i3, int i4) {
            return new b(i2, i3, i4);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public b(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.f10312b = i2;
            this.f10313c = kotlin.d.a.a(i2, i3, i4);
            this.f10314d = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int e() {
        return this.f10314d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r2.f10314d == r3.f10314d) goto L_0x0027;
     */
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.f10312b == bVar.f10312b) {
                    if (this.f10313c == bVar.f10313c) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f10312b;
    }

    public final int getLast() {
        return this.f10313c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f10312b * 31) + this.f10313c) * 31) + this.f10314d;
    }

    public boolean isEmpty() {
        if (this.f10314d > 0) {
            if (this.f10312b > this.f10313c) {
                return true;
            }
        } else if (this.f10312b < this.f10313c) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i2;
        StringBuilder sb;
        String str = " step ";
        if (this.f10314d > 0) {
            sb = new StringBuilder();
            sb.append(this.f10312b);
            sb.append("..");
            sb.append(this.f10313c);
            sb.append(str);
            i2 = this.f10314d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f10312b);
            sb.append(" downTo ");
            sb.append(this.f10313c);
            sb.append(str);
            i2 = -this.f10314d;
        }
        sb.append(i2);
        return sb.toString();
    }

    public t iterator() {
        return new c(this.f10312b, this.f10313c, this.f10314d);
    }
}
