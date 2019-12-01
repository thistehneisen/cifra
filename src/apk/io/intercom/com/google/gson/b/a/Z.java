package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class Z extends D<T1> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Class f10036a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ aa f10037b;

    Z(aa aaVar, Class cls) {
        this.f10037b = aaVar;
        this.f10036a = cls;
    }

    public void a(d dVar, T1 t1) throws IOException {
        this.f10037b.f10040b.a(dVar, t1);
    }

    public T1 a(b bVar) throws IOException {
        T1 a2 = this.f10037b.f10040b.a(bVar);
        if (a2 == null || this.f10036a.isInstance(a2)) {
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a ");
        sb.append(this.f10036a.getName());
        sb.append(" but was ");
        sb.append(a2.getClass().getName());
        throw new JsonSyntaxException(sb.toString());
    }
}
