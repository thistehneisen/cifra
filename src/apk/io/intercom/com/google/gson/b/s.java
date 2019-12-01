package io.intercom.com.google.gson.b;

import io.intercom.com.google.gson.C0751a;
import io.intercom.com.google.gson.C0752b;
import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.a.d;
import io.intercom.com.google.gson.a.e;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class s implements E, Cloneable {

    /* renamed from: a reason: collision with root package name */
    public static final s f10138a = new s();

    /* renamed from: b reason: collision with root package name */
    private double f10139b = -1.0d;

    /* renamed from: c reason: collision with root package name */
    private int f10140c = 136;

    /* renamed from: d reason: collision with root package name */
    private boolean f10141d = true;

    /* renamed from: e reason: collision with root package name */
    private boolean f10142e;

    /* renamed from: f reason: collision with root package name */
    private List<C0751a> f10143f = Collections.emptyList();

    /* renamed from: g reason: collision with root package name */
    private List<C0751a> f10144g = Collections.emptyList();

    private boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        Class a2 = aVar.a();
        boolean a3 = a(a2, true);
        boolean a4 = a(a2, false);
        if (!a3 && !a4) {
            return null;
        }
        r rVar = new r(this, a4, a3, oVar, aVar);
        return rVar;
    }

    /* access modifiers changed from: protected */
    public s clone() {
        try {
            return (s) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean a(Field field, boolean z) {
        if ((this.f10140c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f10139b != -1.0d && !a((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f10142e) {
            io.intercom.com.google.gson.a.a aVar = (io.intercom.com.google.gson.a.a) field.getAnnotation(io.intercom.com.google.gson.a.a.class);
            if (aVar == null || (!z ? !aVar.deserialize() : !aVar.serialize())) {
                return true;
            }
        }
        if ((!this.f10141d && b(field.getType())) || a(field.getType())) {
            return true;
        }
        List<C0751a> list = z ? this.f10143f : this.f10144g;
        if (!list.isEmpty()) {
            C0752b bVar = new C0752b(field);
            for (C0751a a2 : list) {
                if (a2.a(bVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(Class<?> cls, boolean z) {
        if (this.f10139b != -1.0d && !a((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((!this.f10141d && b(cls)) || a(cls)) {
            return true;
        }
        for (C0751a a2 : z ? this.f10143f : this.f10144g) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean a(d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(d dVar) {
        return dVar == null || dVar.value() <= this.f10139b;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.value() > this.f10139b;
    }
}
