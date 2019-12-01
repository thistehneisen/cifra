package kotlin.e.b;

import kotlin.g.b;
import kotlin.g.f;

/* compiled from: FunctionReference */
public class g extends a implements f, f {
    private final int arity;

    public g(int i2) {
        this.arity = i2;
    }

    /* access modifiers changed from: protected */
    public b d() {
        o.a(this);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (kotlin.e.b.h.a(e(), r5.e()) != false) goto L_0x0052;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (g() != null ? g().equals(gVar.g()) : gVar.g() == null) {
                if (f().equals(gVar.f())) {
                    if (i().equals(gVar.i())) {
                    }
                }
            }
            z = false;
            return z;
        } else if (obj instanceof f) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((g() == null ? 0 : g().hashCode() * 31) + f().hashCode()) * 31) + i().hashCode();
    }

    public String toString() {
        String str;
        b c2 = c();
        if (c2 != this) {
            return c2.toString();
        }
        if ("<init>".equals(f())) {
            str = "constructor (Kotlin reflection is not available)";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("function ");
            sb.append(f());
            sb.append(" (Kotlin reflection is not available)");
            str = sb.toString();
        }
        return str;
    }

    public g(int i2, Object obj) {
        super(obj);
        this.arity = i2;
    }
}
