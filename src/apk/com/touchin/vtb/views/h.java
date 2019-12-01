package com.touchin.vtb.views;

import com.touchin.vtb.views.f.a;

/* compiled from: TaxesSmartTabLayout.kt */
public final class h extends f {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TaxesSmartTabLayout f7810a;

    h(TaxesSmartTabLayout taxesSmartTabLayout) {
        this.f7810a = taxesSmartTabLayout;
    }

    public boolean a(a aVar, float f2) {
        kotlin.e.b.h.b(aVar, "direction");
        if (f2 > ((float) 50)) {
            int i2 = j.f7812a[aVar.ordinal()];
            if (i2 == 1) {
                TaxesSmartTabLayout.b(this.f7810a).setCurrentItem(TaxesSmartTabLayout.b(this.f7810a).getCurrentItem() - 1);
            } else if (i2 == 2) {
                TaxesSmartTabLayout.b(this.f7810a).setCurrentItem(TaxesSmartTabLayout.b(this.f7810a).getCurrentItem() + 1);
            }
        }
        return true;
    }
}
