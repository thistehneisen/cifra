package ru.touchin.roboswag.components.navigation.keyboard_resizeable;

import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.ViewGroup;
import kotlin.e.b.h;
import l.a.d.a.a.a.a;
import l.a.d.a.a.a.b;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c;

/* compiled from: KeyboardResizeableViewController.kt */
public abstract class KeyboardResizeableViewController<TActivity extends a, TState extends Parcelable> extends c<TActivity, TState> {
    private boolean isHideKeyboardOnBackEnabled;
    private final b keyboardHideListener;
    /* access modifiers changed from: private */
    public boolean keyboardIsVisible;

    public KeyboardResizeableViewController(int i2, c.a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, i2);
        if (VERSION.SDK_INT >= 20) {
            ViewGroup b2 = aVar.b();
            if (b2 != null) {
                b2.requestApplyInsets();
            }
        }
        this.keyboardHideListener = new b(this);
    }

    public static /* synthetic */ void onKeyboardShow$default(KeyboardResizeableViewController keyboardResizeableViewController, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i2 = 0;
            }
            keyboardResizeableViewController.onKeyboardShow(i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onKeyboardShow");
    }

    /* access modifiers changed from: protected */
    public final void hideKeyboardOnBackPressed() {
        this.isHideKeyboardOnBackEnabled = true;
    }

    /* access modifiers changed from: protected */
    public void onKeyboardHide() {
    }

    /* access modifiers changed from: protected */
    public void onKeyboardShow(int i2) {
    }

    public void onPause() {
        super.onPause();
        if (this.isHideKeyboardOnBackEnabled) {
            ((a) getActivity()).b(this.keyboardHideListener);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.isHideKeyboardOnBackEnabled) {
            ((a) getActivity()).a(this.keyboardHideListener);
        }
    }

    public void onStart() {
        super.onStart();
        a a2 = ((a) getActivity()).a();
        if (a2 != null) {
            a2.a(new c(this));
            throw null;
        }
    }

    public void onStop() {
        super.onStop();
        a a2 = ((a) getActivity()).a();
        if (a2 != null) {
            a2.a();
            throw null;
        }
    }
}
