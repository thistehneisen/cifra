package c.b.a.c.f;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper */
public final class c {

    /* renamed from: a reason: collision with root package name */
    private final View f3144a;

    /* renamed from: b reason: collision with root package name */
    private boolean f3145b = false;

    /* renamed from: c reason: collision with root package name */
    private int f3146c = 0;

    public c(b bVar) {
        this.f3144a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.f3144a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).a(this.f3144a);
        }
    }

    public void a(Bundle bundle) {
        this.f3145b = bundle.getBoolean("expanded", false);
        this.f3146c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f3145b) {
            d();
        }
    }

    public boolean b() {
        return this.f3145b;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f3145b);
        bundle.putInt("expandedComponentIdHint", this.f3146c);
        return bundle;
    }

    public void a(int i2) {
        this.f3146c = i2;
    }

    public int a() {
        return this.f3146c;
    }
}
