package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

/* compiled from: ScrollingTabContainerView */
public class Y extends HorizontalScrollView implements OnItemSelectedListener {

    /* renamed from: a reason: collision with root package name */
    private static final Interpolator f919a = new DecelerateInterpolator();

    /* renamed from: b reason: collision with root package name */
    Runnable f920b;

    /* renamed from: c reason: collision with root package name */
    private b f921c;

    /* renamed from: d reason: collision with root package name */
    O f922d;

    /* renamed from: e reason: collision with root package name */
    private Spinner f923e;

    /* renamed from: f reason: collision with root package name */
    private boolean f924f;

    /* renamed from: g reason: collision with root package name */
    int f925g;

    /* renamed from: h reason: collision with root package name */
    int f926h;

    /* renamed from: i reason: collision with root package name */
    private int f927i;

    /* renamed from: j reason: collision with root package name */
    private int f928j;

    /* compiled from: ScrollingTabContainerView */
    private class a extends BaseAdapter {
        a() {
        }

        public int getCount() {
            return Y.this.f922d.getChildCount();
        }

        public Object getItem(int i2) {
            return ((c) Y.this.f922d.getChildAt(i2)).a();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return Y.this.a((androidx.appcompat.app.C0134a.c) getItem(i2), true);
            }
            ((c) view).a((androidx.appcompat.app.C0134a.c) getItem(i2));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView */
    private class b implements OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ((c) view).a().e();
            int childCount = Y.this.f922d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = Y.this.f922d.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView */
    private class c extends LinearLayout {

        /* renamed from: a reason: collision with root package name */
        private final int[] f931a = {16842964};

        /* renamed from: b reason: collision with root package name */
        private androidx.appcompat.app.C0134a.c f932b;

        /* renamed from: c reason: collision with root package name */
        private TextView f933c;

        /* renamed from: d reason: collision with root package name */
        private ImageView f934d;

        /* renamed from: e reason: collision with root package name */
        private View f935e;

        public c(Context context, androidx.appcompat.app.C0134a.c cVar, boolean z) {
            super(context, null, b.a.a.actionBarTabStyle);
            this.f932b = cVar;
            sa a2 = sa.a(context, null, this.f931a, b.a.a.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(androidx.appcompat.app.C0134a.c cVar) {
            this.f932b = cVar;
            b();
        }

        public void b() {
            androidx.appcompat.app.C0134a.c cVar = this.f932b;
            View b2 = cVar.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f935e = b2;
                TextView textView = this.f933c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f934d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f934d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f935e;
            if (view != null) {
                removeView(view);
                this.f935e = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f934d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LayoutParams layoutParams = new LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f934d = appCompatImageView;
                }
                this.f934d.setImageDrawable(c2);
                this.f934d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f934d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f934d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f933c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, b.a.a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TruncateAt.END);
                    LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f933c = appCompatTextView;
                }
                this.f933c.setText(d2);
                this.f933c.setVisibility(0);
            } else {
                TextView textView2 = this.f933c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f933c.setText(null);
                }
            }
            ImageView imageView3 = this.f934d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z) {
                charSequence = cVar.a();
            }
            Aa.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(androidx.appcompat.app.C0134a.c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(androidx.appcompat.app.C0134a.c.class.getName());
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (Y.this.f925g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = Y.this.f925g;
                if (measuredWidth > i4) {
                    super.onMeasure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
                }
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public androidx.appcompat.app.C0134a.c a() {
            return this.f932b;
        }
    }

    private Spinner a() {
        B b2 = new B(getContext(), null, b.a.a.actionDropDownStyle);
        b2.setLayoutParams(new androidx.appcompat.widget.O.a(-2, -1));
        b2.setOnItemSelectedListener(this);
        return b2;
    }

    private boolean b() {
        Spinner spinner = this.f923e;
        return spinner != null && spinner.getParent() == this;
    }

    private void c() {
        if (!b()) {
            if (this.f923e == null) {
                this.f923e = a();
            }
            removeView(this.f922d);
            addView(this.f923e, new ViewGroup.LayoutParams(-2, -1));
            if (this.f923e.getAdapter() == null) {
                this.f923e.setAdapter(new a());
            }
            Runnable runnable = this.f920b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f920b = null;
            }
            this.f923e.setSelection(this.f928j);
        }
    }

    private boolean d() {
        if (!b()) {
            return false;
        }
        removeView(this.f923e);
        addView(this.f922d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f923e.getSelectedItemPosition());
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f920b;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b.a.d.a a2 = b.a.d.a.a(getContext());
        setContentHeight(a2.e());
        this.f926h = a2.d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f920b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((c) view).a().e();
    }

    public void onMeasure(int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f922d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f925g = -1;
        } else {
            if (childCount > 2) {
                this.f925g = (int) (((float) MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.f925g = MeasureSpec.getSize(i2) / 2;
            }
            this.f925g = Math.min(this.f925g, this.f926h);
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f927i, 1073741824);
        if (z2 || !this.f924f) {
            z = false;
        }
        if (z) {
            this.f922d.measure(0, makeMeasureSpec);
            if (this.f922d.getMeasuredWidth() > MeasureSpec.getSize(i2)) {
                c();
            } else {
                d();
            }
        } else {
            d();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f928j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f924f = z;
    }

    public void setContentHeight(int i2) {
        this.f927i = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f928j = i2;
        int childCount = this.f922d.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f922d.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f923e;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }

    public void a(int i2) {
        View childAt = this.f922d.getChildAt(i2);
        Runnable runnable = this.f920b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f920b = new X(this, childAt);
        post(this.f920b);
    }

    /* access modifiers changed from: 0000 */
    public c a(androidx.appcompat.app.C0134a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f927i));
        } else {
            cVar2.setFocusable(true);
            if (this.f921c == null) {
                this.f921c = new b();
            }
            cVar2.setOnClickListener(this.f921c);
        }
        return cVar2;
    }
}
