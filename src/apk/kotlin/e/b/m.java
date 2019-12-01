package kotlin.e.b;

import kotlin.g.b;
import kotlin.g.g;

/* compiled from: PropertyReference */
public abstract class m extends a implements g {
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (!g().equals(mVar.g()) || !f().equals(mVar.f()) || !i().equals(mVar.i()) || !h.a(e(), mVar.e())) {
                z = false;
            }
            return z;
        } else if (obj instanceof g) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public g h() {
        return (g) super.h();
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + f().hashCode()) * 31) + i().hashCode();
    }

    public String toString() {
        b c2 = c();
        if (c2 != this) {
            return c2.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("property ");
        sb.append(f());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
