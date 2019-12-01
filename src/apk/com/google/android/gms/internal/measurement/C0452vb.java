package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.vb reason: case insensitive filesystem */
final class C0452vb {

    /* renamed from: a reason: collision with root package name */
    private static final C0440tb<?> f5403a = new C0434sb();

    /* renamed from: b reason: collision with root package name */
    private static final C0440tb<?> f5404b = c();

    static C0440tb<?> a() {
        return f5403a;
    }

    static C0440tb<?> b() {
        C0440tb<?> tbVar = f5404b;
        if (tbVar != null) {
            return tbVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static C0440tb<?> c() {
        try {
            return (C0440tb) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
