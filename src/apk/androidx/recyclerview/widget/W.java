package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.u;

/* compiled from: ScrollbarHelper */
class W {
    static int a(u uVar, I i2, View view, View view2, i iVar, boolean z, boolean z2) {
        int i3;
        if (iVar.f() == 0 || uVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.m(view), iVar.m(view2));
        int max = Math.max(iVar.m(view), iVar.m(view2));
        if (z2) {
            i3 = Math.max(0, (uVar.a() - max) - 1);
        } else {
            i3 = Math.max(0, min);
        }
        if (!z) {
            return i3;
        }
        return Math.round((((float) i3) * (((float) Math.abs(i2.a(view2) - i2.d(view))) / ((float) (Math.abs(iVar.m(view) - iVar.m(view2)) + 1)))) + ((float) (i2.f() - i2.d(view))));
    }

    static int b(u uVar, I i2, View view, View view2, i iVar, boolean z) {
        if (iVar.f() == 0 || uVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.a();
        }
        return (int) ((((float) (i2.a(view2) - i2.d(view))) / ((float) (Math.abs(iVar.m(view) - iVar.m(view2)) + 1))) * ((float) uVar.a()));
    }

    static int a(u uVar, I i2, View view, View view2, i iVar, boolean z) {
        if (iVar.f() == 0 || uVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.m(view) - iVar.m(view2)) + 1;
        }
        return Math.min(i2.g(), i2.a(view2) - i2.d(view));
    }
}
