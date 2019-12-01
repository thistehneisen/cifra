package io.intercom.com.bumptech.glide.load.engine.b;

import io.intercom.com.bumptech.glide.load.engine.b.a.C0112a;
import java.io.File;

/* compiled from: DiskLruCacheFactory */
public class d implements C0112a {

    /* renamed from: a reason: collision with root package name */
    private final long f9811a;

    /* renamed from: b reason: collision with root package name */
    private final a f9812b;

    /* compiled from: DiskLruCacheFactory */
    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.f9811a = j2;
        this.f9812b = aVar;
    }

    public a build() {
        File a2 = this.f9812b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f9811a);
        }
        return null;
    }
}
