package io.intercom.android.sdk.views.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.models.Part;
import java.util.List;

public class ConversationItemDecoration extends h {
    private static final int CONCAT_SPACING = 2;
    private static final int DIVIDER_BOTTOM_SPACING = 10;
    private static final int DIVIDER_TOP_SPACING = 16;
    private static final int SPACING = 24;
    private final int concatSpacing;
    private final int headerBottomSpacing;
    private final int headerTopSpacing;
    private final List<Part> parts;
    private final int spacing;

    public ConversationItemDecoration(Context context, List<Part> list) {
        this.parts = list;
        this.spacing = ScreenUtils.dpToPx(24.0f, context);
        this.concatSpacing = ScreenUtils.dpToPx(2.0f, context);
        this.headerTopSpacing = ScreenUtils.dpToPx(16.0f, context);
        this.headerBottomSpacing = ScreenUtils.dpToPx(10.0f, context);
    }

    private boolean nextPartIsDivider(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.parts.size()) {
            if (Part.DAY_DIVIDER_STYLE.equals(((Part) this.parts.get(i3)).getMessageStyle())) {
                return true;
            }
        }
        return false;
    }

    private int topSpacingForPartAtPosition(int i2) {
        if (i2 == 0) {
            return this.spacing;
        }
        return 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        int g2 = recyclerView.g(view);
        if (g2 != -1 && g2 < this.parts.size()) {
            Part part = (Part) this.parts.get(g2);
            if (Part.DAY_DIVIDER_STYLE.equals(part.getMessageStyle())) {
                rect.set(0, this.headerTopSpacing, 0, this.headerBottomSpacing);
            } else if (shouldConcatenate(part, g2)) {
                rect.set(0, topSpacingForPartAtPosition(g2), 0, this.concatSpacing);
            } else if (nextPartIsDivider(g2)) {
                rect.set(0, topSpacingForPartAtPosition(g2), 0, 0);
            } else {
                rect.set(0, topSpacingForPartAtPosition(g2), 0, this.spacing);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldConcatenate(Part part, int i2) {
        int i3 = i2 + 1;
        if (i3 < this.parts.size()) {
            return Part.shouldConcatenate(part, (Part) this.parts.get(i3));
        }
        return false;
    }
}
