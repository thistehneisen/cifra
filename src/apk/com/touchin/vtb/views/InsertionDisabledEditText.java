package com.touchin.vtb.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.C0176p;
import com.touchin.vtb.utils.i;
import java.lang.reflect.Field;
import kotlin.e.b.h;

/* compiled from: InsertionDisabledEditText.kt */
public final class InsertionDisabledEditText extends C0176p {
    public InsertionDisabledEditText(Context context) {
        this(context, null, 0, 6, null);
    }

    public InsertionDisabledEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ InsertionDisabledEditText(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 16842862;
        }
        this(context, attributeSet, i2);
    }

    @SuppressLint({"PrivateApi"})
    private final void a() {
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            h.a((Object) declaredField, "editorField");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mInsertionControllerEnabled");
            h.a((Object) declaredField2, "mInsertionControllerEnabledField");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, Boolean.valueOf(false));
        } catch (Exception unused) {
        }
    }

    public boolean isSuggestionsEnabled() {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.b(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public InsertionDisabledEditText(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        setCustomSelectionActionModeCallback(new i());
        setLongClickable(false);
    }
}
