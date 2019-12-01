package org.joda.time.d;

import java.io.Serializable;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: MillisDurationField */
public final class j extends h implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final h f10809a = new j();
    private static final long serialVersionUID = 2656707858124633367L;

    private j() {
    }

    private Object readResolve() {
        return f10809a;
    }

    public i a() {
        return i.g();
    }

    public final long b() {
        return 1;
    }

    public final boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j) || b() != ((j) obj).b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) b();
    }

    public String toString() {
        return "DurationField[millis]";
    }

    public long a(long j2, int i2) {
        return h.a(j2, (long) i2);
    }

    public long a(long j2, long j3) {
        return h.a(j2, j3);
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
