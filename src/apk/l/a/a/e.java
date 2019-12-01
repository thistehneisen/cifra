package l.a.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0216b;
import androidx.recyclerview.widget.C0220f;
import androidx.recyclerview.widget.C0232s;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.List;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.m;
import l.a.b.g;

/* compiled from: DelegationListAdapter.kt */
public class e<TItem> extends a<x> {

    /* renamed from: a reason: collision with root package name */
    private c<? super TItem, ? super x, m> f10364a;

    /* renamed from: b reason: collision with root package name */
    private final b f10365b;

    /* renamed from: c reason: collision with root package name */
    private C0220f<TItem> f10366c;

    public e(C0216b<TItem> bVar) {
        h.b(bVar, "config");
        this.f10365b = new b();
        this.f10366c = new C0220f<>(new g(this, new c(this)), bVar);
    }

    public int a() {
        return 0;
    }

    public final void a(c<? super TItem, ? super x, m> cVar) {
        this.f10364a = cVar;
    }

    public int b() {
        return 0;
    }

    public final c<TItem, x, m> c() {
        return this.f10364a;
    }

    public final List<TItem> d() {
        List<TItem> a2 = this.f10366c.a();
        h.a((Object) a2, "differ.currentList");
        return a2;
    }

    public int getItemCount() {
        return b() + d().size() + a();
    }

    public long getItemId(int i2) {
        return this.f10365b.a(d(), i2, d(i2));
    }

    public int getItemViewType(int i2) {
        return this.f10365b.b(d(), i2, d(i2));
    }

    public final void onBindViewHolder(x xVar, int i2) {
        h.b(xVar, "holder");
    }

    public void onBindViewHolder(x xVar, int i2, List<? extends Object> list) {
        h.b(xVar, "holder");
        h.b(list, "payloads");
        int d2 = d(i2);
        int size = d().size();
        if (d2 >= 0 && size > d2) {
            if (this.f10364a != null) {
                View view = xVar.itemView;
                h.a((Object) view, "holder.itemView");
                g.a(view, new d(this, xVar));
            } else {
                xVar.itemView.setOnClickListener(null);
            }
        }
        this.f10365b.a(xVar, d(), i2, d2, list);
    }

    public x onCreateViewHolder(ViewGroup viewGroup, int i2) {
        h.b(viewGroup, "parent");
        return this.f10365b.a(viewGroup, i2);
    }

    public final void a(a<?> aVar) {
        h.b(aVar, "delegate");
        this.f10365b.a(aVar);
    }

    public int d(int i2) {
        return i2 - b();
    }

    public final void a(List<? extends TItem> list) {
        h.b(list, AttributeType.LIST);
        this.f10366c.a(list);
    }

    public e(C0232s.c<TItem> cVar) {
        h.b(cVar, "diffCallback");
        C0216b a2 = new C0216b.a(cVar).a();
        h.a((Object) a2, "AsyncDifferConfig.Builde…em>(diffCallback).build()");
        this(a2);
    }
}
