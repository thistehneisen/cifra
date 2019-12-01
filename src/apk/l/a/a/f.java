package l.a.a;

import androidx.recyclerview.widget.RecyclerView.x;
import java.util.List;

/* compiled from: ItemAdapterDelegate */
public abstract class f<TViewHolder extends x, TItem> extends a<TViewHolder> {
    public long a(TItem titem, int i2, int i3) {
        return 0;
    }

    public long a(List<Object> list, int i2, int i3) {
        return a((TItem) list.get(i3), i2, i3);
    }

    public abstract void a(TViewHolder tviewholder, TItem titem, int i2, int i3, List<Object> list);

    public boolean b(Object obj, int i2, int i3) {
        return true;
    }

    public boolean b(List<Object> list, int i2, int i3) {
        return i3 >= 0 && i3 < list.size() && b(list.get(i3), i2, i3);
    }

    public void a(x xVar, List<Object> list, int i2, int i3, List<Object> list2) {
        a((TViewHolder) xVar, (TItem) list.get(i3), i2, i3, list2);
    }
}
