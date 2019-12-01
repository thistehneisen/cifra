package com.touchin.vtb.viewcontrollers.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import kotlin.e.b.h;

/* compiled from: VTBBottomMenuViewController.kt */
public final class c extends n {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ VTBBottomMenuViewController f7642a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ boolean f7643b;

    c(VTBBottomMenuViewController vTBBottomMenuViewController, boolean z) {
        this.f7642a = vTBBottomMenuViewController;
        this.f7643b = z;
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        h.b(recyclerView, "recyclerView");
        if (i3 > 0) {
            this.f7642a.hideBottomMenu(this.f7643b);
        } else if (i3 < 0) {
            this.f7642a.showBottomMenu();
        }
    }
}
