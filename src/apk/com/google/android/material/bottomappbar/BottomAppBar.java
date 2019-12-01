package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import b.g.i.B;
import b.i.a.c;
import c.b.a.c.k.b;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class BottomAppBar extends Toolbar implements androidx.coordinatorlayout.widget.CoordinatorLayout.a {

    /* renamed from: a reason: collision with root package name */
    private final int f6320a;

    /* renamed from: b reason: collision with root package name */
    private final b f6321b;

    /* renamed from: c reason: collision with root package name */
    private final e f6322c;

    /* renamed from: d reason: collision with root package name */
    private Animator f6323d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public Animator f6324e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public Animator f6325f;

    /* renamed from: g reason: collision with root package name */
    private int f6326g;

    /* renamed from: h reason: collision with root package name */
    private boolean f6327h;

    /* renamed from: i reason: collision with root package name */
    private boolean f6328i;

    /* renamed from: j reason: collision with root package name */
    AnimatorListenerAdapter f6329j;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d reason: collision with root package name */
        private final Rect f6330d = new Rect();

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((e) floatingActionButton.getLayoutParams()).f1224d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        /* access modifiers changed from: protected */
        public void b(BottomAppBar bottomAppBar) {
            super.b(bottomAppBar);
            FloatingActionButton a2 = bottomAppBar.b();
            if (a2 != null) {
                a2.clearAnimation();
                a2.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(c.b.a.c.a.a.f3094d).setDuration(225);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            FloatingActionButton a2 = bottomAppBar.b();
            if (a2 != null) {
                a(a2, bottomAppBar);
                a2.b(this.f6330d);
                bottomAppBar.setFabDiameter(this.f6330d.height());
            }
            if (bottomAppBar.c()) {
                coordinatorLayout.c((View) bottomAppBar, i2);
                return super.a(coordinatorLayout, bottomAppBar, i2);
            }
            BottomAppBar.c(bottomAppBar);
            throw null;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.b(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        /* access modifiers changed from: protected */
        public void a(BottomAppBar bottomAppBar) {
            super.a(bottomAppBar);
            FloatingActionButton a2 = bottomAppBar.b();
            if (a2 != null) {
                a2.a(this.f6330d);
                float measuredHeight = (float) (a2.getMeasuredHeight() - this.f6330d.height());
                a2.clearAnimation();
                a2.animate().translationY(((float) (-a2.getPaddingBottom())) + measuredHeight).setInterpolator(c.b.a.c.a.a.f3093c).setDuration(175);
            }
        }
    }

    static class a extends c {
        public static final Creator<a> CREATOR = new d();

        /* renamed from: c reason: collision with root package name */
        int f6331c;

        /* renamed from: d reason: collision with root package name */
        boolean f6332d;

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6331c);
            parcel.writeInt(this.f6332d ? 1 : 0);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6331c = parcel.readInt();
            this.f6332d = parcel.readInt() != 0;
        }
    }

    static /* synthetic */ void c(BottomAppBar bottomAppBar) {
        bottomAppBar.e();
        throw null;
    }

    private void e() {
        this.f6322c.d(getFabTranslationX());
        throw null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return (float) a(this.f6326g);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.f6328i);
    }

    public ColorStateList getBackgroundTint() {
        this.f6321b.a();
        throw null;
    }

    public CoordinatorLayout.b<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        this.f6322c.a();
        throw null;
    }

    public int getFabAlignmentMode() {
        return this.f6326g;
    }

    public float getFabCradleMargin() {
        this.f6322c.b();
        throw null;
    }

    public float getFabCradleRoundedCornerRadius() {
        this.f6322c.c();
        throw null;
    }

    public boolean getHideOnScroll() {
        return this.f6327h;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        a();
        e();
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.n());
        this.f6326g = aVar.f6331c;
        this.f6328i = aVar.f6332d;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f6331c = this.f6326g;
        aVar.f6332d = this.f6328i;
        return aVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a((Drawable) this.f6321b, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            this.f6322c.a(f2);
            throw null;
        }
    }

    public void setFabAlignmentMode(int i2) {
        b(i2);
        a(i2, this.f6328i);
        this.f6326g = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            this.f6322c.b(f2);
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            this.f6322c.c(f2);
            throw null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setFabDiameter(int i2) {
        this.f6322c.d();
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.f6327h = z;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    /* access modifiers changed from: private */
    public boolean c() {
        Animator animator = this.f6323d;
        if (animator == null || !animator.isRunning()) {
            Animator animator2 = this.f6325f;
            if (animator2 == null || !animator2.isRunning()) {
                Animator animator3 = this.f6324e;
                if (animator3 == null || !animator3.isRunning()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean d() {
        FloatingActionButton b2 = b();
        return b2 != null && b2.c();
    }

    private void b(int i2) {
        if (this.f6326g != i2 && B.C(this)) {
            Animator animator = this.f6324e;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            a(i2, (List<Animator>) arrayList);
            b(i2, (List<Animator>) arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f6324e = animatorSet;
            this.f6324e.addListener(new a(this));
            this.f6324e.start();
        }
    }

    private void a(int i2, List<Animator> list) {
        if (this.f6328i) {
            float[] fArr = new float[2];
            this.f6322c.e();
            throw null;
        }
    }

    private void a(int i2, boolean z) {
        if (B.C(this)) {
            Animator animator = this.f6325f;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!d()) {
                i2 = 0;
                z = false;
            }
            a(i2, z, (List<Animator>) arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f6325f = animatorSet;
            this.f6325f.addListener(new b(this));
            this.f6325f.start();
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton b() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).c((View) this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private void a(int i2, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            String str = "alpha";
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, str, new float[]{1.0f});
            if ((this.f6328i || (z && d())) && (this.f6326g == 1 || i2 == 1)) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, str, new float[]{0.0f});
                ofFloat2.addListener(new c(this, actionMenuView, i2, z));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    private void b(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b(), "translationX", new float[]{(float) a(i2)});
        ofFloat.setDuration(300);
        list.add(ofFloat);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.c((AnimatorListener) this.f6329j);
        floatingActionButton.d(this.f6329j);
    }

    private float a(boolean z) {
        FloatingActionButton b2 = b();
        if (b2 == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        b2.a(rect);
        float height = (float) rect.height();
        if (height == 0.0f) {
            height = (float) b2.getMeasuredHeight();
        }
        float height2 = (float) (b2.getHeight() - rect.bottom);
        float f2 = (-getCradleVerticalOffset()) + (height / 2.0f) + height2;
        float height3 = ((float) (b2.getHeight() - rect.height())) - ((float) b2.getPaddingBottom());
        float f3 = (float) (-getMeasuredHeight());
        if (z) {
            height3 = f2;
        }
        return f3 + height3;
    }

    private int a(int i2) {
        int i3 = 1;
        boolean z = B.m(this) == 1;
        if (i2 != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.f6320a;
        if (z) {
            i3 = -1;
        }
        return measuredWidth * i3;
    }

    /* access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i2, boolean z) {
        boolean z2 = B.m(this) == 1;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.b) && (((Toolbar.b) childAt.getLayoutParams()).f471a & 8388615) == 8388611) {
                i3 = Math.max(i3, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i2 != 1 || !z) ? 0.0f : (float) (i3 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft())));
    }

    private void a() {
        Animator animator = this.f6323d;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f6325f;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f6324e;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    /* access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.a((AnimatorListener) this.f6329j);
        floatingActionButton.b((AnimatorListener) this.f6329j);
    }
}
