package org.joda.time.c;

import org.joda.time.e;

/* compiled from: AbstractConverter */
public abstract class a implements c {
    protected a() {
    }

    public long a(Object obj, org.joda.time.a aVar) {
        return e.a();
    }

    public org.joda.time.a b(Object obj, org.joda.time.a aVar) {
        return e.a(aVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Converter[");
        sb.append(a() == null ? "null" : a().getName());
        sb.append("]");
        return sb.toString();
    }
}
