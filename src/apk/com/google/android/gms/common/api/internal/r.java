package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.C0299b.a;
import com.google.android.gms.common.b;
import java.util.Collections;

final class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ b f4619a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ c f4620b;

    r(c cVar, b bVar) {
        this.f4620b = cVar;
        this.f4619a = bVar;
    }

    public final void run() {
        if (this.f4619a.j()) {
            this.f4620b.f4599e = true;
            if (this.f4620b.f4595a.g()) {
                this.f4620b.a();
                return;
            }
            try {
                this.f4620b.f4595a.a(null, Collections.emptySet());
            } catch (SecurityException unused) {
                ((a) C0299b.this.m.get(this.f4620b.f4596b)).a(new b(10));
            }
        } else {
            ((a) C0299b.this.m.get(this.f4620b.f4596b)).a(this.f4619a);
        }
    }
}
