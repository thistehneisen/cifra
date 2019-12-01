package io.fabric.sdk.android.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import io.fabric.sdk.android.a.d.c;
import io.fabric.sdk.android.a.d.d;
import io.fabric.sdk.android.f;

/* renamed from: io.fabric.sdk.android.a.b.d reason: case insensitive filesystem */
/* compiled from: AdvertisingInfoProvider */
class C0733d {

    /* renamed from: a reason: collision with root package name */
    private final Context f8811a;

    /* renamed from: b reason: collision with root package name */
    private final c f8812b;

    public C0733d(Context context) {
        this.f8811a = context.getApplicationContext();
        this.f8812b = new d(context, "TwitterAdvertisingInfoPreferences");
    }

    private void b(C0731b bVar) {
        new Thread(new C0732c(this, bVar)).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void c(C0731b bVar) {
        boolean a2 = a(bVar);
        String str = "limit_ad_tracking_enabled";
        String str2 = Constants.URL_ADVERTISING_ID;
        if (a2) {
            c cVar = this.f8812b;
            cVar.a(cVar.edit().putString(str2, bVar.f8807a).putBoolean(str, bVar.f8808b));
            return;
        }
        c cVar2 = this.f8812b;
        cVar2.a(cVar2.edit().remove(str2).remove(str));
    }

    /* access modifiers changed from: private */
    public C0731b e() {
        C0731b a2 = c().a();
        String str = "Fabric";
        if (!a(a2)) {
            a2 = d().a();
            if (!a(a2)) {
                f.e().d(str, "AdvertisingInfo not present");
            } else {
                f.e().d(str, "Using AdvertisingInfo from Service Provider");
            }
        } else {
            f.e().d(str, "Using AdvertisingInfo from Reflection Provider");
        }
        return a2;
    }

    public h d() {
        return new g(this.f8811a);
    }

    public C0731b a() {
        C0731b b2 = b();
        if (a(b2)) {
            f.e().d("Fabric", "Using AdvertisingInfo from Preference Store");
            b(b2);
            return b2;
        }
        C0731b e2 = e();
        c(e2);
        return e2;
    }

    /* access modifiers changed from: protected */
    public C0731b b() {
        return new C0731b(this.f8812b.get().getString(Constants.URL_ADVERTISING_ID, ""), this.f8812b.get().getBoolean("limit_ad_tracking_enabled", false));
    }

    private boolean a(C0731b bVar) {
        return bVar != null && !TextUtils.isEmpty(bVar.f8807a);
    }

    public h c() {
        return new C0734e(this.f8811a);
    }
}
