package io.intercom.com.bumptech.glide.c;

import io.intercom.com.bumptech.glide.h.j;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle */
class a implements i {

    /* renamed from: a reason: collision with root package name */
    private final Set<j> f9221a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    private boolean f9222b;

    /* renamed from: c reason: collision with root package name */
    private boolean f9223c;

    a() {
    }

    public void a(j jVar) {
        this.f9221a.remove(jVar);
    }

    public void b(j jVar) {
        this.f9221a.add(jVar);
        if (this.f9223c) {
            jVar.onDestroy();
        } else if (this.f9222b) {
            jVar.onStart();
        } else {
            jVar.onStop();
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        this.f9222b = false;
        for (j onStop : j.a((Collection<T>) this.f9221a)) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f9223c = true;
        for (j onDestroy : j.a((Collection<T>) this.f9221a)) {
            onDestroy.onDestroy();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f9222b = true;
        for (j onStart : j.a((Collection<T>) this.f9221a)) {
            onStart.onStart();
        }
    }
}
