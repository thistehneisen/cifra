package com.touchin.vtb.b;

import com.appsflyer.AppsFlyerLib;
import com.touchin.vtb.VTBAccountingApplication;
import kotlin.e.b.h;

/* compiled from: AppsFlyerController.kt */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final AppsFlyerLib f7136a = AppsFlyerLib.getInstance();

    /* renamed from: b reason: collision with root package name */
    private final VTBAccountingApplication f7137b;

    public b(VTBAccountingApplication vTBAccountingApplication) {
        h.b(vTBAccountingApplication, "application");
        this.f7137b = vTBAccountingApplication;
        String str = "ucQ56eBcuffLVAKcPwaz38";
        this.f7136a.init(str, new a(), this.f7137b.getApplicationContext());
        this.f7136a.startTracking(this.f7137b, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r1.f7137b, (java.lang.Object) ((com.touchin.vtb.b.b) r2).f7137b) != false) goto L_0x0015;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        VTBAccountingApplication vTBAccountingApplication = this.f7137b;
        if (vTBAccountingApplication != null) {
            return vTBAccountingApplication.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppsFlyerController(application=");
        sb.append(this.f7137b);
        sb.append(")");
        return sb.toString();
    }
}
