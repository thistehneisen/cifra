package b.p;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import b.g.i.B;

/* compiled from: ViewUtils */
class aa extends Property<View, Rect> {
    aa(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public Rect get(View view) {
        return B.g(view);
    }

    /* renamed from: a */
    public void set(View view, Rect rect) {
        B.a(view, rect);
    }
}
