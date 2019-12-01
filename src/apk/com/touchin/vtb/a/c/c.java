package com.touchin.vtb.a.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.OperationInfo;
import com.touchin.vtb.api.OperationRequisites;
import com.touchin.vtb.b;
import com.touchin.vtb.e.a;
import kotlin.e.b.h;

/* compiled from: OperationViewHolder.kt */
public final class c extends x {

    /* renamed from: a reason: collision with root package name */
    private final AppCompatImageView f6908a = ((AppCompatImageView) l.a.b.c.a(this, R.id.item_operation_info_image));

    /* renamed from: b reason: collision with root package name */
    private final TextView f6909b = ((TextView) l.a.b.c.a(this, R.id.item_operation_info_title));

    /* renamed from: c reason: collision with root package name */
    private final TextView f6910c = ((TextView) l.a.b.c.a(this, R.id.item_operation_info_amount));

    /* renamed from: d reason: collision with root package name */
    private final TextView f6911d = ((TextView) l.a.b.c.a(this, R.id.item_operation_info_description));

    /* renamed from: e reason: collision with root package name */
    private final int f6912e = l.a.b.c.b(this, R.color.common_black);

    /* renamed from: f reason: collision with root package name */
    private final int f6913f = l.a.b.c.b(this, R.color.common_success_color);

    public c(View view) {
        h.b(view, "itemView");
        super(view);
    }

    public final void a(OperationInfo operationInfo) {
        h.b(operationInfo, "operationInfo");
        Amount b2 = operationInfo.b();
        String str = "operationInfo.amount";
        h.a((Object) b2, str);
        boolean a2 = a.a(b2);
        b.a(this.itemView).a(operationInfo.f()).a(a2 ? R.drawable.common_operation_outgoing_logo_icon : R.drawable.common_operation_incoming_logo_icon).a((ImageView) this.f6908a);
        TextView textView = this.f6909b;
        OperationRequisites g2 = operationInfo.g();
        textView.setText(g2 != null ? g2.b() : null);
        this.f6910c.setTextColor(a2 ? this.f6912e : this.f6913f);
        TextView textView2 = this.f6910c;
        Amount b3 = operationInfo.b();
        h.a((Object) b3, str);
        textView2.setText(a.a(b3, true, true, null, 4, null));
        this.f6911d.setText(operationInfo.c());
    }
}
