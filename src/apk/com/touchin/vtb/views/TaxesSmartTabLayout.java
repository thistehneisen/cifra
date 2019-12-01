package com.touchin.vtb.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import androidx.viewpager.widget.ViewPager;
import c.d.a.d;
import java.lang.reflect.Field;
import kotlin.e.b.h;
import l.a.d.b.a.c;

/* compiled from: TaxesSmartTabLayout.kt */
public final class TaxesSmartTabLayout extends d {
    public static final a p = new a(null);
    /* access modifiers changed from: private */
    public final GestureDetector q;
    private ViewPager r;

    /* compiled from: TaxesSmartTabLayout.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public TaxesSmartTabLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public TaxesSmartTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TaxesSmartTabLayout(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public static final /* synthetic */ ViewPager b(TaxesSmartTabLayout taxesSmartTabLayout) {
        ViewPager viewPager = taxesSmartTabLayout.r;
        if (viewPager != null) {
            return viewPager;
        }
        h.b("viewPager");
        throw null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.q.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setViewPager(ViewPager viewPager) {
        h.b(viewPager, "viewPager");
        a(viewPager);
        super.setViewPager(viewPager);
        this.r = viewPager;
    }

    public TaxesSmartTabLayout(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
        this.q = new GestureDetector(context, new h(this));
        setOnTouchListener(new i(this));
    }

    private final void a(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            h.a((Object) declaredField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, new k(viewPager, viewPager.getContext(), new LinearInterpolator()));
        } catch (Exception e2) {
            c.a((Throwable) e2);
        }
    }
}
