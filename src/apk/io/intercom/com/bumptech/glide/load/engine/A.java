package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs */
final class A {

    /* renamed from: a reason: collision with root package name */
    private final Map<g, u<?>> f9718a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private final Map<g, u<?>> f9719b = new HashMap();

    A() {
    }

    /* access modifiers changed from: 0000 */
    public u<?> a(g gVar, boolean z) {
        return (u) a(z).get(gVar);
    }

    /* access modifiers changed from: 0000 */
    public void b(g gVar, u<?> uVar) {
        Map a2 = a(uVar.f());
        if (uVar.equals(a2.get(gVar))) {
            a2.remove(gVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar, u<?> uVar) {
        a(uVar.f()).put(gVar, uVar);
    }

    private Map<g, u<?>> a(boolean z) {
        return z ? this.f9719b : this.f9718a;
    }
}
