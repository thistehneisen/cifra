package io.intercom.com.bumptech.glide.load.engine.b;

import android.content.Context;
import io.intercom.com.bumptech.glide.load.engine.b.d.a;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory */
class f implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Context f9818a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ String f9819b;

    f(Context context, String str) {
        this.f9818a = context;
        this.f9819b = str;
    }

    public File a() {
        File cacheDir = this.f9818a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.f9819b;
        return str != null ? new File(cacheDir, str) : cacheDir;
    }
}
