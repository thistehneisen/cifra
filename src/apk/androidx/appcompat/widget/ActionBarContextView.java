package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import b.a.a;
import b.a.d.b;
import b.a.f;
import b.a.g;
import b.a.j;
import b.g.i.B;
import b.g.i.K;

public class ActionBarContextView extends C0153a {

    /* renamed from: i reason: collision with root package name */
    private CharSequence f710i;

    /* renamed from: j reason: collision with root package name */
    private CharSequence f711j;

    /* renamed from: k reason: collision with root package name */
    private View f712k;

    /* renamed from: l reason: collision with root package name */
    private View f713l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private int p;
    private int q;
    private boolean r;
    private int s;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.m == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            this.m = (LinearLayout) getChildAt(getChildCount() - 1);
            this.n = (TextView) this.m.findViewById(f.action_bar_title);
            this.o = (TextView) this.m.findViewById(f.action_bar_subtitle);
            if (this.p != 0) {
                this.n.setTextAppearance(getContext(), this.p);
            }
            if (this.q != 0) {
                this.o.setTextAppearance(getContext(), this.q);
            }
        }
        this.n.setText(this.f710i);
        this.o.setText(this.f711j);
        boolean z = !TextUtils.isEmpty(this.f710i);
        boolean z2 = !TextUtils.isEmpty(this.f711j);
        int i2 = 0;
        this.o.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.m;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
        if (this.m.getParent() == null) {
            addView(this.m);
        }
    }

    public /* bridge */ /* synthetic */ K a(int i2, long j2) {
        return super.a(i2, j2);
    }

    public boolean b() {
        return this.r;
    }

    public void c() {
        removeAllViews();
        this.f713l = null;
        this.f940c = null;
    }

    public boolean d() {
        C0165g gVar = this.f941d;
        if (gVar != null) {
            return gVar.i();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f711j;
    }

    public CharSequence getTitle() {
        return this.f710i;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0165g gVar = this.f941d;
        if (gVar != null) {
            gVar.e();
            this.f941d.f();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(ActionBarContextView.class.getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f710i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        boolean a2 = Ga.a(this);
        int paddingRight = a2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f712k;
        if (view == null || view.getVisibility() == 8) {
            i6 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f712k.getLayoutParams();
            int i7 = a2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = a2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a3 = C0153a.a(paddingRight, i7, a2);
            i6 = C0153a.a(a3 + a(this.f712k, a3, paddingTop, paddingTop2, a2), i8, a2);
        }
        LinearLayout linearLayout = this.m;
        if (!(linearLayout == null || this.f713l != null || linearLayout.getVisibility() == 8)) {
            i6 += a(this.m, i6, paddingTop, paddingTop2, a2);
        }
        int i9 = i6;
        View view2 = this.f713l;
        if (view2 != null) {
            a(view2, i9, paddingTop, paddingTop2, a2);
        }
        int paddingLeft = a2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f940c;
        if (actionMenuView != null) {
            a(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        String str = " can only be used ";
        int i4 = 1073741824;
        if (MeasureSpec.getMode(i2) != 1073741824) {
            StringBuilder sb = new StringBuilder();
            sb.append(ActionBarContextView.class.getSimpleName());
            sb.append(str);
            sb.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(sb.toString());
        } else if (MeasureSpec.getMode(i3) != 0) {
            int size = MeasureSpec.getSize(i2);
            int i5 = this.f942e;
            if (i5 <= 0) {
                i5 = MeasureSpec.getSize(i3);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i6 = i5 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
            View view = this.f712k;
            if (view != null) {
                int a2 = a(view, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f712k.getLayoutParams();
                paddingLeft = a2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f940c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = a(this.f940c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.m;
            if (linearLayout != null && this.f713l == null) {
                if (this.r) {
                    this.m.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.m.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.m.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f713l;
            if (view2 != null) {
                LayoutParams layoutParams = view2.getLayoutParams();
                int i7 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                int i8 = layoutParams.width;
                if (i8 >= 0) {
                    paddingLeft = Math.min(i8, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i4 = Integer.MIN_VALUE;
                }
                int i9 = layoutParams.height;
                if (i9 >= 0) {
                    i6 = Math.min(i9, i6);
                }
                this.f713l.measure(MeasureSpec.makeMeasureSpec(paddingLeft, i7), MeasureSpec.makeMeasureSpec(i6, i4));
            }
            if (this.f942e <= 0) {
                int childCount = getChildCount();
                int i10 = 0;
                for (int i11 = 0; i11 < childCount; i11++) {
                    int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i10) {
                        i10 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i10);
                return;
            }
            setMeasuredDimension(size, i5);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ActionBarContextView.class.getSimpleName());
            sb2.append(str);
            sb2.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(sb2.toString());
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i2) {
        this.f942e = i2;
    }

    public void setCustomView(View view) {
        View view2 = this.f713l;
        if (view2 != null) {
            removeView(view2);
        }
        this.f713l = view;
        if (view != null) {
            LinearLayout linearLayout = this.m;
            if (linearLayout != null) {
                removeView(linearLayout);
                this.m = null;
            }
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f711j = charSequence;
        e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f710i = charSequence;
        e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.r) {
            requestLayout();
        }
        this.r = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public void a(b bVar) {
        View view = this.f712k;
        if (view == null) {
            this.f712k = LayoutInflater.from(getContext()).inflate(this.s, this, false);
            addView(this.f712k);
        } else if (view.getParent() == null) {
            addView(this.f712k);
        }
        this.f712k.findViewById(f.action_mode_close_button).setOnClickListener(new C0157c(this, bVar));
        l lVar = (l) bVar.c();
        C0165g gVar = this.f941d;
        if (gVar != null) {
            gVar.c();
        }
        this.f941d = new C0165g(getContext());
        this.f941d.c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        lVar.a((v) this.f941d, this.f939b);
        this.f940c = (ActionMenuView) this.f941d.b((ViewGroup) this);
        B.a((View) this.f940c, (Drawable) null);
        addView(this.f940c, layoutParams);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        sa a2 = sa.a(context, attributeSet, j.ActionMode, i2, 0);
        B.a((View) this, a2.b(j.ActionMode_background));
        this.p = a2.g(j.ActionMode_titleTextStyle, 0);
        this.q = a2.g(j.ActionMode_subtitleTextStyle, 0);
        this.f942e = a2.f(j.ActionMode_height, 0);
        this.s = a2.g(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        a2.a();
    }

    public void a() {
        if (this.f712k == null) {
            c();
        }
    }
}
