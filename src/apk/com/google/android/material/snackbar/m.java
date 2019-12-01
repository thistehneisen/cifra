package com.google.android.material.snackbar;

import b.g.i.a.c.a;

/* compiled from: BaseTransientBottomBar */
class m implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ e f6532a;

    m(e eVar) {
        this.f6532a = eVar;
    }

    public void onTouchExplorationStateChanged(boolean z) {
        this.f6532a.setClickableOrFocusableBasedOnAccessibility(z);
    }
}
