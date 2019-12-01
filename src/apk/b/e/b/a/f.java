package b.e.b.a;

import b.e.b.i;

/* compiled from: ConstraintAnchor */
public class f {

    /* renamed from: a reason: collision with root package name */
    private q f2344a = new q(this);

    /* renamed from: b reason: collision with root package name */
    final h f2345b;

    /* renamed from: c reason: collision with root package name */
    final c f2346c;

    /* renamed from: d reason: collision with root package name */
    f f2347d;

    /* renamed from: e reason: collision with root package name */
    public int f2348e = 0;

    /* renamed from: f reason: collision with root package name */
    int f2349f = -1;

    /* renamed from: g reason: collision with root package name */
    private b f2350g = b.NONE;

    /* renamed from: h reason: collision with root package name */
    private a f2351h = a.RELAXED;

    /* renamed from: i reason: collision with root package name */
    private int f2352i = 0;

    /* renamed from: j reason: collision with root package name */
    i f2353j;

    /* compiled from: ConstraintAnchor */
    public enum a {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor */
    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor */
    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public f(h hVar, c cVar) {
        this.f2345b = hVar;
        this.f2346c = cVar;
    }

    public void a(b.e.b.c cVar) {
        i iVar = this.f2353j;
        if (iVar == null) {
            this.f2353j = new i(b.e.b.i.a.UNRESTRICTED, null);
        } else {
            iVar.b();
        }
    }

    public int b() {
        if (this.f2345b.t() == 8) {
            return 0;
        }
        if (this.f2349f > -1) {
            f fVar = this.f2347d;
            if (fVar != null && fVar.f2345b.t() == 8) {
                return this.f2349f;
            }
        }
        return this.f2348e;
    }

    public h c() {
        return this.f2345b;
    }

    public q d() {
        return this.f2344a;
    }

    public i e() {
        return this.f2353j;
    }

    public b f() {
        return this.f2350g;
    }

    public f g() {
        return this.f2347d;
    }

    public c h() {
        return this.f2346c;
    }

    public boolean i() {
        return this.f2347d != null;
    }

    public void j() {
        this.f2347d = null;
        this.f2348e = 0;
        this.f2349f = -1;
        this.f2350g = b.STRONG;
        this.f2352i = 0;
        this.f2351h = a.RELAXED;
        this.f2344a.d();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2345b.g());
        sb.append(":");
        sb.append(this.f2346c.toString());
        return sb.toString();
    }

    public int a() {
        return this.f2352i;
    }

    public boolean a(f fVar, int i2, b bVar, int i3) {
        return a(fVar, i2, -1, bVar, i3, false);
    }

    public boolean a(f fVar, int i2, int i3, b bVar, int i4, boolean z) {
        if (fVar == null) {
            this.f2347d = null;
            this.f2348e = 0;
            this.f2349f = -1;
            this.f2350g = b.NONE;
            this.f2352i = 2;
            return true;
        } else if (!z && !a(fVar)) {
            return false;
        } else {
            this.f2347d = fVar;
            if (i2 > 0) {
                this.f2348e = i2;
            } else {
                this.f2348e = 0;
            }
            this.f2349f = i3;
            this.f2350g = bVar;
            this.f2352i = i4;
            return true;
        }
    }

    public boolean a(f fVar) {
        boolean z = false;
        if (fVar == null) {
            return false;
        }
        c h2 = fVar.h();
        c cVar = this.f2346c;
        if (h2 != cVar) {
            switch (e.f2343a[cVar.ordinal()]) {
                case 1:
                    if (!(h2 == c.BASELINE || h2 == c.CENTER_X || h2 == c.CENTER_Y)) {
                        z = true;
                    }
                    return z;
                case 2:
                case 3:
                    boolean z2 = h2 == c.LEFT || h2 == c.RIGHT;
                    if (fVar.c() instanceof l) {
                        z2 = z2 || h2 == c.CENTER_X;
                    }
                    return z2;
                case 4:
                case 5:
                    boolean z3 = h2 == c.TOP || h2 == c.BOTTOM;
                    if (fVar.c() instanceof l) {
                        z3 = z3 || h2 == c.CENTER_Y;
                    }
                    return z3;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f2346c.name());
            }
        } else if (cVar != c.BASELINE || (fVar.c().z() && c().z())) {
            return true;
        } else {
            return false;
        }
    }
}
