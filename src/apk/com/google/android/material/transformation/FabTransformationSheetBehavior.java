package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import b.g.i.B;
import c.b.a.c.a;
import c.b.a.c.a.h;
import c.b.a.c.a.j;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: g reason: collision with root package name */
    private Map<View, Integer> f6611g;

    public FabTransformationSheetBehavior() {
    }

    /* access modifiers changed from: protected */
    public a a(Context context, boolean z) {
        int i2;
        if (z) {
            i2 = a.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i2 = a.mtrl_fab_transformation_sheet_collapse_spec;
        }
        a aVar = new a();
        aVar.f6607a = h.a(context, i2);
        aVar.f6608b = new j(17, 0.0f, 0.0f);
        return aVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, View view2, boolean z, boolean z2) {
        a(view2, z);
        return super.a(view, view2, z, z2);
    }

    private void a(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (VERSION.SDK_INT >= 16 && z) {
                this.f6611g = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z2 = (childAt.getLayoutParams() instanceof e) && (((e) childAt.getLayoutParams()).d() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        Map<View, Integer> map = this.f6611g;
                        if (map != null && map.containsKey(childAt)) {
                            B.e(childAt, ((Integer) this.f6611g.get(childAt)).intValue());
                        }
                    } else {
                        if (VERSION.SDK_INT >= 16) {
                            this.f6611g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        B.e(childAt, 4);
                    }
                }
            }
            if (!z) {
                this.f6611g = null;
            }
        }
    }
}
