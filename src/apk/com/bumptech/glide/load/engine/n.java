package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

/* compiled from: DiskCacheStrategy */
class n extends s {
    n() {
    }

    public boolean a() {
        return true;
    }

    public boolean a(a aVar) {
        return aVar == a.REMOTE;
    }

    public boolean b() {
        return true;
    }

    public boolean a(boolean z, a aVar, c cVar) {
        return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
    }
}
