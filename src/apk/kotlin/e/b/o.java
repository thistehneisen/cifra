package kotlin.e.b;

import kotlin.g.c;
import kotlin.g.e;
import kotlin.g.f;
import kotlin.g.h;

/* compiled from: Reflection */
public class o {

    /* renamed from: a reason: collision with root package name */
    private static final p f10308a;

    /* renamed from: b reason: collision with root package name */
    private static final c[] f10309b = new c[0];

    static {
        p pVar = null;
        try {
            pVar = (p) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (pVar == null) {
            pVar = new p();
        }
        f10308a = pVar;
    }

    public static e a(Class cls, String str) {
        return f10308a.a(cls, str);
    }

    public static c a(Class cls) {
        return f10308a.a(cls);
    }

    public static String a(i iVar) {
        return f10308a.a(iVar);
    }

    public static f a(g gVar) {
        f10308a.a(gVar);
        return gVar;
    }

    public static h a(k kVar) {
        f10308a.a(kVar);
        return kVar;
    }
}
