package com.intercom.input.gallery;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;

public class HeadingMarginDecoration extends h {
    private final int heightRes;

    public HeadingMarginDecoration(int i2) {
        this.heightRes = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        int integer = recyclerView.getResources().getInteger(R.integer.intercom_composer_expanded_column_count);
        int f2 = recyclerView.f(view);
        if (f2 >= 0 && f2 < integer) {
            rect.set(0, recyclerView.getResources().getDimensionPixelOffset(this.heightRes), 0, 0);
        }
    }
}
