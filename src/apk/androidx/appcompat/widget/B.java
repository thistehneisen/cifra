package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import b.a.d.d;
import b.a.g;
import b.a.j;
import b.g.i.v;

/* compiled from: AppCompatSpinner */
public class B extends Spinner implements v {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f734a = {16843505};

    /* renamed from: b reason: collision with root package name */
    private final C0170j f735b;

    /* renamed from: c reason: collision with root package name */
    private final Context f736c;

    /* renamed from: d reason: collision with root package name */
    private N f737d;

    /* renamed from: e reason: collision with root package name */
    private SpinnerAdapter f738e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f739f;

    /* renamed from: g reason: collision with root package name */
    b f740g;

    /* renamed from: h reason: collision with root package name */
    int f741h;

    /* renamed from: i reason: collision with root package name */
    final Rect f742i;

    /* compiled from: AppCompatSpinner */
    private static class a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a reason: collision with root package name */
        private SpinnerAdapter f743a;

        /* renamed from: b reason: collision with root package name */
        private ListAdapter f744b;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f743a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f744b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof oa) {
                oa oaVar = (oa) spinnerAdapter;
                if (oaVar.getDropDownViewTheme() == null) {
                    oaVar.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f744b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f743a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f743a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f743a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f743a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f743a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f744b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f743a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f743a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner */
    private class b extends S {
        private CharSequence K;
        ListAdapter L;
        private final Rect M = new Rect();

        public b(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            a((View) B.this);
            a(true);
            f(0);
            a((OnItemClickListener) new C(this, B.this));
        }

        public void b() {
            boolean c2 = c();
            l();
            e(2);
            super.b();
            d().setChoiceMode(1);
            g(B.this.getSelectedItemPosition());
            if (!c2) {
                ViewTreeObserver viewTreeObserver = B.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    D d2 = new D(this);
                    viewTreeObserver.addOnGlobalLayoutListener(d2);
                    a((OnDismissListener) new E(this, d2));
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void l() {
            Drawable f2 = f();
            int i2 = 0;
            if (f2 != null) {
                f2.getPadding(B.this.f742i);
                i2 = Ga.a(B.this) ? B.this.f742i.right : -B.this.f742i.left;
            } else {
                Rect rect = B.this.f742i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = B.this.getPaddingLeft();
            int paddingRight = B.this.getPaddingRight();
            int width = B.this.getWidth();
            B b2 = B.this;
            int i3 = b2.f741h;
            if (i3 == -2) {
                int a2 = b2.a((SpinnerAdapter) this.L, f());
                int i4 = B.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = B.this.f742i;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                b(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                b((width - paddingLeft) - paddingRight);
            } else {
                b(i3);
            }
            d(Ga.a(B.this) ? i2 + ((width - paddingRight) - i()) : i2 + paddingLeft);
        }

        public CharSequence m() {
            return this.K;
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.L = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.K = charSequence;
        }

        /* access modifiers changed from: 0000 */
        public boolean b(View view) {
            return b.g.i.B.B(view) && view.getGlobalVisibleRect(this.M);
        }
    }

    public B(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.spinnerStyle);
    }

    /* access modifiers changed from: 0000 */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f742i);
            Rect rect = this.f742i;
            i3 += rect.left + rect.right;
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0170j jVar = this.f735b;
        if (jVar != null) {
            jVar.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        b bVar = this.f740g;
        if (bVar != null) {
            return bVar.g();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        b bVar = this.f740g;
        if (bVar != null) {
            return bVar.h();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f740g != null) {
            return this.f741h;
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        b bVar = this.f740g;
        if (bVar != null) {
            return bVar.f();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        if (this.f740g != null) {
            return this.f736c;
        }
        if (VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public CharSequence getPrompt() {
        b bVar = this.f740g;
        return bVar != null ? bVar.m() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0170j jVar = this.f735b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        C0170j jVar = this.f735b;
        if (jVar != null) {
            return jVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f740g;
        if (bVar != null && bVar.c()) {
            this.f740g.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f740g != null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        N n = this.f737d;
        if (n == null || !n.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        b bVar = this.f740g;
        if (bVar == null) {
            return super.performClick();
        }
        if (!bVar.c()) {
            this.f740g.b();
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0170j jVar = this.f735b;
        if (jVar != null) {
            jVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0170j jVar = this.f735b;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        b bVar = this.f740g;
        if (bVar != null) {
            bVar.d(i2);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public void setDropDownVerticalOffset(int i2) {
        b bVar = this.f740g;
        if (bVar != null) {
            bVar.h(i2);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.f740g != null) {
            this.f741h = i2;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        b bVar = this.f740g;
        if (bVar != null) {
            bVar.a(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(b.a.a.a.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        b bVar = this.f740g;
        if (bVar != null) {
            bVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0170j jVar = this.f735b;
        if (jVar != null) {
            jVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        C0170j jVar = this.f735b;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public B(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f739f) {
            this.f738e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f740g != null) {
            Context context = this.f736c;
            if (context == null) {
                context = getContext();
            }
            this.f740g.a((ListAdapter) new a(spinnerAdapter, context.getTheme()));
        }
    }

    public B(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r12 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r12 != null) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    public B(Context context, AttributeSet attributeSet, int i2, int i3, Theme theme) {
        TypedArray typedArray;
        super(context, attributeSet, i2);
        this.f742i = new Rect();
        sa a2 = sa.a(context, attributeSet, j.Spinner, i2, 0);
        this.f735b = new C0170j(this);
        if (theme != null) {
            this.f736c = new d(context, theme);
        } else {
            int g2 = a2.g(j.Spinner_popupTheme, 0);
            if (g2 != 0) {
                this.f736c = new d(context, g2);
            } else {
                this.f736c = VERSION.SDK_INT < 23 ? context : null;
            }
        }
        if (this.f736c != null) {
            if (i3 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, f734a, i2, 0);
                    try {
                        if (typedArray.hasValue(0)) {
                            i3 = typedArray.getInt(0, 0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        } catch (Throwable th) {
                            th = th;
                            if (typedArray != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    typedArray = null;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = null;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            if (i3 == 1) {
                b bVar = new b(this.f736c, attributeSet, i2);
                sa a3 = sa.a(this.f736c, attributeSet, j.Spinner, i2, 0);
                this.f741h = a3.f(j.Spinner_android_dropDownWidth, -2);
                bVar.a(a3.b(j.Spinner_android_popupBackground));
                bVar.a((CharSequence) a2.d(j.Spinner_android_prompt));
                a3.a();
                this.f740g = bVar;
                this.f737d = new A(this, this, bVar);
            }
        }
        CharSequence[] f2 = a2.f(j.Spinner_android_entries);
        if (f2 != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, f2);
            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        a2.a();
        this.f739f = true;
        SpinnerAdapter spinnerAdapter = this.f738e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f738e = null;
        }
        this.f735b.a(attributeSet, i2);
    }
}
