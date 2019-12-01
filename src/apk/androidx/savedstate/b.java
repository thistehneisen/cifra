package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;

/* compiled from: SavedStateRegistryController */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final c f2060a;

    /* renamed from: b reason: collision with root package name */
    private final a f2061b = new a();

    private b(c cVar) {
        this.f2060a = cVar;
    }

    public a a() {
        return this.f2061b;
    }

    public void b(Bundle bundle) {
        this.f2061b.a(bundle);
    }

    public void a(Bundle bundle) {
        h lifecycle = this.f2060a.getLifecycle();
        if (lifecycle.a() == androidx.lifecycle.h.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f2060a));
            this.f2061b.a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}
