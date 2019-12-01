package io.intercom.com.bumptech.glide.c;

import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.h.j;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker */
public final class r implements j {

    /* renamed from: a reason: collision with root package name */
    private final Set<h<?>> f9256a = Collections.newSetFromMap(new WeakHashMap());

    public void a(h<?> hVar) {
        this.f9256a.add(hVar);
    }

    public void b(h<?> hVar) {
        this.f9256a.remove(hVar);
    }

    public void onDestroy() {
        for (h onDestroy : j.a((Collection<T>) this.f9256a)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (h onStart : j.a((Collection<T>) this.f9256a)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (h onStop : j.a((Collection<T>) this.f9256a)) {
            onStop.onStop();
        }
    }

    public void a() {
        this.f9256a.clear();
    }

    public List<h<?>> b() {
        return j.a((Collection<T>) this.f9256a);
    }
}
