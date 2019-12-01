package l.a.a;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.x;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: DelegatesManager.kt */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final SparseArray<a<?>> f10363a = new SparseArray<>();

    public final long a(List<?> list, int i2, int i3) {
        h.b(list, "items");
        return a(b(list, i2, i3)).a(list, i2, i3);
    }

    public final int b(List<?> list, int i2, int i3) {
        h.b(list, "items");
        int size = this.f10363a.size();
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = (a) this.f10363a.valueAt(i4);
            if (aVar.b(list, i2, i3)) {
                h.a((Object) aVar, "delegate");
                return aVar.a();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Delegate not found for adapterPosition: ");
        sb.append(i2);
        throw new IllegalStateException(sb.toString());
    }

    public final x a(ViewGroup viewGroup, int i2) {
        h.b(viewGroup, "parent");
        x a2 = a(i2).a(viewGroup);
        h.a((Object) a2, "getDelegate(viewType).onCreateViewHolder(parent)");
        return a2;
    }

    public final void a(x xVar, List<?> list, int i2, int i3, List<? extends Object> list2) {
        h.b(xVar, "holder");
        h.b(list, "items");
        h.b(list2, "payloads");
        a(b(list, i2, i3)).a(xVar, list, i2, i3, list2);
    }

    public final void a(a<?> aVar) {
        h.b(aVar, "delegate");
        this.f10363a.put(aVar.a(), aVar);
    }

    private final a<?> a(int i2) {
        a<?> aVar = (a) this.f10363a.get(i2);
        if (aVar != null) {
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No AdapterDelegate added for view type: ");
        sb.append(i2);
        throw new IllegalStateException(sb.toString());
    }
}
