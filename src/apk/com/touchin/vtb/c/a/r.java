package com.touchin.vtb.c.a;

import android.content.SharedPreferences;
import kotlin.e.b.h;
import l.a.d.a.b.b.d;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: PersistentModule.kt */
public final class r {
    public final i<String, Long, Long> a(SharedPreferences sharedPreferences) {
        h.b(sharedPreferences, "sharedPreferences");
        i<String, Long, Long> a2 = d.a("BANK_USAGE_TIME", sharedPreferences, 0);
        h.a((Object) a2, "PreferenceUtils.longStor…E\", sharedPreferences, 0)");
        return a2;
    }

    public final i<String, Boolean, Boolean> b(SharedPreferences sharedPreferences) {
        h.b(sharedPreferences, "sharedPreferences");
        i<String, Boolean, Boolean> a2 = d.a("IS_FAST_ENTRANCE_ENABLED", sharedPreferences, false);
        h.a((Object) a2, "PreferenceUtils.booleanS…sharedPreferences, false)");
        return a2;
    }

    public final i<String, Boolean, Boolean> c(SharedPreferences sharedPreferences) {
        h.b(sharedPreferences, "sharedPreferences");
        i<String, Boolean, Boolean> a2 = d.a("IS_FINGERPRINT_ENABLED", sharedPreferences, false);
        h.a((Object) a2, "PreferenceUtils.booleanS…sharedPreferences, false)");
        return a2;
    }

    public final i<String, String, String> d(SharedPreferences sharedPreferences) {
        h.b(sharedPreferences, "sharedPreferences");
        i<String, String, String> a2 = d.a("PIN", sharedPreferences, "");
        h.a((Object) a2, "PreferenceUtils.stringSt…\", sharedPreferences, \"\")");
        return a2;
    }

    public final i<String, String, String> e(SharedPreferences sharedPreferences) {
        h.b(sharedPreferences, "sharedPreferences");
        i<String, String, String> a2 = d.a("MIDDLE_SESSION", sharedPreferences, "");
        h.a((Object) a2, "PreferenceUtils.stringSt…\", sharedPreferences, \"\")");
        return a2;
    }
}
