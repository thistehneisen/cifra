package com.touchin.vtb.a;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.f;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import l.a.d.a.b.a;

/* compiled from: TasksArchiveAdapter.kt */
final class D extends i implements b<ViewGroup, f> {

    /* renamed from: a reason: collision with root package name */
    public static final D f6886a = new D();

    D() {
        super(1);
    }

    public final f a(ViewGroup viewGroup) {
        h.b(viewGroup, "parent");
        View a2 = a.a(R.layout.item_task_archive_group, viewGroup);
        h.a((Object) a2, "UiUtils.inflate(R.layout…sk_archive_group, parent)");
        return new f(a2);
    }
}
