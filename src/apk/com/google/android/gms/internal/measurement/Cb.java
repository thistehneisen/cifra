package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.d;

final class Cb implements C0382jc {

    /* renamed from: a reason: collision with root package name */
    private static final Cb f4876a = new Cb();

    private Cb() {
    }

    public static Cb a() {
        return f4876a;
    }

    public final C0388kc b(Class<?> cls) {
        if (!Eb.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (C0388kc) Eb.a(cls.asSubclass(Eb.class)).a(d.f4917c, (Object) null, (Object) null);
        } catch (Exception e2) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e2);
        }
    }

    public final boolean a(Class<?> cls) {
        return Eb.class.isAssignableFrom(cls);
    }
}
