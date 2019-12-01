package com.bumptech.glide.c;

import com.bumptech.glide.f.a.h;
import com.bumptech.glide.h.n;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker */
public final class r implements j {

    /* renamed from: a reason: collision with root package name */
    private final Set<h<?>> f3387a = Collections.newSetFromMap(new WeakHashMap());

    public void a(h<?> hVar) {
        this.f3387a.add(hVar);
    }

    public void b(h<?> hVar) {
        this.f3387a.remove(hVar);
    }

    public void onDestroy() {
        for (h onDestroy : n.a((Collection<T>) this.f3387a)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (h onStart : n.a((Collection<T>) this.f3387a)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (h onStop : n.a((Collection<T>) this.f3387a)) {
            onStop.onStop();
        }
    }

    public void a() {
        this.f3387a.clear();
    }

    public List<h<?>> b() {
        return n.a((Collection<T>) this.f3387a);
    }
}
