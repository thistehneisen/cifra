package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;

/* compiled from: TypeAdapters */
class aa implements E {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Class f10039a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ D f10040b;

    aa(Class cls, D d2) {
        this.f10039a = cls;
        this.f10040b = d2;
    }

    public <T2> D<T2> a(o oVar, a<T2> aVar) {
        Class a2 = aVar.a();
        if (!this.f10039a.isAssignableFrom(a2)) {
            return null;
        }
        return new Z(this, a2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factory[typeHierarchy=");
        sb.append(this.f10039a.getName());
        sb.append(",adapter=");
        sb.append(this.f10040b);
        sb.append("]");
        return sb.toString();
    }
}
