package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class i {

    /* renamed from: a reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f4609a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    private final Map<h<?>, Boolean> f4610b = Collections.synchronizedMap(new WeakHashMap());

    /* access modifiers changed from: 0000 */
    public final boolean a() {
        return !this.f4609a.isEmpty() || !this.f4610b.isEmpty();
    }

    public final void b() {
        a(false, C0299b.f4569a);
    }

    public final void c() {
        a(true, z.f4637a);
    }

    private final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f4609a) {
            hashMap = new HashMap(this.f4609a);
        }
        synchronized (this.f4610b) {
            hashMap2 = new HashMap(this.f4610b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((h) entry2.getKey()).b((Exception) new ApiException(status));
            }
        }
    }
}
