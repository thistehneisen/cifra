package com.touchin.vtb.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.ConnectedBank;
import com.touchin.vtb.views.BankSwipeButton;
import java.util.List;
import l.a.a.f;
import l.a.a.h;
import l.a.b.g;

/* compiled from: BanksManagementAdapter.kt */
public final class m extends l.a.a.e<ConnectedBank> {

    /* renamed from: d reason: collision with root package name */
    private static final l f6960d = new l();

    /* renamed from: e reason: collision with root package name */
    public static final a f6961e = new a(null);

    /* renamed from: f reason: collision with root package name */
    private final int f6962f = BankType.values().length;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public final kotlin.e.a.a<kotlin.m> f6963g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final kotlin.e.a.b<String, kotlin.m> f6964h;

    /* compiled from: BanksManagementAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* compiled from: BanksManagementAdapter.kt */
    private final class b extends h<x> {
        public b() {
        }

        public x a(ViewGroup viewGroup) {
            kotlin.e.b.h.b(viewGroup, "parent");
            View a2 = l.a.d.a.b.a.a(R.layout.item_banks_management_footer, viewGroup);
            kotlin.e.b.h.a((Object) a2, "footer");
            g.a(a2, new o(m.this.f6963g));
            if ((m.this.getItemCount() - m.this.b()) - m.this.b() == 4) {
                a2.setEnabled(false);
                ((TextView) a2.findViewById(R.id.item_banks_management_footer_text)).setTextColor(b.g.a.a.a(a2.getContext(), (int) R.color.common_text_gray));
            }
            return new n(this, viewGroup, a2);
        }

        public boolean b(int i2) {
            return i2 == m.this.getItemCount() - m.this.a();
        }
    }

    /* compiled from: BanksManagementAdapter.kt */
    private final class c extends h<x> {
        public c() {
        }

        public x a(ViewGroup viewGroup) {
            kotlin.e.b.h.b(viewGroup, "parent");
            return new p(viewGroup, l.a.d.a.b.a.a(R.layout.item_banks_management_header, viewGroup));
        }

        public boolean b(int i2) {
            return i2 == 0;
        }
    }

    /* compiled from: BanksManagementAdapter.kt */
    private final class d extends f<e, ConnectedBank> {
        public d() {
        }

        public e a(ViewGroup viewGroup) {
            kotlin.e.b.h.b(viewGroup, "parent");
            m mVar = m.this;
            View a2 = l.a.d.a.b.a.a(R.layout.item_bank_management, viewGroup);
            kotlin.e.b.h.a((Object) a2, "UiUtils.inflate(R.layout…_bank_management, parent)");
            return new e(mVar, a2);
        }

        public void a(e eVar, ConnectedBank connectedBank, int i2, int i3, List<Object> list) {
            kotlin.e.b.h.b(eVar, "holder");
            kotlin.e.b.h.b(connectedBank, "item");
            kotlin.e.b.h.b(list, "payloads");
            eVar.a(connectedBank);
        }
    }

    /* compiled from: BanksManagementAdapter.kt */
    private final class e extends x {

        /* renamed from: a reason: collision with root package name */
        private final BankSwipeButton f6968a;

        /* renamed from: b reason: collision with root package name */
        final /* synthetic */ m f6969b;

        public e(m mVar, View view) {
            kotlin.e.b.h.b(view, "itemView");
            this.f6969b = mVar;
            super(view);
            View findViewById = view.findViewById(R.id.test_item);
            kotlin.e.b.h.a((Object) findViewById, "itemView.findViewById(R.id.test_item)");
            this.f6968a = (BankSwipeButton) findViewById;
        }

        public final void a(ConnectedBank connectedBank) {
            kotlin.e.b.h.b(connectedBank, "bank");
            BankSwipeButton bankSwipeButton = this.f6968a;
            boolean z = true;
            if ((this.f6969b.getItemCount() - this.f6969b.b()) - this.f6969b.a() <= 1) {
                z = false;
            }
            bankSwipeButton.setSwipeEnabled(z);
            this.f6968a.a(connectedBank, this.f6969b.f6964h);
        }
    }

    public m(kotlin.e.a.a<kotlin.m> aVar, kotlin.e.a.b<? super String, kotlin.m> bVar) {
        kotlin.e.b.h.b(aVar, "addBankAction");
        kotlin.e.b.h.b(bVar, "deleteBankAction");
        super((androidx.recyclerview.widget.C0232s.c<TItem>) f6960d);
        this.f6963g = aVar;
        this.f6964h = bVar;
        a((l.a.a.a<?>) new d<Object>());
        a((l.a.a.a<?>) new c<Object>());
        a((l.a.a.a<?>) new b<Object>());
    }

    public int a() {
        return super.a() + (d().size() < this.f6962f ? 1 : 0);
    }

    public int b() {
        return super.b() + 1;
    }
}
