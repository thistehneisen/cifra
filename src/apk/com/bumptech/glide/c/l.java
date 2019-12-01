package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.n;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* compiled from: RequestManagerFragment */
public class l extends Fragment {

    /* renamed from: a reason: collision with root package name */
    private final a f3361a;

    /* renamed from: b reason: collision with root package name */
    private final o f3362b;

    /* renamed from: c reason: collision with root package name */
    private final Set<l> f3363c;

    /* renamed from: d reason: collision with root package name */
    private n f3364d;

    /* renamed from: e reason: collision with root package name */
    private l f3365e;

    /* renamed from: f reason: collision with root package name */
    private Fragment f3366f;

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
        return parentFragment != null ? parentFragment : this.f3366f;
    }

    private void e() {
        l lVar = this.f3365e;
        if (lVar != null) {
            lVar.b(this);
            this.f3365e = null;
        }
    }

    public void a(n nVar) {
        this.f3364d = nVar;
    }

    public n b() {
        return this.f3364d;
    }

    public o c() {
        return this.f3362b;
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
        this.f3361a.a();
        e();
    }

    public void onDetach() {
        super.onDetach();
        e();
    }

    public void onStart() {
        super.onStart();
        this.f3361a.b();
    }

    public void onStop() {
        super.onStop();
        this.f3361a.c();
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
        this.f3362b = new a();
        this.f3363c = new HashSet();
        this.f3361a = aVar;
    }

    private void b(l lVar) {
        this.f3363c.remove(lVar);
    }

    /* access modifiers changed from: 0000 */
    public a a() {
        return this.f3361a;
    }

    private void a(l lVar) {
        this.f3363c.add(lVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment) {
        this.f3366f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private void a(Activity activity) {
        e();
        this.f3365e = e.a((Context) activity).h().b(activity);
        if (!equals(this.f3365e)) {
            this.f3365e.a(this);
        }
    }
}
