package com.touchin.vtb.activities.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0200o;
import androidx.fragment.app.C0200o.b;
import androidx.fragment.app.Fragment;
import b.g.i.G;
import kotlin.e.b.h;
import kotlin.g;

/* compiled from: BottomNavigationController.kt */
public final class a extends b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f6996a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewGroup f6997b;

    a(c cVar, ViewGroup viewGroup) {
        this.f6996a = cVar;
        this.f6997b = viewGroup;
    }

    public void a(C0200o oVar, Fragment fragment, View view, Bundle bundle) {
        h.b(oVar, "fragmentManager");
        h.b(fragment, "fragment");
        h.b(view, "view");
        SparseArray c2 = this.f6996a.f7005e;
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = c2.keyAt(i2);
            if (this.f6996a.a(fragment, (Class) ((g) c2.valueAt(i2)).a())) {
                for (View view2 : G.a(this.f6997b)) {
                    view2.setActivated(view2.getId() == keyAt);
                }
            }
        }
    }
}
