package io.intercom.android.sdk.views.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import java.util.List;

public class HomeItemDecoration extends h {
    private static final int SPACING_DP = 8;
    private final List<Object> cards;
    private final int spacing;

    public HomeItemDecoration(Context context, List<Object> list) {
        this.cards = list;
        this.spacing = ScreenUtils.dpToPx(8.0f, context);
    }

    private int topSpacingForPartAtPosition(int i2) {
        if (i2 == 0) {
            return this.spacing;
        }
        return 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        int g2 = recyclerView.g(view);
        if (g2 != -1 && g2 < this.cards.size()) {
            rect.set(0, topSpacingForPartAtPosition(g2), 0, this.spacing);
        }
    }
}
