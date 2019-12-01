package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;

public class ActionMenuView extends O implements androidx.appcompat.view.menu.l.b, w {
    e A;
    private l p;
    private Context q;
    private int r;
    private boolean s;
    private C0165g t;
    private androidx.appcompat.view.menu.v.a u;
    androidx.appcompat.view.menu.l.a v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public interface a {
        boolean b();

        boolean c();
    }

    private static class b implements androidx.appcompat.view.menu.v.a {
        b() {
        }

        public void a(l lVar, boolean z) {
        }

        public boolean a(l lVar) {
            return false;
        }
    }

    public static class c extends androidx.appcompat.widget.O.a {
        @ExportedProperty

        /* renamed from: c reason: collision with root package name */
        public boolean f726c;
        @ExportedProperty

        /* renamed from: d reason: collision with root package name */
        public int f727d;
        @ExportedProperty

        /* renamed from: e reason: collision with root package name */
        public int f728e;
        @ExportedProperty

        /* renamed from: f reason: collision with root package name */
        public boolean f729f;
        @ExportedProperty

        /* renamed from: g reason: collision with root package name */
        public boolean f730g;

        /* renamed from: h reason: collision with root package name */
        boolean f731h;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f726c = cVar.f726c;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f726c = false;
        }
    }

    private class d implements androidx.appcompat.view.menu.l.a {
        d() {
        }

        public boolean a(l lVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.A;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        public void a(l lVar) {
            androidx.appcompat.view.menu.l.a aVar = ActionMenuView.this.v;
            if (aVar != null) {
                aVar.a(lVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    static int a(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i4) - i5, MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = true;
        boolean z3 = actionMenuItemView != null && actionMenuItemView.d();
        int i6 = 2;
        if (i3 <= 0 || (z3 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z3 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (cVar.f726c || !z3) {
            z2 = false;
        }
        cVar.f729f = z2;
        cVar.f727d = i6;
        view.measure(MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x023b A[LOOP:5: B:134:0x023b->B:138:0x025a, LOOP_START, PHI: r13 
      PHI: (r13v3 int) = (r13v2 int), (r13v4 int) binds: [B:133:0x0239, B:138:0x025a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0262  */
    private void e(int i2, int i3) {
        int i4;
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z4;
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i11 = size - paddingLeft;
        int i12 = this.y;
        int i13 = i11 / i12;
        int i14 = i11 % i12;
        if (i13 == 0) {
            setMeasuredDimension(i11, 0);
            return;
        }
        int i15 = i12 + (i14 / i13);
        int childCount = getChildCount();
        int i16 = i13;
        int i17 = 0;
        int i18 = 0;
        boolean z5 = false;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        long j2 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            int i22 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i23 = i19 + 1;
                if (z6) {
                    int i24 = this.z;
                    i10 = i23;
                    z4 = false;
                    childAt.setPadding(i24, 0, i24, 0);
                } else {
                    i10 = i23;
                    z4 = false;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f731h = z4;
                cVar.f728e = z4 ? 1 : 0;
                cVar.f727d = z4;
                cVar.f729f = z4;
                cVar.leftMargin = z4;
                cVar.rightMargin = z4;
                cVar.f730g = z6 && ((ActionMenuItemView) childAt).d();
                int a2 = a(childAt, i15, cVar.f726c ? 1 : i16, childMeasureSpec, paddingTop);
                int max = Math.max(i20, a2);
                if (cVar.f729f) {
                    i21++;
                }
                if (cVar.f726c) {
                    z5 = true;
                }
                i16 -= a2;
                i18 = Math.max(i18, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    j2 |= (long) (1 << i17);
                    i18 = i18;
                } else {
                    int i25 = i18;
                }
                i20 = max;
                i19 = i10;
            }
            i17++;
            size2 = i22;
        }
        int i26 = size2;
        boolean z7 = z5 && i19 == 2;
        boolean z8 = false;
        while (true) {
            if (i21 <= 0 || i16 <= 0) {
                i6 = mode;
                i4 = i11;
                z2 = z8;
                i5 = i18;
            } else {
                int i27 = Integer.MAX_VALUE;
                int i28 = 0;
                int i29 = 0;
                long j3 = 0;
                while (i28 < childCount) {
                    boolean z9 = z8;
                    c cVar2 = (c) getChildAt(i28).getLayoutParams();
                    int i30 = i18;
                    if (cVar2.f729f) {
                        int i31 = cVar2.f727d;
                        if (i31 < i27) {
                            i27 = i31;
                            j3 = 1 << i28;
                            i29 = 1;
                        } else if (i31 == i27) {
                            j3 |= 1 << i28;
                            i29++;
                        }
                    }
                    i28++;
                    i18 = i30;
                    z8 = z9;
                }
                z2 = z8;
                i5 = i18;
                j2 |= j3;
                if (i29 > i16) {
                    i6 = mode;
                    i4 = i11;
                    break;
                }
                int i32 = i27 + 1;
                int i33 = 0;
                while (i33 < childCount) {
                    View childAt2 = getChildAt(i33);
                    c cVar3 = (c) childAt2.getLayoutParams();
                    int i34 = i11;
                    int i35 = mode;
                    long j4 = (long) (1 << i33);
                    if ((j3 & j4) == 0) {
                        if (cVar3.f727d == i32) {
                            j2 |= j4;
                        }
                        i9 = i32;
                    } else {
                        if (!z7 || !cVar3.f730g || i16 != 1) {
                            i9 = i32;
                        } else {
                            int i36 = this.z;
                            i9 = i32;
                            childAt2.setPadding(i36 + i15, 0, i36, 0);
                        }
                        cVar3.f727d++;
                        cVar3.f731h = true;
                        i16--;
                    }
                    i33++;
                    mode = i35;
                    i32 = i9;
                    i11 = i34;
                }
                i18 = i5;
                z8 = true;
            }
        }
        if (!z5) {
            i7 = 1;
            if (i19 == 1) {
                z3 = true;
                if (i16 > 0 || j2 == 0 || (i16 >= i19 - i7 && !z3 && i20 <= i7)) {
                    i8 = 0;
                } else {
                    float bitCount = (float) Long.bitCount(j2);
                    if (!z3) {
                        if ((j2 & 1) != 0) {
                            i8 = 0;
                            if (!((c) getChildAt(0).getLayoutParams()).f730g) {
                                bitCount -= 0.5f;
                            }
                        } else {
                            i8 = 0;
                        }
                        int i37 = childCount - 1;
                        if ((j2 & ((long) (1 << i37))) != 0 && !((c) getChildAt(i37).getLayoutParams()).f730g) {
                            bitCount -= 0.5f;
                        }
                    } else {
                        i8 = 0;
                    }
                    int i38 = bitCount > 0.0f ? (int) (((float) (i16 * i15)) / bitCount) : 0;
                    for (int i39 = 0; i39 < childCount; i39++) {
                        if ((j2 & ((long) (1 << i39))) != 0) {
                            View childAt3 = getChildAt(i39);
                            c cVar4 = (c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                cVar4.f728e = i38;
                                cVar4.f731h = true;
                                if (i39 == 0 && !cVar4.f730g) {
                                    cVar4.leftMargin = (-i38) / 2;
                                }
                            } else if (cVar4.f726c) {
                                cVar4.f728e = i38;
                                cVar4.f731h = true;
                                cVar4.rightMargin = (-i38) / 2;
                            } else {
                                if (i39 != 0) {
                                    cVar4.leftMargin = i38 / 2;
                                }
                                if (i39 != childCount - 1) {
                                    cVar4.rightMargin = i38 / 2;
                                }
                            }
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    while (i8 < childCount) {
                        View childAt4 = getChildAt(i8);
                        c cVar5 = (c) childAt4.getLayoutParams();
                        if (cVar5.f731h) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec((cVar5.f727d * i15) + cVar5.f728e, 1073741824), childMeasureSpec);
                        }
                        i8++;
                    }
                }
                setMeasuredDimension(i4, i6 == 1073741824 ? i5 : i26);
            }
        } else {
            i7 = 1;
        }
        z3 = false;
        if (i16 > 0) {
        }
        i8 = 0;
        if (z2) {
        }
        setMeasuredDimension(i4, i6 == 1073741824 ? i5 : i26);
    }

    public void b() {
        C0165g gVar = this.t;
        if (gVar != null) {
            gVar.c();
        }
    }

    public c c() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f726c = true;
        return generateDefaultLayoutParams;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public boolean d() {
        C0165g gVar = this.t;
        return gVar != null && gVar.e();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean f() {
        C0165g gVar = this.t;
        return gVar != null && gVar.h();
    }

    public boolean g() {
        return this.s;
    }

    public Menu getMenu() {
        if (this.p == null) {
            Context context = getContext();
            this.p = new l(context);
            this.p.a((androidx.appcompat.view.menu.l.a) new d());
            this.t = new C0165g(context);
            this.t.c(true);
            C0165g gVar = this.t;
            androidx.appcompat.view.menu.v.a aVar = this.u;
            if (aVar == null) {
                aVar = new b();
            }
            gVar.a(aVar);
            this.p.a((v) this.t, this.q);
            this.t.a(this);
        }
        return this.p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.t.d();
    }

    public int getPopupTheme() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public l h() {
        return this.p;
    }

    public boolean i() {
        C0165g gVar = this.t;
        return gVar != null && gVar.i();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0165g gVar = this.t;
        if (gVar != null) {
            gVar.a(false);
            if (this.t.h()) {
                this.t.e();
                this.t.i();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (!this.w) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = i4 - i2;
        int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = Ga.a(this);
        int i12 = paddingRight;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f726c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (d(i15)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i8 = getPaddingLeft() + cVar.leftMargin;
                        i9 = i8 + measuredWidth;
                    } else {
                        i9 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i8 = i9 - measuredWidth;
                    }
                    int i16 = i10 - (measuredHeight / 2);
                    childAt.layout(i8, i16, i9, measuredHeight + i16);
                    i12 -= measuredWidth;
                    i13 = 1;
                } else {
                    i12 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    boolean d2 = d(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i11 / 2) - (measuredWidth2 / 2);
            int i18 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        if (i19 > 0) {
            i6 = i12 / i19;
            i7 = 0;
        } else {
            i7 = 0;
            i6 = 0;
        }
        int max = Math.max(i7, i6);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            while (i7 < childCount) {
                View childAt3 = getChildAt(i7);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f726c) {
                    int i20 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i21 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i20 - measuredWidth3, i21, i20, measuredHeight3 + i21);
                    width = i20 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i7++;
            }
        } else {
            int paddingLeft = getPaddingLeft();
            while (i7 < childCount) {
                View childAt4 = getChildAt(i7);
                c cVar3 = (c) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !cVar3.f726c) {
                    int i22 = paddingLeft + cVar3.leftMargin;
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i23 = i10 - (measuredHeight4 / 2);
                    childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                    paddingLeft = i22 + measuredWidth4 + cVar3.rightMargin + max;
                }
                i7++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2 = this.w;
        this.w = MeasureSpec.getMode(i2) == 1073741824;
        if (z2 != this.w) {
            this.x = 0;
        }
        int size = MeasureSpec.getSize(i2);
        if (this.w) {
            l lVar = this.p;
            if (!(lVar == null || size == this.x)) {
                this.x = size;
                lVar.b(true);
            }
        }
        int childCount = getChildCount();
        if (!this.w || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        e(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.t.b(z2);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.t.a(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.s = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.r != i2) {
            this.r = i2;
            if (i2 == 0) {
                this.q = getContext();
            } else {
                this.q = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(C0165g gVar) {
        this.t = gVar;
        this.t.a(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.y = (int) (56.0f * f2);
        this.z = (int) (f2 * 4.0f);
        this.q = context;
        this.r = 0;
    }

    /* access modifiers changed from: protected */
    public boolean d(int i2) {
        boolean z2 = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z2 = false | ((a) childAt).b();
        }
        if (i2 > 0 && (childAt2 instanceof a)) {
            z2 |= ((a) childAt2).c();
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.f851b = 16;
        return cVar;
    }

    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public c generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.f851b <= 0) {
            cVar.f851b = 16;
        }
        return cVar;
    }

    public boolean a(p pVar) {
        return this.p.a((MenuItem) pVar, 0);
    }

    public void a(l lVar) {
        this.p = lVar;
    }

    public void a(androidx.appcompat.view.menu.v.a aVar, androidx.appcompat.view.menu.l.a aVar2) {
        this.u = aVar;
        this.v = aVar2;
    }

    public boolean e() {
        C0165g gVar = this.t;
        return gVar != null && gVar.g();
    }
}
