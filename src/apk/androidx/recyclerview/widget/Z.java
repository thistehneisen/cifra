package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.t.b;

/* compiled from: SnapHelper */
public abstract class Z extends l {

    /* renamed from: a reason: collision with root package name */
    RecyclerView f1866a;

    /* renamed from: b reason: collision with root package name */
    private Scroller f1867b;

    /* renamed from: c reason: collision with root package name */
    private final n f1868c = new Y(this);

    private void b() {
        this.f1866a.b(this.f1868c);
        this.f1866a.setOnFlingListener(null);
    }

    private void c() throws IllegalStateException {
        if (this.f1866a.getOnFlingListener() == null) {
            this.f1866a.a(this.f1868c);
            this.f1866a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public abstract int a(i iVar, int i2, int i3);

    public boolean a(int i2, int i3) {
        i layoutManager = this.f1866a.getLayoutManager();
        boolean z = false;
        if (layoutManager == null || this.f1866a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1866a.getMinFlingVelocity();
        if ((Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && b(layoutManager, i2, i3)) {
            z = true;
        }
        return z;
    }

    public abstract int[] a(i iVar, View view);

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract D b(i iVar);

    public abstract View c(i iVar);

    private boolean b(i iVar, int i2, int i3) {
        if (!(iVar instanceof b)) {
            return false;
        }
        t a2 = a(iVar);
        if (a2 == null) {
            return false;
        }
        int a3 = a(iVar, i2, i3);
        if (a3 == -1) {
            return false;
        }
        a2.c(a3);
        iVar.b(a2);
        return true;
    }

    public void a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f1866a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                b();
            }
            this.f1866a = recyclerView;
            if (this.f1866a != null) {
                c();
                this.f1867b = new Scroller(this.f1866a.getContext(), new DecelerateInterpolator());
                a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        RecyclerView recyclerView = this.f1866a;
        if (recyclerView != null) {
            i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                View c2 = c(layoutManager);
                if (c2 != null) {
                    int[] a2 = a(layoutManager, c2);
                    if (!(a2[0] == 0 && a2[1] == 0)) {
                        this.f1866a.i(a2[0], a2[1]);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public t a(i iVar) {
        return b(iVar);
    }
}
