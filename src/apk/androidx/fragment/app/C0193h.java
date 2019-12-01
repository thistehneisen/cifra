package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.h reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0193h extends C0196k {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Fragment f1535a;

    C0193h(Fragment fragment) {
        this.f1535a = fragment;
    }

    public View a(int i2) {
        View view = this.f1535a.mView;
        if (view != null) {
            return view.findViewById(i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" does not have a view");
        throw new IllegalStateException(sb.toString());
    }

    public boolean a() {
        return this.f1535a.mView != null;
    }
}
