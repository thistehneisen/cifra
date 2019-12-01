package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.load.engine.b.a.C0056a;
import java.io.File;

/* compiled from: DiskLruCacheFactory */
public class d implements C0056a {

    /* renamed from: a reason: collision with root package name */
    private final long f3950a;

    /* renamed from: b reason: collision with root package name */
    private final a f3951b;

    /* compiled from: DiskLruCacheFactory */
    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.f3950a = j2;
        this.f3951b = aVar;
    }

    public a build() {
        File a2 = this.f3951b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f3950a);
        }
        return null;
    }
}
