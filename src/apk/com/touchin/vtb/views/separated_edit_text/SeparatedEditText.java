package com.touchin.vtb.views.separated_edit_text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.f.j;
import com.touchin.vtb.views.InsertionDisabledEditText;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: SeparatedEditText.kt */
public final class SeparatedEditText extends ConstraintLayout {
    public static final a x = new a(null);
    /* access modifiers changed from: private */
    public final UnderlinedDigitView[] A;
    private final InsertionDisabledEditText y;
    private kotlin.e.a.a<m> z;

    /* compiled from: SeparatedEditText.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public SeparatedEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SeparatedEditText(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public final void b() {
        for (UnderlinedDigitView a2 : this.A) {
            UnderlinedDigitView.a(a2, j.UNDERLINE_SUCCESS, null, 2, null);
        }
    }

    public final InsertionDisabledEditText getInvisibleEditText() {
        return this.y;
    }

    public final kotlin.e.a.a<m> getOnCodeEnteredAction() {
        return this.z;
    }

    public final void setOnCodeEnteredAction(kotlin.e.a.a<m> aVar) {
        h.b(aVar, "<set-?>");
        this.z = aVar;
    }

    public SeparatedEditText(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        h.b(attributeSet, "attrs");
        super(context, attributeSet, i2);
        l.a.d.a.b.a.b(R.layout.view_separated_edit_text, this);
        View findViewById = findViewById(R.id.view_invisible_edittext);
        h.a((Object) findViewById, "findViewById(R.id.view_invisible_edittext)");
        this.y = (InsertionDisabledEditText) findViewById;
        this.z = b.f7846a;
        View findViewById2 = findViewById(R.id.view_digit1);
        h.a((Object) findViewById2, "findViewById(R.id.view_digit1)");
        View findViewById3 = findViewById(R.id.view_digit2);
        h.a((Object) findViewById3, "findViewById(R.id.view_digit2)");
        View findViewById4 = findViewById(R.id.view_digit3);
        h.a((Object) findViewById4, "findViewById(R.id.view_digit3)");
        View findViewById5 = findViewById(R.id.view_digit4);
        h.a((Object) findViewById5, "findViewById(R.id.view_digit4)");
        this.A = new UnderlinedDigitView[]{(UnderlinedDigitView) findViewById2, (UnderlinedDigitView) findViewById3, (UnderlinedDigitView) findViewById4, (UnderlinedDigitView) findViewById5};
        this.y.addTextChangedListener(new a(this));
    }

    public final void a() {
        for (UnderlinedDigitView a2 : this.A) {
            UnderlinedDigitView.a(a2, j.UNDERLINE_ERROR, null, 2, null);
        }
        this.y.postDelayed(new c(this), 1000);
    }
}
