package com.touchin.vtb.viewcontrollers.startup;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.api.DaDataSuggestion;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: SearchViewController.kt */
final class oa extends i implements c<DaDataSuggestion, x, m> {
    final /* synthetic */ SearchViewController this$0;

    oa(SearchViewController searchViewController) {
        this.this$0 = searchViewController;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        a((DaDataSuggestion) obj, (x) obj2);
        return m.f10346a;
    }

    public final void a(DaDataSuggestion daDataSuggestion, x xVar) {
        h.b(daDataSuggestion, "daDataSuggestion");
        h.b(xVar, "<anonymous parameter 1>");
        Intent intent = new Intent();
        intent.putExtra("SEARCH_COMPANY_EXTRA", daDataSuggestion);
        ((com.touchin.vtb.activities.c) this.this$0.getActivity()).d().a(com.touchin.vtb.b.h.SELECT_COMPANY);
        Fragment targetFragment = this.this$0.getFragment().getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(100, -1, intent);
        }
        ((com.touchin.vtb.activities.c) this.this$0.getActivity()).c().a();
    }
}
