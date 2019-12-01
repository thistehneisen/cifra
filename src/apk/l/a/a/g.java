package l.a.a;

import androidx.recyclerview.widget.E;
import androidx.recyclerview.widget.RecyclerView.a;
import kotlin.e.b.h;

/* compiled from: OffsetAdapterUpdateCallback.kt */
public final class g implements E {

    /* renamed from: a reason: collision with root package name */
    private final a<?> f10367a;

    /* renamed from: b reason: collision with root package name */
    private final kotlin.e.a.a<Integer> f10368b;

    public g(a<?> aVar, kotlin.e.a.a<Integer> aVar2) {
        h.b(aVar, "adapter");
        h.b(aVar2, "offsetProvider");
        this.f10367a = aVar;
        this.f10368b = aVar2;
    }

    public void a(int i2, int i3) {
        this.f10367a.notifyItemMoved(i2 + ((Number) this.f10368b.b()).intValue(), i3 + ((Number) this.f10368b.b()).intValue());
    }

    public void b(int i2, int i3) {
        this.f10367a.notifyItemRangeInserted(i2 + ((Number) this.f10368b.b()).intValue(), i3);
    }

    public void c(int i2, int i3) {
        this.f10367a.notifyItemRangeRemoved(i2 + ((Number) this.f10368b.b()).intValue(), i3);
    }

    public void a(int i2, int i3, Object obj) {
        this.f10367a.notifyItemRangeChanged(i2 + ((Number) this.f10368b.b()).intValue(), i3, obj);
    }
}
