package io.intercom.com.bumptech.glide.load.engine.b;

import b.g.h.d;
import io.intercom.com.bumptech.glide.h.a.d.c;
import io.intercom.com.bumptech.glide.h.a.f;
import io.intercom.com.bumptech.glide.h.e;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.g;
import java.security.MessageDigest;

/* compiled from: SafeKeyGenerator */
public class l {

    /* renamed from: a reason: collision with root package name */
    private final e<g, String> f9836a = new e<>(1000);

    /* renamed from: b reason: collision with root package name */
    private final d<a> f9837b = io.intercom.com.bumptech.glide.h.a.d.b(10, new k(this));

    /* compiled from: SafeKeyGenerator */
    private static final class a implements c {

        /* renamed from: a reason: collision with root package name */
        final MessageDigest f9838a;

        /* renamed from: b reason: collision with root package name */
        private final f f9839b = f.a();

        a(MessageDigest messageDigest) {
            this.f9838a = messageDigest;
        }

        public f d() {
            return this.f9839b;
        }
    }

    private String b(g gVar) {
        Object a2 = this.f9837b.a();
        h.a(a2);
        a aVar = (a) a2;
        try {
            gVar.updateDiskCacheKey(aVar.f9838a);
            return j.a(aVar.f9838a.digest());
        } finally {
            this.f9837b.a(aVar);
        }
    }

    public String a(g gVar) {
        String str;
        synchronized (this.f9836a) {
            str = (String) this.f9836a.a(gVar);
        }
        if (str == null) {
            str = b(gVar);
        }
        synchronized (this.f9836a) {
            this.f9836a.b(gVar, str);
        }
        return str;
    }
}
