package com.touchin.vtb.views.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;
import b.g.a.a.i;
import b.g.i.G;
import kotlin.e.a.b;
import l.a.d.a.b.a.C0122a;

/* compiled from: DividerItemDecoration.kt */
public abstract class c extends h {

    /* renamed from: a reason: collision with root package name */
    private final Rect f7765a = new Rect();

    /* renamed from: b reason: collision with root package name */
    private final Drawable f7766b;

    /* renamed from: c reason: collision with root package name */
    private final Context f7767c;

    /* renamed from: d reason: collision with root package name */
    private final b<Integer, Boolean> f7768d;

    /* renamed from: e reason: collision with root package name */
    private final int f7769e;

    /* renamed from: f reason: collision with root package name */
    private final int f7770f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f7771g;

    public c(Context context, Integer num, b<? super Integer, Boolean> bVar, int i2, int i3, boolean z) {
        kotlin.e.b.h.b(context, "context");
        kotlin.e.b.h.b(bVar, "predicate");
        this.f7767c = context;
        this.f7768d = bVar;
        this.f7769e = i2;
        this.f7770f = i3;
        this.f7771g = z;
        if (num == null) {
            TypedArray obtainStyledAttributes = this.f7767c.obtainStyledAttributes(new int[]{16843284});
            this.f7766b = i.a(obtainStyledAttributes, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        Drawable drawable = this.f7767c.getDrawable(num.intValue());
        if (drawable != null) {
            this.f7766b = drawable;
        } else {
            kotlin.e.b.h.a();
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final Rect a() {
        return this.f7765a;
    }

    /* access modifiers changed from: protected */
    public final Drawable b() {
        return this.f7766b;
    }

    /* access modifiers changed from: protected */
    public abstract int c();

    public abstract int c(View view);

    public abstract int d(View view);

    /* access modifiers changed from: protected */
    public abstract boolean d();

    /* access modifiers changed from: protected */
    public abstract b<Integer, Boolean> e();

    /* access modifiers changed from: protected */
    public abstract int f();

    public void onDraw(Canvas canvas, RecyclerView recyclerView, u uVar) {
        kotlin.e.b.h.b(canvas, "canvas");
        kotlin.e.b.h.b(recyclerView, "parent");
        kotlin.e.b.h.b(uVar, "state");
        if (d()) {
            a(canvas, recyclerView, uVar);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, u uVar) {
        kotlin.e.b.h.b(canvas, "canvas");
        kotlin.e.b.h.b(recyclerView, "parent");
        kotlin.e.b.h.b(uVar, "state");
        if (!d()) {
            a(canvas, recyclerView, uVar);
        }
    }

    private final void a(Canvas canvas, RecyclerView recyclerView, u uVar) {
        canvas.save();
        for (View view : G.a(recyclerView)) {
            int f2 = recyclerView.f(view);
            if (((Boolean) e().a(Integer.valueOf(f2))).booleanValue() && f2 != uVar.a() - 1) {
                recyclerView.a(view, this.f7765a);
                this.f7766b.setBounds(this.f7765a.left + ((int) C0122a.a(this.f7767c, (float) f())), d(view), this.f7765a.right - ((int) C0122a.a(this.f7767c, (float) c())), c(view));
                this.f7766b.draw(canvas);
            }
        }
        canvas.restore();
    }
}
