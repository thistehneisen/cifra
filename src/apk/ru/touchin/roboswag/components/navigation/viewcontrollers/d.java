package ru.touchin.roboswag.components.navigation.viewcontrollers;

import android.content.Context;
import android.os.Parcelable;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;
import l.a.d.a.a.a;

/* compiled from: ViewControllerNavigation.kt */
public class d<TActivity extends C0195j> extends a {
    public /* synthetic */ d(Context context, C0200o oVar, int i2, int i3, int i4, e eVar) {
        if ((i4 & 8) != 0) {
            i3 = 4097;
        }
        this(context, oVar, i2, i3);
    }

    public static /* synthetic */ void a(d dVar, Class cls, Parcelable parcelable, boolean z, String str, b bVar, int i2, Object obj) {
        if (obj == null) {
            dVar.a(cls, parcelable, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : bVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushViewController");
    }

    public d(Context context, C0200o oVar, int i2, int i3) {
        h.b(context, "context");
        h.b(oVar, "fragmentManager");
        super(context, oVar, i2, i3);
    }

    public final <TState extends Parcelable> void a(Class<? extends c<? extends TActivity, TState>> cls, TState tstate, boolean z, String str, b<? super F, m> bVar) {
        h.b(cls, "viewControllerClass");
        h.b(tstate, "state");
        a(l.a.d.a.a.b.a.class, null, 0, z, l.a.d.a.a.b.a.f10403a.a(cls, tstate), str, bVar);
    }

    public static /* synthetic */ void a(d dVar, Class cls, Parcelable parcelable, Fragment fragment, int i2, String str, b bVar, int i3, Object obj) {
        if (obj == null) {
            dVar.a(cls, (TState) parcelable, (TTargetFragment) fragment, i2, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : bVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushViewControllerForResult");
    }

    public final <TState extends Parcelable, TTargetFragment extends Fragment> void a(Class<? extends c<? extends TActivity, TState>> cls, TState tstate, TTargetFragment ttargetfragment, int i2, String str, b<? super F, m> bVar) {
        h.b(cls, "viewControllerClass");
        h.b(tstate, "state");
        h.b(ttargetfragment, "targetFragment");
        a(l.a.d.a.a.b.a.class, ttargetfragment, i2, true, l.a.d.a.a.b.a.f10403a.a(cls, tstate), str, bVar);
    }

    public final <TState extends Parcelable> void a(Class<? extends c<? extends TActivity, TState>> cls, TState tstate, boolean z, b<? super F, m> bVar) {
        h.b(cls, "viewControllerClass");
        h.b(tstate, "state");
        a(l.a.d.a.a.b.a.class, null, 0, z, l.a.d.a.a.b.a.f10403a.a(cls, tstate), "TOP_FRAGMENT", bVar);
    }

    public static /* synthetic */ void a(d dVar, Class cls, Parcelable parcelable, b bVar, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                bVar = null;
            }
            dVar.a(cls, parcelable, bVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setInitialViewController");
    }

    public final <TState extends Parcelable> void a(Class<? extends c<? extends TActivity, TState>> cls, TState tstate, b<? super F, m> bVar) {
        h.b(cls, "viewControllerClass");
        h.b(tstate, "state");
        b();
        a(cls, tstate, false, bVar);
    }
}
