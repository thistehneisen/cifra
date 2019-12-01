package com.touchin.vtb.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.C;
import com.google.android.gms.tasks.g;
import com.google.firebase.iid.C0612a;
import com.touchin.vtb.R;
import com.touchin.vtb.api.UserProfile;
import com.touchin.vtb.b.e;
import com.touchin.vtb.f.i;
import com.touchin.vtb.g.o;
import com.touchin.vtb.h.c.z;
import com.touchin.vtb.utils.c;
import com.touchin.vtb.viewcontrollers.startup.CreatePinViewController;
import com.touchin.vtb.viewcontrollers.startup.EnterPinViewController;
import com.touchin.vtb.viewcontrollers.startup.WelcomeViewController;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.c.q;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: StartupActivity.kt */
public final class StartupActivity extends c {

    /* renamed from: g reason: collision with root package name */
    public static final a f6994g = new a(null);

    /* renamed from: h reason: collision with root package name */
    private z f6995h;

    /* compiled from: StartupActivity.kt */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ Intent a(a aVar, Context context, boolean z, String str, Boolean bool, Boolean bool2, int i2, int i3, Object obj) {
            boolean z2 = (i3 & 2) != 0 ? true : z;
            if ((i3 & 4) != 0) {
                str = null;
            }
            String str2 = str;
            if ((i3 & 8) != 0) {
                bool = Boolean.valueOf(false);
            }
            Boolean bool3 = bool;
            if ((i3 & 16) != 0) {
                bool2 = Boolean.valueOf(false);
            }
            return aVar.a(context, z2, str2, bool3, bool2, (i3 & 32) != 0 ? R.id.main_navigation_tasks : i2);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public final Intent a(Context context, boolean z, String str, Boolean bool, Boolean bool2, int i2) {
            h.b(context, "context");
            Intent flags = new Intent(context, StartupActivity.class).setFlags(z ? 268468224 : 0);
            flags.putExtra("NAVIGATE_TO_ITEM_ID_KEY", i2);
            if (str != null) {
                flags.putExtra("PUSH_TASK_ID_KEY", str);
            }
            if (bool != null) {
                bool.booleanValue();
                flags.putExtra("IS_DEADLINE_PUSH_KEY", bool.booleanValue());
            }
            if (bool2 != null) {
                bool2.booleanValue();
                flags.putExtra("IS_LOGOUT_ACTION", bool2.booleanValue());
            }
            h.a((Object) flags, "Intent(context, StartupA…tion) }\n                }");
            return flags;
        }
    }

    public static final /* synthetic */ z a(StartupActivity startupActivity) {
        z zVar = startupActivity.f6995h;
        if (zVar != null) {
            return zVar;
        }
        h.b("viewModel");
        throw null;
    }

    private final void g() {
        z zVar = this.f6995h;
        String str = "viewModel";
        if (zVar != null) {
            zVar.d().a(this, new d(this));
            z zVar2 = this.f6995h;
            if (zVar2 != null) {
                zVar2.f().a(this, new e(this));
            } else {
                h.b(str);
                throw null;
            }
        } else {
            h.b(str);
            throw null;
        }
    }

    public final b e() {
        z zVar = this.f6995h;
        if (zVar != null) {
            return zVar.c();
        }
        h.b("viewModel");
        throw null;
    }

    public final g<C0612a> f() {
        z zVar = this.f6995h;
        if (zVar != null) {
            return zVar.e();
        }
        h.b("viewModel");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.common_activity);
        C a2 = q.a(q.f10391a, this, null, 2, null).a(z.class);
        h.a((Object) a2, "LifecycleViewModelProvid…tupViewModel::class.java)");
        this.f6995h = (z) a2;
        g();
    }

    /* access modifiers changed from: private */
    public final void a(i iVar) {
        UserProfile userProfile = (UserProfile) iVar.b().a();
        String str = "IS_LOGOUT_ACTION";
        if (userProfile == null) {
            d.a(c(), WelcomeViewController.class, (Parcelable) new o(getIntent().getBooleanExtra(str, false)), (kotlin.e.a.b) null, 4, (Object) null);
            return;
        }
        String e2 = userProfile.e();
        h.a((Object) e2, "userProfile.phoneNumber");
        boolean z = true;
        if (e2.length() == 0) {
            d().a(e.DEVICE_MODEL, c.f7616a.a());
            d.a(c(), WelcomeViewController.class, (Parcelable) new o(getIntent().getBooleanExtra(str, false)), (kotlin.e.a.b) null, 4, (Object) null);
            return;
        }
        if (iVar.a().length() != 0) {
            z = false;
        }
        if (z) {
            com.touchin.vtb.g.c cVar = new com.touchin.vtb.g.c(null, null, false, 7, null);
            d.a(c(), CreatePinViewController.class, (Parcelable) cVar, (kotlin.e.a.b) null, 4, (Object) null);
            return;
        }
        com.touchin.vtb.g.d dVar = new com.touchin.vtb.g.d(iVar.a(), iVar.c(), 0, false, false, getIntent().getStringExtra("PUSH_TASK_ID_KEY"), Boolean.valueOf(getIntent().getBooleanExtra("IS_DEADLINE_PUSH_KEY", false)), getIntent().getIntExtra("NAVIGATE_TO_ITEM_ID_KEY", R.id.main_navigation_tasks), null, null, 0, 0, 3860, null);
        d.a(c(), EnterPinViewController.class, (Parcelable) dVar, (kotlin.e.a.b) null, 4, (Object) null);
    }
}
