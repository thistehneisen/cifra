package com.touchin.vtb.a;

import android.view.View;
import android.view.ViewGroup;
import com.touchin.vtb.R;
import com.touchin.vtb.a.c.d;
import com.touchin.vtb.api.DaDataSuggestion;
import java.util.List;
import kotlin.e.b.h;
import l.a.a.f;
import l.a.d.a.b.a;

/* compiled from: SearchCompanyAdapter.kt */
public final class r extends f<d, DaDataSuggestion> {
    r() {
    }

    public d a(ViewGroup viewGroup) {
        h.b(viewGroup, "parent");
        View a2 = a.a(R.layout.item_search_company, viewGroup);
        h.a((Object) a2, "UiUtils.inflate(R.layout…m_search_company, parent)");
        return new d(a2);
    }

    public void a(d dVar, DaDataSuggestion daDataSuggestion, int i2, int i3, List<Object> list) {
        h.b(dVar, "holder");
        h.b(daDataSuggestion, "item");
        h.b(list, "payloads");
        dVar.a(daDataSuggestion);
    }
}
