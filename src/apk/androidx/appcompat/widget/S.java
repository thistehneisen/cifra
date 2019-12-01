package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.z;
import androidx.core.widget.i;
import b.a.j;
import b.g.i.B;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class S implements z {

    /* renamed from: a reason: collision with root package name */
    private static Method f854a;

    /* renamed from: b reason: collision with root package name */
    private static Method f855b;

    /* renamed from: c reason: collision with root package name */
    private static Method f856c;
    final e A;
    private final d B;
    private final c C;
    private final a D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;

    /* renamed from: d reason: collision with root package name */
    private Context f857d;

    /* renamed from: e reason: collision with root package name */
    private ListAdapter f858e;

    /* renamed from: f reason: collision with root package name */
    L f859f;

    /* renamed from: g reason: collision with root package name */
    private int f860g;

    /* renamed from: h reason: collision with root package name */
    private int f861h;

    /* renamed from: i reason: collision with root package name */
    private int f862i;

    /* renamed from: j reason: collision with root package name */
    private int f863j;

    /* renamed from: k reason: collision with root package name */
    private int f864k;

    /* renamed from: l reason: collision with root package name */
    private boolean f865l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    int s;
    private View t;
    private int u;
    private DataSetObserver v;
    private View w;
    private Drawable x;
    private OnItemClickListener y;
    private OnItemSelectedListener z;

    /* compiled from: ListPopupWindow */
    private class a implements Runnable {
        a() {
        }

        public void run() {
            S.this.a();
        }
    }

    /* compiled from: ListPopupWindow */
    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (S.this.c()) {
                S.this.b();
            }
        }

        public void onInvalidated() {
            S.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow */
    private class c implements OnScrollListener {
        c() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !S.this.j() && S.this.J.getContentView() != null) {
                S s = S.this;
                s.F.removeCallbacks(s.A);
                S.this.A.run();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    private class d implements OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0) {
                PopupWindow popupWindow = S.this.J;
                if (popupWindow != null && popupWindow.isShowing() && x >= 0 && x < S.this.J.getWidth() && y >= 0 && y < S.this.J.getHeight()) {
                    S s = S.this;
                    s.F.postDelayed(s.A, 250);
                    return false;
                }
            }
            if (action == 1) {
                S s2 = S.this;
                s2.F.removeCallbacks(s2.A);
            }
            return false;
        }
    }

    /* compiled from: ListPopupWindow */
    private class e implements Runnable {
        e() {
        }

        public void run() {
            L l2 = S.this.f859f;
            if (l2 != null && B.B(l2) && S.this.f859f.getCount() > S.this.f859f.getChildCount()) {
                int childCount = S.this.f859f.getChildCount();
                S s = S.this;
                if (childCount <= s.s) {
                    s.J.setInputMethodMode(2);
                    S.this.b();
                }
            }
        }
    }

    static {
        String str = "ListPopupWindow";
        try {
            f854a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i(str, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f855b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
            Log.i(str, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f856c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException unused3) {
            Log.i(str, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public S(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    private int l() {
        int i2;
        int i3;
        int makeMeasureSpec;
        View view;
        int i4;
        boolean z2 = true;
        if (this.f859f == null) {
            Context context = this.f857d;
            this.E = new P(this);
            this.f859f = a(context, !this.I);
            Drawable drawable = this.x;
            if (drawable != null) {
                this.f859f.setSelector(drawable);
            }
            this.f859f.setAdapter(this.f858e);
            this.f859f.setOnItemClickListener(this.y);
            this.f859f.setFocusable(true);
            this.f859f.setFocusableInTouchMode(true);
            this.f859f.setOnItemSelectedListener(new Q(this));
            this.f859f.setOnScrollListener(this.C);
            OnItemSelectedListener onItemSelectedListener = this.z;
            if (onItemSelectedListener != null) {
                this.f859f.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view2 = this.f859f;
            View view3 = this.t;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams = new LayoutParams(-1, 0, 1.0f);
                int i5 = this.u;
                if (i5 == 0) {
                    linearLayout.addView(view3);
                    linearLayout.addView(view2, layoutParams);
                } else if (i5 != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid hint position ");
                    sb.append(this.u);
                    Log.e("ListPopupWindow", sb.toString());
                } else {
                    linearLayout.addView(view2, layoutParams);
                    linearLayout.addView(view3);
                }
                int i6 = this.f861h;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                i2 = view3.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i2 = 0;
                view = view2;
            }
            this.J.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.J.getContentView();
            View view4 = this.t;
            if (view4 != null) {
                LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
                i2 = view4.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.f865l) {
                this.f863j = -i7;
            }
        } else {
            this.G.setEmpty();
            i3 = 0;
        }
        if (this.J.getInputMethodMode() != 2) {
            z2 = false;
        }
        int a2 = a(e(), this.f863j, z2);
        if (this.q || this.f860g == -1) {
            return a2 + i3;
        }
        int i8 = this.f861h;
        if (i8 == -2) {
            int i9 = this.f857d.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.G;
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f857d.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.G;
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int a3 = this.f859f.a(makeMeasureSpec, 0, -1, a2 - i2, -1);
        if (a3 > 0) {
            i2 += i3 + this.f859f.getPaddingTop() + this.f859f.getPaddingBottom();
        }
        return a3 + i2;
    }

    private void m() {
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.v;
        if (dataSetObserver == null) {
            this.v = new b();
        } else {
            ListAdapter listAdapter2 = this.f858e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f858e = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.v);
        }
        L l2 = this.f859f;
        if (l2 != null) {
            l2.setAdapter(this.f858e);
        }
    }

    public void b(int i2) {
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            this.f861h = rect.left + rect.right + i2;
            return;
        }
        i(i2);
    }

    public void c(int i2) {
        this.p = i2;
    }

    public void d(int i2) {
        this.f862i = i2;
    }

    public void dismiss() {
        this.J.dismiss();
        m();
        this.J.setContentView(null);
        this.f859f = null;
        this.F.removeCallbacks(this.A);
    }

    public View e() {
        return this.w;
    }

    public void f(int i2) {
        this.u = i2;
    }

    public int g() {
        return this.f862i;
    }

    public int h() {
        if (!this.f865l) {
            return 0;
        }
        return this.f863j;
    }

    public int i() {
        return this.f861h;
    }

    public boolean j() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean k() {
        return this.I;
    }

    public S(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f860g = -2;
        this.f861h = -2;
        this.f864k = 1002;
        this.m = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = Integer.MAX_VALUE;
        this.u = 0;
        this.A = new e();
        this.B = new d();
        this.C = new c();
        this.D = new a();
        this.G = new Rect();
        this.f857d = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i2, i3);
        this.f862i = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f863j = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f863j != 0) {
            this.f865l = true;
        }
        obtainStyledAttributes.recycle();
        this.J = new C0180u(context, attributeSet, i2, i3);
        this.J.setInputMethodMode(1);
    }

    public boolean c() {
        return this.J.isShowing();
    }

    public ListView d() {
        return this.f859f;
    }

    public void e(int i2) {
        this.J.setInputMethodMode(i2);
    }

    public Drawable f() {
        return this.J.getBackground();
    }

    public void g(int i2) {
        L l2 = this.f859f;
        if (c() && l2 != null) {
            l2.setListSelectionHidden(false);
            l2.setSelection(i2);
            if (l2.getChoiceMode() != 0) {
                l2.setItemChecked(i2, true);
            }
        }
    }

    public void i(int i2) {
        this.f861h = i2;
    }

    private void c(boolean z2) {
        Method method = f854a;
        if (method != null) {
            try {
                method.invoke(this.J, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void h(int i2) {
        this.f863j = i2;
        this.f865l = true;
    }

    public void b() {
        int l2 = l();
        boolean j2 = j();
        i.a(this.J, this.f864k);
        boolean z2 = true;
        if (!this.J.isShowing()) {
            int i2 = this.f861h;
            if (i2 == -1) {
                i2 = -1;
            } else if (i2 == -2) {
                i2 = e().getWidth();
            }
            int i3 = this.f860g;
            if (i3 == -1) {
                l2 = -1;
            } else if (i3 != -2) {
                l2 = i3;
            }
            this.J.setWidth(i2);
            this.J.setHeight(l2);
            c(true);
            this.J.setOutsideTouchable(!this.r && !this.q);
            this.J.setTouchInterceptor(this.B);
            if (this.o) {
                i.a(this.J, this.n);
            }
            Method method = f856c;
            if (method != null) {
                try {
                    method.invoke(this.J, new Object[]{this.H});
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
            i.a(this.J, e(), this.f862i, this.f863j, this.p);
            this.f859f.setSelection(-1);
            if (!this.I || this.f859f.isInTouchMode()) {
                a();
            }
            if (!this.I) {
                this.F.post(this.D);
            }
        } else if (B.B(e())) {
            int i4 = this.f861h;
            if (i4 == -1) {
                i4 = -1;
            } else if (i4 == -2) {
                i4 = e().getWidth();
            }
            int i5 = this.f860g;
            if (i5 == -1) {
                if (!j2) {
                    l2 = -1;
                }
                if (j2) {
                    this.J.setWidth(this.f861h == -1 ? -1 : 0);
                    this.J.setHeight(0);
                } else {
                    this.J.setWidth(this.f861h == -1 ? -1 : 0);
                    this.J.setHeight(-1);
                }
            } else if (i5 != -2) {
                l2 = i5;
            }
            PopupWindow popupWindow = this.J;
            if (this.r || this.q) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.J.update(e(), this.f862i, this.f863j, i4 < 0 ? -1 : i4, l2 < 0 ? -1 : l2);
        }
    }

    public void a(boolean z2) {
        this.I = z2;
        this.J.setFocusable(z2);
    }

    public void a(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void a(int i2) {
        this.J.setAnimationStyle(i2);
    }

    public void a(View view) {
        this.w = view;
    }

    public void a(Rect rect) {
        this.H = rect;
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.y = onItemClickListener;
    }

    public void a(OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void a() {
        L l2 = this.f859f;
        if (l2 != null) {
            l2.setListSelectionHidden(true);
            l2.requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    public L a(Context context, boolean z2) {
        return new L(context, z2);
    }

    private int a(View view, int i2, boolean z2) {
        Method method = f855b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.J.getMaxAvailableHeight(view, i2);
    }

    public void b(boolean z2) {
        this.o = true;
        this.n = z2;
    }
}
