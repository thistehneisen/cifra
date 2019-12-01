package com.touchin.vtb.e;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.Z;
import com.touchin.vtb.utils.m;
import com.touchin.vtb.utils.r;
import com.touchin.vtb.utils.r.a;

/* compiled from: RecyclerView.kt */
public final class h {
    public static /* synthetic */ void a(RecyclerView recyclerView, Z z, m mVar, a aVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            aVar = a.NOTIFY_ON_SCROLL_STATE_IDLE;
        }
        a(recyclerView, z, mVar, aVar);
    }

    public static final void a(RecyclerView recyclerView, Z z, m mVar, a aVar) {
        kotlin.e.b.h.b(recyclerView, "$this$attachSnapHelperWithListener");
        kotlin.e.b.h.b(z, "snapHelper");
        kotlin.e.b.h.b(mVar, "onSnapPositionChangeListener");
        kotlin.e.b.h.b(aVar, "behavior");
        z.a(recyclerView);
        recyclerView.a((n) new r(z, aVar, mVar));
    }
}
