package com.touchin.vtb.a;

import androidx.recyclerview.widget.RecyclerView;
import com.touchin.vtb.views.a.d;
import kotlin.e.b.h;

/* compiled from: TasksArchiveAdapter.kt */
public final class G extends B {
    public G() {
        super(null, null, null, null, null, null, 63, null);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.b(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        d dVar = new d(0, new C(this, F.f6887a), D.f6886a, new E(this), 1, null);
        recyclerView.a((RecyclerView.h) dVar);
    }
}
