package com.touchin.vtb.views.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.u;
import kotlin.e.b.h;

/* compiled from: BottomDividerItemDecoration.kt */
public class b extends c {

    /* renamed from: h reason: collision with root package name */
    private final kotlin.e.a.b<Integer, Boolean> f7761h;

    /* renamed from: i reason: collision with root package name */
    private final int f7762i;

    /* renamed from: j reason: collision with root package name */
    private final int f7763j;

    /* renamed from: k reason: collision with root package name */
    private final boolean f7764k;

    public /* synthetic */ b(Context context, Integer num, kotlin.e.a.b bVar, int i2, int i3, boolean z, int i4, e eVar) {
        if ((i4 & 2) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i4 & 4) != 0) {
            bVar = a.f7760a;
        }
        this(context, num2, bVar, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? true : z);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.f7763j;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return this.f7764k;
    }

    /* access modifiers changed from: protected */
    public kotlin.e.a.b<Integer, Boolean> e() {
        return this.f7761h;
    }

    /* access modifiers changed from: protected */
    public int f() {
        return this.f7762i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        h.b(rect, "outRect");
        h.b(view, "view");
        h.b(recyclerView, "parent");
        h.b(uVar, "state");
        int f2 = recyclerView.f(view);
        if (d() && ((Boolean) e().a(Integer.valueOf(f2))).booleanValue() && f2 != uVar.a() - 1) {
            rect.set(0, 0, 0, b().getIntrinsicHeight());
        }
    }

    public int c(View view) {
        h.b(view, "child");
        return a().bottom + ((int) view.getTranslationY());
    }

    public int d(View view) {
        h.b(view, "child");
        return c(view) - b().getIntrinsicHeight();
    }

    public b(Context context, Integer num, kotlin.e.a.b<? super Integer, Boolean> bVar, int i2, int i3, boolean z) {
        h.b(context, "context");
        h.b(bVar, "predicate");
        super(context, num, bVar, i2, i3, z);
        this.f7761h = bVar;
        this.f7762i = i2;
        this.f7763j = i3;
        this.f7764k = z;
    }
}
