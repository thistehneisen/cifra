package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.C0171k;
import c.b.a.c.b.a;

@Keep
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    /* access modifiers changed from: protected */
    public C0171k createButton(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}
