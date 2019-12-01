package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.c;

/* compiled from: DiskCacheStrategy */
class l extends q {
    l() {
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
