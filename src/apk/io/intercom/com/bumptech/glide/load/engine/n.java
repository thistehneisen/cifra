package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.c;

/* compiled from: DiskCacheStrategy */
class n extends q {
    n() {
    }

    public boolean a() {
        return true;
    }

    public boolean a(a aVar) {
        return (aVar == a.DATA_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
    }

    public boolean a(boolean z, a aVar, c cVar) {
        return false;
    }

    public boolean b() {
        return false;
    }
}
