package com.google.android.material.appbar;

import android.view.View;
import b.g.i.B;

/* compiled from: ViewOffsetHelper */
class i {

    /* renamed from: a reason: collision with root package name */
    private final View f6294a;

    /* renamed from: b reason: collision with root package name */
    private int f6295b;

    /* renamed from: c reason: collision with root package name */
    private int f6296c;

    /* renamed from: d reason: collision with root package name */
    private int f6297d;

    /* renamed from: e reason: collision with root package name */
    private int f6298e;

    public i(View view) {
        this.f6294a = view;
    }

    private void d() {
        View view = this.f6294a;
        B.c(view, this.f6297d - (view.getTop() - this.f6295b));
        View view2 = this.f6294a;
        B.b(view2, this.f6298e - (view2.getLeft() - this.f6296c));
    }

    public boolean a(int i2) {
        if (this.f6298e == i2) {
            return false;
        }
        this.f6298e = i2;
        d();
        return true;
    }

    public boolean b(int i2) {
        if (this.f6297d == i2) {
            return false;
        }
        this.f6297d = i2;
        d();
        return true;
    }

    public void c() {
        this.f6295b = this.f6294a.getTop();
        this.f6296c = this.f6294a.getLeft();
        d();
    }

    public int a() {
        return this.f6295b;
    }

    public int b() {
        return this.f6297d;
    }
}
