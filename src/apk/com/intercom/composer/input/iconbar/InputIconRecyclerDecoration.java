package com.intercom.composer.input.iconbar;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;
import com.intercom.composer.R;

public class InputIconRecyclerDecoration extends h {
    final int startSpacing;

    public InputIconRecyclerDecoration(Context context) {
        this.startSpacing = context.getResources().getDimensionPixelSize(R.dimen.intercom_composer_icon_bar_left_spacing);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        if (recyclerView.g(view) == 0) {
            rect.set(this.startSpacing, 0, 0, 0);
        }
    }
}
