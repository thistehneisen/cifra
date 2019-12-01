package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.a.b;
import io.intercom.com.google.gson.b.q;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.s;
import io.intercom.com.google.gson.y;

/* renamed from: io.intercom.com.google.gson.b.a.f reason: case insensitive filesystem */
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class C0759f implements E {

    /* renamed from: a reason: collision with root package name */
    private final q f10051a;

    public C0759f(q qVar) {
        this.f10051a = qVar;
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        b bVar = (b) aVar.a().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return a(this.f10051a, oVar, aVar, bVar);
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [io.intercom.com.google.gson.D, io.intercom.com.google.gson.D<?>] */
    /* JADX WARNING: type inference failed for: r9v13, types: [io.intercom.com.google.gson.D] */
    /* JADX WARNING: type inference failed for: r9v14, types: [io.intercom.com.google.gson.D] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    public D<?> a(q qVar, o oVar, a<?> aVar, b bVar) {
        C0774v vVar;
        Object a2 = qVar.a(a.a(bVar.value())).a();
        if (a2 instanceof D) {
            vVar = (D) a2;
        } else if (a2 instanceof E) {
            vVar = ((E) a2).a(oVar, aVar);
        } else {
            boolean z = a2 instanceof y;
            if (z || (a2 instanceof s)) {
                s sVar = null;
                y yVar = z ? (y) a2 : null;
                if (a2 instanceof s) {
                    sVar = (s) a2;
                }
                C0774v vVar2 = new C0774v(yVar, sVar, oVar, aVar, null);
                vVar = vVar2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid attempt to bind an instance of ");
                sb.append(a2.getClass().getName());
                sb.append(" as a @JsonAdapter for ");
                sb.append(aVar.toString());
                sb.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (vVar == 0 || !bVar.nullSafe()) ? vVar : vVar.a();
    }
}
