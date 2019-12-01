package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs */
final class C {

    /* renamed from: a reason: collision with root package name */
    private final Map<f, w<?>> f3856a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private final Map<f, w<?>> f3857b = new HashMap();

    C() {
    }

    /* access modifiers changed from: 0000 */
    public w<?> a(f fVar, boolean z) {
        return (w) a(z).get(fVar);
    }

    /* access modifiers changed from: 0000 */
    public void b(f fVar, w<?> wVar) {
        Map a2 = a(wVar.f());
        if (wVar.equals(a2.get(fVar))) {
            a2.remove(fVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(f fVar, w<?> wVar) {
        a(wVar.f()).put(fVar, wVar);
    }

    private Map<f, w<?>> a(boolean z) {
        return z ? this.f3857b : this.f3856a;
    }
}
