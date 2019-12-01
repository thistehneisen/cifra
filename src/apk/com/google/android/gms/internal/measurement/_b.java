package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.d;

final class _b implements Ec {

    /* renamed from: a reason: collision with root package name */
    private static final C0382jc f5115a = new C0339cc();

    /* renamed from: b reason: collision with root package name */
    private final C0382jc f5116b;

    public _b() {
        this(new C0332bc(Cb.a(), a()));
    }

    public final <T> Ac<T> a(Class<T> cls) {
        Cc.a(cls);
        C0388kc b2 = this.f5116b.b(cls);
        if (b2.b()) {
            if (Eb.class.isAssignableFrom(cls)) {
                return C0429rc.a(Cc.c(), C0452vb.a(), b2.a());
            }
            return C0429rc.a(Cc.a(), C0452vb.b(), b2.a());
        } else if (Eb.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return C0418pc.a(cls, b2, C0453vc.b(), Xb.b(), Cc.c(), C0452vb.a(), C0370hc.b());
            }
            return C0418pc.a(cls, b2, C0453vc.b(), Xb.b(), Cc.c(), null, C0370hc.b());
        } else if (a(b2)) {
            return C0418pc.a(cls, b2, C0453vc.a(), Xb.a(), Cc.a(), C0452vb.b(), C0370hc.a());
        } else {
            return C0418pc.a(cls, b2, C0453vc.a(), Xb.a(), Cc.b(), null, C0370hc.a());
        }
    }

    private _b(C0382jc jcVar) {
        Fb.a(jcVar, "messageInfoFactory");
        this.f5116b = jcVar;
    }

    private static boolean a(C0388kc kcVar) {
        return kcVar.c() == d.f4923i;
    }

    private static C0382jc a() {
        try {
            return (C0382jc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f5115a;
        }
    }
}
