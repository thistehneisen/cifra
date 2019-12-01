package com.touchin.vtb.a.c;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.e.d;
import com.touchin.vtb.views.a.d.a;
import kotlin.e.b.h;
import org.joda.time.b;

/* compiled from: TaskArchiveGroupViewHolder.kt */
public final class f extends a {

    /* renamed from: b reason: collision with root package name */
    private final TextView f6918b = ((TextView) a(R.id.item_task_archive_group_text));

    public f(View view) {
        h.b(view, "itemView");
        super(view);
    }

    public final void a(b bVar) {
        h.b(bVar, "dateTime");
        TextView textView = this.f6918b;
        Context context = a().getContext();
        h.a((Object) context, "view.context");
        textView.setText(d.a(bVar, context));
    }
}
