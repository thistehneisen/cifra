package com.touchin.vtb.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.Z;
import kotlin.e.b.h;

/* compiled from: SnapOnScrollListener.kt */
public final class r extends n {

    /* renamed from: a reason: collision with root package name */
    private int f7633a = -1;

    /* renamed from: b reason: collision with root package name */
    private final Z f7634b;

    /* renamed from: c reason: collision with root package name */
    private final a f7635c;

    /* renamed from: d reason: collision with root package name */
    private final m f7636d;

    /* compiled from: SnapOnScrollListener.kt */
    public enum a {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    public r(Z z, a aVar, m mVar) {
        h.b(z, "snapHelper");
        h.b(aVar, "behavior");
        this.f7634b = z;
        this.f7635c = aVar;
        this.f7636d = mVar;
    }

    private final int a(RecyclerView recyclerView) {
        i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            h.a((Object) layoutManager, "recyclerView.layoutManag… RecyclerView.NO_POSITION");
            View c2 = this.f7634b.c(layoutManager);
            if (c2 != null) {
                h.a((Object) c2, "snapHelper.findSnapView(… RecyclerView.NO_POSITION");
                return layoutManager.m(c2);
            }
        }
        return -1;
    }

    private final void b(RecyclerView recyclerView) {
        int a2 = a(recyclerView);
        if (this.f7633a != a2) {
            m mVar = this.f7636d;
            if (mVar != null) {
                mVar.onSnapPositionChange(a2);
            }
            this.f7633a = a2;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        h.b(recyclerView, "recyclerView");
        if (this.f7635c == a.NOTIFY_ON_SCROLL_STATE_IDLE && i2 == 0) {
            b(recyclerView);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        h.b(recyclerView, "recyclerView");
        if (this.f7635c == a.NOTIFY_ON_SCROLL) {
            b(recyclerView);
        }
    }
}
