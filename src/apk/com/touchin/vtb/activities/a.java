package com.touchin.vtb.activities;

import androidx.fragment.app.C0200o;
import com.touchin.vtb.R;
import kotlin.e.b.h;
import kotlin.e.b.i;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: NavigationActivity.kt */
final class a extends i implements kotlin.e.a.a<d<c>> {
    final /* synthetic */ c this$0;

    a(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    public final d<c> b() {
        c cVar = this.this$0;
        C0200o supportFragmentManager = cVar.getSupportFragmentManager();
        h.a((Object) supportFragmentManager, "supportFragmentManager");
        d dVar = new d(cVar, supportFragmentManager, R.id.fragment_container, 0, 8, null);
        return dVar;
    }
}
