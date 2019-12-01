package com.touchin.vtb.a.c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.PaymentInfo;
import com.touchin.vtb.e.a;
import com.touchin.vtb.utils.b;
import com.touchin.vtb.utils.k;
import kotlin.e.b.h;
import l.a.b.c;

/* compiled from: TaxInfoViewHolder.kt */
public final class r extends x {

    /* renamed from: a reason: collision with root package name */
    private final TextView f6946a = ((TextView) c.a(this, R.id.item_tax_amount));

    /* renamed from: b reason: collision with root package name */
    private final TextView f6947b = ((TextView) c.a(this, R.id.item_tax_description));

    /* renamed from: c reason: collision with root package name */
    private final TextView f6948c = ((TextView) c.a(this, R.id.item_tax_date));

    public r(View view) {
        h.b(view, "itemView");
        super(view);
    }

    public final void a(PaymentInfo paymentInfo) {
        h.b(paymentInfo, "paymentInfo");
        TextView textView = this.f6946a;
        Amount b2 = paymentInfo.b();
        h.a((Object) b2, "paymentInfo.amount");
        textView.setText(a.a(b2, false, true, null, 5, null));
        this.f6947b.setText(paymentInfo.c());
        TextView textView2 = this.f6948c;
        b bVar = b.f7611a;
        org.joda.time.b d2 = paymentInfo.d();
        h.a((Object) d2, "paymentInfo.date");
        textView2.setText(c.a(this, R.string.common_global_year_date_template, bVar.a(d2, k.DAY_MONTH_YEAR)));
    }
}
