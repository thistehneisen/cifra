package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.w.a;
import androidx.appcompat.widget.Aa;
import androidx.appcompat.widget.O;
import androidx.core.widget.j;
import b.g.a.a.h;
import b.g.i.B;
import b.g.i.C0240a;
import c.b.a.c.d;
import c.b.a.c.e;
import c.b.a.c.f;

public class NavigationMenuItemView extends h implements a {
    private static final int[] v = {16842912};
    private FrameLayout A;
    private p B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final C0240a F;
    private final int w;
    private boolean x;
    boolean y;
    private final CheckedTextView z;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void b() {
        if (d()) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                O.a aVar = (O.a) frameLayout.getLayoutParams();
                aVar.width = -1;
                this.A.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.z.setVisibility(0);
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            O.a aVar2 = (O.a) frameLayout2.getLayoutParams();
            aVar2.width = -2;
            this.A.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(b.a.a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(v, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean d() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(f.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    public void a(p pVar, int i2) {
        this.B = pVar;
        setVisibility(pVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            B.a((View) this, (Drawable) c());
        }
        setCheckable(pVar.isCheckable());
        setChecked(pVar.isChecked());
        setEnabled(pVar.isEnabled());
        setTitle(pVar.getTitle());
        setIcon(pVar.getIcon());
        setActionView(pVar.getActionView());
        setContentDescription(pVar.getContentDescription());
        Aa.a(this, pVar.getTooltipText());
        b();
    }

    public boolean a() {
        return false;
    }

    public p getItemData() {
        return this.B;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        p pVar = this.B;
        if (pVar != null && pVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, v);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.y != z2) {
            this.y = z2;
            this.F.a((View) this.z, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.z.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.C);
            }
            int i2 = this.w;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.x) {
            if (this.E == null) {
                this.E = h.a(getResources(), e.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.E;
                if (drawable2 != null) {
                    int i3 = this.w;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.E;
        }
        j.a(this.z, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.z.setCompoundDrawablePadding(i2);
    }

    /* access modifiers changed from: 0000 */
    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = this.C != null;
        p pVar = this.B;
        if (pVar != null) {
            setIcon(pVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.x = z2;
    }

    public void setTextAppearance(int i2) {
        j.d(this.z, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.F = new i(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(c.b.a.c.h.design_navigation_menu_item, this, true);
        this.w = context.getResources().getDimensionPixelSize(d.design_navigation_icon_size);
        this.z = (CheckedTextView) findViewById(f.design_menu_item_text);
        this.z.setDuplicateParentStateEnabled(true);
        B.a((View) this.z, this.F);
    }
}
