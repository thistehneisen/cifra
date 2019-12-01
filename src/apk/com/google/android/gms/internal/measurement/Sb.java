package com.google.android.gms.internal.measurement;

public class Sb {

    /* renamed from: a reason: collision with root package name */
    private static final C0428rb f5042a = C0428rb.b();

    /* renamed from: b reason: collision with root package name */
    private Xa f5043b;

    /* renamed from: c reason: collision with root package name */
    private volatile C0400mc f5044c;

    /* renamed from: d reason: collision with root package name */
    private volatile Xa f5045d;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    private final C0400mc b(C0400mc mcVar) {
        if (this.f5044c == null) {
            synchronized (this) {
                if (this.f5044c == null) {
                    this.f5044c = mcVar;
                    this.f5045d = Xa.f5082a;
                    this.f5044c = mcVar;
                    this.f5045d = Xa.f5082a;
                }
            }
        }
        return this.f5044c;
    }

    public final C0400mc a(C0400mc mcVar) {
        C0400mc mcVar2 = this.f5044c;
        this.f5043b = null;
        this.f5045d = null;
        this.f5044c = mcVar;
        return mcVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sb)) {
            return false;
        }
        Sb sb = (Sb) obj;
        C0400mc mcVar = this.f5044c;
        C0400mc mcVar2 = sb.f5044c;
        if (mcVar == null && mcVar2 == null) {
            return a().equals(sb.a());
        }
        if (mcVar != null && mcVar2 != null) {
            return mcVar.equals(mcVar2);
        }
        if (mcVar != null) {
            return mcVar.equals(sb.b(mcVar.a()));
        }
        return b(mcVar2.a()).equals(mcVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final Xa a() {
        if (this.f5045d != null) {
            return this.f5045d;
        }
        synchronized (this) {
            if (this.f5045d != null) {
                Xa xa = this.f5045d;
                return xa;
            }
            if (this.f5044c == null) {
                this.f5045d = Xa.f5082a;
            } else {
                this.f5045d = this.f5044c.d();
            }
            Xa xa2 = this.f5045d;
            return xa2;
        }
    }

    public final int b() {
        if (this.f5045d != null) {
            return this.f5045d.size();
        }
        if (this.f5044c != null) {
            return this.f5044c.c();
        }
        return 0;
    }
}
