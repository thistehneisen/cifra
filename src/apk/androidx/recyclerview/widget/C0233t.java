package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;

/* renamed from: androidx.recyclerview.widget.t reason: case insensitive filesystem */
/* compiled from: DividerItemDecoration */
public class C0233t extends h {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1992a = {16843284};

    /* renamed from: b reason: collision with root package name */
    private Drawable f1993b;

    /* renamed from: c reason: collision with root package name */
    private int f1994c;

    /* renamed from: d reason: collision with root package name */
    private final Rect f1995d = new Rect();

    public C0233t(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1992a);
        this.f1993b = obtainStyledAttributes.getDrawable(0);
        if (this.f1993b == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        a(i2);
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft();
            i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = recyclerView.getWidth();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.a(childAt, this.f1995d);
            int round = this.f1995d.bottom + Math.round(childAt.getTranslationY());
            this.f1993b.setBounds(i3, round - this.f1993b.getIntrinsicHeight(), i2, round);
            this.f1993b.draw(canvas);
        }
        canvas.restore();
    }

    public void a(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f1994c = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
        Drawable drawable = this.f1993b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (this.f1994c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, u uVar) {
        if (recyclerView.getLayoutManager() != null && this.f1993b != null) {
            if (this.f1994c == 1) {
                b(canvas, recyclerView);
            } else {
                a(canvas, recyclerView);
            }
        }
    }

    public void a(Drawable drawable) {
        if (drawable != null) {
            this.f1993b = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingTop();
            i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i3, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
        } else {
            i2 = recyclerView.getHeight();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getLayoutManager().b(childAt, this.f1995d);
            int round = this.f1995d.right + Math.round(childAt.getTranslationX());
            this.f1993b.setBounds(round - this.f1993b.getIntrinsicWidth(), i3, round, i2);
            this.f1993b.draw(canvas);
        }
        canvas.restore();
    }
}
