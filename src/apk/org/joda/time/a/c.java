package org.joda.time.a;

import org.joda.time.a;
import org.joda.time.d;
import org.joda.time.d.h;
import org.joda.time.t;

/* compiled from: AbstractPartial */
public abstract class c implements t, Comparable<t> {
    protected c() {
    }

    /* access modifiers changed from: protected */
    public abstract org.joda.time.c a(int i2, a aVar);

    public d a(int i2) {
        return a(i2, getChronology()).g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (size() != tVar.size()) {
            return false;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (getValue(i2) != tVar.getValue(i2) || a(i2) != tVar.a(i2)) {
                return false;
            }
        }
        return h.a((Object) getChronology(), (Object) tVar.getChronology());
    }

    public int hashCode() {
        int i2 = 157;
        for (int i3 = 0; i3 < size(); i3++) {
            i2 = (((i2 * 23) + getValue(i3)) * 23) + a(i3).hashCode();
        }
        return i2 + getChronology().hashCode();
    }

    public int a(t tVar) {
        if (this == tVar) {
            return 0;
        }
        String str = "ReadablePartial objects must have matching field types";
        if (size() == tVar.size()) {
            int size = size();
            int i2 = 0;
            while (i2 < size) {
                if (a(i2) == tVar.a(i2)) {
                    i2++;
                } else {
                    throw new ClassCastException(str);
                }
            }
            int size2 = size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (getValue(i3) > tVar.getValue(i3)) {
                    return 1;
                }
                if (getValue(i3) < tVar.getValue(i3)) {
                    return -1;
                }
            }
            return 0;
        }
        throw new ClassCastException(str);
    }
}
