package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FlexLine */
public class c {

    /* renamed from: a reason: collision with root package name */
    int f4464a = Integer.MAX_VALUE;

    /* renamed from: b reason: collision with root package name */
    int f4465b = Integer.MAX_VALUE;

    /* renamed from: c reason: collision with root package name */
    int f4466c = Integer.MIN_VALUE;

    /* renamed from: d reason: collision with root package name */
    int f4467d = Integer.MIN_VALUE;

    /* renamed from: e reason: collision with root package name */
    int f4468e;

    /* renamed from: f reason: collision with root package name */
    int f4469f;

    /* renamed from: g reason: collision with root package name */
    int f4470g;

    /* renamed from: h reason: collision with root package name */
    int f4471h;

    /* renamed from: i reason: collision with root package name */
    int f4472i;

    /* renamed from: j reason: collision with root package name */
    float f4473j;

    /* renamed from: k reason: collision with root package name */
    float f4474k;

    /* renamed from: l reason: collision with root package name */
    int f4475l;
    int m;
    List<Integer> n = new ArrayList();
    int o;
    int p;

    c() {
    }

    public int a() {
        return this.f4470g;
    }

    public int b() {
        return this.f4471h;
    }

    public int c() {
        return this.f4471h - this.f4472i;
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, int i2, int i3, int i4, int i5) {
        b bVar = (b) view.getLayoutParams();
        this.f4464a = Math.min(this.f4464a, (view.getLeft() - bVar.e()) - i2);
        this.f4465b = Math.min(this.f4465b, (view.getTop() - bVar.f()) - i3);
        this.f4466c = Math.max(this.f4466c, view.getRight() + bVar.i() + i4);
        this.f4467d = Math.max(this.f4467d, view.getBottom() + bVar.d() + i5);
    }
}
