package com.google.firebase.analytics.a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.a;
import com.google.firebase.a.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements a {

    /* renamed from: a reason: collision with root package name */
    private static volatile a f6656a;

    /* renamed from: b reason: collision with root package name */
    private final AppMeasurement f6657b;

    /* renamed from: c reason: collision with root package name */
    final Map<String, Object> f6658c = new ConcurrentHashMap();

    private b(AppMeasurement appMeasurement) {
        q.a(appMeasurement);
        this.f6657b = appMeasurement;
    }

    public static a a(FirebaseApp firebaseApp, Context context, d dVar) {
        q.a(firebaseApp);
        q.a(context);
        q.a(dVar);
        q.a(context.getApplicationContext());
        if (f6656a == null) {
            synchronized (b.class) {
                if (f6656a == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.e()) {
                        dVar.a(a.class, d.f6660a, c.f6659a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    f6656a = new b(AppMeasurement.a(context, bundle));
                }
            }
        }
        return f6656a;
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.b.a(str) && com.google.firebase.analytics.connector.internal.b.a(str2, bundle) && com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle)) {
            this.f6657b.logEventInternal(str, str2, bundle);
        }
    }

    public void a(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.b.a(str) && com.google.firebase.analytics.connector.internal.b.a(str, str2)) {
            this.f6657b.a(str, str2, obj);
        }
    }

    static final /* synthetic */ void a(com.google.firebase.a.a aVar) {
        boolean z = ((a) aVar.a()).f6647a;
        synchronized (b.class) {
            ((b) f6656a).f6657b.a(z);
        }
    }
}
