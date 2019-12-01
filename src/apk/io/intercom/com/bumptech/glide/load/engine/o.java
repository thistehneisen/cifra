package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.c;

/* compiled from: DiskCacheStrategy */
class o extends q {
    o() {
    }

    public boolean a() {
        return false;
    }

    public boolean a(a aVar) {
        return false;
    }

    public boolean a(boolean z, a aVar, c cVar) {
        return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
    }

    public boolean b() {
        return true;
    }
}
