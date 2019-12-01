package l.a.d.a.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;
import l.a.d.b.a.c;

/* compiled from: FragmentNavigation.kt */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final C0120a f10395a = new C0120a(null);

    /* renamed from: b reason: collision with root package name */
    private final Context f10396b;

    /* renamed from: c reason: collision with root package name */
    private final C0200o f10397c;

    /* renamed from: d reason: collision with root package name */
    private final int f10398d;

    /* renamed from: e reason: collision with root package name */
    private final int f10399e;

    /* renamed from: l.a.d.a.a.a$a reason: collision with other inner class name */
    /* compiled from: FragmentNavigation.kt */
    public static final class C0120a {
        private C0120a() {
        }

        public /* synthetic */ C0120a(e eVar) {
            this();
        }
    }

    public a(Context context, C0200o oVar, int i2, int i3) {
        h.b(context, "context");
        h.b(oVar, "fragmentManager");
        this.f10396b = context;
        this.f10397c = oVar;
        this.f10398d = i2;
        this.f10399e = i3;
    }

    public final void a(Class<? extends Fragment> cls, Fragment fragment, int i2, boolean z, Bundle bundle, String str, b<? super F, m> bVar) {
        h.b(cls, "fragmentClass");
        if (this.f10397c.f()) {
            c.a("FragmentManager is destroyed");
            return;
        }
        Fragment instantiate = Fragment.instantiate(this.f10396b, cls.getName(), bundle);
        instantiate.setTargetFragment(fragment, i2);
        F a2 = this.f10397c.a();
        h.a((Object) a2, "fragmentManager.beginTransaction()");
        if (bVar != null) {
            m mVar = (m) bVar.a(a2);
        }
        a2.b(this.f10398d, instantiate, null);
        if (z) {
            a2.a(str);
            a2.a(this.f10399e);
        }
        a2.d(instantiate);
        a2.a();
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (this.f10397c.f()) {
            c.a("FragmentManager is destroyed");
            return;
        }
        if (this.f10397c.b() > 0) {
            this.f10397c.a((String) null, 1);
        }
    }

    public final boolean c() {
        if (this.f10397c.b() == 0) {
            return true;
        }
        C0200o oVar = this.f10397c;
        androidx.fragment.app.C0200o.a b2 = oVar.b(oVar.b() - 1);
        h.a((Object) b2, "fragmentManager\n        ….backStackEntryCount - 1)");
        String name = b2.getName();
        if (name != null) {
            return s.a((CharSequence) name, (CharSequence) "TOP_FRAGMENT", false, 2, (Object) null);
        }
        return false;
    }

    public final boolean a() {
        if (this.f10397c.b() < 1) {
            return false;
        }
        this.f10397c.g();
        return true;
    }

    public static /* synthetic */ void a(a aVar, String str, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            aVar.a(str, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: up");
    }

    public final void a(String str, boolean z) {
        this.f10397c.a(str, z ? 1 : 0);
    }

    public final void a(Class<? extends Fragment> cls, Bundle bundle, boolean z, b<? super F, m> bVar) {
        h.b(cls, "fragmentClass");
        a(cls, null, 0, z, bundle, "TOP_FRAGMENT", bVar);
    }

    public static /* synthetic */ void a(a aVar, Class cls, Bundle bundle, b bVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bundle = null;
            }
            if ((i2 & 4) != 0) {
                bVar = null;
            }
            aVar.a(cls, bundle, bVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setInitial");
    }

    public final void a(Class<? extends Fragment> cls, Bundle bundle, b<? super F, m> bVar) {
        h.b(cls, "fragmentClass");
        b();
        a(cls, bundle, false, bVar);
    }
}
