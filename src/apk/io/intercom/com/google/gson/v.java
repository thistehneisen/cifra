package io.intercom.com.google.gson;

import io.intercom.com.google.gson.b.x;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: JsonObject */
public final class v extends t {

    /* renamed from: a reason: collision with root package name */
    private final x<String, t> f10225a = new x<>();

    public void a(String str, t tVar) {
        if (tVar == null) {
            tVar = u.f10224a;
        }
        this.f10225a.put(str, tVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof v) && ((v) obj).f10225a.equals(this.f10225a));
    }

    public int hashCode() {
        return this.f10225a.hashCode();
    }

    public Set<Entry<String, t>> l() {
        return this.f10225a.entrySet();
    }
}
