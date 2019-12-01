package com.bumptech.glide.c;

import android.util.Log;
import com.bumptech.glide.f.c;
import com.bumptech.glide.h.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class p {

    /* renamed from: a reason: collision with root package name */
    private final Set<c> f3377a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    private final List<c> f3378b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private boolean f3379c;

    public boolean a(c cVar) {
        return a(cVar, true);
    }

    public void b(c cVar) {
        this.f3377a.add(cVar);
        if (!this.f3379c) {
            cVar.e();
            return;
        }
        cVar.clear();
        String str = "RequestTracker";
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "Paused, delaying request");
        }
        this.f3378b.add(cVar);
    }

    public void c() {
        for (c cVar : n.a((Collection<T>) this.f3377a)) {
            if (!cVar.isComplete() && !cVar.f()) {
                cVar.clear();
                if (!this.f3379c) {
                    cVar.e();
                } else {
                    this.f3378b.add(cVar);
                }
            }
        }
    }

    public void d() {
        this.f3379c = false;
        for (c cVar : n.a((Collection<T>) this.f3377a)) {
            if (!cVar.isComplete() && !cVar.isRunning()) {
                cVar.e();
            }
        }
        this.f3378b.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.f3377a.size());
        sb.append(", isPaused=");
        sb.append(this.f3379c);
        sb.append("}");
        return sb.toString();
    }

    private boolean a(c cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f3377a.remove(cVar);
        if (!this.f3378b.remove(cVar) && !remove) {
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

    public void a() {
        for (c a2 : n.a((Collection<T>) this.f3377a)) {
            a(a2, false);
        }
        this.f3378b.clear();
    }

    public void b() {
        this.f3379c = true;
        for (c cVar : n.a((Collection<T>) this.f3377a)) {
            if (cVar.isRunning()) {
                cVar.clear();
                this.f3378b.add(cVar);
            }
        }
    }
}
