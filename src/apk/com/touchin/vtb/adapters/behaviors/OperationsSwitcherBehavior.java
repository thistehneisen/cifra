package com.touchin.vtb.adapters.behaviors;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import b.g.i.G;
import com.touchin.vtb.R;
import java.util.List;
import kotlin.e.b.h;
import kotlin.h.c;
import kotlin.m;

/* compiled from: OperationsSwitcherBehavior.kt */
public final class OperationsSwitcherBehavior<V extends View> extends b<V> {

    /* renamed from: a reason: collision with root package name */
    private final int f7021a;

    /* renamed from: b reason: collision with root package name */
    private final int f7022b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public int f7023c = this.f7022b;

    /* renamed from: d reason: collision with root package name */
    private final int f7024d;

    /* renamed from: e reason: collision with root package name */
    private final int f7025e;

    /* renamed from: f reason: collision with root package name */
    private final int f7026f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public int f7027g;

    /* renamed from: h reason: collision with root package name */
    private final int f7028h;

    /* renamed from: i reason: collision with root package name */
    private ValueAnimator f7029i;

    /* renamed from: j reason: collision with root package name */
    private ValueAnimator f7030j;

    public OperationsSwitcherBehavior(Context context, AttributeSet attributeSet) {
        h.b(context, "context");
        super(context, attributeSet);
        this.f7021a = context.getResources().getDimensionPixelSize(R.dimen.operations_list_min_offset);
        this.f7022b = context.getResources().getDimensionPixelSize(R.dimen.operations_list_max_offset);
        this.f7024d = context.getResources().getDimensionPixelSize(R.dimen.bank_card_margin) * 2;
        this.f7025e = context.getResources().getDimensionPixelSize(R.dimen.bank_card_min_height) + this.f7024d;
        this.f7026f = context.getResources().getDimensionPixelSize(R.dimen.bank_card_height) + this.f7024d;
        this.f7027g = this.f7026f;
        this.f7028h = R.id.view_controller_bank_cards_switcher;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "target");
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "target");
        return false;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "dependency");
        if (view.getId() == this.f7028h) {
            view.getLayoutParams().height = this.f7027g;
            if (!(view instanceof ViewGroup)) {
                view = null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup != null) {
                c a2 = G.a(viewGroup);
                if (a2 != null) {
                    c<RecyclerView> a3 = i.a(a2, RecyclerView.class);
                    if (a3 != null) {
                        for (RecyclerView adapter : a3) {
                            a adapter2 = adapter.getAdapter();
                            if (adapter2 != null) {
                                adapter2.notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        v.measure(i2, MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i4) - i5) - this.f7021a, 1073741824));
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        coordinatorLayout.c((View) v, i2);
        v.offsetTopAndBottom(this.f7023c);
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "dependency");
        return view.getId() == this.f7028h;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "directTargetChild");
        h.b(view2, "target");
        ValueAnimator valueAnimator = this.f7029i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f7030j;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        return i2 == 2;
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "target");
        h.b(iArr, "consumed");
        if (this.f7023c != this.f7021a) {
            this.f7027g = b.g.e.a.a(this.f7027g - i3, this.f7025e, this.f7026f);
            List<View> b2 = coordinatorLayout.b((View) v);
            h.a((Object) b2, "parent.getDependencies(child)");
            for (View a2 : b2) {
                coordinatorLayout.a(a2);
            }
            iArr[1] = a((View) v, i3, this.f7021a, this.f7022b);
            this.f7023c = v.getTop();
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "target");
        a((View) v, i5, this.f7021a, this.f7022b);
        this.f7023c = v.getTop();
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        h.b(coordinatorLayout, "parent");
        h.b(v, "child");
        h.b(view, "target");
        if (this.f7029i == null) {
            this.f7029i = a((kotlin.e.a.b<? super Integer, m>) new b<Object,m>(this, v));
        }
        if (this.f7030j == null) {
            this.f7030j = a((kotlin.e.a.b<? super Integer, m>) new c<Object,m>(this, coordinatorLayout, v));
        }
        int i3 = this.f7023c;
        if (i3 == this.f7021a || i3 == this.f7022b) {
            int i4 = this.f7027g;
            if (i4 == this.f7025e || i4 == this.f7026f) {
                return;
            }
        }
        int i5 = this.f7023c;
        int i6 = this.f7021a;
        boolean z = i5 > i6 + ((this.f7022b - i6) / 2);
        ValueAnimator valueAnimator = this.f7029i;
        if (valueAnimator != null) {
            int[] iArr = new int[2];
            iArr[0] = this.f7023c;
            iArr[1] = z ? this.f7022b : this.f7021a;
            valueAnimator.setIntValues(iArr);
        }
        ValueAnimator valueAnimator2 = this.f7030j;
        if (valueAnimator2 != null) {
            int[] iArr2 = new int[2];
            iArr2[0] = this.f7027g;
            iArr2[1] = z ? this.f7026f : this.f7025e;
            valueAnimator2.setIntValues(iArr2);
        }
        ValueAnimator valueAnimator3 = this.f7029i;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
        ValueAnimator valueAnimator4 = this.f7030j;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    private final int a(View view, int i2, int i3, int i4) {
        int top = view.getTop();
        int a2 = b.g.e.a.a(top - i2, i3, i4) - top;
        view.offsetTopAndBottom(a2);
        return -a2;
    }

    private final ValueAnimator a(kotlin.e.a.b<? super Integer, m> bVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(100);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new a(bVar));
        return ofInt;
    }
}
