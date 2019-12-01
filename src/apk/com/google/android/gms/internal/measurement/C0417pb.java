package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.pb reason: case insensitive filesystem */
final class C0417pb {

    /* renamed from: a reason: collision with root package name */
    private static final Class<?> f5319a = c();

    public static C0428rb a() {
        if (f5319a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C0428rb.f5352d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e  */
    static C0428rb b() {
        C0428rb rbVar;
        if (f5319a != null) {
            try {
                rbVar = a("loadGeneratedRegistry");
            } catch (Exception unused) {
            }
            if (rbVar == null) {
                rbVar = C0428rb.a();
            }
            return rbVar != null ? a() : rbVar;
        }
        rbVar = null;
        if (rbVar == null) {
        }
        if (rbVar != null) {
        }
    }

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static final C0428rb a(String str) throws Exception {
        return (C0428rb) f5319a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
