package com.bumptech.glide.load.b;

import com.bumptech.glide.h.i;
import com.bumptech.glide.h.n;
import java.util.Queue;

/* compiled from: ModelCache */
public class t<A, B> {

    /* renamed from: a reason: collision with root package name */
    private final i<a<A>, B> f3669a;

    /* compiled from: ModelCache */
    static final class a<A> {

        /* renamed from: a reason: collision with root package name */
        private static final Queue<a<?>> f3670a = n.a(0);

        /* renamed from: b reason: collision with root package name */
        private int f3671b;

        /* renamed from: c reason: collision with root package name */
        private int f3672c;

        /* renamed from: d reason: collision with root package name */
        private A f3673d;

        private a() {
        }

        static <A> a<A> a(A a2, int i2, int i3) {
            a<A> aVar;
            synchronized (f3670a) {
                aVar = (a) f3670a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i2, i3);
            return aVar;
        }

        private void b(A a2, int i2, int i3) {
            this.f3673d = a2;
            this.f3672c = i2;
            this.f3671b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3672c == aVar.f3672c && this.f3671b == aVar.f3671b && this.f3673d.equals(aVar.f3673d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f3671b * 31) + this.f3672c) * 31) + this.f3673d.hashCode();
        }

        public void a() {
            synchronized (f3670a) {
                f3670a.offer(this);
            }
        }
    }

    public t(long j2) {
        this.f3669a = new s(this, j2);
    }

    public B a(A a2, int i2, int i3) {
        a a3 = a.a(a2, i2, i3);
        B a4 = this.f3669a.a(a3);
        a3.a();
        return a4;
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.f3669a.b(a.a(a2, i2, i3), b2);
    }
}
