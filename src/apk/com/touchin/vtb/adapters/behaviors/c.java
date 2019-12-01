package com.touchin.vtb.adapters.behaviors;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: OperationsSwitcherBehavior.kt */
final class c extends i implements b<Integer, m> {
    final /* synthetic */ View $child;
    final /* synthetic */ CoordinatorLayout $parent;
    final /* synthetic */ OperationsSwitcherBehavior this$0;

    c(OperationsSwitcherBehavior operationsSwitcherBehavior, CoordinatorLayout coordinatorLayout, View view) {
        this.this$0 = operationsSwitcherBehavior;
        this.$parent = coordinatorLayout;
        this.$child = view;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a(((Number) obj).intValue());
        return m.f10346a;
    }

    public final void a(int i2) {
        this.this$0.f7027g = i2;
        List<View> b2 = this.$parent.b(this.$child);
        h.a((Object) b2, "parent.getDependencies(child)");
        CoordinatorLayout coordinatorLayout = this.$parent;
        for (View a2 : b2) {
            coordinatorLayout.a(a2);
        }
    }
}
