package com.touchin.vtb.activities.a;

import android.content.Context;
import androidx.fragment.app.C0200o;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.c;
import kotlin.e.a.a;
import kotlin.e.b.i;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: NavigationContainerFragment.kt */
final class h extends i implements a<d<c>> {
    final /* synthetic */ g this$0;

    h(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    public final d<c> b() {
        Context requireContext = this.this$0.requireContext();
        kotlin.e.b.h.a((Object) requireContext, "requireContext()");
        C0200o childFragmentManager = this.this$0.getChildFragmentManager();
        kotlin.e.b.h.a((Object) childFragmentManager, "childFragmentManager");
        d dVar = new d(requireContext, childFragmentManager, R.id.fragment_container, 0, 8, null);
        return dVar;
    }
}
