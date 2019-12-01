package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;

/* compiled from: TypeAdapters */
class X implements E {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Class f10030a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Class f10031b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ D f10032c;

    X(Class cls, Class cls2, D d2) {
        this.f10030a = cls;
        this.f10031b = cls2;
        this.f10032c = d2;
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        Class a2 = aVar.a();
        if (a2 == this.f10030a || a2 == this.f10031b) {
            return this.f10032c;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[type=");
        sb.append(this.f10031b.getName());
        sb.append("+");
        sb.append(this.f10030a.getName());
        sb.append(",adapter=");
        sb.append(this.f10032c);
        sb.append("]");
        return sb.toString();
    }
}
