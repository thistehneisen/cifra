package com.touchin.vtb.views.separated_edit_text;

/* compiled from: SeparatedEditText.kt */
final class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SeparatedEditText f7847a;

    c(SeparatedEditText separatedEditText) {
        this.f7847a = separatedEditText;
    }

    public final void run() {
        this.f7847a.getInvisibleEditText().setText("");
    }
}
