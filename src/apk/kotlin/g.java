package kotlin;

import java.io.Serializable;
import kotlin.e.b.h;

/* compiled from: Tuples.kt */
public final class g<A, B> implements Serializable {
    private final A first;
    private final B second;

    public g(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final A c() {
        return this.first;
    }

    public final B d() {
        return this.second;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r2.second, (java.lang.Object) r3.second) != false) goto L_0x001f;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (h.a((Object) this.first, (Object) gVar.first)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.first;
        int i2 = 0;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.first);
        sb.append(", ");
        sb.append(this.second);
        sb.append(')');
        return sb.toString();
    }
}
