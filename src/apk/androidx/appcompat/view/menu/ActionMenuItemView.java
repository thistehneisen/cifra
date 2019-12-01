package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.Aa;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.N;
import b.a.j;

public class ActionMenuItemView extends AppCompatTextView implements androidx.appcompat.view.menu.w.a, OnClickListener, androidx.appcompat.widget.ActionMenuView.a {

    /* renamed from: a reason: collision with root package name */
    p f544a;

    /* renamed from: b reason: collision with root package name */
    private CharSequence f545b;

    /* renamed from: c reason: collision with root package name */
    private Drawable f546c;

    /* renamed from: d reason: collision with root package name */
    androidx.appcompat.view.menu.l.b f547d;

    /* renamed from: e reason: collision with root package name */
    private N f548e;

    /* renamed from: f reason: collision with root package name */
    b f549f;

    /* renamed from: g reason: collision with root package name */
    private boolean f550g;

    /* renamed from: h reason: collision with root package name */
    private boolean f551h;

    /* renamed from: i reason: collision with root package name */
    private int f552i;

    /* renamed from: j reason: collision with root package name */
    private int f553j;

    /* renamed from: k reason: collision with root package name */
    private int f554k;

    private class a extends N {
        public a() {
            super(ActionMenuItemView.this);
        }

        public z a() {
            b bVar = ActionMenuItemView.this.f549f;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            androidx.appcompat.view.menu.l.b bVar = actionMenuItemView.f547d;
            if (bVar == null || !bVar.a(actionMenuItemView.f544a)) {
                return false;
            }
            z a2 = a();
            if (a2 == null || !a2.c()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class b {
        public abstract z a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void f() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f545b);
        if (this.f546c != null && (!this.f544a.n() || (!this.f550g && !this.f551h))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.f545b : null);
        CharSequence contentDescription = this.f544a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f544a.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f544a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f544a.getTitle();
            }
            Aa.a(this, charSequence2);
            return;
        }
        Aa.a(this, tooltipText);
    }

    public void a(p pVar, int i2) {
        this.f544a = pVar;
        setIcon(pVar.getIcon());
        setTitle(pVar.a((androidx.appcompat.view.menu.w.a) this));
        setId(pVar.getItemId());
        setVisibility(pVar.isVisible() ? 0 : 8);
        setEnabled(pVar.isEnabled());
        if (pVar.hasSubMenu() && this.f548e == null) {
            this.f548e = new a();
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return d();
    }

    public boolean c() {
        return d() && this.f544a.getIcon() == null;
    }

    public boolean d() {
        return !TextUtils.isEmpty(getText());
    }

    public p getItemData() {
        return this.f544a;
    }

    public void onClick(View view) {
        androidx.appcompat.view.menu.l.b bVar = this.f547d;
        if (bVar != null) {
            bVar.a(this.f544a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f550g = e();
        f();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean d2 = d();
        if (d2) {
            int i4 = this.f553j;
            if (i4 >= 0) {
                super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
        }
        super.onMeasure(i2, i3);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f552i) : this.f552i;
        if (mode != 1073741824 && this.f552i > 0 && measuredWidth < min) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!d2 && this.f546c != null) {
            super.setPadding((getMeasuredWidth() - this.f546c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f544a.hasSubMenu()) {
            N n = this.f548e;
            if (n != null && n.onTouch(this, motionEvent)) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f551h != z) {
            this.f551h = z;
            p pVar = this.f544a;
            if (pVar != null) {
                pVar.b();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f546c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.f554k;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            int i3 = this.f554k;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i3) / ((float) intrinsicHeight)));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public void setItemInvoker(androidx.appcompat.view.menu.l.b bVar) {
        this.f547d = bVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f553j = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f549f = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f545b = charSequence;
        f();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f550g = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMenuItemView, i2, 0);
        this.f552i = obtainStyledAttributes.getDimensionPixelSize(j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f554k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f553j = -1;
        setSaveEnabled(false);
    }
}
