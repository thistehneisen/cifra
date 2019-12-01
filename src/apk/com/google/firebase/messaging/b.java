package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.a.a;

public class b {
    public static void a(Intent intent) {
        a("_nd", intent);
    }

    public static void b(Intent intent) {
        a("_nf", intent);
    }

    public static void c(Intent intent) {
        if (intent != null) {
            String str = "FirebaseMessaging";
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                a aVar = (a) FirebaseApp.getInstance().a(a.class);
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (aVar != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    String str2 = "fcm";
                    aVar.a(str2, "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    aVar.logEvent(str2, "_cmp", bundle);
                } else {
                    Log.w(str, "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable(str, 3)) {
                Log.d(str, "Received event with track-conversion=false. Do not set user property");
            }
        }
        a("_no", intent);
    }

    public static void d(Intent intent) {
        a("_nr", intent);
    }

    public static boolean e(Intent intent) {
        if (intent == null) {
            return false;
        }
        if ("com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction())) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    private static void a(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String stringExtra5 = intent.getStringExtra("from");
        if (stringExtra5 == null || !stringExtra5.startsWith("/topics/")) {
            stringExtra5 = null;
        }
        if (stringExtra5 != null) {
            bundle.putString("_nt", stringExtra5);
        }
        String str2 = "google.c.a.ts";
        String str3 = "FirebaseMessaging";
        if (intent.hasExtra(str2)) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(intent.getStringExtra(str2)));
            } catch (NumberFormatException e2) {
                Log.w(str3, "Error while parsing timestamp in GCM event", e2);
            }
        }
        String str4 = "google.c.a.udt";
        if (intent.hasExtra(str4)) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(intent.getStringExtra(str4)));
            } catch (NumberFormatException e3) {
                Log.w(str3, "Error while parsing use_device_time in GCM event", e3);
            }
        }
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", (intent.getExtras() == null || !e.b(intent.getExtras())) ? "data" : "display");
        }
        if (Log.isLoggable(str3, 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(valueOf).length());
            sb.append("Sending event=");
            sb.append(str);
            sb.append(" params=");
            sb.append(valueOf);
            Log.d(str3, sb.toString());
        }
        a aVar = (a) FirebaseApp.getInstance().a(a.class);
        if (aVar != null) {
            aVar.logEvent("fcm", str, bundle);
        } else {
            Log.w(str3, "Unable to log event: analytics library is missing");
        }
    }
}
