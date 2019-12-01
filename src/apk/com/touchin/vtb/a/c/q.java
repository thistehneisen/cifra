package com.touchin.vtb.a.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.R;
import com.touchin.vtb.api.Amount;
import com.touchin.vtb.api.TaskInfo;
import com.touchin.vtb.api.TaskPriority;
import com.touchin.vtb.e.a;
import com.touchin.vtb.utils.k;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;
import l.a.b.c;

/* compiled from: TaskTaxViewHolder.kt */
public final class q extends x {

    /* renamed from: a reason: collision with root package name */
    private final TextView f6940a = ((TextView) c.a(this, R.id.item_task_tax_title));

    /* renamed from: b reason: collision with root package name */
    private final ImageView f6941b = ((ImageView) c.a(this, R.id.item_task_tax_icon));

    /* renamed from: c reason: collision with root package name */
    private final TextView f6942c = ((TextView) c.a(this, R.id.item_task_tax_description));

    /* renamed from: d reason: collision with root package name */
    private final TextView f6943d = ((TextView) c.a(this, R.id.item_task_tax_expire_text));

    /* renamed from: e reason: collision with root package name */
    private final TextView f6944e = ((TextView) c.a(this, R.id.item_task_tax_amount));
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final b<TaskInfo, m> f6945f;

    public q(View view, b<? super TaskInfo, m> bVar) {
        h.b(view, "itemView");
        h.b(bVar, "onTaxesItemClickAction");
        super(view);
        this.f6945f = bVar;
    }

    public final void a(TaskInfo taskInfo) {
        Drawable drawable;
        h.b(taskInfo, "taskInfo");
        this.f6940a.setText(taskInfo.k());
        this.f6942c.setText(taskInfo.e());
        this.itemView.setOnClickListener(new p(this, taskInfo));
        org.joda.time.b f2 = taskInfo.f();
        String str = "it";
        if (f2 != null) {
            this.f6943d.setVisibility(0);
            TextView textView = this.f6943d;
            com.touchin.vtb.utils.b bVar = com.touchin.vtb.utils.b.f7611a;
            h.a((Object) f2, str);
            textView.setText(c.a(this, R.string.common_global_till, bVar.a(f2, k.DAY_MONTH)));
            org.joda.time.b a2 = f2.a(1);
            h.a((Object) a2, "it.minusWeeks(1)");
            long n = a2.n();
            org.joda.time.b g2 = org.joda.time.b.g();
            h.a((Object) g2, "DateTime.now()");
            if (n <= g2.n()) {
                this.f6943d.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.common_tax_expire_icon, 0, 0, 0);
            }
        }
        Amount b2 = taskInfo.b();
        if (b2 != null) {
            this.f6944e.setVisibility(0);
            TextView textView2 = this.f6944e;
            h.a((Object) b2, str);
            textView2.setText(a.a(b2, false, true, null, 5, null));
        }
        ImageView imageView = this.f6941b;
        if (taskInfo.h() == TaskPriority.HIGH) {
            imageView.setImageDrawable(c.c(this, R.drawable.common_task_tax_high_priority_icon));
            drawable = c.c(this, R.drawable.common_task_tax_high_priority_circle_background);
        } else {
            imageView.setImageDrawable(c.c(this, R.drawable.common_task_tax_low_priority_icon));
            drawable = c.c(this, R.drawable.common_task_tax_low_priority_circle_background);
        }
        imageView.setBackground(drawable);
    }
}
