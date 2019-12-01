package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.f;

/* renamed from: io.fabric.sdk.android.a.b.e reason: case insensitive filesystem */
/* compiled from: AdvertisingInfoReflectionStrategy */
class C0734e implements h {

    /* renamed from: a reason: collision with root package name */
    private final Context f8813a;

    public C0734e(Context context) {
        this.f8813a = context.getApplicationContext();
    }

    private String b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(c(), new Object[0]);
        } catch (Exception unused) {
            f.e().a("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private Object c() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f8813a});
        } catch (Exception unused) {
            f.e().a("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    private boolean d() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(c(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f.e().a("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public C0731b a() {
        if (a(this.f8813a)) {
            return new C0731b(b(), d());
        }
        return null;
    }
}
