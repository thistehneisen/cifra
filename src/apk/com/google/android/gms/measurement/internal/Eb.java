package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.Af;

public final class Eb {

    /* renamed from: a reason: collision with root package name */
    private final Gb f5541a;

    public Eb(Gb gb) {
        q.a(gb);
        this.f5541a = gb;
    }

    public static boolean a(Context context) {
        q.a(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
        }
    }

    public final void a(Context context, Intent intent) {
        Ob a2 = Ob.a(context, (Af) null);
        C0532kb e2 = a2.e();
        if (intent == null) {
            e2.w().a("Receiver called with null intent");
            return;
        }
        a2.b();
        String action = intent.getAction();
        e2.B().a("Local receiver got", action);
        String str = "com.google.android.gms.measurement.UPLOAD";
        if (str.equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction(str);
            e2.B().a("Starting wakeful intent.");
            this.f5541a.a(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                a2.d().a((Runnable) new Db(this, a2, e2));
            } catch (Exception e3) {
                e2.w().a("Install Referrer Reporter encountered a problem", e3);
            }
            PendingResult a3 = this.f5541a.a();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                e2.B().a("Install referrer extras are null");
                if (a3 != null) {
                    a3.finish();
                }
                return;
            }
            e2.z().a("Install referrer extras are", stringExtra);
            String str2 = "?";
            if (!stringExtra.contains(str2)) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            Bundle a4 = a2.G().a(Uri.parse(stringExtra));
            if (a4 == null) {
                e2.B().a("No campaign defined in install referrer broadcast");
                if (a3 != null) {
                    a3.finish();
                }
            } else {
                long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
                if (longExtra == 0) {
                    e2.w().a("Install referrer is missing timestamp");
                }
                Ib d2 = a2.d();
                Hb hb = new Hb(this, a2, longExtra, a4, context, e2, a3);
                d2.a((Runnable) hb);
            }
        }
    }
}
