package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.a.a;
import com.google.android.gms.internal.measurement.Gb;

final class Bb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Gb f5514a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f5515b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Cb f5516c;

    Bb(Cb cb, Gb gb, ServiceConnection serviceConnection) {
        this.f5516c = cb;
        this.f5514a = gb;
        this.f5515b = serviceConnection;
    }

    public final void run() {
        Cb cb = this.f5516c;
        C0606zb zbVar = cb.f5523b;
        String a2 = cb.f5522a;
        Gb gb = this.f5514a;
        ServiceConnection serviceConnection = this.f5515b;
        Bundle a3 = zbVar.a(a2, gb);
        zbVar.f6177a.d().j();
        if (a3 != null) {
            long j2 = a3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j2 == 0) {
                zbVar.f6177a.e().t().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zbVar.f6177a.e().t().a("No referrer defined in install referrer response");
                } else {
                    zbVar.f6177a.e().B().a("InstallReferrer API result", string);
                    Wd G = zbVar.f6177a.G();
                    String str = "?";
                    String valueOf = String.valueOf(string);
                    Bundle a4 = G.a(Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
                    if (a4 == null) {
                        zbVar.f6177a.e().t().a("No campaign params defined in install referrer result");
                    } else {
                        String string2 = a4.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j3 = a3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j3 == 0) {
                                zbVar.f6177a.e().t().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                a4.putLong("click_timestamp", j3);
                            }
                        }
                        if (j2 == zbVar.f6177a.h().f6109l.a()) {
                            zbVar.f6177a.b();
                            zbVar.f6177a.e().B().a("Campaign has already been logged");
                        } else {
                            zbVar.f6177a.h().f6109l.a(j2);
                            zbVar.f6177a.b();
                            String str2 = "referrer API";
                            zbVar.f6177a.e().B().a("Logging Install Referrer campaign from sdk with ", str2);
                            a4.putString("_cis", str2);
                            zbVar.f6177a.y().b("auto", "_cmp", a4);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            a.a().a(zbVar.f6177a.a(), serviceConnection);
        }
    }
}
