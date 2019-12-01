package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.za reason: case insensitive filesystem */
public final class C0475za implements C0392la {

    /* renamed from: a reason: collision with root package name */
    static final Map<String, C0475za> f5443a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private final SharedPreferences f5444b;

    /* renamed from: c reason: collision with root package name */
    private final OnSharedPreferenceChangeListener f5445c = new Ca(this);

    /* renamed from: d reason: collision with root package name */
    private final Object f5446d = new Object();

    /* renamed from: e reason: collision with root package name */
    private volatile Map<String, ?> f5447e;

    /* renamed from: f reason: collision with root package name */
    private final List<C0398ma> f5448f = new ArrayList();

    private C0475za(SharedPreferences sharedPreferences) {
        this.f5444b = sharedPreferences;
        this.f5444b.registerOnSharedPreferenceChangeListener(this.f5445c);
    }

    static C0475za a(Context context, String str) {
        C0475za zaVar;
        SharedPreferences sharedPreferences;
        if (!((!C0374ia.a() || str.startsWith("direct_boot:")) ? true : C0374ia.a(context))) {
            return null;
        }
        synchronized (C0475za.class) {
            zaVar = (C0475za) f5443a.get(str);
            if (zaVar == null) {
                if (str.startsWith("direct_boot:")) {
                    if (C0374ia.a()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zaVar = new C0475za(sharedPreferences);
                f5443a.put(str, zaVar);
            }
        }
        return zaVar;
    }

    public final Object a(String str) {
        Map<String, ?> map = this.f5447e;
        if (map == null) {
            synchronized (this.f5446d) {
                map = this.f5447e;
                if (map == null) {
                    map = this.f5444b.getAll();
                    this.f5447e = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f5446d) {
            this.f5447e = null;
            C0439ta.b();
        }
        synchronized (this) {
            for (C0398ma a2 : this.f5448f) {
                a2.a();
            }
        }
    }
}
