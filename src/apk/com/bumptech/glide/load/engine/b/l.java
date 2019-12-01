package com.bumptech.glide.load.engine.b;

import b.g.h.d;
import com.bumptech.glide.h.a.d.c;
import com.bumptech.glide.h.a.g;
import com.bumptech.glide.h.i;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: SafeKeyGenerator */
public class l {

    /* renamed from: a reason: collision with root package name */
    private final i<f, String> f3975a = new i<>(1000);

    /* renamed from: b reason: collision with root package name */
    private final d<a> f3976b = com.bumptech.glide.h.a.d.a(10, (com.bumptech.glide.h.a.d.a<T>) new k<T>(this));

    /* compiled from: SafeKeyGenerator */
    private static final class a implements c {

        /* renamed from: a reason: collision with root package name */
        final MessageDigest f3977a;

        /* renamed from: b reason: collision with root package name */
        private final g f3978b = g.a();

        a(MessageDigest messageDigest) {
            this.f3977a = messageDigest;
        }

        public g d() {
            return this.f3978b;
        }
    }

    private String b(f fVar) {
        Object a2 = this.f3976b.a();
        com.bumptech.glide.h.l.a(a2);
        a aVar = (a) a2;
        try {
            fVar.updateDiskCacheKey(aVar.f3977a);
            return n.a(aVar.f3977a.digest());
        } finally {
            this.f3976b.a(aVar);
        }
    }

    public String a(f fVar) {
        String str;
        synchronized (this.f3975a) {
            str = (String) this.f3975a.a(fVar);
        }
        if (str == null) {
            str = b(fVar);
        }
        synchronized (this.f3975a) {
            this.f3975a.b(fVar, str);
        }
        return str;
    }
}
