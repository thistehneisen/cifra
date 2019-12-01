package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import b.g.i.C0240a;
import b.g.i.a.d;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class V extends C0240a {

    /* renamed from: d reason: collision with root package name */
    final RecyclerView f1860d;

    /* renamed from: e reason: collision with root package name */
    final C0240a f1861e = new a(this);

    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends C0240a {

        /* renamed from: d reason: collision with root package name */
        final V f1862d;

        public a(V v) {
            this.f1862d = v;
        }

        public void a(View view, d dVar) {
            super.a(view, dVar);
            if (!this.f1862d.c() && this.f1862d.f1860d.getLayoutManager() != null) {
                this.f1862d.f1860d.getLayoutManager().a(view, dVar);
            }
        }

        public boolean a(View view, int i2, Bundle bundle) {
            if (super.a(view, i2, bundle)) {
                return true;
            }
            if (this.f1862d.c() || this.f1862d.f1860d.getLayoutManager() == null) {
                return false;
            }
            return this.f1862d.f1860d.getLayoutManager().a(view, i2, bundle);
        }
    }

    public V(RecyclerView recyclerView) {
        this.f1860d = recyclerView;
    }

    public boolean a(View view, int i2, Bundle bundle) {
        if (super.a(view, i2, bundle)) {
            return true;
        }
        if (c() || this.f1860d.getLayoutManager() == null) {
            return false;
        }
        return this.f1860d.getLayoutManager().a(i2, bundle);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean c() {
        return this.f1860d.j();
    }

    public void a(View view, d dVar) {
        super.a(view, dVar);
        dVar.b((CharSequence) RecyclerView.class.getName());
        if (!c() && this.f1860d.getLayoutManager() != null) {
            this.f1860d.getLayoutManager().a(dVar);
        }
    }

    public C0240a b() {
        return this.f1861e;
    }
}
