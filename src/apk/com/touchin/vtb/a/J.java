package com.touchin.vtb.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0232s.c;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.r;
import com.touchin.vtb.api.PaymentInfo;
import java.util.List;
import kotlin.e.b.h;
import l.a.a.e;
import l.a.a.f;

/* compiled from: TaxesAdapter.kt */
public final class J extends e<PaymentInfo> {

    /* renamed from: d reason: collision with root package name */
    private static final I f6893d = new I();

    /* renamed from: e reason: collision with root package name */
    public static final a f6894e = new a(null);

    /* compiled from: TaxesAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* compiled from: TaxesAdapter.kt */
    public final class b extends f<r, PaymentInfo> {
        public b() {
        }

        public boolean b(Object obj, int i2, int i3) {
            h.b(obj, "item");
            return obj instanceof PaymentInfo;
        }

        public r a(ViewGroup viewGroup) {
            h.b(viewGroup, "parent");
            View a2 = l.a.d.a.b.a.a(R.layout.item_tax_info, viewGroup);
            h.a((Object) a2, "UiUtils.inflate(R.layout.item_tax_info, parent)");
            return new r(a2);
        }

        public void a(r rVar, PaymentInfo paymentInfo, int i2, int i3, List<Object> list) {
            h.b(rVar, "holder");
            h.b(paymentInfo, "item");
            h.b(list, "payloads");
            rVar.a(paymentInfo);
        }
    }

    public J() {
        super((c<TItem>) f6893d);
        a((l.a.a.a<?>) new b<Object>());
    }
}
