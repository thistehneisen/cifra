package b.p;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: b.p.i reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0263i extends Property<View, PointF> {
    C0263i(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }

    /* renamed from: a */
    public void set(View view, PointF pointF) {
        int round = Math.round(pointF.x);
        int round2 = Math.round(pointF.y);
        ba.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
    }
}
