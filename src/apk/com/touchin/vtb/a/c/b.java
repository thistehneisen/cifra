package com.touchin.vtb.a.c;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.e.d;
import com.touchin.vtb.views.a.d.a;
import kotlin.e.b.h;

/* compiled from: DateViewHolder.kt */
public final class b extends a {

    /* renamed from: b reason: collision with root package name */
    private final TextView f6907b = ((TextView) a(R.id.item_date_header_text_view));

    public b(View view) {
        h.b(view, "itemView");
        super(view);
    }

    public final void a(org.joda.time.b bVar) {
        h.b(bVar, "dateTime");
        TextView textView = this.f6907b;
        Context context = a().getContext();
        h.a((Object) context, "view.context");
        textView.setText(d.a(bVar, context));
    }
}
