package com.touchin.vtb.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.touchin.vtb.R;
import com.touchin.vtb.f.b;
import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: BankCardView.kt */
public final class a extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    public static final C0081a f7752a = new C0081a(null);

    /* renamed from: b reason: collision with root package name */
    private final int f7753b;

    /* renamed from: c reason: collision with root package name */
    private final CardView f7754c;

    /* renamed from: d reason: collision with root package name */
    private final TextView f7755d;

    /* renamed from: e reason: collision with root package name */
    private final AppCompatImageView f7756e;

    /* renamed from: f reason: collision with root package name */
    private final TextView f7757f;

    /* renamed from: g reason: collision with root package name */
    private final AppCompatImageView f7758g;

    /* renamed from: h reason: collision with root package name */
    private final TextView f7759h;

    /* renamed from: com.touchin.vtb.views.a$a reason: collision with other inner class name */
    /* compiled from: BankCardView.kt */
    public static final class C0081a {
        private C0081a() {
        }

        public /* synthetic */ C0081a(e eVar) {
            this();
        }
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float a2 = b.g.e.a.a(((float) i3) / ((float) this.f7753b), 0.3f, 1.0f);
        this.f7757f.setScaleX(a2);
        this.f7757f.setScaleY(a2);
    }

    @SuppressLint({"SetTextI18n"})
    public final void setup(b bVar) {
        h.b(bVar, "model");
        Context context = getContext();
        Integer k2 = bVar.k();
        int a2 = b.g.a.a.a(context, k2 != null ? k2.intValue() : R.color.common_card_title_light_color);
        Context context2 = getContext();
        Integer f2 = bVar.f();
        int a3 = b.g.a.a.a(context2, f2 != null ? f2.intValue() : R.color.common_card_number_light_color);
        CardView cardView = this.f7754c;
        Context context3 = getContext();
        Integer d2 = bVar.d();
        cardView.setCardBackgroundColor(b.g.a.a.a(context3, d2 != null ? d2.intValue() : 17170443));
        this.f7755d.setText(bVar.j());
        this.f7755d.setTextColor(a2);
        Integer c2 = bVar.c();
        if (c2 != null) {
            this.f7756e.setImageResource(c2.intValue());
        }
        boolean z = true;
        int i2 = 0;
        this.f7756e.setVisibility(bVar.c() == null ? 8 : 0);
        this.f7757f.setText(bVar.b());
        this.f7757f.setTextColor(a2);
        Integer i3 = bVar.i();
        if (i3 != null) {
            this.f7758g.setImageResource(i3.intValue());
        }
        AppCompatImageView appCompatImageView = this.f7758g;
        if (bVar.i() != null) {
            z = false;
        }
        if (z) {
            i2 = 8;
        }
        appCompatImageView.setVisibility(i2);
        TextView textView = this.f7759h;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.e());
        sb.append(" ");
        String str = bVar.a().toString();
        if (str != null) {
            String lowerCase = str.toLowerCase();
            h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            textView.setText(sb.toString());
            this.f7759h.setTextColor(a3);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        this.f7753b = context.getResources().getDimensionPixelSize(R.dimen.bank_card_height);
        FrameLayout.inflate(context, R.layout.view_bank_card, this);
        View findViewById = findViewById(R.id.view_bank_card_view);
        h.a((Object) findViewById, "findViewById(R.id.view_bank_card_view)");
        this.f7754c = (CardView) findViewById;
        View findViewById2 = findViewById(R.id.view_bank_card_title);
        h.a((Object) findViewById2, "findViewById(R.id.view_bank_card_title)");
        this.f7755d = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.view_bank_card_logo);
        h.a((Object) findViewById3, "findViewById(R.id.view_bank_card_logo)");
        this.f7756e = (AppCompatImageView) findViewById3;
        View findViewById4 = findViewById(R.id.view_bank_card_amount);
        h.a((Object) findViewById4, "findViewById(R.id.view_bank_card_amount)");
        this.f7757f = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.view_bank_card_payment_system_logo);
        h.a((Object) findViewById5, "findViewById(R.id.view_b…card_payment_system_logo)");
        this.f7758g = (AppCompatImageView) findViewById5;
        View findViewById6 = findViewById(R.id.view_bank_card_number);
        h.a((Object) findViewById6, "findViewById(R.id.view_bank_card_number)");
        this.f7759h = (TextView) findViewById6;
    }
}
