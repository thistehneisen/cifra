package com.touchin.vtb.h.d;

import androidx.lifecycle.u;
import com.touchin.vtb.api.TaskListResponse;
import com.touchin.vtb.f.b.C0669w;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.b.c;
import l.a.c.c.s;

/* compiled from: TasksArchiveViewModel.kt */
public final class e extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<a<TaskListResponse>> f7590e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final C0669w f7591f;

    public e(C0669w wVar) {
        h.b(wVar, "tasksRepository");
        super(null, null, 3, null);
        this.f7591f = wVar;
    }

    public final b c() {
        return a(this.f7591f.b(), (u<a<T>>) this.f7590e);
    }

    public final c<a<TaskListResponse>> d() {
        return this.f7590e;
    }
}
