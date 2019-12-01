package kotlin.e.b;

import kotlin.g.c;
import kotlin.g.e;
import kotlin.g.f;
import kotlin.g.h;

/* compiled from: ReflectionFactory */
public class p {
    public e a(Class cls, String str) {
        return new j(cls, str);
    }

    public f a(g gVar) {
        return gVar;
    }

    public h a(k kVar) {
        return kVar;
    }

    public c a(Class cls) {
        return new c(cls);
    }

    public String a(i iVar) {
        return a((f) iVar);
    }

    public String a(f fVar) {
        String obj = fVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
