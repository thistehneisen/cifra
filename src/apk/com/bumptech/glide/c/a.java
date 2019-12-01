package com.bumptech.glide.c;

import com.bumptech.glide.h.n;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle */
class a implements i {

    /* renamed from: a reason: collision with root package name */
    private final Set<j> f3352a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    private boolean f3353b;

    /* renamed from: c reason: collision with root package name */
    private boolean f3354c;

    a() {
    }

    public void a(j jVar) {
        this.f3352a.add(jVar);
        if (this.f3354c) {
            jVar.onDestroy();
        } else if (this.f3353b) {
            jVar.onStart();
        } else {
            jVar.onStop();
        }
    }

    public void b(j jVar) {
        this.f3352a.remove(jVar);
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        this.f3353b = false;
        for (j onStop : n.a((Collection<T>) this.f3352a)) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f3353b = true;
        for (j onStart : n.a((Collection<T>) this.f3352a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f3354c = true;
        for (j onDestroy : n.a((Collection<T>) this.f3352a)) {
            onDestroy.onDestroy();
        }
    }
}
