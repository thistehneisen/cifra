package io.intercom.com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.C0195j;
import androidx.fragment.app.Fragment;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.bumptech.glide.n;
import java.util.HashSet;

/* compiled from: SupportRequestManagerFragment */
public class q extends Fragment {

    /* renamed from: a reason: collision with root package name */
    private final a f9249a;

    /* renamed from: b reason: collision with root package name */
    private final o f9250b;

    /* renamed from: c reason: collision with root package name */
    private final HashSet<q> f9251c;

    /* renamed from: d reason: collision with root package name */
    private q f9252d;

    /* renamed from: e reason: collision with root package name */
    private n f9253e;

    /* renamed from: f reason: collision with root package name */
    private Fragment f9254f;

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
        return parentFragment != null ? parentFragment : this.f9254f;
    }

    private void e() {
        q qVar = this.f9252d;
        if (qVar != null) {
            qVar.b(this);
            this.f9252d = null;
        }
    }

    public void a(n nVar) {
        this.f9253e = nVar;
    }

    public n b() {
        return this.f9253e;
    }

    public o c() {
        return this.f9250b;
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
        this.f9249a.a();
        e();
    }

    public void onDetach() {
        super.onDetach();
        this.f9254f = null;
        e();
    }

    public void onStart() {
        super.onStart();
        this.f9249a.b();
    }

    public void onStop() {
        super.onStop();
        this.f9249a.c();
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
        this.f9250b = new a();
        this.f9251c = new HashSet<>();
        this.f9249a = aVar;
    }

    private void b(q qVar) {
        this.f9251c.remove(qVar);
    }

    /* access modifiers changed from: 0000 */
    public a a() {
        return this.f9249a;
    }

    private void a(q qVar) {
        this.f9251c.add(qVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(Fragment fragment) {
        this.f9254f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private void a(C0195j jVar) {
        e();
        this.f9252d = c.a((Context) jVar).h().a(jVar.getSupportFragmentManager(), (Fragment) null);
        q qVar = this.f9252d;
        if (qVar != this) {
            qVar.a(this);
        }
    }
}
