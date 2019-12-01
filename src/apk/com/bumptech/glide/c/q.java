package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.e;
import com.bumptech.glide.n;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment */
public class q extends Fragment {

    /* renamed from: a reason: collision with root package name */
    private final a f3380a;

    /* renamed from: b reason: collision with root package name */
    private final o f3381b;

    /* renamed from: c reason: collision with root package name */
    private final Set<q> f3382c;

    /* renamed from: d reason: collision with root package name */
    private q f3383d;

    /* renamed from: e reason: collision with root package name */
    private n f3384e;

    /* renamed from: f reason: collision with root package name */
    private Fragment f3385f;

    /* compiled from: SupportRequestManagerFragment */
    private class a implements o {
        a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(q.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public q() {
        this(new a());
    }

    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f3385f;
    }

    private void e() {
        q qVar = this.f3383d;
        if (qVar != null) {
            qVar.b(this);
            this.f3383d = null;
        }
    }

    public void a(n nVar) {
        this.f3384e = nVar;
    }

    public n b() {
        return this.f3384e;
    }

    public o c() {
        return this.f3381b;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getActivity());
        } catch (IllegalStateException e2) {
            String str = "SupportRMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3380a.a();
        e();
    }

    public void onDetach() {
        super.onDetach();
        this.f3385f = null;
        e();
    }

    public void onStart() {
        super.onStart();
        this.f3380a.b();
    }

    public void onStop() {
        super.onStop();
        this.f3380a.c();
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
    public q(a aVar) {
        this.f3381b = new a();
        this.f3382c = new HashSet();
        this.f3380a = aVar;
    }

    private void b(q qVar) {
        this.f3382c.remove(qVar);
    }

    /* access modifiers changed from: 0000 */
    public a a() {
        return this.f3380a;
    }

    private void a(q qVar) {
        this.f3382c.add(qVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment) {
        this.f3385f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private void a(C0195j jVar) {
        e();
        this.f3383d = e.a((Context) jVar).h().b(jVar);
        if (!equals(this.f3383d)) {
            this.f3383d.a(this);
        }
    }
}
