package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import b.a.a;
import b.a.j;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* renamed from: androidx.appcompat.widget.a reason: case insensitive filesystem */
/* compiled from: AbsActionBarView */
abstract class C0153a extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    protected final C0007a f938a;

    /* renamed from: b reason: collision with root package name */
    protected final Context f939b;

    /* renamed from: c reason: collision with root package name */
    protected ActionMenuView f940c;

    /* renamed from: d reason: collision with root package name */
    protected C0165g f941d;

    /* renamed from: e reason: collision with root package name */
    protected int f942e;

    /* renamed from: f reason: collision with root package name */
    protected K f943f;

    /* renamed from: g reason: collision with root package name */
    private boolean f944g;

    /* renamed from: h reason: collision with root package name */
    private boolean f945h;

    /* renamed from: androidx.appcompat.widget.a$a reason: collision with other inner class name */
    /* compiled from: AbsActionBarView */
    protected class C0007a implements L {

        /* renamed from: a reason: collision with root package name */
        private boolean f946a = false;

        /* renamed from: b reason: collision with root package name */
        int f947b;

        protected C0007a() {
        }

        public C0007a a(K k2, int i2) {
            C0153a.this.f943f = k2;
            this.f947b = i2;
            return this;
        }

        public void b(View view) {
            if (!this.f946a) {
                C0153a aVar = C0153a.this;
                aVar.f943f = null;
                C0153a.super.setVisibility(this.f947b);
            }
        }

        public void c(View view) {
            C0153a.super.setVisibility(0);
            this.f946a = false;
        }

        public void a(View view) {
            this.f946a = true;
        }
    }

    C0153a(Context context) {
        this(context, null);
    }

    protected static int a(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    public int getAnimatedVisibility() {
        if (this.f943f != null) {
            return this.f938a.f947b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f942e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.ActionBar, a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        C0165g gVar = this.f941d;
        if (gVar != null) {
            gVar.a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f945h = false;
        }
        if (!this.f945h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f945h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f945h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f944g = false;
        }
        if (!this.f944g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f944g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f944g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            K k2 = this.f943f;
            if (k2 != null) {
                k2.a();
            }
            super.setVisibility(i2);
        }
    }

    C0153a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public K a(int i2, long j2) {
        K k2 = this.f943f;
        if (k2 != null) {
            k2.a();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            K a2 = B.a(this);
            a2.a(1.0f);
            a2.a(j2);
            C0007a aVar = this.f938a;
            aVar.a(a2, i2);
            a2.a((L) aVar);
            return a2;
        }
        K a3 = B.a(this);
        a3.a(0.0f);
        a3.a(j2);
        C0007a aVar2 = this.f938a;
        aVar2.a(a3, i2);
        a3.a((L) aVar2);
        return a3;
    }

    C0153a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f938a = new C0007a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.actionBarPopupTheme, typedValue, true)) {
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f939b = new ContextThemeWrapper(context, i3);
                return;
            }
        }
        this.f939b = context;
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i2, int i3, int i4) {
        view.measure(MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
