package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.c;

/* compiled from: DiskCacheStrategy */
class p extends q {
    p() {
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
        return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
    }
}
