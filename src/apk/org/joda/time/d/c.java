package org.joda.time.d;

import java.io.Serializable;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: BaseDurationField */
public abstract class c extends h implements Serializable {
    private static final long serialVersionUID = -2554245107589433218L;
    private final i iType;

    protected c(i iVar) {
        if (iVar != null) {
            this.iType = iVar;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public final i a() {
        return this.iType;
    }

    public final boolean d() {
        return true;
    }

    public final String e() {
        return this.iType.d();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DurationField[");
        sb.append(e());
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        int i2 = (b() > hVar.b() ? 1 : (b() == hVar.b() ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }
}
