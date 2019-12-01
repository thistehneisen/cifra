package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;

/* compiled from: ViewOffsetBehavior */
class h<V extends View> extends b<V> {

    /* renamed from: a reason: collision with root package name */
    private i f6291a;

    /* renamed from: b reason: collision with root package name */
    private int f6292b = 0;

    /* renamed from: c reason: collision with root package name */
    private int f6293c = 0;

    public h() {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        b(coordinatorLayout, v, i2);
        if (this.f6291a == null) {
            this.f6291a = new i(v);
        }
        this.f6291a.c();
        int i3 = this.f6292b;
        if (i3 != 0) {
            this.f6291a.b(i3);
            this.f6292b = 0;
        }
        int i4 = this.f6293c;
        if (i4 != 0) {
            this.f6291a.a(i4);
            this.f6293c = 0;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.c((View) v, i2);
    }

    public int b() {
        i iVar = this.f6291a;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i2) {
        i iVar = this.f6291a;
        if (iVar != null) {
            return iVar.b(i2);
        }
        this.f6292b = i2;
        return false;
    }
}
