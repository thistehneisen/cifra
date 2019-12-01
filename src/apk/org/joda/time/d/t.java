package org.joda.time.d;

import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: UnsupportedDurationField */
public final class t extends h implements Serializable {

    /* renamed from: a reason: collision with root package name */
    private static HashMap<i, t> f10823a = null;
    private static final long serialVersionUID = -6390301302770925357L;
    private final i iType;

    private t(i iVar) {
        this.iType = iVar;
    }

    public static synchronized t a(i iVar) {
        t tVar;
        synchronized (t.class) {
            if (f10823a == null) {
                f10823a = new HashMap<>(7);
                tVar = null;
            } else {
                tVar = (t) f10823a.get(iVar);
            }
            if (tVar == null) {
                tVar = new t(iVar);
                f10823a.put(iVar, tVar);
            }
        }
        return tVar;
    }

    private UnsupportedOperationException f() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.iType);
        sb.append(" field is unsupported");
        return new UnsupportedOperationException(sb.toString());
    }

    private Object readResolve() {
        return a(this.iType);
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        return 0;
    }

    public long b() {
        return 0;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.iType.d();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (tVar.e() != null) {
            return tVar.e().equals(e());
        }
        if (e() != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UnsupportedDurationField[");
        sb.append(e());
        sb.append(']');
        return sb.toString();
    }

    public final i a() {
        return this.iType;
    }

    public long a(long j2, int i2) {
        throw f();
    }

    public long a(long j2, long j3) {
        throw f();
    }
}
