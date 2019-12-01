package b.g.i;

import android.view.View;

/* compiled from: ViewCompat */
class y extends b<Boolean> {
    y(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    /* access modifiers changed from: 0000 */
    public Boolean a(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }
}
