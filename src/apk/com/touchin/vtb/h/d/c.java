package com.touchin.vtb.h.d;

import androidx.lifecycle.u;
import com.touchin.vtb.api.TasksTaxInfo;
import com.touchin.vtb.api.TaxPaymentResponse;
import com.touchin.vtb.f.b.C0669w;
import com.touchin.vtb.f.b.qa;
import com.touchin.vtb.f.d;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.a.a;

/* compiled from: TaskTaxViewModel.kt */
public final class c extends a {

    /* renamed from: f reason: collision with root package name */
    private final l.a.c.b.c<a<TasksTaxInfo>> f7583f = new l.a.c.b.c<>();

    /* renamed from: g reason: collision with root package name */
    private final l.a.c.b.c<a<d>> f7584g = new l.a.c.b.c<>();

    /* renamed from: h reason: collision with root package name */
    private final l.a.c.b.c<a<TaxPaymentResponse>> f7585h = new l.a.c.b.c<>();

    /* renamed from: i reason: collision with root package name */
    private final C0669w f7586i;

    /* renamed from: j reason: collision with root package name */
    private final qa f7587j;

    public c(C0669w wVar, qa qaVar) {
        h.b(wVar, "tasksRepository");
        h.b(qaVar, "userInfoRepository");
        super(wVar);
        this.f7586i = wVar;
        this.f7587j = qaVar;
    }

    public final b a(String str) {
        h.b(str, "taskId");
        return a(this.f7586i.b(str), (u<a<T>>) this.f7583f);
    }

    public final b b(String str) {
        h.b(str, "taskId");
        return a(this.f7586i.c(str), (u<a<T>>) this.f7585h);
    }

    public final b c() {
        return a(this.f7587j.c(), (u<a<T>>) this.f7584g);
    }

    public final l.a.c.b.c<a<d>> d() {
        return this.f7584g;
    }

    public final l.a.c.b.c<a<TasksTaxInfo>> e() {
        return this.f7583f;
    }

    public final l.a.c.b.c<a<TaxPaymentResponse>> f() {
        return this.f7585h;
    }
}
