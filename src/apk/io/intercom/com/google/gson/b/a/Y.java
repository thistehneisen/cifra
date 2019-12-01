package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;

/* compiled from: TypeAdapters */
class Y implements E {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Class f10033a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Class f10034b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ D f10035c;

    Y(Class cls, Class cls2, D d2) {
        this.f10033a = cls;
        this.f10034b = cls2;
        this.f10035c = d2;
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        Class a2 = aVar.a();
        if (a2 == this.f10033a || a2 == this.f10034b) {
            return this.f10035c;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.f10033a.getName());
        sb.append("+");
        sb.append(this.f10034b.getName());
        sb.append(",adapter=");
        sb.append(this.f10035c);
        sb.append("]");
        return sb.toString();
    }
}
