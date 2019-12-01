package com.bumptech.glide.load.engine.b;

import android.content.Context;
import com.bumptech.glide.load.engine.b.d.a;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory */
class f implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Context f3957a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f3958b;

    f(Context context, String str) {
        this.f3957a = context;
        this.f3958b = str;
    }

    public File a() {
        File cacheDir = this.f3957a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.f3958b;
        return str != null ? new File(cacheDir, str) : cacheDir;
    }
}
