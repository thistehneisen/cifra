package l.a.a;

import androidx.recyclerview.widget.RecyclerView.x;
import java.util.List;

/* compiled from: PositionAdapterDelegate */
public abstract class h<TViewHolder extends x> extends a<TViewHolder> {
    public long a(int i2) {
        return 0;
    }

    public long a(List<Object> list, int i2, int i3) {
        return a(i2);
    }

    public void a(TViewHolder tviewholder, int i2, List<Object> list) {
    }

    public abstract boolean b(int i2);

    public boolean b(List<Object> list, int i2, int i3) {
        return b(i2);
    }

    public void a(x xVar, List<Object> list, int i2, int i3, List<Object> list2) {
        a((TViewHolder) xVar, i2, list2);
    }
}
