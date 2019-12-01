package com.touchin.vtb.activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.C0134a;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.Fragment;
import com.touchin.vtb.R;
import com.touchin.vtb.VTBAccountingApplication;
import com.touchin.vtb.b.b;
import com.touchin.vtb.b.i;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.Intercom.Visibility;
import kotlin.TypeCastException;
import kotlin.e.b.h;
import kotlin.e.b.k;
import kotlin.e.b.l;
import kotlin.e.b.o;
import kotlin.g.g;
import l.a.d.a.a.a.a;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: NavigationActivity.kt */
public abstract class c extends a {

    /* renamed from: c reason: collision with root package name */
    static final /* synthetic */ g[] f7015c;

    /* renamed from: d reason: collision with root package name */
    private final kotlin.c f7016d = e.a(new b(this));

    /* renamed from: e reason: collision with root package name */
    private final kotlin.c f7017e = e.a(new a(this));

    /* renamed from: f reason: collision with root package name */
    private b f7018f;

    static {
        l lVar = new l(o.a(c.class), "vtbAnalytics", "getVtbAnalytics()Lcom/touchin/vtb/analytics/VTBAnalytics;");
        o.a((k) lVar);
        l lVar2 = new l(o.a(c.class), "screenNavigation", "getScreenNavigation()Lru/touchin/roboswag/components/navigation/viewcontrollers/ViewControllerNavigation;");
        o.a((k) lVar2);
        f7015c = new g[]{lVar, lVar2};
    }

    public static /* synthetic */ void a(c cVar, Toolbar toolbar, String str, String str2, boolean z, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            cVar.a(toolbar, str3, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? R.drawable.common_navigation_icon_selector : i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBar");
    }

    private final d<c> e() {
        kotlin.c cVar = this.f7017e;
        g gVar = f7015c[1];
        return (d) cVar.getValue();
    }

    private final void f() {
        Visibility visibility;
        Intercom client = Intercom.client();
        if (this instanceof MainActivity) {
            visibility = Visibility.VISIBLE;
        } else {
            visibility = Visibility.GONE;
        }
        client.setInAppMessageVisibility(visibility);
    }

    public final d<c> b() {
        com.touchin.vtb.activities.a.g a2 = a(getSupportFragmentManager());
        if (a2 != null) {
            d<c> b2 = a2.b();
            if (b2 != null) {
                return b2;
            }
        }
        return e();
    }

    public final d<c> c() {
        return e();
    }

    public final i d() {
        kotlin.c cVar = this.f7016d;
        g gVar = f7015c[0];
        return (i) cVar.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        h.a((Object) window, "window");
        View decorView = window.getDecorView();
        h.a((Object) decorView, "window.decorView");
        decorView.setSystemUiVisibility(1280);
        super.onCreate(bundle);
        Resources resources = getResources();
        h.a((Object) resources, "resources");
        Configuration configuration = resources.getConfiguration();
        h.a((Object) configuration, "resources.configuration");
        a(configuration);
        f();
        Application application = getApplication();
        if (application != null) {
            this.f7018f = new b((VTBAccountingApplication) application);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.touchin.vtb.VTBAccountingApplication");
    }

    public final void a(Toolbar toolbar, String str, String str2, boolean z, int i2) {
        h.b(toolbar, "toolbar");
        h.b(str, "title");
        setSupportActionBar(toolbar);
        C0134a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b((CharSequence) str);
            if (str2 != null) {
                supportActionBar.a((CharSequence) str2);
            }
            supportActionBar.d(z);
            supportActionBar.b(i2);
        }
    }

    public final void a(Intent intent) {
        h.b(intent, "intent");
        startActivity(intent);
        finish();
    }

    private final void a(Configuration configuration) {
        configuration.fontScale = 1.0f;
        Resources resources = getResources();
        h.a((Object) resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Object systemService = getSystemService("window");
        if (systemService != null) {
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
            Context baseContext = getBaseContext();
            h.a((Object) baseContext, "baseContext");
            baseContext.getResources().updateConfiguration(configuration, displayMetrics);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final com.touchin.vtb.activities.a.g a(C0200o oVar) {
        com.touchin.vtb.activities.a.g gVar = null;
        if (oVar == null) {
            return null;
        }
        Fragment e2 = oVar.e();
        if (e2 == null) {
            return null;
        }
        if (e2 instanceof com.touchin.vtb.activities.a.g) {
            gVar = e2;
        }
        com.touchin.vtb.activities.a.g gVar2 = gVar;
        if (gVar2 != null) {
            return gVar2;
        }
        h.a((Object) e2, "navigationFragment");
        return a(e2.getChildFragmentManager());
    }
}
