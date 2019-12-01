package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* compiled from: ReportFragment */
public class B extends Fragment {

    /* renamed from: a reason: collision with root package name */
    private a f1602a;

    /* compiled from: ReportFragment */
    interface a {
        void a();

        void onCreate();

        void onStart();
    }

    static B a(Activity activity) {
        return (B) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        String str = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
        if (fragmentManager.findFragmentByTag(str) == null) {
            fragmentManager.beginTransaction().add(new B(), str).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f1602a);
        a(androidx.lifecycle.h.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(androidx.lifecycle.h.a.ON_DESTROY);
        this.f1602a = null;
    }

    public void onPause() {
        super.onPause();
        a(androidx.lifecycle.h.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        c(this.f1602a);
        a(androidx.lifecycle.h.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        d(this.f1602a);
        a(androidx.lifecycle.h.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(androidx.lifecycle.h.a.ON_STOP);
    }

    private void a(androidx.lifecycle.h.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof o) {
            ((o) activity).getLifecycle().b(aVar);
            return;
        }
        if (activity instanceof l) {
            h lifecycle = ((l) activity).getLifecycle();
            if (lifecycle instanceof n) {
                ((n) lifecycle).b(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.f1602a = aVar;
    }
}
