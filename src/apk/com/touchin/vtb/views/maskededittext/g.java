package com.touchin.vtb.views.maskededittext;

/* compiled from: Range.kt */
public final class g {

    /* renamed from: a reason: collision with root package name */
    private int f7837a;

    /* renamed from: b reason: collision with root package name */
    private int f7838b;

    public g() {
        this(0, 0, 3, null);
    }

    public g(int i2, int i3) {
        this.f7837a = i2;
        this.f7838b = i3;
    }

    public final int a() {
        return this.f7838b;
    }

    public final int b() {
        return this.f7837a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (this.f7837a == gVar.f7837a) {
                    if (this.f7838b == gVar.f7838b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f7837a * 31) + this.f7838b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Range(start=");
        sb.append(this.f7837a);
        sb.append(", end=");
        sb.append(this.f7838b);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ g(int i2, int i3, int i4, e eVar) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        this(i2, i3);
    }

    public final void a(int i2) {
        this.f7838b = i2;
    }

    public final void b(int i2) {
        this.f7837a = i2;
    }
}
