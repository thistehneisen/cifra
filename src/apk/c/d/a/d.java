package c.d.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import b.g.i.B;

/* compiled from: SmartTabLayout */
public class d extends HorizontalScrollView {

    /* renamed from: a reason: collision with root package name */
    protected final f f3230a;

    /* renamed from: b reason: collision with root package name */
    private int f3231b;

    /* renamed from: c reason: collision with root package name */
    private int f3232c;

    /* renamed from: d reason: collision with root package name */
    private boolean f3233d;

    /* renamed from: e reason: collision with root package name */
    private ColorStateList f3234e;

    /* renamed from: f reason: collision with root package name */
    private float f3235f;

    /* renamed from: g reason: collision with root package name */
    private int f3236g;

    /* renamed from: h reason: collision with root package name */
    private int f3237h;
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public ViewPager f3238i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public androidx.viewpager.widget.ViewPager.f f3239j;

    /* renamed from: k reason: collision with root package name */
    private c f3240k;

    /* renamed from: l reason: collision with root package name */
    private g f3241l;
    private a m;
    /* access modifiers changed from: private */
    public C0041d n;
    private boolean o;

    /* compiled from: SmartTabLayout */
    private class a implements OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            for (int i2 = 0; i2 < d.this.f3230a.getChildCount(); i2++) {
                if (view == d.this.f3230a.getChildAt(i2)) {
                    if (d.this.n != null) {
                        d.this.n.a(i2);
                    }
                    d.this.f3238i.setCurrentItem(i2);
                    return;
                }
            }
        }
    }

    /* compiled from: SmartTabLayout */
    private class b implements androidx.viewpager.widget.ViewPager.f {

        /* renamed from: a reason: collision with root package name */
        private int f3243a;

        private b() {
        }

        public void a(int i2, float f2, int i3) {
            int childCount = d.this.f3230a.getChildCount();
            if (childCount != 0 && i2 >= 0 && i2 < childCount) {
                d.this.f3230a.a(i2, f2);
                d.this.a(i2, f2);
                if (d.this.f3239j != null) {
                    d.this.f3239j.a(i2, f2, i3);
                }
            }
        }

        public void b(int i2) {
            if (this.f3243a == 0) {
                d.this.f3230a.a(i2, 0.0f);
                d.this.a(i2, 0.0f);
            }
            int childCount = d.this.f3230a.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                d.this.f3230a.getChildAt(i3).setSelected(i2 == i3);
                i3++;
            }
            if (d.this.f3239j != null) {
                d.this.f3239j.b(i2);
            }
        }

        public void a(int i2) {
            this.f3243a = i2;
            if (d.this.f3239j != null) {
                d.this.f3239j.a(i2);
            }
        }
    }

    /* compiled from: SmartTabLayout */
    public interface c {
        void a(int i2, int i3);
    }

    /* renamed from: c.d.a.d$d reason: collision with other inner class name */
    /* compiled from: SmartTabLayout */
    public interface C0041d {
        void a(int i2);
    }

    /* compiled from: SmartTabLayout */
    private static class e implements g {

        /* renamed from: a reason: collision with root package name */
        private final LayoutInflater f3245a;

        /* renamed from: b reason: collision with root package name */
        private final int f3246b;

        /* renamed from: c reason: collision with root package name */
        private final int f3247c;

        public View a(ViewGroup viewGroup, int i2, androidx.viewpager.widget.a aVar) {
            int i3 = this.f3246b;
            TextView textView = null;
            View inflate = i3 != -1 ? this.f3245a.inflate(i3, viewGroup, false) : null;
            int i4 = this.f3247c;
            if (!(i4 == -1 || inflate == null)) {
                textView = (TextView) inflate.findViewById(i4);
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView = (TextView) inflate;
            }
            if (textView != null) {
                textView.setText(aVar.getPageTitle(i2));
            }
            return inflate;
        }

        private e(Context context, int i2, int i3) {
            this.f3245a = LayoutInflater.from(context);
            this.f3246b = i2;
            this.f3247c = i3;
        }
    }

    /* compiled from: SmartTabLayout */
    public interface f {
        int a(int i2);

        int b(int i2);
    }

    /* compiled from: SmartTabLayout */
    public interface g {
        View a(ViewGroup viewGroup, int i2, androidx.viewpager.widget.a aVar);
    }

    public d(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            ViewPager viewPager = this.f3238i;
            if (viewPager != null) {
                a(viewPager.getCurrentItem(), 0.0f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        c cVar = this.f3240k;
        if (cVar != null) {
            cVar.a(i2, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f3230a.b() && this.f3230a.getChildCount() > 0) {
            View childAt = this.f3230a.getChildAt(0);
            f fVar = this.f3230a;
            View childAt2 = fVar.getChildAt(fVar.getChildCount() - 1);
            int e2 = ((i2 - g.e(childAt)) / 2) - g.d(childAt);
            int e3 = ((i2 - g.e(childAt2)) / 2) - g.b(childAt2);
            f fVar2 = this.f3230a;
            fVar2.setMinimumWidth(fVar2.getMeasuredWidth());
            B.a(this, e2, getPaddingTop(), e3, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    public void setCustomTabColorizer(f fVar) {
        this.f3230a.a(fVar);
    }

    public void setCustomTabView(g gVar) {
        this.f3241l = gVar;
    }

    public void setDefaultTabTextColor(int i2) {
        this.f3234e = ColorStateList.valueOf(i2);
    }

    public void setDistributeEvenly(boolean z) {
        this.o = z;
    }

    public void setDividerColors(int... iArr) {
        this.f3230a.a(iArr);
    }

    public void setIndicationInterpolator(b bVar) {
        this.f3230a.a(bVar);
    }

    public void setOnPageChangeListener(androidx.viewpager.widget.ViewPager.f fVar) {
        this.f3239j = fVar;
    }

    public void setOnScrollChangeListener(c cVar) {
        this.f3240k = cVar;
    }

    public void setOnTabClickListener(C0041d dVar) {
        this.n = dVar;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f3230a.b(iArr);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f3230a.removeAllViews();
        this.f3238i = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.addOnPageChangeListener(new b());
            a();
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setDefaultTabTextColor(ColorStateList colorStateList) {
        this.f3234e = colorStateList;
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        super(context, attributeSet, i2);
        setHorizontalScrollBarEnabled(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        float applyDimension = TypedValue.applyDimension(2, 12.0f, displayMetrics);
        int i3 = (int) (16.0f * f2);
        int i4 = (int) (0.0f * f2);
        int i5 = (int) (f2 * 24.0f);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, a.stl_SmartTabLayout, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(a.stl_SmartTabLayout_stl_defaultTabBackground, -1);
        boolean z = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_defaultTabTextAllCaps, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(a.stl_SmartTabLayout_stl_defaultTabTextColor);
        float dimension = obtainStyledAttributes.getDimension(a.stl_SmartTabLayout_stl_defaultTabTextSize, applyDimension);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.stl_SmartTabLayout_stl_defaultTabTextHorizontalPadding, i3);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(a.stl_SmartTabLayout_stl_defaultTabTextMinWidth, i4);
        int resourceId2 = obtainStyledAttributes.getResourceId(a.stl_SmartTabLayout_stl_customTabTextLayoutId, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(a.stl_SmartTabLayout_stl_customTabTextViewId, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_distributeEvenly, false);
        boolean z3 = obtainStyledAttributes.getBoolean(a.stl_SmartTabLayout_stl_clickable, true);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(a.stl_SmartTabLayout_stl_titleOffset, i5);
        obtainStyledAttributes.recycle();
        this.f3231b = layoutDimension;
        this.f3232c = resourceId;
        this.f3233d = z;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-67108864);
        }
        this.f3234e = colorStateList;
        this.f3235f = dimension;
        this.f3236g = dimensionPixelSize;
        this.f3237h = dimensionPixelSize2;
        a aVar = null;
        if (z3) {
            aVar = new a();
        }
        this.m = aVar;
        this.o = z2;
        if (resourceId2 != -1) {
            a(resourceId2, resourceId3);
        }
        this.f3230a = new f(context2, attributeSet2);
        if (!z2 || !this.f3230a.b()) {
            setFillViewport(!this.f3230a.b());
            addView(this.f3230a, -1, -1);
            return;
        }
        throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
    }

    public void a(int i2, int i3) {
        this.f3241l = new e(getContext(), i2, i3);
    }

    public View a(int i2) {
        return this.f3230a.getChildAt(i2);
    }

    /* access modifiers changed from: protected */
    public TextView a(CharSequence charSequence) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(charSequence);
        textView.setTextColor(this.f3234e);
        textView.setTextSize(0, this.f3235f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LayoutParams(-2, -1));
        int i2 = this.f3232c;
        if (i2 != -1) {
            textView.setBackgroundResource(i2);
        } else {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (VERSION.SDK_INT >= 14) {
            textView.setAllCaps(this.f3233d);
        }
        int i3 = this.f3236g;
        textView.setPadding(i3, 0, i3, 0);
        int i4 = this.f3237h;
        if (i4 > 0) {
            textView.setMinWidth(i4);
        }
        return textView;
    }

    private void a() {
        View view;
        androidx.viewpager.widget.a adapter = this.f3238i.getAdapter();
        int i2 = 0;
        while (i2 < adapter.getCount()) {
            g gVar = this.f3241l;
            if (gVar == null) {
                view = a(adapter.getPageTitle(i2));
            } else {
                view = gVar.a(this.f3230a, i2, adapter);
            }
            if (view != null) {
                if (this.o) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                }
                a aVar = this.m;
                if (aVar != null) {
                    view.setOnClickListener(aVar);
                }
                this.f3230a.addView(view);
                if (i2 == this.f3238i.getCurrentItem()) {
                    view.setSelected(true);
                }
                i2++;
            } else {
                throw new IllegalStateException("tabView is null.");
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, float f2) {
        int i3;
        int i4;
        int i5;
        int childCount = this.f3230a.getChildCount();
        if (childCount != 0 && i2 >= 0 && i2 < childCount) {
            boolean l2 = g.l(this);
            View childAt = this.f3230a.getChildAt(i2);
            int j2 = (int) (((float) (g.j(childAt) + g.c(childAt))) * f2);
            if (this.f3230a.b()) {
                if (0.0f < f2 && f2 < 1.0f) {
                    View childAt2 = this.f3230a.getChildAt(i2 + 1);
                    j2 = Math.round(f2 * ((float) ((g.j(childAt) / 2) + g.b(childAt) + (g.j(childAt2) / 2) + g.d(childAt2))));
                }
                View childAt3 = this.f3230a.getChildAt(0);
                if (l2) {
                    i5 = (g.a(childAt) - g.b(childAt)) - j2;
                    i4 = ((g.j(childAt3) + g.b(childAt3)) - (g.j(childAt) + g.b(childAt))) / 2;
                } else {
                    i5 = (g.i(childAt) - g.d(childAt)) + j2;
                    i4 = ((g.j(childAt3) + g.d(childAt3)) - (g.j(childAt) + g.d(childAt))) / 2;
                }
                scrollTo(i5 - i4, 0);
                return;
            }
            if (this.f3231b == -1) {
                if (0.0f < f2 && f2 < 1.0f) {
                    View childAt4 = this.f3230a.getChildAt(i2 + 1);
                    j2 = Math.round(f2 * ((float) ((g.j(childAt) / 2) + g.b(childAt) + (g.j(childAt4) / 2) + g.d(childAt4))));
                }
                i3 = l2 ? (((-g.k(childAt)) / 2) + (getWidth() / 2)) - g.h(this) : ((g.k(childAt) / 2) - (getWidth() / 2)) + g.h(this);
            } else {
                if (l2) {
                    if (i2 > 0 || f2 > 0.0f) {
                        i3 = this.f3231b;
                    }
                } else if (i2 > 0 || f2 > 0.0f) {
                    i3 = -this.f3231b;
                }
                i3 = 0;
            }
            int i6 = g.i(childAt);
            int d2 = g.d(childAt);
            scrollTo(i3 + (l2 ? (((i6 + d2) - j2) - getWidth()) + g.g(this) : (i6 - d2) + j2), 0);
        }
    }
}
