package c.c.a;

import android.view.View;
import b.g.i.B;

/* compiled from: ItemTouchUIUtilImpl */
class o extends n {
    o() {
    }

    public void a(View view) {
        Object tag = view.getTag(q.item_touch_helper_previous_elevation);
        if (tag != null && (tag instanceof Float)) {
            B.b(view, ((Float) tag).floatValue());
        }
        view.setTag(q.item_touch_helper_previous_elevation, null);
        super.a(view);
    }
}
