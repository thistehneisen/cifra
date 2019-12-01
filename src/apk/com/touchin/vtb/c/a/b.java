package com.touchin.vtb.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.touchin.vtb.api.d;
import com.touchin.vtb.b.i;
import kotlin.e.b.h;

/* compiled from: ApplicationModule.kt */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final Context f7182a;

    public b(Context context) {
        h.b(context, "context");
        this.f7182a = context;
    }

    public final Context a() {
        return this.f7182a;
    }

    public final i b(Context context) {
        h.b(context, "context");
        return new i(context);
    }

    public final SharedPreferences a(Context context) {
        h.b(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        h.a((Object) defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
        return defaultSharedPreferences;
    }

    public final d a(i iVar) {
        h.b(iVar, "vtbAnalytics");
        return new d(iVar);
    }
}
