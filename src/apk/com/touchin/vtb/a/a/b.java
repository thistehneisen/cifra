package com.touchin.vtb.a.a;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.appsflyer.share.Constants;
import com.touchin.vtb.a.c.e;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: CommonItemTouchHelperCallback.kt */
public final class b extends a {
    public b(kotlin.e.a.b<? super Integer, m> bVar) {
        super(bVar);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, x xVar, float f2, float f3, int i2, boolean z) {
        h.b(canvas, Constants.URL_CAMPAIGN);
        h.b(recyclerView, "recyclerView");
        h.b(xVar, "viewHolder");
        if (!(xVar instanceof e)) {
            xVar = null;
        }
        e eVar = (e) xVar;
        if (eVar != null) {
            eVar.a(f2);
        }
    }
}
