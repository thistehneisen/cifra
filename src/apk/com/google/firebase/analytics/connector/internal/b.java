package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.C0563qc;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class b {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f6662a = new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));

    /* renamed from: b reason: collision with root package name */
    private static final List<String> f6663b = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open"});

    /* renamed from: c reason: collision with root package name */
    private static final List<String> f6664c = Arrays.asList(new String[]{"auto", "app", "am"});

    /* renamed from: d reason: collision with root package name */
    private static final List<String> f6665d = Arrays.asList(new String[]{"_r", "_dbg"});

    /* renamed from: e reason: collision with root package name */
    private static final List<String> f6666e = Arrays.asList((String[]) com.google.android.gms.common.util.b.a(C0563qc.f6068a, C0563qc.f6069b));

    /* renamed from: f reason: collision with root package name */
    private static final List<String> f6667f = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    public static boolean a(String str) {
        return !f6664c.contains(str);
    }

    public static boolean a(String str, Bundle bundle) {
        if (f6663b.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String containsKey : f6665d) {
                if (bundle.containsKey(containsKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        String str3 = "fcm";
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(str3) || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals(str3) || str.equals("fiam");
        }
        if (f6666e.contains(str2)) {
            return false;
        }
        for (String matches : f6667f) {
            if (str2.matches(matches)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        for (String containsKey : f6665d) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c2 = 2;
                }
            } else if (str.equals("fdl")) {
                c2 = 1;
            }
        } else if (str.equals("fcm")) {
            c2 = 0;
        }
        String str3 = "_cis";
        if (c2 == 0) {
            bundle.putString(str3, "fcm_integration");
            return true;
        } else if (c2 == 1) {
            bundle.putString(str3, "fdl_integration");
            return true;
        } else if (c2 != 2) {
            return false;
        } else {
            bundle.putString(str3, "fiam_integration");
            return true;
        }
    }
}
