package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.x;

/* compiled from: RecyclerView */
class P implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecyclerView f1731a;

    P(RecyclerView recyclerView) {
        this.f1731a = recyclerView;
    }

    public int a() {
        return this.f1731a.getChildCount();
    }

    public int b(View view) {
        return this.f1731a.indexOfChild(view);
    }

    public void c(int i2) {
        View childAt = this.f1731a.getChildAt(i2);
        if (childAt != null) {
            this.f1731a.b(childAt);
            childAt.clearAnimation();
        }
        this.f1731a.removeViewAt(i2);
    }

    public void d(View view) {
        x i2 = RecyclerView.i(view);
        if (i2 != null) {
            i2.onLeftHiddenState(this.f1731a);
        }
    }

    public void a(View view, int i2) {
        this.f1731a.addView(view, i2);
        this.f1731a.a(view);
    }

    public void b() {
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            View a3 = a(i2);
            this.f1731a.b(a3);
            a3.clearAnimation();
        }
        this.f1731a.removeAllViews();
    }

    public View a(int i2) {
        return this.f1731a.getChildAt(i2);
    }

    public void a(View view, int i2, LayoutParams layoutParams) {
        x i3 = RecyclerView.i(view);
        if (i3 != null) {
            if (i3.isTmpDetached() || i3.shouldIgnore()) {
                i3.clearTmpDetachFlag();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(i3);
                sb.append(this.f1731a.i());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.f1731a.attachViewToParent(view, i2, layoutParams);
    }

    public x c(View view) {
        return RecyclerView.i(view);
    }

    public void b(int i2) {
        View a2 = a(i2);
        if (a2 != null) {
            x i3 = RecyclerView.i(a2);
            if (i3 != null) {
                if (!i3.isTmpDetached() || i3.shouldIgnore()) {
                    i3.addFlags(256);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("called detach on an already detached child ");
                    sb.append(i3);
                    sb.append(this.f1731a.i());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        this.f1731a.detachViewFromParent(i2);
    }

    public void a(View view) {
        x i2 = RecyclerView.i(view);
        if (i2 != null) {
            i2.onEnteredHiddenState(this.f1731a);
        }
    }
}
