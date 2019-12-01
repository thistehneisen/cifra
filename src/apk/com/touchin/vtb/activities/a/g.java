package com.touchin.vtb.activities.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.touchin.vtb.R;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.c;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.k;
import kotlin.e.b.l;
import kotlin.e.b.o;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: NavigationContainerFragment.kt */
public final class g extends Fragment {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ kotlin.g.g[] f7011a;

    /* renamed from: b reason: collision with root package name */
    public static final a f7012b = new a(null);

    /* renamed from: c reason: collision with root package name */
    private final c f7013c = e.a(new h(this));

    /* renamed from: d reason: collision with root package name */
    private HashMap f7014d;

    /* compiled from: NavigationContainerFragment.kt */
    public static final class a {
        private a() {
        }

        public final Bundle a(Class<? extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<?, ?>> cls, Parcelable parcelable) {
            h.b(cls, "cls");
            h.b(parcelable, "state");
            Bundle bundle = new Bundle();
            bundle.putSerializable("VIEW_CONTROLLER_CLASS_ARG", cls);
            bundle.putParcelable("VIEW_CONTROLLER_STATE_ARG", parcelable);
            return bundle;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    static {
        l lVar = new l(o.a(g.class), "navigation", "getNavigation()Lru/touchin/roboswag/components/navigation/viewcontrollers/ViewControllerNavigation;");
        o.a((k) lVar);
        f7011a = new kotlin.g.g[]{lVar};
    }

    public void a() {
        HashMap hashMap = this.f7014d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final d<com.touchin.vtb.activities.c> b() {
        c cVar = this.f7013c;
        kotlin.g.g gVar = f7011a[0];
        return (d) cVar.getValue();
    }

    public final Class<? extends ru.touchin.roboswag.components.navigation.viewcontrollers.c<? extends com.touchin.vtb.activities.c, Parcelable>> c() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("VIEW_CONTROLLER_CLASS_ARG") : null;
        if (serializable != null) {
            return (Class) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController<out com.touchin.vtb.activities.NavigationActivity, android.os.Parcelable>>");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                h.a((Object) arguments, "arguments ?: return");
                d b2 = b();
                Class c2 = c();
                Parcelable parcelable = arguments.getParcelable("VIEW_CONTROLLER_STATE_ARG");
                h.a((Object) parcelable, "args.getParcelable(VIEW_CONTROLLER_STATE_ARG)");
                d.a(b2, c2, parcelable, (b) null, 4, (Object) null);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_container, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }
}
