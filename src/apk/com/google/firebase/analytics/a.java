package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.Cf;
import com.google.android.gms.measurement.internal.C0572sc;
import com.google.android.gms.measurement.internal.Mc;
import java.util.List;
import java.util.Map;

final class a implements Mc {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Cf f6655a;

    a(Cf cf) {
        this.f6655a = cf;
    }

    public final void a(String str, String str2, Bundle bundle) {
        this.f6655a.b(str, str2, bundle);
    }

    public final long b() {
        return this.f6655a.a();
    }

    public final String c() {
        return this.f6655a.c();
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f6655a.a(str, str2, bundle);
    }

    public final String d() {
        return this.f6655a.d();
    }

    public final String e() {
        return this.f6655a.b();
    }

    public final void setDataCollectionEnabled(boolean z) {
        this.f6655a.a(z);
    }

    public final void a(String str, String str2, Object obj) {
        this.f6655a.a(str, str2, obj);
    }

    public final void b(String str) {
        this.f6655a.a(str);
    }

    public final void c(String str) {
        this.f6655a.b(str);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        return this.f6655a.a(str, str2, z);
    }

    public final void a(C0572sc scVar) {
        this.f6655a.a(scVar);
    }

    public final String a() {
        return this.f6655a.e();
    }

    public final void a(Bundle bundle) {
        this.f6655a.a(bundle);
    }

    public final List<Bundle> a(String str, String str2) {
        return this.f6655a.a(str, str2);
    }

    public final int a(String str) {
        return this.f6655a.c(str);
    }
}
