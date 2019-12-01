package com.bumptech.glide.load.engine.b;

import android.content.Context;

/* compiled from: InternalCacheDiskCacheFactory */
public final class g extends d {
    public g(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public g(Context context, String str, long j2) {
        super(new f(context, str), j2);
    }
}
