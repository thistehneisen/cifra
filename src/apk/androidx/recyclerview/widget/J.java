package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.t.a;
import androidx.recyclerview.widget.RecyclerView.u;

/* compiled from: PagerSnapHelper */
class J extends D {
    final /* synthetic */ K o;

    J(K k2, Context context) {
        this.o = k2;
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(View view, u uVar, a aVar) {
        K k2 = this.o;
        int[] a2 = k2.a(k2.f1866a.getLayoutManager(), view);
        int i2 = a2[0];
        int i3 = a2[1];
        int d2 = d(Math.max(Math.abs(i2), Math.abs(i3)));
        if (d2 > 0) {
            aVar.a(i2, i3, d2, this.f1691j);
        }
    }

    /* access modifiers changed from: protected */
    public int e(int i2) {
        return Math.min(100, super.e(i2));
    }

    /* access modifiers changed from: protected */
    public float a(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
