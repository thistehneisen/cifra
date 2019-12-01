package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.hc reason: case insensitive filesystem */
final class C0370hc {

    /* renamed from: a reason: collision with root package name */
    private static final C0358fc f5214a = c();

    /* renamed from: b reason: collision with root package name */
    private static final C0358fc f5215b = new C0376ic();

    static C0358fc a() {
        return f5214a;
    }

    static C0358fc b() {
        return f5215b;
    }

    private static C0358fc c() {
        try {
            return (C0358fc) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
