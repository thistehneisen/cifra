package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;

/* compiled from: TypeAdapters */
class W implements E {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Class f10028a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ D f10029b;

    W(Class cls, D d2) {
        this.f10028a = cls;
        this.f10029b = d2;
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        if (aVar.a() == this.f10028a) {
            return this.f10029b;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.f10028a.getName());
        sb.append(",adapter=");
        sb.append(this.f10029b);
        sb.append("]");
        return sb.toString();
    }
}
