package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.C;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.g.i.B;
import b.g.i.C0240a;
import c.b.a.c.b;
import c.b.a.c.f;
import c.b.a.c.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;

/* compiled from: BottomSheetDialog */
public class h extends C {

    /* renamed from: c reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f6364c;

    /* renamed from: d reason: collision with root package name */
    boolean f6365d = true;

    /* renamed from: e reason: collision with root package name */
    private boolean f6366e = true;

    /* renamed from: f reason: collision with root package name */
    private boolean f6367f;

    /* renamed from: g reason: collision with root package name */
    private a f6368g = new g(this);

    public h(Context context, int i2) {
        super(context, b(context, i2));
        a(1);
    }

    private View a(int i2, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), c.b.a.c.h.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(f.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(f.design_bottom_sheet);
        this.f6364c = BottomSheetBehavior.b(frameLayout2);
        this.f6364c.a(this.f6368g);
        this.f6364c.b(this.f6365d);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f.touch_outside).setOnClickListener(new d(this));
        B.a((View) frameLayout2, (C0240a) new e(this));
        frameLayout2.setOnTouchListener(new f(this));
        return frameLayout;
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        if (!this.f6367f) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f6366e = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f6367f = true;
        }
        return this.f6366e;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f6364c;
        if (bottomSheetBehavior != null && bottomSheetBehavior.b() == 5) {
            this.f6364c.c(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f6365d != z) {
            this.f6365d = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f6364c;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.b(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f6365d) {
            this.f6365d = true;
        }
        this.f6366e = z;
        this.f6367f = true;
    }

    public void setContentView(int i2) {
        super.setContentView(a(i2, null, null));
    }

    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    private static int b(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(b.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return j.Theme_Design_Light_BottomSheetDialog;
    }
}
