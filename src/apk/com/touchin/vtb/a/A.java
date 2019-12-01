package com.touchin.vtb.a;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.C0232s.c;
import kotlin.e.b.h;

/* compiled from: TasksAdapter.kt */
public final class A extends c<H> {
    A() {
    }

    @SuppressLint({"DiffUtilEquals"})
    public boolean a(H h2, H h3) {
        h.b(h2, "oldItem");
        h.b(h3, "newItem");
        return h.a((Object) h2.a(), (Object) h3.a());
    }

    public boolean b(H h2, H h3) {
        h.b(h2, "oldItem");
        h.b(h3, "newItem");
        return h.a((Object) h2.a().g(), (Object) h3.a().g());
    }
}
