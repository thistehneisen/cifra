package com.touchin.vtb.a;

import androidx.recyclerview.widget.C0232s.c;
import com.touchin.vtb.a.b.d;
import com.touchin.vtb.api.TaskInfo;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;
import l.a.a.e;

/* compiled from: TasksAdapter.kt */
public class B extends e<H> {

    /* renamed from: d reason: collision with root package name */
    private static final A f6884d = new A();

    /* renamed from: e reason: collision with root package name */
    public static final a f6885e = new a(null);

    /* compiled from: TasksAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public /* synthetic */ B(b bVar, b bVar2, b bVar3, b bVar4, kotlin.e.a.a aVar, kotlin.e.a.a aVar2, int i2, e eVar) {
        if ((i2 & 1) != 0) {
            bVar = u.f6983a;
        }
        if ((i2 & 2) != 0) {
            bVar2 = v.f6984a;
        }
        b bVar5 = bVar2;
        if ((i2 & 4) != 0) {
            bVar3 = w.f6985a;
        }
        b bVar6 = bVar3;
        if ((i2 & 8) != 0) {
            bVar4 = x.f6986a;
        }
        b bVar7 = bVar4;
        if ((i2 & 16) != 0) {
            aVar = y.f6987a;
        }
        kotlin.e.a.a aVar3 = aVar;
        if ((i2 & 32) != 0) {
            aVar2 = z.f6988a;
        }
        this(bVar, bVar5, bVar6, bVar7, aVar3, aVar2);
    }

    public B(b<? super String, m> bVar, b<? super String, m> bVar2, b<? super TaskInfo, m> bVar3, b<? super TaskInfo, m> bVar4, kotlin.e.a.a<m> aVar, kotlin.e.a.a<m> aVar2) {
        h.b(bVar, "deleteTaskAction");
        h.b(bVar2, "restoreTaskAction");
        h.b(bVar3, "onInfoItemClickAction");
        h.b(bVar4, "onTaxesItemClickAction");
        h.b(aVar, "onBankConnectionClickAction");
        h.b(aVar2, "onRegistrationClickAction");
        super((c<TItem>) f6884d);
        a((l.a.a.a<?>) new com.touchin.vtb.a.b.b<Object>(bVar, bVar2, bVar3));
        a((l.a.a.a<?>) new d<Object>(bVar4));
        a((l.a.a.a<?>) new com.touchin.vtb.a.b.a<Object>(aVar));
        a((l.a.a.a<?>) new com.touchin.vtb.a.b.c<Object>(aVar2));
    }
}
