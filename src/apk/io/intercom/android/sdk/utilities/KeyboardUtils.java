package io.intercom.android.sdk.utilities;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtils {
    private KeyboardUtils() {
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
