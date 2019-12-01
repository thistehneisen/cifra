package com.touchin.vtb.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.C;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.a.f;
import com.touchin.vtb.b.g;
import com.touchin.vtb.b.i;
import com.touchin.vtb.h.a.k;
import io.intercom.android.sdk.Intercom;
import kotlin.e.b.h;
import l.a.c.c.q;
import org.joda.time.b;

/* compiled from: MainActivity.kt */
public final class MainActivity extends c {

    /* renamed from: g reason: collision with root package name */
    public static final a f6990g = new a(null);

    /* renamed from: h reason: collision with root package name */
    private k f6991h;

    /* renamed from: i reason: collision with root package name */
    private com.touchin.vtb.h.a.a f6992i;

    /* renamed from: j reason: collision with root package name */
    private b f6993j;

    /* compiled from: MainActivity.kt */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ Intent a(a aVar, Context context, String str, Boolean bool, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            if ((i3 & 4) != 0) {
                bool = Boolean.valueOf(false);
            }
            if ((i3 & 8) != 0) {
                i2 = R.id.main_navigation_tasks;
            }
            return aVar.a(context, str, bool, i2);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public final Intent a(Context context, String str, Boolean bool, int i2) {
            h.b(context, "context");
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("NAVIGATE_TO_ITEM_ID_KEY", i2);
            if (str != null) {
                intent.putExtra("PUSH_TASK_ID_KEY", str);
            }
            if (bool != null) {
                bool.booleanValue();
                intent.putExtra("IS_DEADLINE_PUSH_KEY", bool.booleanValue());
            }
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.common_activity);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(k.class);
        h.a((Object) a2, "LifecycleViewModelProvid…ityViewModel::class.java)");
        this.f6991h = (k) a2;
        C a3 = q.a(q.f10391a, this, null, 2, null).a(com.touchin.vtb.h.a.a.class);
        h.a((Object) a3, "LifecycleViewModelProvid…imeViewModel::class.java)");
        this.f6992i = (com.touchin.vtb.h.a.a) a3;
        b g2 = b.g();
        h.a((Object) g2, "DateTime.now()");
        this.f6993j = g2;
        com.touchin.vtb.h.a.a aVar = this.f6992i;
        if (aVar != null) {
            aVar.a(0);
            k kVar = this.f6991h;
            if (kVar != null) {
                String string = getString(R.string.common_intercom_company_custom_attributes_inn);
                h.a((Object) string, "getString(R.string.commo…ny_custom_attributes_inn)");
                kVar.a(string);
                Bundle bundle2 = new Bundle();
                String str = "NAVIGATE_TO_ITEM_ID_KEY";
                bundle2.putInt(str, getIntent().getIntExtra(str, R.id.main_navigation_tasks));
                String str2 = "PUSH_TASK_ID_KEY";
                bundle2.putString(str2, getIntent().getStringExtra(str2));
                String str3 = "IS_DEADLINE_PUSH_KEY";
                bundle2.putBoolean(str3, getIntent().getBooleanExtra(str3, false));
                l.a.d.a.a.a.a(c(), f.class, bundle2, null, 4, null);
                return;
            }
            h.b("viewModel");
            throw null;
        }
        h.b("bankUsageTimeViewModel");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Intercom.client().handlePushMessage();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        i d2 = d();
        com.touchin.vtb.h.a.a aVar = this.f6992i;
        if (aVar != null) {
            long j2 = (long) 1000;
            long c2 = aVar.c() / j2;
            b g2 = b.g();
            h.a((Object) g2, "DateTime.now()");
            long n = g2.n();
            b bVar = this.f6993j;
            if (bVar != null) {
                d2.a((g) new com.touchin.vtb.b.g.a(c2, (n - bVar.n()) / j2));
            } else {
                h.b("timeOfStart");
                throw null;
            }
        } else {
            h.b("bankUsageTimeViewModel");
            throw null;
        }
    }
}
