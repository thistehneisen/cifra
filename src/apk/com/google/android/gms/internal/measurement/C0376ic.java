package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.ic reason: case insensitive filesystem */
final class C0376ic implements C0358fc {
    C0376ic() {
    }

    public final Map<?, ?> a(Object obj) {
        return (C0364gc) obj;
    }

    public final Map<?, ?> b(Object obj) {
        return (C0364gc) obj;
    }

    public final C0346dc<?, ?> c(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Object d(Object obj) {
        return C0364gc.c().d();
    }

    public final Object e(Object obj) {
        ((C0364gc) obj).b();
        return obj;
    }

    public final boolean f(Object obj) {
        return !((C0364gc) obj).a();
    }

    public final Object a(Object obj, Object obj2) {
        C0364gc gcVar = (C0364gc) obj;
        C0364gc gcVar2 = (C0364gc) obj2;
        if (!gcVar2.isEmpty()) {
            if (!gcVar.a()) {
                gcVar = gcVar.d();
            }
            gcVar.a(gcVar2);
        }
        return gcVar;
    }

    public final int a(int i2, Object obj, Object obj2) {
        C0364gc gcVar = (C0364gc) obj;
        if (gcVar.isEmpty()) {
            return 0;
        }
        Iterator it = gcVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
