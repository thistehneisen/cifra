package com.touchin.vtb.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import c.e.a.a.a.C0042a;
import com.touchin.vtb.R;
import com.touchin.vtb.views.a.d;
import java.util.List;
import kotlin.e.b.h;
import l.a.a.f;

/* renamed from: com.touchin.vtb.a.d reason: case insensitive filesystem */
/* compiled from: BankOperationsAdapter.kt */
public final class C0640d extends l.a.a.e<q> implements C0042a {

    /* renamed from: d reason: collision with root package name */
    private static final C0639c f6949d = new C0639c();

    /* renamed from: e reason: collision with root package name */
    public static final a f6950e = new a(null);

    /* renamed from: com.touchin.vtb.a.d$a */
    /* compiled from: BankOperationsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* renamed from: com.touchin.vtb.a.d$b */
    /* compiled from: BankOperationsAdapter.kt */
    private final class b extends f<x, com.touchin.vtb.a.q.b> {
        public b() {
        }

        public void a(x xVar, com.touchin.vtb.a.q.b bVar, int i2, int i3, List<Object> list) {
            h.b(xVar, "holder");
            h.b(bVar, "item");
            h.b(list, "payloads");
        }

        public boolean b(Object obj, int i2, int i3) {
            h.b(obj, "item");
            return obj instanceof com.touchin.vtb.a.q.b;
        }

        public x a(ViewGroup viewGroup) {
            h.b(viewGroup, "parent");
            return new C0641e(viewGroup, l.a.d.a.b.a.a(R.layout.item_bank_operations_empty, viewGroup));
        }
    }

    /* renamed from: com.touchin.vtb.a.d$c */
    /* compiled from: BankOperationsAdapter.kt */
    private final class c extends l.a.a.h<x> {
        public c() {
        }

        public x a(ViewGroup viewGroup) {
            h.b(viewGroup, "parent");
            return new C0642f(viewGroup, l.a.d.a.b.a.a(R.layout.item_bank_operations_header, viewGroup));
        }

        public boolean b(int i2) {
            return i2 == 0;
        }
    }

    /* renamed from: com.touchin.vtb.a.d$d reason: collision with other inner class name */
    /* compiled from: BankOperationsAdapter.kt */
    private final class C0071d extends f<x, com.touchin.vtb.a.q.c> {
        public C0071d() {
        }

        public void a(x xVar, com.touchin.vtb.a.q.c cVar, int i2, int i3, List<Object> list) {
            h.b(xVar, "holder");
            h.b(cVar, "item");
            h.b(list, "payloads");
        }

        public boolean b(Object obj, int i2, int i3) {
            h.b(obj, "item");
            return obj instanceof com.touchin.vtb.a.q.c;
        }

        public x a(ViewGroup viewGroup) {
            h.b(viewGroup, "parent");
            return new C0643g(viewGroup, l.a.d.a.b.a.a(R.layout.item_banks_loader, viewGroup));
        }
    }

    /* renamed from: com.touchin.vtb.a.d$e */
    /* compiled from: BankOperationsAdapter.kt */
    private final class e extends f<com.touchin.vtb.a.c.c, com.touchin.vtb.a.q.a> {
        public e() {
        }

        public boolean b(Object obj, int i2, int i3) {
            h.b(obj, "item");
            return obj instanceof com.touchin.vtb.a.q.a;
        }

        public com.touchin.vtb.a.c.c a(ViewGroup viewGroup) {
            h.b(viewGroup, "parent");
            View a2 = l.a.d.a.b.a.a(R.layout.item_operation_info, viewGroup);
            h.a((Object) a2, "UiUtils.inflate(R.layout…m_operation_info, parent)");
            return new com.touchin.vtb.a.c.c(a2);
        }

        public void a(com.touchin.vtb.a.c.c cVar, com.touchin.vtb.a.q.a aVar, int i2, int i3, List<Object> list) {
            h.b(cVar, "holder");
            h.b(aVar, "item");
            h.b(list, "payloads");
            cVar.a(aVar.b());
        }
    }

    public C0640d() {
        super((androidx.recyclerview.widget.C0232s.c<TItem>) f6949d);
        a((l.a.a.a<?>) new e<Object>());
        a((l.a.a.a<?>) new c<Object>());
        a((l.a.a.a<?>) new C0071d<Object>());
        a((l.a.a.a<?>) new b<Object>());
    }

    public void a(View view, int i2) {
        h.b(view, "header");
    }

    public boolean a(int i2) {
        return i2 == 0;
    }

    public int b() {
        return super.b() + 1;
    }

    public int b(int i2) {
        return R.layout.item_bank_operations_header;
    }

    public int c(int i2) {
        return 0;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.b(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        d dVar = new d(0, new C0644h(this, k.f6959a), C0645i.f6958a, new C0646j(this), 1, null);
        recyclerView.a((RecyclerView.h) dVar);
        recyclerView.a((RecyclerView.h) new c.e.a.a.a(this));
    }
}
