package com.touchin.vtb.b;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.e.b.h;

/* compiled from: VTBAnalytics.kt */
public final class i {

    /* renamed from: a reason: collision with root package name */
    private final FirebaseAnalytics f7181a;

    public i(Context context) {
        h.b(context, "context");
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
        h.a((Object) instance, "FirebaseAnalytics.getInstance(context)");
        this.f7181a = instance;
    }

    public final void a(g gVar) {
        h.b(gVar, "event");
        this.f7181a.a(gVar.b(), gVar.a());
    }

    public final void a(h hVar) {
        h.b(hVar, "screen");
        Bundle bundle = new Bundle();
        bundle.putString("item_name", hVar.a());
        this.f7181a.a(hVar.a(), bundle);
    }

    public final void a(f fVar) {
        h.b(fVar, "error");
        Bundle bundle = new Bundle();
        bundle.putString("item_name", fVar.a());
        this.f7181a.a(fVar.a(), bundle);
    }

    public final void a(e eVar, String str) {
        h.b(eVar, "property");
        h.b(str, "propertyValue");
        this.f7181a.a(eVar.a(), str);
    }
}
