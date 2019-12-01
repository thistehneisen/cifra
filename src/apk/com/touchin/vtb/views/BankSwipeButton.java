package com.touchin.vtb.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.api.BankType;
import com.touchin.vtb.api.ConnectedBank;
import com.touchin.vtb.e.c;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: BankSwipeButton.kt */
public final class BankSwipeButton extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    public static final a f7741a = new a(null);

    /* renamed from: b reason: collision with root package name */
    private boolean f7742b;

    /* renamed from: c reason: collision with root package name */
    private b<? super String, m> f7743c;

    /* renamed from: d reason: collision with root package name */
    private ConnectedBank f7744d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final View f7745e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final View f7746f;

    /* renamed from: g reason: collision with root package name */
    private final View f7747g;

    /* renamed from: h reason: collision with root package name */
    private GestureDetector f7748h;

    /* renamed from: i reason: collision with root package name */
    private ValueAnimator f7749i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public boolean f7750j;

    /* compiled from: BankSwipeButton.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public BankSwipeButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public BankSwipeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BankSwipeButton(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public static final /* synthetic */ ConnectedBank c(BankSwipeButton bankSwipeButton) {
        ConnectedBank connectedBank = bankSwipeButton.f7744d;
        if (connectedBank != null) {
            return connectedBank;
        }
        h.b("connectedBank");
        throw null;
    }

    public static final /* synthetic */ b d(BankSwipeButton bankSwipeButton) {
        b<? super String, m> bVar = bankSwipeButton.f7743c;
        if (bVar != null) {
            return bVar;
        }
        h.b("onDeleteAction");
        throw null;
    }

    /* access modifiers changed from: private */
    public final void setDragProgress(float f2) {
        LayoutParams layoutParams = this.f7745e.getLayoutParams();
        int min = (int) Math.min(Math.max(Math.abs(f2), ((float) getWidth()) * 0.5f), (float) this.f7746f.getWidth());
        View view = this.f7747g;
        int i2 = 0;
        if (!(((float) min) > ((float) view.getWidth()) + this.f7747g.getX())) {
            i2 = 8;
        }
        view.setVisibility(i2);
        layoutParams.width = min;
        this.f7745e.requestLayout();
    }

    public final boolean getSwipeEnabled() {
        return this.f7742b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.b(motionEvent, "event");
        if (!this.f7742b || this.f7748h.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            b(motionEvent.getX());
        } else if (action == 3 && ((float) this.f7746f.getWidth()) + this.f7746f.getX() != ((float) this.f7745e.getWidth()) + this.f7745e.getX()) {
            b(motionEvent.getX());
        }
        return true;
    }

    public final void setSwipeEnabled(boolean z) {
        this.f7742b = z;
    }

    public BankSwipeButton(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        this.f7742b = true;
        FrameLayout.inflate(context, R.layout.bank_swipe_button, this);
        View findViewById = findViewById(R.id.item_background_management_background_overlay);
        h.a((Object) findViewById, "findViewById(R.id.item_b…ement_background_overlay)");
        this.f7745e = findViewById;
        View findViewById2 = findViewById(R.id.item_background_management_background);
        h.a((Object) findViewById2, "findViewById(R.id.item_b…nd_management_background)");
        this.f7746f = findViewById2;
        View findViewById3 = findViewById(R.id.item_banks_management_bank_title);
        h.a((Object) findViewById3, "findViewById(R.id.item_b…ks_management_bank_title)");
        this.f7747g = findViewById3;
        this.f7748h = new GestureDetector(getContext(), new b(this));
        this.f7748h.setIsLongpressEnabled(false);
    }

    /* access modifiers changed from: private */
    public final m b() {
        ValueAnimator valueAnimator = this.f7749i;
        if (valueAnimator == null) {
            return null;
        }
        valueAnimator.cancel();
        return m.f10346a;
    }

    private final void b(float f2) {
        if (this.f7750j) {
            a();
        } else {
            a(f2);
        }
    }

    public final void a(ConnectedBank connectedBank, b<? super String, m> bVar) {
        h.b(connectedBank, "connectedBank");
        h.b(bVar, "onDeleteAction");
        this.f7744d = connectedBank;
        ImageView imageView = (ImageView) findViewById(R.id.item_banks_management_bank_icon);
        BankType b2 = connectedBank.b();
        String str = "connectedBank.bankType";
        h.a((Object) b2, str);
        imageView.setImageResource(c.d(b2));
        View findViewById = findViewById(R.id.item_banks_management_bank_title);
        h.a((Object) findViewById, "findViewById<TextView>(R…ks_management_bank_title)");
        TextView textView = (TextView) findViewById;
        BankType b3 = connectedBank.b();
        h.a((Object) b3, str);
        Context context = getContext();
        h.a((Object) context, "context");
        textView.setText(c.a(b3, context));
        this.f7743c = bVar;
    }

    private final void a() {
        b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((float) this.f7745e.getWidth()) + this.f7745e.getX(), ((float) this.f7746f.getWidth()) + this.f7746f.getX()});
        ofFloat.addUpdateListener(new d(this));
        ofFloat.setDuration(200);
        ofFloat.start();
        this.f7749i = ofFloat;
    }

    private final void a(float f2) {
        b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, ((float) getWidth()) * 0.5f});
        ofFloat.addUpdateListener(new c(this));
        ofFloat.setDuration(100);
        ofFloat.start();
        this.f7749i = ofFloat;
    }
}
