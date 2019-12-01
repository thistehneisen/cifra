package com.google.android.gms.common.api.internal;

import b.d.b;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.h;
import java.util.Map;
import java.util.Set;

public final class E {

    /* renamed from: a reason: collision with root package name */
    private final b<D<?>, com.google.android.gms.common.b> f4559a;

    /* renamed from: b reason: collision with root package name */
    private final b<D<?>, String> f4560b;

    /* renamed from: c reason: collision with root package name */
    private final h<Map<D<?>, String>> f4561c;

    /* renamed from: d reason: collision with root package name */
    private int f4562d;

    /* renamed from: e reason: collision with root package name */
    private boolean f4563e;

    public final Set<D<?>> a() {
        return this.f4559a.keySet();
    }

    public final void a(D<?> d2, com.google.android.gms.common.b bVar, String str) {
        this.f4559a.put(d2, bVar);
        this.f4560b.put(d2, str);
        this.f4562d--;
        if (!bVar.j()) {
            this.f4563e = true;
        }
        if (this.f4562d == 0) {
            if (this.f4563e) {
                this.f4561c.a((Exception) new AvailabilityException(this.f4559a));
                return;
            }
            this.f4561c.a(this.f4560b);
        }
    }
}
