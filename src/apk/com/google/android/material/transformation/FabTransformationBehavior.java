package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.g.i.B;
import c.b.a.c.a.b;
import c.b.a.c.a.e;
import c.b.a.c.a.h;
import c.b.a.c.a.i;
import c.b.a.c.a.j;
import c.b.a.c.d.f;
import c.b.a.c.d.f.c;
import c.b.a.c.d.f.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c reason: collision with root package name */
    private final Rect f6603c = new Rect();

    /* renamed from: d reason: collision with root package name */
    private final RectF f6604d = new RectF();

    /* renamed from: e reason: collision with root package name */
    private final RectF f6605e = new RectF();

    /* renamed from: f reason: collision with root package name */
    private final int[] f6606f = new int[2];

    protected static class a {

        /* renamed from: a reason: collision with root package name */
        public h f6607a;

        /* renamed from: b reason: collision with root package name */
        public j f6608b;

        protected a() {
        }
    }

    public FabTransformationBehavior() {
    }

    @TargetApi(21)
    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float i2 = B.i(view2) - B.i(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-i2);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-i2});
        }
        aVar.f6607a.a("elevation").a((Animator) objectAnimator);
        list.add(objectAnimator);
    }

    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof f) && (view instanceof ImageView)) {
            f fVar = (f) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f3098a, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f3098a, new int[]{255});
                }
                objectAnimator.addUpdateListener(new d(this, view2));
                aVar.f6607a.a("iconFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
                list2.add(new e(this, fVar, drawable));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract a a(Context context, boolean z);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        boolean z3 = z;
        a a2 = a(view2.getContext(), z3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.f6604d;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z;
        boolean z5 = z2;
        a aVar = a2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        a(view3, view4, z4, z5, aVar, (List<Animator>) arrayList3, (List<AnimatorListener>) arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        d(view3, view4, z4, z5, aVar, arrayList3, arrayList4);
        a(view3, view4, z4, z5, aVar, width, height, (List<Animator>) arrayList, (List<AnimatorListener>) arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        b(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        a(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new c(this, z3, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener((AnimatorListener) arrayList2.get(i2));
        }
        return animatorSet;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(CoordinatorLayout.e eVar) {
        if (eVar.f1228h == 0) {
            eVar.f1228h = 80;
        }
    }

    private float c(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f6604d;
        RectF rectF2 = this.f6605e;
        a(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f3110a & 7;
        if (i2 == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i2 == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i2 != 5) {
            f2 = 0.0f;
            return f2 + jVar.f3111b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f3111b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092  */
    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<AnimatorListener> list2, RectF rectF) {
        i iVar;
        i iVar2;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        List<Animator> list3 = list;
        float c2 = c(view3, view4, aVar2.f6608b);
        float d2 = d(view3, view4, aVar2.f6608b);
        if (c2 != 0.0f) {
            int i2 = (d2 > 0.0f ? 1 : (d2 == 0.0f ? 0 : -1));
            if (i2 != 0) {
                if ((!z || d2 >= 0.0f) && (z || i2 <= 0)) {
                    iVar2 = aVar2.f6607a.a("translationXCurveDownwards");
                    iVar = aVar2.f6607a.a("translationYCurveDownwards");
                } else {
                    iVar2 = aVar2.f6607a.a("translationXCurveUpwards");
                    iVar = aVar2.f6607a.a("translationYCurveUpwards");
                }
                i iVar3 = iVar2;
                i iVar4 = iVar;
                if (!z) {
                    if (!z2) {
                        view4.setTranslationX(-c2);
                        view4.setTranslationY(-d2);
                    }
                    objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
                    objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
                    a(view2, aVar, iVar3, iVar4, -c2, -d2, 0.0f, 0.0f, rectF);
                } else {
                    objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-c2});
                    objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-d2});
                }
                iVar3.a((Animator) objectAnimator2);
                iVar4.a((Animator) objectAnimator);
                list3.add(objectAnimator2);
                list3.add(objectAnimator);
            }
        }
        iVar2 = aVar2.f6607a.a("translationXLinear");
        iVar = aVar2.f6607a.a("translationYLinear");
        i iVar32 = iVar2;
        i iVar42 = iVar;
        if (!z) {
        }
        iVar32.a((Animator) objectAnimator2);
        iVar42.a((Animator) objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private float d(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f6604d;
        RectF rectF2 = this.f6605e;
        a(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f3110a & 112;
        if (i2 == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i2 == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i2 != 80) {
            f2 = 0.0f;
            return f2 + jVar.f3112c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.f3112c;
    }

    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void b(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof f) {
            f fVar = (f) view2;
            int b2 = b(view);
            int i2 = 16777215 & b2;
            if (z) {
                if (!z2) {
                    fVar.setCircularRevealScrimColor(b2);
                }
                objectAnimator = ObjectAnimator.ofInt(fVar, c.f3140a, new int[]{i2});
            } else {
                objectAnimator = ObjectAnimator.ofInt(fVar, c.f3140a, new int[]{b2});
            }
            objectAnimator.setEvaluator(c.b.a.c.a.c.a());
            aVar.f6607a.a("color").a((Animator) objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f2, float f3, List<Animator> list, List<AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        if (view4 instanceof f) {
            f fVar = (f) view4;
            float a2 = a(view3, view4, aVar2.f6608b);
            float b2 = b(view3, view4, aVar2.f6608b);
            ((FloatingActionButton) view3).a(this.f6603c);
            float width = ((float) this.f6603c.width()) / 2.0f;
            i a3 = aVar2.f6607a.a("expansion");
            if (z) {
                if (!z2) {
                    fVar.setRevealInfo(new d(a2, b2, width));
                }
                if (z2) {
                    width = fVar.getRevealInfo().f3143c;
                }
                animator = c.b.a.c.d.b.a(fVar, a2, b2, c.b.a.c.g.a.a(a2, b2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new f(this, fVar));
                a(view2, a3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f4 = fVar.getRevealInfo().f3143c;
                Animator a4 = c.b.a.c.d.b.a(fVar, a2, b2, width);
                int i2 = (int) a2;
                int i3 = (int) b2;
                View view5 = view2;
                int i4 = i2;
                a(view5, a3.a(), i2, i3, f4, list);
                a(view5, a3.a(), a3.b(), aVar2.f6607a.a(), i4, i3, width, list);
                animator = a4;
            }
            a3.a(animator);
            list.add(animator);
            list2.add(c.b.a.c.d.b.a(fVar));
        }
    }

    private float b(View view, View view2, j jVar) {
        RectF rectF = this.f6604d;
        RectF rectF2 = this.f6605e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(View view) {
        ColorStateList e2 = B.e(view);
        if (e2 != null) {
            return e2.getColorForState(view.getDrawableState(), e2.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if (!(view2 instanceof f) || c.b.a.c.d.d.f3136a != 0) {
                ViewGroup a2 = a(view2);
                if (a2 != null) {
                    if (z) {
                        if (!z2) {
                            c.b.a.c.a.d.f3097a.set(a2, Float.valueOf(0.0f));
                        }
                        objectAnimator = ObjectAnimator.ofFloat(a2, c.b.a.c.a.d.f3097a, new float[]{1.0f});
                    } else {
                        objectAnimator = ObjectAnimator.ofFloat(a2, c.b.a.c.a.d.f3097a, new float[]{0.0f});
                    }
                    aVar.f6607a.a("contentFade").a((Animator) objectAnimator);
                    list.add(objectAnimator);
                }
            }
        }
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f6606f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private float a(View view, View view2, j jVar) {
        RectF rectF = this.f6604d;
        RectF rectF2 = this.f6605e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(aVar, iVar, f2, f4);
        float a3 = a(aVar, iVar2, f3, f5);
        Rect rect = this.f6603c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f6604d;
        rectF2.set(rect);
        RectF rectF3 = this.f6605e;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i a3 = aVar.f6607a.a("expansion");
        return c.b.a.c.a.a.a(f2, f3, iVar.c().getInterpolation(((float) (((a3.a() + a3.b()) + 17) - a2)) / ((float) b2)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(c.b.a.c.f.mtrl_child_content_container);
        if (findViewById != null) {
            return c(findViewById);
        }
        if ((view instanceof i) || (view instanceof h)) {
            return c(((ViewGroup) view).getChildAt(0));
        }
        return c(view);
    }

    private void a(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
        if (VERSION.SDK_INT >= 21 && j2 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j2);
            list.add(createCircularReveal);
        }
    }

    private void a(View view, long j2, long j3, long j4, int i2, int i3, float f2, List<Animator> list) {
        if (VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }
}
