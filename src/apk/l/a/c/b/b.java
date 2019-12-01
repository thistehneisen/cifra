package l.a.c.b;

import androidx.lifecycle.v;

/* compiled from: SingleLiveEvent.kt */
final class b<T> implements v<T> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f10382a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ v f10383b;

    b(c cVar, v vVar) {
        this.f10382a = cVar;
        this.f10383b = vVar;
    }

    public final void a(T t) {
        if (this.f10382a.f10384k.compareAndSet(true, false)) {
            this.f10383b.a(t);
        }
    }
}
