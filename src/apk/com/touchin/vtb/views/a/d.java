package com.touchin.vtb.views.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;
import b.g.i.G;
import com.touchin.vtb.views.a.d.a;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.e.a.b;
import kotlin.e.a.c;
import kotlin.m;

/* compiled from: GroupItemDecoration.kt */
public final class d<TViewHolder extends a> extends h {

    /* renamed from: a reason: collision with root package name */
    private final SparseArray<TViewHolder> f7772a;

    /* renamed from: b reason: collision with root package name */
    private final Rect f7773b;

    /* renamed from: c reason: collision with root package name */
    private final int f7774c;

    /* renamed from: d reason: collision with root package name */
    private final b<Integer, Boolean> f7775d;

    /* renamed from: e reason: collision with root package name */
    private final b<ViewGroup, TViewHolder> f7776e;

    /* renamed from: f reason: collision with root package name */
    private final c<Integer, TViewHolder, m> f7777f;

    /* compiled from: GroupItemDecoration.kt */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        private final View f7778a;

        public a(View view) {
            kotlin.e.b.h.b(view, "view");
            this.f7778a = view;
        }

        public final View a() {
            return this.f7778a;
        }

        public final <T extends View> T a(int i2) {
            T findViewById = this.f7778a.findViewById(i2);
            kotlin.e.b.h.a((Object) findViewById, "view.findViewById(resId)");
            return findViewById;
        }
    }

    public /* synthetic */ d(int i2, b bVar, b bVar2, c cVar, int i3, e eVar) {
        if ((i3 & 1) != 0) {
            i2 = 1;
        }
        this(i2, bVar, bVar2, cVar);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        kotlin.e.b.h.b(rect, "outRect");
        kotlin.e.b.h.b(view, "view");
        kotlin.e.b.h.b(recyclerView, "parent");
        kotlin.e.b.h.b(uVar, "state");
        int f2 = recyclerView.f(view);
        if (((Boolean) this.f7775d.a(Integer.valueOf(f2))).booleanValue()) {
            a aVar = (a) this.f7772a.get(f2);
            if (aVar == null) {
                aVar = (a) this.f7776e.a(recyclerView);
                this.f7772a.put(f2, aVar);
            }
            this.f7777f.a(Integer.valueOf(f2), aVar);
            View a2 = aVar.a();
            LayoutParams layoutParams = a2.getLayoutParams();
            if (layoutParams != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                a2.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(recyclerView.getMeasuredWidth(), 1073741824), recyclerView.getPaddingLeft() + recyclerView.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, a2.getLayoutParams().width), ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(recyclerView.getMeasuredHeight(), 1073741824), recyclerView.getPaddingTop() + recyclerView.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, a2.getLayoutParams().height));
                a2.layout(0, 0, a2.getMeasuredWidth(), a2.getMeasuredHeight());
                int i2 = this.f7774c;
                if (i2 == 0) {
                    rect.left = a2.getMeasuredWidth();
                } else if (i2 == 1) {
                    rect.top = a2.getMeasuredHeight();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        } else {
            this.f7772a.remove(f2);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, u uVar) {
        boolean z;
        kotlin.e.b.h.b(canvas, "canvas");
        kotlin.e.b.h.b(recyclerView, "parent");
        kotlin.e.b.h.b(uVar, "state");
        Iterator it = G.a(recyclerView).iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            View view = (View) it.next();
            int f2 = recyclerView.f(view);
            a aVar = (a) this.f7772a.get(f2);
            View a2 = aVar != null ? aVar.a() : null;
            if (((Boolean) this.f7775d.a(Integer.valueOf(f2))).booleanValue()) {
                if (a2 == null) {
                    break;
                }
                LayoutParams layoutParams = a2.getLayoutParams();
                if (layoutParams != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    recyclerView.a(view, this.f7773b);
                    canvas.save();
                    int i2 = this.f7774c;
                    if (i2 == 0) {
                        canvas.translate((float) this.f7773b.left, ((float) recyclerView.getPaddingTop()) + ((float) marginLayoutParams.topMargin));
                    } else if (i2 == 1) {
                        canvas.translate(((float) recyclerView.getPaddingLeft()) + ((float) marginLayoutParams.leftMargin), (float) this.f7773b.top);
                    }
                    a2.draw(canvas);
                    canvas.restore();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            } else if (a2 != null) {
                break;
            }
        }
        if (z) {
            recyclerView.m();
        }
    }

    public d(int i2, b<? super Integer, Boolean> bVar, b<? super ViewGroup, ? extends TViewHolder> bVar2, c<? super Integer, ? super TViewHolder, m> cVar) {
        kotlin.e.b.h.b(bVar, "predicate");
        kotlin.e.b.h.b(bVar2, "onCreateViewHolder");
        kotlin.e.b.h.b(cVar, "onBindViewHolder");
        this.f7774c = i2;
        this.f7775d = bVar;
        this.f7776e = bVar2;
        this.f7777f = cVar;
        this.f7772a = new SparseArray<>();
        this.f7773b = new Rect();
    }
}
