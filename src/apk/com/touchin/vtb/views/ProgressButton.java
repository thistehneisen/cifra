package com.touchin.vtb.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.f;
import com.touchin.vtb.f.h;
import l.a.d.a.b.a.C0122a;
import ru.touchin.roboswag.components.views.MaterialLoadingBar;

/* compiled from: ProgressButton.kt */
public final class ProgressButton extends ConstraintLayout {
    public static final a x = new a(null);
    private final ImageView A;
    private float B;
    private int C;
    private final TextView y;
    private final MaterialLoadingBar z;

    /* compiled from: ProgressButton.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ProgressButton(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.y.setEnabled(z2);
    }

    public final void setState(h hVar) {
        kotlin.e.b.h.b(hVar, "state");
        this.y.setVisibility(hVar == h.LOADING || hVar == h.FAIL || hVar == h.SUCCESS ? 4 : 0);
        this.z.setVisibility(hVar == h.NORMAL || hVar == h.FAIL || hVar == h.SUCCESS ? 4 : 0);
        this.A.setVisibility(hVar == h.FAIL || hVar == h.SUCCESS ? 0 : 8);
        setEnabled(hVar == h.NORMAL);
        int i2 = g.f7809a[hVar.ordinal()];
        if (i2 == 1) {
            setBackground(b.g.a.a.c(getContext(), R.drawable.common_progress_button_active));
            setEnabled(false);
        } else if (i2 == 2) {
            this.y.setVisibility(0);
            setBackground(b.g.a.a.c(getContext(), R.drawable.common_progress_button_normal));
        } else if (i2 == 3) {
            this.A.setImageDrawable(b.g.a.a.c(getContext(), R.drawable.common_fail_icon));
            setBackground(b.g.a.a.c(getContext(), R.drawable.common_progress_button_active));
        } else if (i2 == 4) {
            this.A.setImageDrawable(b.g.a.a.c(getContext(), R.drawable.common_success_icon));
            setBackground(b.g.a.a.c(getContext(), R.drawable.common_progress_button_active));
        }
    }

    public final void setText(CharSequence charSequence) {
        this.y.setText(charSequence);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x006c, code lost:
        if (r0 != null) goto L_0x0086;
     */
    public ProgressButton(Context context, AttributeSet attributeSet, int i2) {
        kotlin.e.b.h.b(context, "context");
        super(context, attributeSet, i2);
        l.a.d.a.b.a.b(R.layout.view_progress_button, this);
        View findViewById = findViewById(R.id.startup_progress_button_text);
        kotlin.e.b.h.a((Object) findViewById, "findViewById(R.id.startup_progress_button_text)");
        this.y = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.startup_progress_button_progress);
        kotlin.e.b.h.a((Object) findViewById2, "findViewById(R.id.startu…progress_button_progress)");
        this.z = (MaterialLoadingBar) findViewById2;
        View findViewById3 = findViewById(R.id.startup_progress_image);
        kotlin.e.b.h.a((Object) findViewById3, "findViewById(R.id.startup_progress_image)");
        this.A = (ImageView) findViewById3;
        this.B = C0122a.a(context, 15.0f);
        this.C = R.font.rubik_normal;
        int[] iArr = f.ProgressButton;
        kotlin.e.b.h.a((Object) iArr, "R.styleable.ProgressButton");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
        if (colorStateList != null) {
            this.y.setTextColor(colorStateList);
            this.z.setColor(colorStateList.getDefaultColor());
        }
        int intValue = Integer.valueOf(obtainStyledAttributes.getColor(3, -1)).intValue();
        this.y.setTextColor(intValue);
        this.z.setColor(intValue);
        setText(obtainStyledAttributes.getText(4));
        this.y.setTypeface(b.g.a.a.h.a(context, obtainStyledAttributes.getResourceId(2, this.C)));
        this.y.setTextSize(0, obtainStyledAttributes.getDimension(0, this.B));
        this.y.setAllCaps(obtainStyledAttributes.getBoolean(1, false));
        this.z.setColor(b.g.a.a.a(context, (int) R.color.common_black));
        obtainStyledAttributes.recycle();
    }
}
