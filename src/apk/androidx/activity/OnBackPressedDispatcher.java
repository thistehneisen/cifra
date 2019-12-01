package androidx.activity;

import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a reason: collision with root package name */
    private final Runnable f367a;

    /* renamed from: b reason: collision with root package name */
    final ArrayDeque<d> f368b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements j, a {

        /* renamed from: a reason: collision with root package name */
        private final h f369a;

        /* renamed from: b reason: collision with root package name */
        private final d f370b;

        /* renamed from: c reason: collision with root package name */
        private a f371c;

        LifecycleOnBackPressedCancellable(h hVar, d dVar) {
            this.f369a = hVar;
            this.f370b = dVar;
            hVar.a(this);
        }

        public void a(l lVar, androidx.lifecycle.h.a aVar) {
            if (aVar == androidx.lifecycle.h.a.ON_START) {
                this.f371c = OnBackPressedDispatcher.this.a(this.f370b);
            } else if (aVar == androidx.lifecycle.h.a.ON_STOP) {
                a aVar2 = this.f371c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            } else if (aVar == androidx.lifecycle.h.a.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.f369a.b(this);
            this.f370b.b(this);
            a aVar = this.f371c;
            if (aVar != null) {
                aVar.cancel();
                this.f371c = null;
            }
        }
    }

    private class a implements a {

        /* renamed from: a reason: collision with root package name */
        private final d f373a;

        a(d dVar) {
            this.f373a = dVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f368b.remove(this.f373a);
            this.f373a.b(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f367a = runnable;
    }

    /* access modifiers changed from: 0000 */
    public a a(d dVar) {
        this.f368b.add(dVar);
        a aVar = new a(dVar);
        dVar.a((a) aVar);
        return aVar;
    }

    public void a(l lVar, d dVar) {
        h lifecycle = lVar.getLifecycle();
        if (lifecycle.a() != b.DESTROYED) {
            dVar.a((a) new LifecycleOnBackPressedCancellable(lifecycle, dVar));
        }
    }

    public void a() {
        Iterator descendingIterator = this.f368b.descendingIterator();
        while (descendingIterator.hasNext()) {
            d dVar = (d) descendingIterator.next();
            if (dVar.b()) {
                dVar.a();
                return;
            }
        }
        Runnable runnable = this.f367a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
