package ru.touchin.roboswag.components.navigation.keyboard_resizeable;

import android.app.Activity;

/* compiled from: KeyboardResizeableViewController.kt */
final class b implements l.a.d.a.a.a.b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ KeyboardResizeableViewController f11112a;

    b(KeyboardResizeableViewController keyboardResizeableViewController) {
        this.f11112a = keyboardResizeableViewController;
    }

    public final boolean a() {
        if (!this.f11112a.keyboardIsVisible) {
            return false;
        }
        l.a.d.a.b.a.b.a((Activity) this.f11112a.getActivity());
        return true;
    }
}
