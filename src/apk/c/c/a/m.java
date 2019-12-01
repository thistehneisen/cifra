package c.c.a;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.A;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ItemTouchUIUtilImpl */
class m implements A {
    m() {
    }

    private void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3) {
        canvas.save();
        canvas.translate(f2, f3);
        recyclerView.drawChild(canvas, view, 0);
        canvas.restore();
    }

    public void b(View view) {
        view.setVisibility(4);
    }

    public void a(View view) {
        view.setVisibility(0);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z) {
        if (i2 == 2) {
            a(canvas, recyclerView, view, f2, f3);
        }
    }
}
