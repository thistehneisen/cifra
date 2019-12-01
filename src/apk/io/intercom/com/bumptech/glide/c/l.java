package io.intercom.com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;
import java.util.HashSet;

/* compiled from: RequestManagerFragment */
public class l extends Fragment {

    /* renamed from: a reason: collision with root package name */
    private final a f9230a;

    /* renamed from: b reason: collision with root package name */
    private final o f9231b;

    /* renamed from: c reason: collision with root package name */
    private final HashSet<l> f9232c;

    /* renamed from: d reason: collision with root package name */
    private n f9233d;

    /* renamed from: e reason: collision with root package name */
    private l f9234e;

    /* renamed from: f reason: collision with root package name */
    private Fragment f9235f;

    /* compiled from: RequestManagerFragment */
    private class a implements o {
        a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(l.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public l() {
        this(new a());
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f9235f;
    }

    private void e() {
        l lVar = this.f9234e;
        if (lVar != null) {
            lVar.b(this);
            this.f9234e = null;
        }
    }

    public void a(n nVar) {
        this.f9233d = nVar;
    }

    public n b() {
        return this.f9233d;
    }

    public o c() {
        return this.f9231b;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            String str = "RMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9230a.a();
        e();
    }

    public void onDetach() {
        super.onDetach();
        e();
    }

    public void onStart() {
        super.onStart();
        this.f9230a.b();
    }

    public void onStop() {
        super.onStop();
        this.f9230a.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(d());
        sb.append("}");
        return sb.toString();
    }

    @SuppressLint({"ValidFragment"})
    l(a aVar) {
        this.f9231b = new a();
        this.f9232c = new HashSet<>();
        this.f9230a = aVar;
    }

    private void b(l lVar) {
        this.f9232c.remove(lVar);
    }

    /* access modifiers changed from: 0000 */
    public a a() {
        return this.f9230a;
    }

    private void a(l lVar) {
        this.f9232c.add(lVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment) {
        this.f9235f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private void a(Activity activity) {
        e();
        this.f9234e = c.a((Context) activity).h().a(activity.getFragmentManager(), (Fragment) null);
        l lVar = this.f9234e;
        if (lVar != this) {
            lVar.a(this);
        }
    }
}
