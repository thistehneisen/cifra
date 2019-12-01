package io.intercom.com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
public final class q extends t implements Iterable<t> {

    /* renamed from: a reason: collision with root package name */
    private final List<t> f10189a = new ArrayList();

    public void a(t tVar) {
        if (tVar == null) {
            tVar = u.f10224a;
        }
        this.f10189a.add(tVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof q) && ((q) obj).f10189a.equals(this.f10189a));
    }

    public int hashCode() {
        return this.f10189a.hashCode();
    }

    public Iterator<t> iterator() {
        return this.f10189a.iterator();
    }
}
