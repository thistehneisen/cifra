package com.touchin.vtb.viewcontrollers.main.more;

import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import com.touchin.vtb.b.h;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;
import l.a.b.b;

/* compiled from: MoreViewController.kt */
final class l extends i implements a<m> {
    final /* synthetic */ MoreViewController this$0;

    l(MoreViewController moreViewController) {
        this.this$0 = moreViewController;
        super(0);
    }

    public final void b() {
        ((c) this.this$0.getActivity()).d().a(h.TELEGRAM);
        b.b(this.this$0.getActivity(), this.this$0.getString(R.string.common_global_url_social_telegram));
    }
}
