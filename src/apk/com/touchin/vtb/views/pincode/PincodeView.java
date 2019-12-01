package com.touchin.vtb.views.pincode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.touchin.vtb.R;
import com.touchin.vtb.f.g;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: PincodeView.kt */
public final class PincodeView extends ConstraintLayout {
    public static final a x = new a(null);
    /* access modifiers changed from: private */
    public String A;
    private final Animation B;
    private final PinView[] C;
    private final View[] D;
    private final ImageView E;
    private final View F;
    private final View G;
    private kotlin.e.a.a<m> y;
    private b<? super String, m> z;

    /* compiled from: PincodeView.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public PincodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PincodeView(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    /* access modifiers changed from: private */
    public final boolean e() {
        return this.y != null;
    }

    /* access modifiers changed from: private */
    public final void f() {
        String str = this.A;
        Character a2 = u.a((CharSequence) str, str.length() - 2);
        if (this.A.length() > 0) {
            String str2 = this.A;
            this.A = s.a(str2, h.d(0, str2.length() - 1));
        }
        a(this.A.length(), String.valueOf(a2), true);
    }

    public final void d() {
        for (PinView a2 : this.C) {
            PinView.a(a2, g.UNDERLINE_ERROR, null, 2, null);
        }
        this.G.startAnimation(this.B);
    }

    public final kotlin.e.a.a<m> getOnFingerprintClickListener() {
        return this.y;
    }

    public final b<String, m> getOnPincodeEnteredListener() {
        return this.z;
    }

    public final void setOnFingerprintClickListener(kotlin.e.a.a<m> aVar) {
        this.y = aVar;
        a(this, this.A.length(), null, false, 6, null);
    }

    public final void setOnForgotPasswordClickListener(kotlin.e.a.a<m> aVar) {
        h.b(aVar, "listener");
        View view = this.F;
        view.setVisibility(0);
        l.a.b.g.a(view, aVar);
    }

    public final void setOnPincodeEnteredListener(b<? super String, m> bVar) {
        h.b(bVar, "<set-?>");
        this.z = bVar;
    }

    public PincodeView(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        h.b(attributeSet, "attrs");
        super(context, attributeSet, i2);
        this.z = g.f7844a;
        this.A = "";
        l.a.d.a.b.a.b(R.layout.view_pincode, this);
        this.B = AnimationUtils.loadAnimation(context, R.anim.common_shaking_animation);
        View findViewById = findViewById(R.id.view_pincode_pin1);
        h.a((Object) findViewById, "findViewById(R.id.view_pincode_pin1)");
        int i3 = 0;
        View findViewById2 = findViewById(R.id.view_pincode_pin2);
        h.a((Object) findViewById2, "findViewById(R.id.view_pincode_pin2)");
        View findViewById3 = findViewById(R.id.view_pincode_pin3);
        h.a((Object) findViewById3, "findViewById(R.id.view_pincode_pin3)");
        View findViewById4 = findViewById(R.id.view_pincode_pin4);
        h.a((Object) findViewById4, "findViewById(R.id.view_pincode_pin4)");
        this.C = new PinView[]{(PinView) findViewById, (PinView) findViewById2, (PinView) findViewById3, (PinView) findViewById4};
        View findViewById5 = findViewById(R.id.view_pincode_button_0);
        h.a((Object) findViewById5, "findViewById(R.id.view_pincode_button_0)");
        View findViewById6 = findViewById(R.id.view_pincode_button_1);
        h.a((Object) findViewById6, "findViewById(R.id.view_pincode_button_1)");
        View findViewById7 = findViewById(R.id.view_pincode_button_2);
        h.a((Object) findViewById7, "findViewById(R.id.view_pincode_button_2)");
        View findViewById8 = findViewById(R.id.view_pincode_button_3);
        h.a((Object) findViewById8, "findViewById(R.id.view_pincode_button_3)");
        View findViewById9 = findViewById(R.id.view_pincode_button_4);
        h.a((Object) findViewById9, "findViewById(R.id.view_pincode_button_4)");
        View findViewById10 = findViewById(R.id.view_pincode_button_5);
        h.a((Object) findViewById10, "findViewById(R.id.view_pincode_button_5)");
        View findViewById11 = findViewById(R.id.view_pincode_button_6);
        h.a((Object) findViewById11, "findViewById(R.id.view_pincode_button_6)");
        View findViewById12 = findViewById(R.id.view_pincode_button_7);
        h.a((Object) findViewById12, "findViewById(R.id.view_pincode_button_7)");
        View findViewById13 = findViewById(R.id.view_pincode_button_8);
        h.a((Object) findViewById13, "findViewById(R.id.view_pincode_button_8)");
        View findViewById14 = findViewById(R.id.view_pincode_button_9);
        h.a((Object) findViewById14, "findViewById(R.id.view_pincode_button_9)");
        this.D = new View[]{findViewById5, findViewById6, findViewById7, findViewById8, findViewById9, findViewById10, findViewById11, findViewById12, findViewById13, findViewById14};
        View findViewById15 = findViewById(R.id.view_pincode_button_fingerprint_or_backspace);
        h.a((Object) findViewById15, "findViewById(R.id.view_p…fingerprint_or_backspace)");
        this.E = (ImageView) findViewById15;
        View findViewById16 = findViewById(R.id.view_pincode_button_forgot);
        h.a((Object) findViewById16, "findViewById(R.id.view_pincode_button_forgot)");
        this.F = findViewById16;
        View findViewById17 = findViewById(R.id.view_pincode_dots_container);
        h.a((Object) findViewById17, "findViewById(R.id.view_pincode_dots_container)");
        this.G = findViewById17;
        View[] viewArr = this.D;
        int length = viewArr.length;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            l.a.b.g.a(viewArr[i3], new b(i4, this));
            i3++;
            i4 = i5;
        }
        l.a.b.g.a(this.E, new d(this));
        this.B.setAnimationListener(new e(this));
        a();
    }

    public final void b() {
        for (View enabled : this.D) {
            enabled.setEnabled(false);
        }
    }

    public final void c() {
        setOnFingerprintClickListener(null);
        c(0);
    }

    public final void a() {
        this.A = "";
        a(this, 0, null, false, 6, null);
    }

    private final void c(int i2) {
        this.E.setImageResource((!e() || i2 != 0) ? R.drawable.common_remove_icon : R.drawable.common_fingerprint_pin_icon);
    }

    static /* synthetic */ void a(PincodeView pincodeView, int i2, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        pincodeView.a(i2, str, z2);
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (this.A.length() < 4) {
            String str2 = this.A;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            this.A = sb.toString();
            a(this, this.A.length(), str, false, 4, null);
            if (this.A.length() == 4) {
                this.E.setVisibility(4);
                postDelayed(new f(this), 200);
            }
        }
    }

    private final void a(int i2, String str, boolean z2) {
        int i3 = 0;
        this.E.setVisibility(i2 <= 0 && !e() ? 4 : 0);
        PinView[] pinViewArr = this.C;
        int length = pinViewArr.length;
        int i4 = 0;
        while (i3 < length) {
            PinView pinView = pinViewArr[i3];
            int i5 = i4 + 1;
            int i6 = i2 - 1;
            if (i4 < i6) {
                PinView.a(pinView, g.DOT_VISIBLE, null, 2, null);
            } else if (i4 != i6 || str == null) {
                if (i4 == i2) {
                    PinView.a(pinView, g.UNDERLINE_FOCUSED, null, 2, null);
                } else {
                    PinView.a(pinView, g.UNDERLINE_UNFOCUSED, null, 2, null);
                }
            } else if (z2) {
                PinView.a(pinView, g.DOT_VISIBLE, null, 2, null);
            } else {
                pinView.a(g.DIGIT_VISIBLE, str);
                postDelayed(new c(pinView), 700);
            }
            i3++;
            i4 = i5;
        }
        c(i2);
    }
}
