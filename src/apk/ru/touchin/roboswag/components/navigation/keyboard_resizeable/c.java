package ru.touchin.roboswag.components.navigation.keyboard_resizeable;

import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: KeyboardResizeableViewController.kt */
final class c extends i implements a<m> {
    final /* synthetic */ KeyboardResizeableViewController this$0;

    c(KeyboardResizeableViewController keyboardResizeableViewController) {
        this.this$0 = keyboardResizeableViewController;
        super(0);
    }

    public final void b() {
        if (this.this$0.keyboardIsVisible) {
            this.this$0.onKeyboardHide();
        }
        this.this$0.keyboardIsVisible = false;
    }
}
