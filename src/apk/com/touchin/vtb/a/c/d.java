package com.touchin.vtb.a.c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.DaDataAddress;
import com.touchin.vtb.api.DaDataAddressDescription;
import com.touchin.vtb.api.DaDataOrganizationDescription;
import com.touchin.vtb.api.DaDataSuggestion;
import kotlin.e.b.h;
import l.a.b.c;

/* compiled from: SearchCompanyViewHolder.kt */
public final class d extends x {

    /* renamed from: a reason: collision with root package name */
    private final TextView f6914a = ((TextView) c.a(this, R.id.item_search_company_title));

    /* renamed from: b reason: collision with root package name */
    private final TextView f6915b = ((TextView) c.a(this, R.id.item_search_company_subtitle));

    public d(View view) {
        h.b(view, "itemView");
        super(view);
    }

    public final void a(DaDataSuggestion daDataSuggestion) {
        h.b(daDataSuggestion, "item");
        this.f6914a.setText(daDataSuggestion.c());
        TextView textView = this.f6915b;
        Object[] objArr = new Object[2];
        DaDataOrganizationDescription daDataOrganizationDescription = (DaDataOrganizationDescription) daDataSuggestion.b();
        String str = "item.data";
        h.a((Object) daDataOrganizationDescription, str);
        String c2 = daDataOrganizationDescription.c();
        h.a((Object) c2, "item.data.inn");
        objArr[0] = c2;
        DaDataOrganizationDescription daDataOrganizationDescription2 = (DaDataOrganizationDescription) daDataSuggestion.b();
        h.a((Object) daDataOrganizationDescription2, str);
        DaDataAddress b2 = daDataOrganizationDescription2.b();
        h.a((Object) b2, "item.data.address");
        DaDataAddressDescription daDataAddressDescription = (DaDataAddressDescription) b2.b();
        h.a((Object) daDataAddressDescription, "item.data.address.data");
        String b3 = daDataAddressDescription.b();
        if (b3 == null) {
            b3 = "";
        }
        objArr[1] = b3;
        textView.setText(c.a(this, R.string.common_registration_inn_address_mask, objArr));
    }
}
