package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import c.b.a.c.j;
import c.b.a.c.k;
import com.google.android.material.internal.g;
import com.google.android.material.internal.l;

public class ChipGroup extends g {

    /* renamed from: d reason: collision with root package name */
    private int f6379d;

    /* renamed from: e reason: collision with root package name */
    private int f6380e;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public boolean f6381f;

    /* renamed from: g reason: collision with root package name */
    private c f6382g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final a f6383h;

    /* renamed from: i reason: collision with root package name */
    private d f6384i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public int f6385j;
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public boolean f6386k;

    private class a implements OnCheckedChangeListener {
        private a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!ChipGroup.this.f6386k) {
                int id = compoundButton.getId();
                if (z) {
                    if (!(ChipGroup.this.f6385j == -1 || ChipGroup.this.f6385j == id || !ChipGroup.this.f6381f)) {
                        ChipGroup chipGroup = ChipGroup.this;
                        chipGroup.a(chipGroup.f6385j, false);
                    }
                    ChipGroup.this.setCheckedId(id);
                } else if (ChipGroup.this.f6385j == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            }
        }
    }

    public static class b extends MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }
    }

    public interface c {
        void a(ChipGroup chipGroup, int i2);
    }

    private class d implements OnHierarchyChangeListener {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public OnHierarchyChangeListener f6388a;

        private d() {
        }

        public void onChildViewAdded(View view, View view2) {
            int i2;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (VERSION.SDK_INT >= 17) {
                        i2 = View.generateViewId();
                    } else {
                        i2 = view2.hashCode();
                    }
                    view2.setId(i2);
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.f6383h);
            }
            OnHierarchyChangeListener onHierarchyChangeListener = this.f6388a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            OnHierarchyChangeListener onHierarchyChangeListener = this.f6388a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i2) {
        this.f6385j = i2;
        c cVar = this.f6382g;
        if (cVar != null && this.f6381f) {
            cVar.a(this, i2);
        }
    }

    public void addView(View view, int i2, LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.f6385j;
                if (i3 != -1 && this.f6381f) {
                    a(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f6381f) {
            return this.f6385j;
        }
        return -1;
    }

    public int getChipSpacingHorizontal() {
        return this.f6379d;
    }

    public int getChipSpacingVertical() {
        return this.f6380e;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f6385j;
        if (i2 != -1) {
            a(i2, true);
            setCheckedId(this.f6385j);
        }
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.f6379d != i2) {
            this.f6379d = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(int i2) {
        if (this.f6380e != i2) {
            this.f6380e = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.f6382g = cVar;
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f6384i.f6388a = onHierarchyChangeListener;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z) {
        if (this.f6381f != z) {
            this.f6381f = z;
            b();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.b.a.c.b.chipGroupStyle);
    }

    public void b() {
        this.f6386k = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f6386k = false;
        setCheckedId(-1);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6383h = new a();
        this.f6384i = new d();
        this.f6385j = -1;
        this.f6386k = false;
        TypedArray a2 = l.a(context, attributeSet, k.ChipGroup, i2, j.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(k.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(k.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(a2.getDimensionPixelOffset(k.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(a2.getBoolean(k.ChipGroup_singleLine, false));
        setSingleSelection(a2.getBoolean(k.ChipGroup_singleSelection, false));
        int resourceId = a2.getResourceId(k.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.f6385j = resourceId;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.f6384i);
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.f6386k = true;
            ((Chip) findViewById).setChecked(z);
            this.f6386k = false;
        }
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
