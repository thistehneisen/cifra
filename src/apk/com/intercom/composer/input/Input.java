package com.intercom.composer.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.fragment.app.C0200o;
import com.intercom.composer.R;
import com.intercom.composer.input.InputFragment;

public abstract class Input<T extends InputFragment> {
    private String fragmentTag;
    private final IconProvider iconProvider;
    private final String uniqueIdentifier;

    protected Input(String str, IconProvider iconProvider2) {
        this.uniqueIdentifier = str;
        this.iconProvider = iconProvider2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Inputs must have a non-empty unique identifier.");
        }
    }

    public abstract T createFragment();

    public T findFragment(C0200o oVar) {
        return (InputFragment) oVar.a(this.fragmentTag);
    }

    public int getBackgroundColor() {
        return R.color.intercom_composer_white;
    }

    public int getBorderColor() {
        return R.color.intercom_composer_border;
    }

    public Drawable getIconDrawable(Context context) {
        return this.iconProvider.getIconDrawable(this.uniqueIdentifier, context);
    }

    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    public void setFragmentTag(String str) {
        this.fragmentTag = str;
    }
}
