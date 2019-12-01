package com.intercom.composer.input.empty;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;

public class EmptyInput extends Input<EmptyFragment> {
    public EmptyInput() {
        super("Empty", new IconProvider() {
            public Drawable getIconDrawable(String str, Context context) {
                return null;
            }
        });
    }

    public EmptyFragment createFragment() {
        return new EmptyFragment();
    }
}
