package com.intercom.composer.keyboard;

import android.app.Activity;
import android.view.View;
import android.view.Window;

public class KeyboardHelper implements OnKeyboardVisibilityListener {
    private final View behindKeyboardView;
    private final View editText;
    private final KeyboardManager keyboardManager;
    private final OrientationProvider orientationProvider;
    private final Window window;

    public KeyboardHelper(Activity activity, OrientationProvider orientationProvider2, View view, View view2) {
        this(new KeyboardManager(activity, orientationProvider2), orientationProvider2, activity.getWindow(), view, view2);
    }

    private boolean isBehindKeyboardViewVisible() {
        return this.behindKeyboardView.getLayoutParams().height != 0;
    }

    public boolean hideBehindKeyboardView() {
        if (!isBehindKeyboardViewVisible()) {
            return false;
        }
        this.behindKeyboardView.getLayoutParams().height = 0;
        this.behindKeyboardView.requestLayout();
        this.window.setSoftInputMode(16);
        return true;
    }

    public void onDestroy() {
        this.keyboardManager.removeGlobalLayoutListener();
    }

    public void onKeyboardVisibilityChanged(boolean z, int i2) {
        if (z) {
            this.window.setSoftInputMode(16);
            if (isBehindKeyboardViewVisible()) {
                this.behindKeyboardView.getLayoutParams().height = 0;
                this.behindKeyboardView.requestLayout();
            }
        } else if (isBehindKeyboardViewVisible()) {
            this.window.setSoftInputMode(32);
        } else {
            this.window.setSoftInputMode(16);
        }
    }

    public void showBehindKeyboardView() {
        int orientation = this.orientationProvider.getOrientation();
        if (this.keyboardManager.isShowingKeyboard()) {
            this.behindKeyboardView.getLayoutParams().height = this.keyboardManager.getKeyboardHeight(orientation);
            this.behindKeyboardView.requestLayout();
            this.window.setSoftInputMode(32);
            if (this.keyboardManager.isShowingKeyboard()) {
                this.keyboardManager.hideSoftInput(this.editText);
            }
        } else if (!isBehindKeyboardViewVisible()) {
            this.behindKeyboardView.getLayoutParams().height = this.keyboardManager.getKeyboardHeight(orientation);
            this.behindKeyboardView.requestLayout();
            this.window.setSoftInputMode(32);
        }
    }

    KeyboardHelper(KeyboardManager keyboardManager2, OrientationProvider orientationProvider2, Window window2, View view, View view2) {
        if (view2 == null) {
            throw new IllegalArgumentException("behindKeyboardView can not be null!");
        } else if (view != null) {
            this.editText = view;
            this.behindKeyboardView = view2;
            this.window = window2;
            this.window.setSoftInputMode(19);
            this.orientationProvider = orientationProvider2;
            this.keyboardManager = keyboardManager2;
            this.keyboardManager.setOnKeyboardVisibilityListener(this);
        } else {
            throw new IllegalArgumentException("editText can not be null!");
        }
    }
}
