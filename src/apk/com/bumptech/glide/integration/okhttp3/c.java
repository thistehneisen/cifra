package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.y;
import com.bumptech.glide.load.i;
import i.G;
import java.io.InputStream;

/* compiled from: OkHttpUrlLoader */
public class c implements u<l, InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final i.C0721j.a f3541a;

    /* compiled from: OkHttpUrlLoader */
    public static class a implements v<l, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private static volatile i.C0721j.a f3542a;

        /* renamed from: b reason: collision with root package name */
        private final i.C0721j.a f3543b;

        public a() {
            this(b());
        }

        private static i.C0721j.a b() {
            if (f3542a == null) {
                synchronized (a.class) {
                    if (f3542a == null) {
                        f3542a = new G();
                    }
                }
            }
            return f3542a;
        }

        public u<l, InputStream> a(y yVar) {
            return new c(this.f3543b);
        }

        public void a() {
        }

        public a(i.C0721j.a aVar) {
            this.f3543b = aVar;
        }
    }

    public c(i.C0721j.a aVar) {
        this.f3541a = aVar;
    }

    public boolean a(l lVar) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<InputStream> a(l lVar, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(lVar, new b(this.f3541a, lVar));
    }
}
