package b.g.i;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.e.b.a.b;

/* compiled from: ViewGroup.kt */
public final class F implements Iterator<View>, b {

    /* renamed from: a reason: collision with root package name */
    private int f2647a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewGroup f2648b;

    F(ViewGroup viewGroup) {
        this.f2648b = viewGroup;
    }

    public boolean hasNext() {
        return this.f2647a < this.f2648b.getChildCount();
    }

    public void remove() {
        ViewGroup viewGroup = this.f2648b;
        this.f2647a--;
        viewGroup.removeViewAt(this.f2647a);
    }

    public View next() {
        ViewGroup viewGroup = this.f2648b;
        int i2 = this.f2647a;
        this.f2647a = i2 + 1;
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
