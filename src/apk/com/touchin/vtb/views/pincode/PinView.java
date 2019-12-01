package com.touchin.vtb.views.pincode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.f.g;
import kotlin.e.b.h;
import l.a.d.a.b.a;

/* compiled from: PinView.kt */
public final class PinView extends ConstraintLayout {
    private final TextView x;
    private final View y;
    private final View z;

    public PinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PinView(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public static /* synthetic */ void a(PinView pinView, g gVar, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        pinView.a(gVar, str);
    }

    public final TextView getDigitView() {
        return this.x;
    }

    public PinView(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        h.b(attributeSet, "attrs");
        super(context, attributeSet, i2);
        a.b(R.layout.view_pin, this);
        View findViewById = findViewById(R.id.view_pin_digit);
        h.a((Object) findViewById, "findViewById(R.id.view_pin_digit)");
        this.x = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.view_pin_dot);
        h.a((Object) findViewById2, "findViewById(R.id.view_pin_dot)");
        this.y = findViewById2;
        View findViewById3 = findViewById(R.id.view_pin_underline);
        h.a((Object) findViewById3, "findViewById(R.id.view_pin_underline)");
        this.z = findViewById3;
    }

    public final void a(g gVar, String str) {
        h.b(gVar, "state");
        int i2 = 0;
        this.x.setVisibility(gVar != g.DIGIT_VISIBLE ? 4 : 0);
        this.y.setVisibility(gVar == g.DOT_VISIBLE ? 0 : 8);
        View view = this.z;
        if (!((gVar == g.DIGIT_VISIBLE || gVar == g.DOT_VISIBLE) ? false : true)) {
            i2 = 8;
        }
        view.setVisibility(i2);
        if (str != null) {
            this.x.setText(str);
        }
        View view2 = this.z;
        Context context = getContext();
        int i3 = a.f7840a[gVar.ordinal()];
        int i4 = i3 != 1 ? i3 != 2 ? R.color.common_unfocused_color : R.color.common_error_color : R.color.common_action_yellow_color;
        view2.setBackground(b.g.a.a.c(context, i4));
    }
}
