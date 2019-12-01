package l.a.c.c;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.D;
import androidx.lifecycle.D.b;
import androidx.lifecycle.E;
import androidx.lifecycle.l;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;

/* compiled from: LifecycleViewModelProviders.kt */
public final class q {

    /* renamed from: a reason: collision with root package name */
    public static final q f10391a = new q();

    private q() {
    }

    public static /* synthetic */ D a(q qVar, l lVar, b bVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bVar = qVar.a(lVar);
        }
        return qVar.a(lVar, bVar);
    }

    public final D a(l lVar, b bVar) {
        h.b(lVar, "lifecycleOwner");
        h.b(bVar, "factory");
        if (lVar instanceof c) {
            D a2 = E.a((Fragment) ((c) lVar).getFragment(), bVar);
            h.a((Object) a2, "ViewModelProviders.of(li…eOwner.fragment, factory)");
            return a2;
        }
        String str = "ViewModelProviders.of(lifecycleOwner, factory)";
        if (lVar instanceof Fragment) {
            D a3 = E.a((Fragment) lVar, bVar);
            h.a((Object) a3, str);
            return a3;
        } else if (lVar instanceof C0195j) {
            D a4 = E.a((C0195j) lVar, bVar);
            h.a((Object) a4, str);
            return a4;
        } else {
            throw new IllegalArgumentException("Not supported LifecycleOwner.");
        }
    }

    public final b a(Object obj) {
        h.b(obj, "provider");
        if (obj instanceof u) {
            return ((u) obj).a();
        }
        if (obj instanceof c) {
            return a(((c) obj).getFragment());
        }
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            Object parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                parentFragment = fragment.requireActivity();
                h.a(parentFragment, "provider.requireActivity()");
            }
            return a(parentFragment);
        } else if (obj instanceof Activity) {
            Application application = ((Activity) obj).getApplication();
            h.a((Object) application, "provider.application");
            return a(application);
        } else {
            throw new IllegalArgumentException("View model factory not found.");
        }
    }
}
