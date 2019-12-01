package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.bc reason: case insensitive filesystem */
final class C0332bc implements C0382jc {

    /* renamed from: a reason: collision with root package name */
    private C0382jc[] f5128a;

    C0332bc(C0382jc... jcVarArr) {
        this.f5128a = jcVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (C0382jc a2 : this.f5128a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final C0388kc b(Class<?> cls) {
        C0382jc[] jcVarArr;
        for (C0382jc jcVar : this.f5128a) {
            if (jcVar.a(cls)) {
                return jcVar.b(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
