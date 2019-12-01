package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import b.k.a.a;
import com.google.android.gms.common.util.k;

public final class FirebaseInstanceIdReceiver extends a {

    /* renamed from: c reason: collision with root package name */
    private static K f6760c;

    @SuppressLint({"InlinedApi"})
    public static int a(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        boolean z = true;
        boolean z2 = k.i() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        if (z2 && !z) {
            return b(broadcastReceiver, context, intent);
        }
        int a2 = C0635y.a().a(context, intent);
        if (!k.i() || a2 != 402) {
            return a2;
        }
        b(broadcastReceiver, context, intent);
        return 403;
    }

    private static int b(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        String str = "FirebaseInstanceId";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Binding to service");
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        a(context, "com.google.firebase.MESSAGING_EVENT").a(intent, broadcastReceiver.goAsync());
        return -1;
    }

    private final void c(Context context, Intent intent) {
        int i2;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            String stringExtra = intent.getStringExtra("CMD");
            if (stringExtra != null) {
                String str = "FirebaseInstanceId";
                if (Log.isLoggable(str, 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                    sb.append("Received command: ");
                    sb.append(stringExtra);
                    sb.append(" - ");
                    sb.append(valueOf);
                    Log.d(str, sb.toString());
                }
                if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                    FirebaseInstanceId.b().i();
                } else if ("SYNC".equals(stringExtra)) {
                    FirebaseInstanceId.b().k();
                }
            }
            i2 = -1;
        } else {
            String str2 = "gcm.rawData64";
            String stringExtra2 = intent.getStringExtra(str2);
            if (stringExtra2 != null) {
                intent.putExtra("rawData", Base64.decode(stringExtra2, 0));
                intent.removeExtra(str2);
            }
            i2 = a(this, context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(i2);
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                c(context, intent2);
            } else {
                c(context, intent);
            }
        }
    }

    private static synchronized K a(Context context, String str) {
        K k2;
        synchronized (FirebaseInstanceIdReceiver.class) {
            if (f6760c == null) {
                f6760c = new K(context, str);
            }
            k2 = f6760c;
        }
        return k2;
    }
}
