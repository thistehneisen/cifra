package com.touchin.vtb.viewcontrollers.startup;

import androidx.lifecycle.v;
import com.touchin.vtb.R;
import com.touchin.vtb.a.s;
import com.touchin.vtb.api.DaDataSuggestionListing;
import java.util.List;
import kotlin.e.b.h;
import l.a.c.a.a;
import l.a.c.a.a.b;
import l.a.c.a.a.d;

/* compiled from: SearchViewController.kt */
final class pa<T> implements v<a<? extends DaDataSuggestionListing>> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchViewController f7725a;

    pa(SearchViewController searchViewController) {
        this.f7725a = searchViewController;
    }

    public final void a(a<? extends DaDataSuggestionListing> aVar) {
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            if (((DaDataSuggestionListing) dVar.a()).b().isEmpty()) {
                this.f7725a.switcher.a(R.id.view_controller_search_empty_text);
                return;
            }
            s access$getAdapter$p = this.f7725a.adapter;
            List b2 = ((DaDataSuggestionListing) dVar.a()).b();
            h.a((Object) b2, "event.data.suggestions");
            access$getAdapter$p.a(b2);
            this.f7725a.switcher.a(R.id.view_controller_search_recycler);
            return;
        }
        boolean z = aVar instanceof b;
    }
}
