package com.touchin.vtb.activities.a;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.C0200o.b;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import b.g.i.G;
import com.touchin.vtb.R;
import kotlin.TypeCastException;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g;
import kotlin.m;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;

/* compiled from: BottomNavigationController.kt */
public final class c {

    /* renamed from: a reason: collision with root package name */
    private b f7001a;

    /* renamed from: b reason: collision with root package name */
    private int f7002b = -1;

    /* renamed from: c reason: collision with root package name */
    private final Context f7003c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final C0200o f7004d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final SparseArray<g<Class<? extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<?, ?>>, Parcelable>> f7005e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final a<m> f7006f;

    public c(Context context, C0200o oVar, SparseArray<g<Class<? extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<?, ?>>, Parcelable>> sparseArray, a<m> aVar) {
        h.b(context, "context");
        h.b(oVar, "fragmentManager");
        h.b(sparseArray, "viewControllers");
        this.f7003c = context;
        this.f7004d = oVar;
        this.f7005e = sparseArray;
        this.f7006f = aVar;
    }

    private final void b(ViewGroup viewGroup) {
        this.f7001a = new a(this, viewGroup);
    }

    public final void a(ViewGroup viewGroup) {
        h.b(viewGroup, "navigationContainer");
        a();
        b(viewGroup);
        b bVar = this.f7001a;
        if (bVar != null) {
            this.f7004d.a(bVar, false);
        }
        for (View view : G.a(viewGroup)) {
            g gVar = (g) this.f7005e.get(view.getId());
            if (gVar != null) {
                a(view, (Class) gVar.a());
            }
        }
    }

    public final int b() {
        return this.f7002b;
    }

    private final void a(View view, Class<? extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<?, ?>> cls) {
        view.setOnClickListener(new b(this, cls, view));
    }

    public final m a() {
        b bVar = this.f7001a;
        if (bVar == null) {
            return null;
        }
        this.f7004d.a(bVar);
        return m.f10346a;
    }

    public static /* synthetic */ void a(c cVar, int i2, Parcelable parcelable, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            parcelable = null;
        }
        cVar.a(i2, parcelable);
    }

    public final void a(int i2, Parcelable parcelable) {
        g gVar = (g) this.f7005e.get(i2);
        if (gVar != null) {
            Class cls = (Class) gVar.a();
            Parcelable parcelable2 = (Parcelable) gVar.b();
            if (parcelable == null || !(!h.a((Object) o.a(parcelable.getClass()), (Object) o.a(parcelable2.getClass())))) {
                if (parcelable != null) {
                    parcelable2 = parcelable;
                }
                F a2 = this.f7004d.a();
                h.a((Object) a2, "fragmentManager.beginTransaction()");
                Fragment e2 = this.f7004d.e();
                if (e2 != null) {
                    a2.b(e2);
                }
                String canonicalName = cls.getCanonicalName();
                Fragment a3 = this.f7004d.a(canonicalName);
                if (parcelable != null || a3 == null) {
                    if (a3 != null) {
                        a2.c(a3);
                    }
                    a3 = Fragment.instantiate(this.f7003c, g.class.getName(), g.f7012b.a(cls, parcelable2));
                    a2.a(R.id.fragment_container, a3, canonicalName);
                } else {
                    a2.a(a3);
                }
                a2.d(a3);
                a2.a(true);
                a2.a();
                this.f7002b = i2;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Incorrect state type for navigation tab root ViewController. Should be ");
            sb.append(o.a(parcelable2.getClass()));
            throw new ShouldNotHappenException(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public final boolean a(Fragment fragment, Class<? extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<?, ?>> cls) {
        if (fragment != null) {
            return ((g) fragment).c() == cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.touchin.vtb.activities.navigation.NavigationContainerFragment");
    }
}
