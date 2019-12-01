package com.intercom.composer.keyboard;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.intercom.composer.R;

class KeyboardManager implements OnGlobalLayoutListener, OnKeyboardVisibilityListener {
    private static final String KEY_KEYBOARD_HEIGHT_PORTRAIT = "keyboard_height_portrait";
    private static final String PREFERENCES_NAME = "keyboard";
    private final InputMethodManager inputMethodManager;
    private OnKeyboardVisibilityListener onKeyboardVisibilityListener;
    private final OrientationProvider orientationProvider;
    int previousRelayoutOrientation;
    private final SharedPreferences sharedPreferences;
    boolean wasOpened;
    private final Window window;
    private final WindowManager windowManager;

    KeyboardManager(Activity activity, OrientationProvider orientationProvider2) {
        this(activity.getWindow(), (WindowManager) activity.getSystemService("window"), (InputMethodManager) activity.getSystemService("input_method"), activity.getSharedPreferences(PREFERENCES_NAME, 0), orientationProvider2);
    }

    private int getCurrentKeyboardHeight() {
        View decorView = this.window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int height = decorView.getRootView().getHeight() - rect.bottom;
        return VERSION.SDK_INT >= 18 ? height - getSoftButtonsBarHeight() : height;
    }

    @TargetApi(18)
    private int getSoftButtonsBarHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        defaultDisplay.getRealMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        if (i3 > i2) {
            return i3 - i2;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getKeyboardHeight(int i2) {
        Resources resources = this.window.getContext().getResources();
        if (i2 != 1) {
            return resources.getDimensionPixelSize(R.dimen.intercom_composer_keyboard_landscape_height);
        }
        return this.sharedPreferences.getInt(KEY_KEYBOARD_HEIGHT_PORTRAIT, resources.getDimensionPixelSize(R.dimen.intercom_composer_keyboard_portrait_height));
    }

    /* access modifiers changed from: 0000 */
    public void hideSoftInput(View view) {
        this.inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* access modifiers changed from: 0000 */
    public boolean isShowingKeyboard() {
        return getCurrentKeyboardHeight() > 0;
    }

    public void onGlobalLayout() {
        int currentKeyboardHeight = getCurrentKeyboardHeight();
        boolean z = currentKeyboardHeight > 0;
        int orientation = this.orientationProvider.getOrientation();
        if (z != this.wasOpened || orientation != this.previousRelayoutOrientation) {
            this.wasOpened = z;
            this.previousRelayoutOrientation = orientation;
            onKeyboardVisibilityChanged(z, currentKeyboardHeight);
            OnKeyboardVisibilityListener onKeyboardVisibilityListener2 = this.onKeyboardVisibilityListener;
            if (onKeyboardVisibilityListener2 != null) {
                onKeyboardVisibilityListener2.onKeyboardVisibilityChanged(z, currentKeyboardHeight);
            }
        }
    }

    public void onKeyboardVisibilityChanged(boolean z, int i2) {
        if (z && this.orientationProvider.getOrientation() == 1) {
            this.sharedPreferences.edit().putInt(KEY_KEYBOARD_HEIGHT_PORTRAIT, i2).apply();
        }
    }

    /* access modifiers changed from: 0000 */
    public void removeGlobalLayoutListener() {
        Window window2 = this.window;
        if (window2 != null) {
            ViewTreeObserver viewTreeObserver = window2.getDecorView().getRootView().getViewTreeObserver();
            if (VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setOnKeyboardVisibilityListener(OnKeyboardVisibilityListener onKeyboardVisibilityListener2) {
        this.onKeyboardVisibilityListener = onKeyboardVisibilityListener2;
    }

    KeyboardManager(Window window2, WindowManager windowManager2, InputMethodManager inputMethodManager2, SharedPreferences sharedPreferences2, OrientationProvider orientationProvider2) {
        this.window = window2;
        this.windowManager = windowManager2;
        this.inputMethodManager = inputMethodManager2;
        this.sharedPreferences = sharedPreferences2;
        this.orientationProvider = orientationProvider2;
        this.window.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
