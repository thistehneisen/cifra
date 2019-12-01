package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import b.g.i.B;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements a {

    /* renamed from: a reason: collision with root package name */
    private int f4414a;

    /* renamed from: b reason: collision with root package name */
    private int f4415b;

    /* renamed from: c reason: collision with root package name */
    private int f4416c;

    /* renamed from: d reason: collision with root package name */
    private int f4417d;

    /* renamed from: e reason: collision with root package name */
    private int f4418e;

    /* renamed from: f reason: collision with root package name */
    private int f4419f;

    /* renamed from: g reason: collision with root package name */
    private Drawable f4420g;

    /* renamed from: h reason: collision with root package name */
    private Drawable f4421h;

    /* renamed from: i reason: collision with root package name */
    private int f4422i;

    /* renamed from: j reason: collision with root package name */
    private int f4423j;

    /* renamed from: k reason: collision with root package name */
    private int f4424k;

    /* renamed from: l reason: collision with root package name */
    private int f4425l;
    private int[] m;
    private SparseIntArray n;
    private e o;
    private List<c> p;
    private a q;

    public static class a extends MarginLayoutParams implements b {
        public static final Creator<a> CREATOR = new f();

        /* renamed from: a reason: collision with root package name */
        private int f4426a = 1;

        /* renamed from: b reason: collision with root package name */
        private float f4427b = 0.0f;

        /* renamed from: c reason: collision with root package name */
        private float f4428c = 1.0f;

        /* renamed from: d reason: collision with root package name */
        private int f4429d = -1;

        /* renamed from: e reason: collision with root package name */
        private float f4430e = -1.0f;

        /* renamed from: f reason: collision with root package name */
        private int f4431f;

        /* renamed from: g reason: collision with root package name */
        private int f4432g;

        /* renamed from: h reason: collision with root package name */
        private int f4433h = 16777215;

        /* renamed from: i reason: collision with root package name */
        private int f4434i = 16777215;

        /* renamed from: j reason: collision with root package name */
        private boolean f4435j;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.FlexboxLayout_Layout);
            this.f4426a = obtainStyledAttributes.getInt(j.FlexboxLayout_Layout_layout_order, 1);
            this.f4427b = obtainStyledAttributes.getFloat(j.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f4428c = obtainStyledAttributes.getFloat(j.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f4429d = obtainStyledAttributes.getInt(j.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f4430e = obtainStyledAttributes.getFraction(j.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f4431f = obtainStyledAttributes.getDimensionPixelSize(j.FlexboxLayout_Layout_layout_minWidth, 0);
            this.f4432g = obtainStyledAttributes.getDimensionPixelSize(j.FlexboxLayout_Layout_layout_minHeight, 0);
            this.f4433h = obtainStyledAttributes.getDimensionPixelSize(j.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.f4434i = obtainStyledAttributes.getDimensionPixelSize(j.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.f4435j = obtainStyledAttributes.getBoolean(j.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f4429d;
        }

        public float b() {
            return this.f4428c;
        }

        public int c() {
            return this.f4431f;
        }

        public int d() {
            return this.bottomMargin;
        }

        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.leftMargin;
        }

        public int f() {
            return this.topMargin;
        }

        public float g() {
            return this.f4427b;
        }

        public int getHeight() {
            return this.height;
        }

        public int getOrder() {
            return this.f4426a;
        }

        public int getWidth() {
            return this.width;
        }

        public float h() {
            return this.f4430e;
        }

        public int i() {
            return this.rightMargin;
        }

        public int j() {
            return this.f4432g;
        }

        public boolean k() {
            return this.f4435j;
        }

        public int l() {
            return this.f4434i;
        }

        public int m() {
            return this.f4433h;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4426a);
            parcel.writeFloat(this.f4427b);
            parcel.writeFloat(this.f4428c);
            parcel.writeInt(this.f4429d);
            parcel.writeFloat(this.f4430e);
            parcel.writeInt(this.f4431f);
            parcel.writeInt(this.f4432g);
            parcel.writeInt(this.f4433h);
            parcel.writeInt(this.f4434i);
            parcel.writeByte(this.f4435j ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        public a(a aVar) {
            super(aVar);
            this.f4426a = aVar.f4426a;
            this.f4427b = aVar.f4427b;
            this.f4428c = aVar.f4428c;
            this.f4429d = aVar.f4429d;
            this.f4430e = aVar.f4430e;
            this.f4431f = aVar.f4431f;
            this.f4432g = aVar.f4432g;
            this.f4433h = aVar.f4433h;
            this.f4434i = aVar.f4434i;
            this.f4435j = aVar.f4435j;
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        protected a(Parcel parcel) {
            boolean z = false;
            super(0, 0);
            this.f4426a = parcel.readInt();
            this.f4427b = parcel.readFloat();
            this.f4428c = parcel.readFloat();
            this.f4429d = parcel.readInt();
            this.f4430e = parcel.readFloat();
            this.f4431f = parcel.readInt();
            this.f4432g = parcel.readInt();
            this.f4433h = parcel.readInt();
            this.f4434i = parcel.readInt();
            if (parcel.readByte() != 0) {
                z = true;
            }
            this.f4435j = z;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private void d(int i2, int i3) {
        this.p.clear();
        this.q.a();
        this.o.b(this.q, i2, i3);
        this.p = this.q.f4481a;
        this.o.a(i2, i3);
        this.o.a(i2, i3, getPaddingLeft() + getPaddingRight());
        this.o.a();
        a(this.f4414a, i2, i3, this.q.f4482b);
    }

    private boolean e(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 < this.p.size()) {
            if (d(i2)) {
                if (a()) {
                    if ((this.f4422i & 1) != 0) {
                        z = true;
                    }
                    return z;
                }
                if ((this.f4423j & 1) != 0) {
                    z = true;
                }
                return z;
            } else if (a()) {
                if ((this.f4422i & 2) != 0) {
                    z = true;
                }
                return z;
            } else if ((this.f4423j & 2) != 0) {
                z = true;
            }
        }
        return z;
    }

    private boolean f(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 < this.p.size()) {
            for (int i3 = i2 + 1; i3 < this.p.size(); i3++) {
                if (((c) this.p.get(i3)).c() > 0) {
                    return false;
                }
            }
            if (a()) {
                if ((this.f4422i & 4) != 0) {
                    z = true;
                }
                return z;
            } else if ((this.f4423j & 4) != 0) {
                z = true;
            }
        }
        return z;
    }

    public int a(View view) {
        return 0;
    }

    public View a(int i2) {
        return c(i2);
    }

    public void a(int i2, View view) {
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        this.m = this.o.a(view, i2, layoutParams, this.n);
        super.addView(view, i2, layoutParams);
    }

    public View b(int i2) {
        return getChildAt(i2);
    }

    public View c(int i2) {
        if (i2 >= 0) {
            int[] iArr = this.m;
            if (i2 < iArr.length) {
                return getChildAt(iArr[i2]);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public int getAlignContent() {
        return this.f4418e;
    }

    public int getAlignItems() {
        return this.f4417d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f4420g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f4421h;
    }

    public int getFlexDirection() {
        return this.f4414a;
    }

    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<c> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.p.size());
        for (c cVar : this.p) {
            if (cVar.c() != 0) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public List<c> getFlexLinesInternal() {
        return this.p;
    }

    public int getFlexWrap() {
        return this.f4415b;
    }

    public int getJustifyContent() {
        return this.f4416c;
    }

    public int getLargestMainSize() {
        int i2 = Integer.MIN_VALUE;
        for (c cVar : this.p) {
            i2 = Math.max(i2, cVar.f4468e);
        }
        return i2;
    }

    public int getMaxLine() {
        return this.f4419f;
    }

    public int getShowDividerHorizontal() {
        return this.f4422i;
    }

    public int getShowDividerVertical() {
        return this.f4423j;
    }

    public int getSumOfCrossSize() {
        int i2;
        int i3;
        int size = this.p.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            c cVar = (c) this.p.get(i5);
            if (e(i5)) {
                if (a()) {
                    i3 = this.f4424k;
                } else {
                    i3 = this.f4425l;
                }
                i4 += i3;
            }
            if (f(i5)) {
                if (a()) {
                    i2 = this.f4424k;
                } else {
                    i2 = this.f4425l;
                }
                i4 += i2;
            }
            i4 += cVar.f4470g;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4421h != null || this.f4420g != null) {
            if (this.f4422i != 0 || this.f4423j != 0) {
                int m2 = B.m(this);
                int i2 = this.f4414a;
                boolean z = false;
                boolean z2 = true;
                if (i2 == 0) {
                    boolean z3 = m2 == 1;
                    if (this.f4415b == 2) {
                        z = true;
                    }
                    a(canvas, z3, z);
                } else if (i2 == 1) {
                    boolean z4 = m2 != 1;
                    if (this.f4415b == 2) {
                        z = true;
                    }
                    a(canvas, z4, z);
                } else if (i2 == 2) {
                    if (m2 != 1) {
                        z2 = false;
                    }
                    if (this.f4415b == 2) {
                        z2 = !z2;
                    }
                    b(canvas, z2, false);
                } else if (i2 == 3) {
                    if (m2 == 1) {
                        z = true;
                    }
                    if (this.f4415b == 2) {
                        z = !z;
                    }
                    b(canvas, z, true);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int m2 = B.m(this);
        int i6 = this.f4414a;
        boolean z2 = false;
        if (i6 == 0) {
            a(m2 == 1, i2, i3, i4, i5);
        } else if (i6 == 1) {
            a(m2 != 1, i2, i3, i4, i5);
        } else if (i6 == 2) {
            if (m2 == 1) {
                z2 = true;
            }
            a(this.f4415b == 2 ? !z2 : z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            if (m2 == 1) {
                z2 = true;
            }
            a(this.f4415b == 2 ? !z2 : z2, true, i2, i3, i4, i5);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid flex direction is set: ");
            sb.append(this.f4414a);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        if (this.o.b(this.n)) {
            this.m = this.o.a(this.n);
        }
        int i4 = this.f4414a;
        if (i4 == 0 || i4 == 1) {
            c(i2, i3);
        } else if (i4 == 2 || i4 == 3) {
            d(i2, i3);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid value for the flex direction is set: ");
            sb.append(this.f4414a);
            throw new IllegalStateException(sb.toString());
        }
    }

    public void setAlignContent(int i2) {
        if (this.f4418e != i2) {
            this.f4418e = i2;
            requestLayout();
        }
    }

    public void setAlignItems(int i2) {
        if (this.f4417d != i2) {
            this.f4417d = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable != this.f4420g) {
            this.f4420g = drawable;
            if (drawable != null) {
                this.f4424k = drawable.getIntrinsicHeight();
            } else {
                this.f4424k = 0;
            }
            b();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable != this.f4421h) {
            this.f4421h = drawable;
            if (drawable != null) {
                this.f4425l = drawable.getIntrinsicWidth();
            } else {
                this.f4425l = 0;
            }
            b();
            requestLayout();
        }
    }

    public void setFlexDirection(int i2) {
        if (this.f4414a != i2) {
            this.f4414a = i2;
            requestLayout();
        }
    }

    public void setFlexLines(List<c> list) {
        this.p = list;
    }

    public void setFlexWrap(int i2) {
        if (this.f4415b != i2) {
            this.f4415b = i2;
            requestLayout();
        }
    }

    public void setJustifyContent(int i2) {
        if (this.f4416c != i2) {
            this.f4416c = i2;
            requestLayout();
        }
    }

    public void setMaxLine(int i2) {
        if (this.f4419f != i2) {
            this.f4419f = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.f4422i) {
            this.f4422i = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.f4423j) {
            this.f4423j = i2;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        int mode2 = MeasureSpec.getMode(i4);
        int size2 = MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            i6 = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            i7 = getLargestMainSize();
        } else if (i2 == 2 || i2 == 3) {
            i6 = getLargestMainSize();
            i7 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid flex direction: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = i7;
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            i8 = View.resolveSizeAndState(i7, i3, i5);
        } else if (mode == 1073741824) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown width mode is set: ");
            sb2.append(mode);
            throw new IllegalStateException(sb2.toString());
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, 256);
                i6 = size2;
            }
            i9 = View.resolveSizeAndState(i6, i4, i5);
        } else if (mode2 == 0) {
            i9 = View.resolveSizeAndState(i6, i4, i5);
        } else if (mode2 == 1073741824) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            i9 = View.resolveSizeAndState(size2, i4, i5);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown height mode is set: ");
            sb3.append(mode2);
            throw new IllegalStateException(sb3.toString());
        }
        setMeasuredDimension(i8, i9);
    }

    private void b(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.p.size();
        for (int i6 = 0; i6 < size; i6++) {
            c cVar = (c) this.p.get(i6);
            for (int i7 = 0; i7 < cVar.f4471h; i7++) {
                int i8 = cVar.o + i7;
                View c2 = c(i8);
                if (!(c2 == null || c2.getVisibility() == 8)) {
                    a aVar = (a) c2.getLayoutParams();
                    if (b(i8, i7)) {
                        if (z2) {
                            i5 = c2.getBottom() + aVar.bottomMargin;
                        } else {
                            i5 = (c2.getTop() - aVar.topMargin) - this.f4424k;
                        }
                        a(canvas, cVar.f4464a, i5, cVar.f4470g);
                    }
                    if (i7 == cVar.f4471h - 1 && (this.f4422i & 4) > 0) {
                        if (z2) {
                            i4 = (c2.getTop() - aVar.topMargin) - this.f4424k;
                        } else {
                            i4 = c2.getBottom() + aVar.bottomMargin;
                        }
                        a(canvas, cVar.f4464a, i4, cVar.f4470g);
                    }
                }
            }
            if (e(i6)) {
                if (z) {
                    i3 = cVar.f4466c;
                } else {
                    i3 = cVar.f4464a - this.f4425l;
                }
                b(canvas, i3, paddingTop, max);
            }
            if (f(i6) && (this.f4423j & 4) > 0) {
                if (z) {
                    i2 = cVar.f4464a - this.f4425l;
                } else {
                    i2 = cVar.f4466c;
                }
                b(canvas, i2, paddingTop, max);
            }
        }
    }

    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4419f = -1;
        this.o = new e(this);
        this.p = new ArrayList();
        this.q = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.FlexboxLayout, i2, 0);
        this.f4414a = obtainStyledAttributes.getInt(j.FlexboxLayout_flexDirection, 0);
        this.f4415b = obtainStyledAttributes.getInt(j.FlexboxLayout_flexWrap, 0);
        this.f4416c = obtainStyledAttributes.getInt(j.FlexboxLayout_justifyContent, 0);
        this.f4417d = obtainStyledAttributes.getInt(j.FlexboxLayout_alignItems, 4);
        this.f4418e = obtainStyledAttributes.getInt(j.FlexboxLayout_alignContent, 5);
        this.f4419f = obtainStyledAttributes.getInt(j.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(j.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(j.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(j.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = obtainStyledAttributes.getInt(j.FlexboxLayout_showDivider, 0);
        if (i3 != 0) {
            this.f4423j = i3;
            this.f4422i = i3;
        }
        int i4 = obtainStyledAttributes.getInt(j.FlexboxLayout_showDividerVertical, 0);
        if (i4 != 0) {
            this.f4423j = i4;
        }
        int i5 = obtainStyledAttributes.getInt(j.FlexboxLayout_showDividerHorizontal, 0);
        if (i5 != 0) {
            this.f4422i = i5;
        }
        obtainStyledAttributes.recycle();
    }

    private void c(int i2, int i3) {
        this.p.clear();
        this.q.a();
        this.o.a(this.q, i2, i3);
        this.p = this.q.f4481a;
        this.o.a(i2, i3);
        if (this.f4417d == 3) {
            for (c cVar : this.p) {
                int i4 = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < cVar.f4471h; i5++) {
                    View c2 = c(cVar.o + i5);
                    if (!(c2 == null || c2.getVisibility() == 8)) {
                        a aVar = (a) c2.getLayoutParams();
                        if (this.f4415b != 2) {
                            i4 = Math.max(i4, c2.getMeasuredHeight() + Math.max(cVar.f4475l - c2.getBaseline(), aVar.topMargin) + aVar.bottomMargin);
                        } else {
                            i4 = Math.max(i4, c2.getMeasuredHeight() + aVar.topMargin + Math.max((cVar.f4475l - c2.getMeasuredHeight()) + c2.getBaseline(), aVar.bottomMargin));
                        }
                    }
                }
                cVar.f4470g = i4;
            }
        }
        this.o.a(i2, i3, getPaddingTop() + getPaddingBottom());
        this.o.a();
        a(this.f4414a, i2, i3, this.q.f4482b);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new a((MarginLayoutParams) layoutParams);
        }
        return new a(layoutParams);
    }

    private boolean d(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (((c) this.p.get(i3)).c() > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean a() {
        int i2 = this.f4414a;
        return i2 == 0 || i2 == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f9  */
    private void a(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        int i6;
        int i7;
        int i8;
        int i9;
        float f5;
        float f6;
        int i10;
        a aVar;
        int i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i12 = i4 - i2;
        int paddingBottom = (i5 - i3) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.p.size();
        int i13 = paddingTop;
        int i14 = paddingBottom;
        int i15 = 0;
        while (i15 < size) {
            c cVar = (c) this.p.get(i15);
            if (e(i15)) {
                int i16 = this.f4424k;
                i14 -= i16;
                i13 += i16;
            }
            int i17 = this.f4416c;
            if (i17 == 0) {
                f3 = (float) paddingLeft;
                i11 = i12 - paddingRight;
            } else if (i17 == 1) {
                int i18 = cVar.f4468e;
                f3 = (float) ((i12 - i18) + paddingRight);
                i11 = i18 - paddingLeft;
            } else if (i17 != 2) {
                if (i17 == 3) {
                    f3 = (float) paddingLeft;
                    int c2 = cVar.c();
                    f4 = ((float) (i12 - cVar.f4468e)) / (c2 != 1 ? (float) (c2 - 1) : 1.0f);
                    f2 = (float) (i12 - paddingRight);
                } else if (i17 == 4) {
                    int c3 = cVar.c();
                    f4 = c3 != 0 ? ((float) (i12 - cVar.f4468e)) / ((float) c3) : 0.0f;
                    float f7 = f4 / 2.0f;
                    f3 = ((float) paddingLeft) + f7;
                    f2 = ((float) (i12 - paddingRight)) - f7;
                } else if (i17 == 5) {
                    int c4 = cVar.c();
                    f4 = c4 != 0 ? ((float) (i12 - cVar.f4468e)) / ((float) (c4 + 1)) : 0.0f;
                    f3 = ((float) paddingLeft) + f4;
                    f2 = ((float) (i12 - paddingRight)) - f4;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid justifyContent is set: ");
                    sb.append(this.f4416c);
                    throw new IllegalStateException(sb.toString());
                }
                float max = Math.max(f4, 0.0f);
                i6 = 0;
                while (i6 < cVar.f4471h) {
                    int i19 = cVar.o + i6;
                    View c5 = c(i19);
                    if (c5 == null || c5.getVisibility() == 8) {
                        i7 = paddingLeft;
                        i8 = i6;
                    } else {
                        a aVar2 = (a) c5.getLayoutParams();
                        float f8 = f3 + ((float) aVar2.leftMargin);
                        float f9 = f2 - ((float) aVar2.rightMargin);
                        if (b(i19, i6)) {
                            int i20 = this.f4425l;
                            float f10 = (float) i20;
                            f6 = f8 + f10;
                            i9 = i20;
                            f5 = f9 - f10;
                        } else {
                            f6 = f8;
                            f5 = f9;
                            i9 = 0;
                        }
                        if (i6 == cVar.f4471h - 1) {
                            if ((this.f4423j & 4) > 0) {
                                i10 = this.f4425l;
                                if (this.f4415b == 2) {
                                    i7 = paddingLeft;
                                    i8 = i6;
                                    aVar = aVar2;
                                    if (z) {
                                        this.o.a(c5, cVar, Math.round(f5) - c5.getMeasuredWidth(), i13, Math.round(f5), i13 + c5.getMeasuredHeight());
                                    } else {
                                        this.o.a(c5, cVar, Math.round(f6), i13, Math.round(f6) + c5.getMeasuredWidth(), i13 + c5.getMeasuredHeight());
                                    }
                                } else if (z) {
                                    i8 = i6;
                                    i7 = paddingLeft;
                                    aVar = aVar2;
                                    this.o.a(c5, cVar, Math.round(f5) - c5.getMeasuredWidth(), i14 - c5.getMeasuredHeight(), Math.round(f5), i14);
                                } else {
                                    i7 = paddingLeft;
                                    i8 = i6;
                                    aVar = aVar2;
                                    this.o.a(c5, cVar, Math.round(f6), i14 - c5.getMeasuredHeight(), Math.round(f6) + c5.getMeasuredWidth(), i14);
                                }
                                float measuredWidth = f6 + ((float) c5.getMeasuredWidth()) + max + ((float) aVar.rightMargin);
                                float measuredWidth2 = f5 - ((((float) c5.getMeasuredWidth()) + max) + ((float) aVar.leftMargin));
                                if (!z) {
                                    cVar.a(c5, i10, 0, i9, 0);
                                } else {
                                    cVar.a(c5, i9, 0, i10, 0);
                                }
                                f3 = measuredWidth;
                                f2 = measuredWidth2;
                            }
                        }
                        i10 = 0;
                        if (this.f4415b == 2) {
                        }
                        float measuredWidth3 = f6 + ((float) c5.getMeasuredWidth()) + max + ((float) aVar.rightMargin);
                        float measuredWidth22 = f5 - ((((float) c5.getMeasuredWidth()) + max) + ((float) aVar.leftMargin));
                        if (!z) {
                        }
                        f3 = measuredWidth3;
                        f2 = measuredWidth22;
                    }
                    i6 = i8 + 1;
                    paddingLeft = i7;
                }
                int i21 = paddingLeft;
                int i22 = cVar.f4470g;
                i13 += i22;
                i14 -= i22;
                i15++;
                paddingLeft = i21;
            } else {
                float f11 = (float) paddingLeft;
                int i23 = cVar.f4468e;
                f2 = ((float) (i12 - paddingRight)) - (((float) (i12 - i23)) / 2.0f);
                f3 = f11 + (((float) (i12 - i23)) / 2.0f);
                f4 = 0.0f;
                float max2 = Math.max(f4, 0.0f);
                i6 = 0;
                while (i6 < cVar.f4471h) {
                }
                int i212 = paddingLeft;
                int i222 = cVar.f4470g;
                i13 += i222;
                i14 -= i222;
                i15++;
                paddingLeft = i212;
            }
            f2 = (float) i11;
            f4 = 0.0f;
            float max22 = Math.max(f4, 0.0f);
            i6 = 0;
            while (i6 < cVar.f4471h) {
            }
            int i2122 = paddingLeft;
            int i2222 = cVar.f4470g;
            i13 += i2222;
            i14 -= i2222;
            i15++;
            paddingLeft = i2122;
        }
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f4421h;
        if (drawable != null) {
            drawable.setBounds(i2, i3, this.f4425l + i2, i4 + i3);
            this.f4421h.draw(canvas);
        }
    }

    public int b(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    private void b() {
        if (this.f4420g == null && this.f4421h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean b(int i2, int i3) {
        boolean a2 = a(i2, i3);
        boolean z = false;
        if (a2) {
            if (a()) {
                if ((this.f4423j & 1) != 0) {
                    z = true;
                }
                return z;
            }
            if ((this.f4422i & 1) != 0) {
                z = true;
            }
            return z;
        } else if (a()) {
            if ((this.f4423j & 2) != 0) {
                z = true;
            }
            return z;
        } else {
            if ((this.f4422i & 2) != 0) {
                z = true;
            }
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f7  */
    private void a(boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        int i6;
        int i7;
        int i8;
        float f5;
        float f6;
        int i9;
        a aVar;
        int i10;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i11 = i5 - i3;
        int i12 = (i4 - i2) - paddingRight;
        int size = this.p.size();
        int i13 = i12;
        int i14 = paddingLeft;
        for (int i15 = 0; i15 < size; i15++) {
            c cVar = (c) this.p.get(i15);
            if (e(i15)) {
                int i16 = this.f4425l;
                i14 += i16;
                i13 -= i16;
            }
            int i17 = this.f4416c;
            if (i17 == 0) {
                f3 = (float) paddingTop;
                i10 = i11 - paddingBottom;
            } else if (i17 == 1) {
                int i18 = cVar.f4468e;
                f3 = (float) ((i11 - i18) + paddingBottom);
                i10 = i18 - paddingTop;
            } else if (i17 != 2) {
                if (i17 == 3) {
                    f3 = (float) paddingTop;
                    int c2 = cVar.c();
                    f2 = (float) (i11 - paddingBottom);
                    f4 = ((float) (i11 - cVar.f4468e)) / (c2 != 1 ? (float) (c2 - 1) : 1.0f);
                } else if (i17 == 4) {
                    int c3 = cVar.c();
                    f4 = c3 != 0 ? ((float) (i11 - cVar.f4468e)) / ((float) c3) : 0.0f;
                    float f7 = f4 / 2.0f;
                    f3 = ((float) paddingTop) + f7;
                    f2 = ((float) (i11 - paddingBottom)) - f7;
                } else if (i17 == 5) {
                    int c4 = cVar.c();
                    f4 = c4 != 0 ? ((float) (i11 - cVar.f4468e)) / ((float) (c4 + 1)) : 0.0f;
                    f3 = ((float) paddingTop) + f4;
                    f2 = ((float) (i11 - paddingBottom)) - f4;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid justifyContent is set: ");
                    sb.append(this.f4416c);
                    throw new IllegalStateException(sb.toString());
                }
                float max = Math.max(f4, 0.0f);
                float f8 = f2;
                i6 = 0;
                while (i6 < cVar.f4471h) {
                    int i19 = cVar.o + i6;
                    View c5 = c(i19);
                    if (c5 == null || c5.getVisibility() == 8) {
                        i7 = i6;
                    } else {
                        a aVar2 = (a) c5.getLayoutParams();
                        float f9 = f3 + ((float) aVar2.topMargin);
                        float f10 = f8 - ((float) aVar2.bottomMargin);
                        if (b(i19, i6)) {
                            int i20 = this.f4424k;
                            float f11 = (float) i20;
                            f5 = f10 - f11;
                            i8 = i20;
                            f6 = f9 + f11;
                        } else {
                            f5 = f10;
                            f6 = f9;
                            i8 = 0;
                        }
                        if (i6 == cVar.f4471h - 1) {
                            if ((this.f4422i & 4) > 0) {
                                i9 = this.f4424k;
                                if (z) {
                                    i7 = i6;
                                    aVar = aVar2;
                                    if (z2) {
                                        this.o.a(c5, cVar, false, i14, Math.round(f5) - c5.getMeasuredHeight(), i14 + c5.getMeasuredWidth(), Math.round(f5));
                                    } else {
                                        this.o.a(c5, cVar, false, i14, Math.round(f6), i14 + c5.getMeasuredWidth(), Math.round(f6) + c5.getMeasuredHeight());
                                    }
                                } else if (z2) {
                                    i7 = i6;
                                    aVar = aVar2;
                                    this.o.a(c5, cVar, true, i13 - c5.getMeasuredWidth(), Math.round(f5) - c5.getMeasuredHeight(), i13, Math.round(f5));
                                } else {
                                    i7 = i6;
                                    aVar = aVar2;
                                    this.o.a(c5, cVar, true, i13 - c5.getMeasuredWidth(), Math.round(f6), i13, Math.round(f6) + c5.getMeasuredHeight());
                                }
                                a aVar3 = aVar;
                                float measuredHeight = f6 + ((float) c5.getMeasuredHeight()) + max + ((float) aVar3.bottomMargin);
                                float measuredHeight2 = f5 - ((((float) c5.getMeasuredHeight()) + max) + ((float) aVar3.topMargin));
                                if (!z2) {
                                    cVar.a(c5, 0, i9, 0, i8);
                                } else {
                                    cVar.a(c5, 0, i8, 0, i9);
                                }
                                f3 = measuredHeight;
                                f8 = measuredHeight2;
                            }
                        }
                        i9 = 0;
                        if (z) {
                        }
                        a aVar32 = aVar;
                        float measuredHeight3 = f6 + ((float) c5.getMeasuredHeight()) + max + ((float) aVar32.bottomMargin);
                        float measuredHeight22 = f5 - ((((float) c5.getMeasuredHeight()) + max) + ((float) aVar32.topMargin));
                        if (!z2) {
                        }
                        f3 = measuredHeight3;
                        f8 = measuredHeight22;
                    }
                    i6 = i7 + 1;
                }
                int i21 = cVar.f4470g;
                i14 += i21;
                i13 -= i21;
            } else {
                float f12 = (float) paddingTop;
                int i22 = cVar.f4468e;
                f3 = (((float) (i11 - i22)) / 2.0f) + f12;
                f2 = ((float) (i11 - paddingBottom)) - (((float) (i11 - i22)) / 2.0f);
                f4 = 0.0f;
                float max2 = Math.max(f4, 0.0f);
                float f82 = f2;
                i6 = 0;
                while (i6 < cVar.f4471h) {
                }
                int i212 = cVar.f4470g;
                i14 += i212;
                i13 -= i212;
            }
            f2 = (float) i10;
            f4 = 0.0f;
            float max22 = Math.max(f4, 0.0f);
            float f822 = f2;
            i6 = 0;
            while (i6 < cVar.f4471h) {
            }
            int i2122 = cVar.f4470g;
            i14 += i2122;
            i13 -= i2122;
        }
    }

    private void a(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.p.size();
        for (int i6 = 0; i6 < size; i6++) {
            c cVar = (c) this.p.get(i6);
            for (int i7 = 0; i7 < cVar.f4471h; i7++) {
                int i8 = cVar.o + i7;
                View c2 = c(i8);
                if (!(c2 == null || c2.getVisibility() == 8)) {
                    a aVar = (a) c2.getLayoutParams();
                    if (b(i8, i7)) {
                        if (z) {
                            i5 = c2.getRight() + aVar.rightMargin;
                        } else {
                            i5 = (c2.getLeft() - aVar.leftMargin) - this.f4425l;
                        }
                        b(canvas, i5, cVar.f4465b, cVar.f4470g);
                    }
                    if (i7 == cVar.f4471h - 1 && (this.f4423j & 4) > 0) {
                        if (z) {
                            i4 = (c2.getLeft() - aVar.leftMargin) - this.f4425l;
                        } else {
                            i4 = c2.getRight() + aVar.rightMargin;
                        }
                        b(canvas, i4, cVar.f4465b, cVar.f4470g);
                    }
                }
            }
            if (e(i6)) {
                if (z2) {
                    i3 = cVar.f4467d;
                } else {
                    i3 = cVar.f4465b - this.f4424k;
                }
                a(canvas, paddingLeft, i3, max);
            }
            if (f(i6) && (this.f4422i & 4) > 0) {
                if (z2) {
                    i2 = cVar.f4465b - this.f4424k;
                } else {
                    i2 = cVar.f4467d;
                }
                a(canvas, paddingLeft, i2, max);
            }
        }
    }

    private void a(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f4420g;
        if (drawable != null) {
            drawable.setBounds(i2, i3, i4 + i2, this.f4424k + i3);
            this.f4420g.draw(canvas);
        }
    }

    public int a(View view, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (a()) {
            if (b(i2, i3)) {
                i5 = 0 + this.f4425l;
            }
            if ((this.f4423j & 4) <= 0) {
                return i5;
            }
            i4 = this.f4425l;
        } else {
            if (b(i2, i3)) {
                i5 = 0 + this.f4424k;
            }
            if ((this.f4422i & 4) <= 0) {
                return i5;
            }
            i4 = this.f4424k;
        }
        return i5 + i4;
    }

    public void a(c cVar) {
        if (a()) {
            if ((this.f4423j & 4) > 0) {
                int i2 = cVar.f4468e;
                int i3 = this.f4425l;
                cVar.f4468e = i2 + i3;
                cVar.f4469f += i3;
            }
        } else if ((this.f4422i & 4) > 0) {
            int i4 = cVar.f4468e;
            int i5 = this.f4424k;
            cVar.f4468e = i4 + i5;
            cVar.f4469f += i5;
        }
    }

    public int a(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    public void a(View view, int i2, int i3, c cVar) {
        if (!b(i2, i3)) {
            return;
        }
        if (a()) {
            int i4 = cVar.f4468e;
            int i5 = this.f4425l;
            cVar.f4468e = i4 + i5;
            cVar.f4469f += i5;
            return;
        }
        int i6 = cVar.f4468e;
        int i7 = this.f4424k;
        cVar.f4468e = i6 + i7;
        cVar.f4469f += i7;
    }

    private boolean a(int i2, int i3) {
        for (int i4 = 1; i4 <= i3; i4++) {
            View c2 = c(i2 - i4);
            if (c2 != null && c2.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }
}
