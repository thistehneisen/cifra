package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.vc reason: case insensitive filesystem */
final class C0453vc {

    /* renamed from: a reason: collision with root package name */
    private static final C0441tc f5405a = c();

    /* renamed from: b reason: collision with root package name */
    private static final C0441tc f5406b = new C0435sc();

    static C0441tc a() {
        return f5405a;
    }

    static C0441tc b() {
        return f5406b;
    }

    private static C0441tc c() {
        try {
            return (C0441tc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
