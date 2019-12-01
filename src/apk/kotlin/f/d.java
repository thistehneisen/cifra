package kotlin.f;

/* compiled from: Ranges.kt */
public final class d extends b implements a<Integer> {
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public static final d f10319e = new d(1, 0);

    /* renamed from: f reason: collision with root package name */
    public static final a f10320f = new a(null);

    /* compiled from: Ranges.kt */
    public static final class a {
        private a() {
        }

        public final d a() {
            return d.f10319e;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public d(int i2, int i3) {
        super(i2, i3, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (getLast() == r3.getLast()) goto L_0x0029;
     */
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (getFirst() == dVar.getFirst()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer g() {
        return Integer.valueOf(getLast());
    }

    public Integer h() {
        return Integer.valueOf(getFirst());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirst());
        sb.append("..");
        sb.append(getLast());
        return sb.toString();
    }
}
