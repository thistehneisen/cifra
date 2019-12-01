package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.D.a;
import androidx.lifecycle.D.b;

/* compiled from: ViewModelProviders */
public class E {
    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    private static Activity a(Fragment fragment) {
        C0195j activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    public static D a(Fragment fragment, b bVar) {
        Application a2 = a(a(fragment));
        if (bVar == null) {
            bVar = a.a(a2);
        }
        return new D(fragment.getViewModelStore(), bVar);
    }

    public static D a(C0195j jVar, b bVar) {
        Application a2 = a((Activity) jVar);
        if (bVar == null) {
            bVar = a.a(a2);
        }
        return new D(jVar.getViewModelStore(), bVar);
    }
}
