package com.touchin.vtb.e;

import android.content.Context;
import com.touchin.vtb.R;
import com.touchin.vtb.utils.k;
import kotlin.e.b.h;
import org.joda.time.b;

/* compiled from: DateTime.kt */
public final class d {
    public static final String a(b bVar, Context context) {
        h.b(bVar, "$this$printForViewHolder");
        h.b(context, "context");
        if (com.touchin.vtb.utils.b.f7611a.b(bVar.n())) {
            String string = context.getString(R.string.common_global_date_today);
            h.a((Object) string, "context.getString(R.stri…common_global_date_today)");
            return string;
        } else if (com.touchin.vtb.utils.b.f7611a.c(bVar.n())) {
            String string2 = context.getString(R.string.common_global_yesterday_date_template, new Object[]{com.touchin.vtb.utils.b.f7611a.a(bVar, k.DAY_MONTH)});
            h.a((Object) string2, "context.getString(\n     …, Format.DAY_MONTH)\n    )");
            return string2;
        } else if (com.touchin.vtb.utils.b.f7611a.a(bVar)) {
            return com.touchin.vtb.utils.b.f7611a.a(bVar, k.DAY_MONTH);
        } else {
            String string3 = context.getString(R.string.common_global_year_date_template, new Object[]{com.touchin.vtb.utils.b.f7611a.a(bVar, k.DAY_MONTH_YEAR)});
            h.a((Object) string3, "context.getString(\n     …mat.DAY_MONTH_YEAR)\n    )");
            return string3;
        }
    }
}
