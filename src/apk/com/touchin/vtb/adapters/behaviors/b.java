package com.touchin.vtb.adapters.behaviors;

import android.view.View;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: OperationsSwitcherBehavior.kt */
final class b extends i implements kotlin.e.a.b<Integer, m> {
    final /* synthetic */ View $child;
    final /* synthetic */ OperationsSwitcherBehavior this$0;

    b(OperationsSwitcherBehavior operationsSwitcherBehavior, View view) {
        this.this$0 = operationsSwitcherBehavior;
        this.$child = view;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a(((Number) obj).intValue());
        return m.f10346a;
    }

    public final void a(int i2) {
        this.$child.offsetTopAndBottom(i2 - this.this$0.f7023c);
        this.this$0.f7023c = this.$child.getTop();
    }
}
