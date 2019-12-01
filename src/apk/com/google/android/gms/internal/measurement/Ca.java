package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

final /* synthetic */ class Ca implements OnSharedPreferenceChangeListener {

    /* renamed from: a reason: collision with root package name */
    private final C0475za f4875a;

    Ca(C0475za zaVar) {
        this.f4875a = zaVar;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.f4875a.a(sharedPreferences, str);
    }
}
