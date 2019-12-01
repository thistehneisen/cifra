package c.e.a.a;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;

/* compiled from: StickHeaderItemDecoration */
public class a extends h {

    /* renamed from: a reason: collision with root package name */
    private C0042a f3262a;

    /* renamed from: b reason: collision with root package name */
    private int f3263b;

    /* renamed from: c.e.a.a.a$a reason: collision with other inner class name */
    /* compiled from: StickHeaderItemDecoration */
    public interface C0042a {
        void a(View view, int i2);

        boolean a(int i2);

        int b(int i2);

        int c(int i2);
    }

    public a(C0042a aVar) {
        this.f3262a = aVar;
    }

    private View a(int i2, RecyclerView recyclerView) {
        View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(this.f3262a.b(i2), recyclerView, false);
        this.f3262a.a(inflate, i2);
        return inflate;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, u uVar) {
        super.onDrawOver(canvas, recyclerView, uVar);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null) {
            int f2 = recyclerView.f(childAt);
            if (f2 != -1) {
                int c2 = this.f3262a.c(f2);
                View a2 = a(c2, recyclerView);
                a((ViewGroup) recyclerView, a2);
                View a3 = a(recyclerView, a2.getBottom(), c2);
                if (a3 == null || !this.f3262a.a(recyclerView.f(a3))) {
                    a(canvas, a2);
                } else {
                    a(canvas, a2, a3);
                }
            }
        }
    }

    private void a(Canvas canvas, View view) {
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        view.draw(canvas);
        canvas.restore();
    }

    private void a(Canvas canvas, View view, View view2) {
        canvas.save();
        canvas.translate(0.0f, (float) (view2.getTop() - view.getHeight()));
        view.draw(canvas);
        canvas.restore();
    }

    private View a(RecyclerView recyclerView, int i2, int i3) {
        int i4;
        int i5 = 0;
        while (i5 < recyclerView.getChildCount()) {
            View childAt = recyclerView.getChildAt(i5);
            int height = (i3 == i5 || !this.f3262a.a(recyclerView.f(childAt))) ? 0 : this.f3263b - childAt.getHeight();
            if (childAt.getTop() > 0) {
                i4 = childAt.getBottom() + height;
            } else {
                i4 = childAt.getBottom();
            }
            if (i4 > i2 && childAt.getTop() <= i2) {
                return childAt;
            }
            i5++;
        }
        return null;
    }

    private void a(ViewGroup viewGroup, View view) {
        view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getHeight(), 0), viewGroup.getPaddingTop() + viewGroup.getPaddingBottom(), view.getLayoutParams().height));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        this.f3263b = measuredHeight;
        view.layout(0, 0, measuredWidth, measuredHeight);
    }
}
