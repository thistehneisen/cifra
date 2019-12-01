package io.intercom.com.bumptech.glide.c;

import io.intercom.com.bumptech.glide.f.c;
import io.intercom.com.bumptech.glide.h.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class p {

    /* renamed from: a reason: collision with root package name */
    private final Set<c> f9246a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    private final List<c> f9247b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private boolean f9248c;

    public boolean a(c cVar) {
        return a(cVar, true);
    }

    public void b(c cVar) {
        this.f9246a.add(cVar);
        if (!this.f9248c) {
            cVar.e();
        } else {
            this.f9247b.add(cVar);
        }
    }

    public void c() {
        for (c cVar : j.a((Collection<T>) this.f9246a)) {
            if (!cVar.isComplete() && !cVar.isCancelled()) {
                cVar.pause();
                if (!this.f9248c) {
                    cVar.e();
                } else {
                    this.f9247b.add(cVar);
                }
            }
        }
    }

    public void d() {
        this.f9248c = false;
        for (c cVar : j.a((Collection<T>) this.f9246a)) {
            if (!cVar.isComplete() && !cVar.isCancelled() && !cVar.isRunning()) {
                cVar.e();
            }
        }
        this.f9247b.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.f9246a.size());
        sb.append(", isPaused=");
        sb.append(this.f9248c);
        sb.append("}");
        return sb.toString();
    }

    private boolean a(c cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f9246a.remove(cVar);
        if (!this.f9247b.remove(cVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            cVar.clear();
            if (z) {
                cVar.a();
            }
        }
        return z2;
    }

    public void b() {
        this.f9248c = true;
        for (c cVar : j.a((Collection<T>) this.f9246a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f9247b.add(cVar);
            }
        }
    }

    public void a() {
        for (c a2 : j.a((Collection<T>) this.f9246a)) {
            a(a2, false);
        }
        this.f9247b.clear();
    }
}
