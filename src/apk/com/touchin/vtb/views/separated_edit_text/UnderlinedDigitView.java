package com.touchin.vtb.views.separated_edit_text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.f.j;
import kotlin.e.b.h;
import l.a.d.a.b.a;

/* compiled from: UnderlinedDigitView.kt */
public final class UnderlinedDigitView extends ConstraintLayout {
    private final TextView x;
    private final View y;

    public UnderlinedDigitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ UnderlinedDigitView(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public static /* synthetic */ void a(UnderlinedDigitView underlinedDigitView, j jVar, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        underlinedDigitView.a(jVar, str);
    }

    public UnderlinedDigitView(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        h.b(attributeSet, "attrs");
        super(context, attributeSet, i2);
        a.b(R.layout.view_underlined_digit, this);
        View findViewById = findViewById(R.id.view_digit);
        h.a((Object) findViewById, "findViewById(R.id.view_digit)");
        this.x = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.view_underline);
        h.a((Object) findViewById2, "findViewById(R.id.view_underline)");
        this.y = findViewById2;
    }

    public final void a(j jVar, String str) {
        h.b(jVar, "state");
        if (str != null) {
            this.x.setText(str);
        }
        View view = this.y;
        Context context = getContext();
        int i2 = d.f7848a[jVar.ordinal()];
        int i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? R.color.common_unfocused_color : R.color.common_success_color : R.color.common_error_color : R.color.common_action_yellow_color : 17170443;
        view.setBackground(b.g.a.a.c(context, i3));
    }
}
