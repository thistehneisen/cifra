package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import b.g.i.B;
import c.b.a.c.a.g;
import c.b.a.c.a.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FloatingActionButtonImpl */
class e {

    /* renamed from: a reason: collision with root package name */
    static final TimeInterpolator f6430a = c.b.a.c.a.a.f3093c;

    /* renamed from: b reason: collision with root package name */
    static final int[] f6431b = {16842919, 16842910};

    /* renamed from: c reason: collision with root package name */
    static final int[] f6432c = {16843623, 16842908, 16842910};

    /* renamed from: d reason: collision with root package name */
    static final int[] f6433d = {16842908, 16842910};

    /* renamed from: e reason: collision with root package name */
    static final int[] f6434e = {16843623, 16842910};

    /* renamed from: f reason: collision with root package name */
    static final int[] f6435f = {16842910};

    /* renamed from: g reason: collision with root package name */
    static final int[] f6436g = new int[0];
    private ArrayList<AnimatorListener> A;
    final n B;
    final c.b.a.c.j.b C;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private OnPreDrawListener H;

    /* renamed from: h reason: collision with root package name */
    int f6437h = 0;

    /* renamed from: i reason: collision with root package name */
    Animator f6438i;

    /* renamed from: j reason: collision with root package name */
    h f6439j;

    /* renamed from: k reason: collision with root package name */
    h f6440k;

    /* renamed from: l reason: collision with root package name */
    private h f6441l;
    private h m;
    private final k n;
    c.b.a.c.j.a o;
    private float p;
    Drawable q;
    Drawable r;
    com.google.android.material.internal.c s;
    Drawable t;
    float u;
    float v;
    float w;
    int x;
    float y = 1.0f;
    private ArrayList<AnimatorListener> z;

    /* compiled from: FloatingActionButtonImpl */
    private class a extends f {
        a() {
            super(e.this, null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class b extends f {
        b() {
            super(e.this, null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            e eVar = e.this;
            return eVar.u + eVar.v;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class c extends f {
        c() {
            super(e.this, null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            e eVar = e.this;
            return eVar.u + eVar.w;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    interface d {
        void a();

        void b();
    }

    /* renamed from: com.google.android.material.floatingactionbutton.e$e reason: collision with other inner class name */
    /* compiled from: FloatingActionButtonImpl */
    private class C0069e extends f {
        C0069e() {
            super(e.this, null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return e.this.u;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private abstract class f extends AnimatorListenerAdapter implements AnimatorUpdateListener {

        /* renamed from: a reason: collision with root package name */
        private boolean f6446a;

        /* renamed from: b reason: collision with root package name */
        private float f6447b;

        /* renamed from: c reason: collision with root package name */
        private float f6448c;

        private f() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            e.this.o.b(this.f6448c);
            this.f6446a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f6446a) {
                this.f6447b = e.this.o.b();
                this.f6448c = a();
                this.f6446a = true;
            }
            c.b.a.c.j.a aVar = e.this.o;
            float f2 = this.f6447b;
            aVar.b(f2 + ((this.f6448c - f2) * valueAnimator.getAnimatedFraction()));
        }

        /* synthetic */ f(e eVar, b bVar) {
            this();
        }
    }

    e(n nVar, c.b.a.c.j.b bVar) {
        this.B = nVar;
        this.C = bVar;
        this.n = new k();
        this.n.a(f6431b, a((f) new c()));
        this.n.a(f6432c, a((f) new b()));
        this.n.a(f6433d, a((f) new b()));
        this.n.a(f6434e, a((f) new b()));
        this.n.a(f6435f, a((f) new C0069e()));
        this.n.a(f6436g, a((f) new a()));
        this.p = this.B.getRotation();
    }

    private void t() {
        if (this.H == null) {
            this.H = new d(this);
        }
    }

    private h u() {
        if (this.m == null) {
            this.m = h.a(this.B.getContext(), c.b.a.c.a.design_fab_hide_motion_spec);
        }
        return this.m;
    }

    private h v() {
        if (this.f6441l == null) {
            this.f6441l = h.a(this.B.getContext(), c.b.a.c.a.design_fab_show_motion_spec);
        }
        return this.f6441l;
    }

    private boolean w() {
        return B.C(this.B) && !this.B.isInEditMode();
    }

    private void x() {
        if (VERSION.SDK_INT == 19) {
            if (this.p % 90.0f != 0.0f) {
                if (this.B.getLayerType() != 1) {
                    this.B.setLayerType(1, null);
                }
            } else if (this.B.getLayerType() != 0) {
                this.B.setLayerType(0, null);
            }
        }
        c.b.a.c.j.a aVar = this.o;
        if (aVar != null) {
            aVar.a(-this.p);
        }
        com.google.android.material.internal.c cVar = this.s;
        if (cVar != null) {
            cVar.b(-this.p);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList, Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable[] drawableArr;
        this.q = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a(this.q, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.q, mode);
        }
        this.r = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a(this.r, c.b.a.c.i.a.a(colorStateList2));
        if (i2 > 0) {
            this.s = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.s, this.q, this.r};
        } else {
            this.s = null;
            drawableArr = new Drawable[]{this.q, this.r};
        }
        this.t = new LayerDrawable(drawableArr);
        Context context = this.B.getContext();
        Drawable drawable = this.t;
        float b2 = this.C.b();
        float f2 = this.u;
        c.b.a.c.j.a aVar = new c.b.a.c.j.a(context, drawable, b2, f2, f2 + this.w);
        this.o = aVar;
        this.o.a(false);
        this.C.a(this.o);
    }

    /* access modifiers changed from: 0000 */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, c.b.a.c.i.a.a(colorStateList));
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(Rect rect) {
    }

    /* access modifiers changed from: 0000 */
    public float c() {
        return this.u;
    }

    /* access modifiers changed from: 0000 */
    public final void d(float f2) {
        if (this.w != f2) {
            this.w = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* access modifiers changed from: 0000 */
    public float e() {
        return this.v;
    }

    /* access modifiers changed from: 0000 */
    public float f() {
        return this.w;
    }

    /* access modifiers changed from: 0000 */
    public final h g() {
        return this.f6439j;
    }

    /* access modifiers changed from: 0000 */
    public boolean h() {
        boolean z2 = false;
        if (this.B.getVisibility() == 0) {
            if (this.f6437h == 1) {
                z2 = true;
            }
            return z2;
        }
        if (this.f6437h != 2) {
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    public boolean i() {
        boolean z2 = false;
        if (this.B.getVisibility() != 0) {
            if (this.f6437h == 2) {
                z2 = true;
            }
            return z2;
        }
        if (this.f6437h != 1) {
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    public void j() {
        this.n.a();
    }

    /* access modifiers changed from: 0000 */
    public com.google.android.material.internal.c k() {
        return new com.google.android.material.internal.c();
    }

    /* access modifiers changed from: 0000 */
    public GradientDrawable l() {
        return new GradientDrawable();
    }

    /* access modifiers changed from: 0000 */
    public void m() {
        if (q()) {
            t();
            this.B.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    /* access modifiers changed from: 0000 */
    public void n() {
    }

    /* access modifiers changed from: 0000 */
    public void o() {
        if (this.H != null) {
            this.B.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void p() {
        float rotation = this.B.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            x();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean q() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final void r() {
        c(this.y);
    }

    /* access modifiers changed from: 0000 */
    public final void s() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.C.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: 0000 */
    public final void c(float f2) {
        this.y = f2;
        Matrix matrix = this.G;
        a(f2, matrix);
        this.B.setImageMatrix(matrix);
    }

    /* access modifiers changed from: 0000 */
    public final void b(float f2) {
        if (this.v != f2) {
            this.v = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* access modifiers changed from: 0000 */
    public final h d() {
        return this.f6440k;
    }

    /* access modifiers changed from: 0000 */
    public void d(AnimatorListener animatorListener) {
        ArrayList<AnimatorListener> arrayList = this.z;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    public void c(AnimatorListener animatorListener) {
        ArrayList<AnimatorListener> arrayList = this.A;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(h hVar) {
        this.f6439j = hVar;
    }

    /* access modifiers changed from: 0000 */
    public void b(AnimatorListener animatorListener) {
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        this.z.add(animatorListener);
    }

    /* access modifiers changed from: 0000 */
    public void b(d dVar, boolean z2) {
        if (!i()) {
            Animator animator = this.f6438i;
            if (animator != null) {
                animator.cancel();
            }
            if (w()) {
                if (this.B.getVisibility() != 0) {
                    this.B.setAlpha(0.0f);
                    this.B.setScaleY(0.0f);
                    this.B.setScaleX(0.0f);
                    c(0.0f);
                }
                h hVar = this.f6439j;
                if (hVar == null) {
                    hVar = v();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new c(this, z2, dVar));
                ArrayList<AnimatorListener> arrayList = this.z;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener((AnimatorListener) it.next());
                    }
                }
                a2.start();
            } else {
                this.B.a(0, z2);
                this.B.setAlpha(1.0f);
                this.B.setScaleY(1.0f);
                this.B.setScaleX(1.0f);
                c(1.0f);
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        com.google.android.material.internal.c cVar = this.s;
        if (cVar != null) {
            cVar.a(colorStateList);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Mode mode) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(float f2) {
        if (this.u != f2) {
            this.u = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(int i2) {
        if (this.x != i2) {
            this.x = i2;
            r();
        }
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.B.getDrawable();
        if (drawable != null && this.x != 0) {
            RectF rectF = this.E;
            RectF rectF2 = this.F;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.x;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
            int i3 = this.x;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    /* access modifiers changed from: 0000 */
    public final Drawable b() {
        return this.t;
    }

    /* access modifiers changed from: 0000 */
    public final void a(h hVar) {
        this.f6440k = hVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2, float f3, float f4) {
        c.b.a.c.j.a aVar = this.o;
        if (aVar != null) {
            aVar.a(f2, this.w + f2);
            s();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(int[] iArr) {
        this.n.a(iArr);
    }

    public void a(AnimatorListener animatorListener) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(animatorListener);
    }

    /* access modifiers changed from: 0000 */
    public void a(d dVar, boolean z2) {
        if (!h()) {
            Animator animator = this.f6438i;
            if (animator != null) {
                animator.cancel();
            }
            if (w()) {
                h hVar = this.f6440k;
                if (hVar == null) {
                    hVar = u();
                }
                AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new b(this, z2, dVar));
                ArrayList<AnimatorListener> arrayList = this.A;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener((AnimatorListener) it.next());
                    }
                }
                a2.start();
            } else {
                this.B.a(z2 ? 8 : 4, z2);
                if (dVar != null) {
                    dVar.b();
                }
            }
        }
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.B, View.ALPHA, new float[]{f2});
        hVar.a("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.B, View.SCALE_X, new float[]{f3});
        String str = "scale";
        hVar.a(str).a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.B, View.SCALE_Y, new float[]{f3});
        hVar.a(str).a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.B, new c.b.a.c.a.f(), new g(), new Matrix[]{new Matrix(this.G)});
        hVar.a("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        c.b.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: 0000 */
    public void a(Rect rect) {
        this.o.getPadding(rect);
    }

    /* access modifiers changed from: 0000 */
    public com.google.android.material.internal.c a(int i2, ColorStateList colorStateList) {
        Context context = this.B.getContext();
        com.google.android.material.internal.c k2 = k();
        k2.a(b.g.a.a.a(context, c.b.a.c.c.design_fab_stroke_top_outer_color), b.g.a.a.a(context, c.b.a.c.c.design_fab_stroke_top_inner_color), b.g.a.a.a(context, c.b.a.c.c.design_fab_stroke_end_inner_color), b.g.a.a.a(context, c.b.a.c.c.design_fab_stroke_end_outer_color));
        k2.a((float) i2);
        k2.a(colorStateList);
        return k2;
    }

    /* access modifiers changed from: 0000 */
    public GradientDrawable a() {
        GradientDrawable l2 = l();
        l2.setShape(1);
        l2.setColor(-1);
        return l2;
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f6430a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }
}
