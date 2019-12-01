package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.h.e;
import io.intercom.com.bumptech.glide.h.j;
import java.util.Queue;

/* compiled from: ModelCache */
public class t<A, B> {

    /* renamed from: a reason: collision with root package name */
    private final e<a<A>, B> f9539a;

    /* compiled from: ModelCache */
    static final class a<A> {

        /* renamed from: a reason: collision with root package name */
        private static final Queue<a<?>> f9540a = j.a(0);

        /* renamed from: b reason: collision with root package name */
        private int f9541b;

        /* renamed from: c reason: collision with root package name */
        private int f9542c;

        /* renamed from: d reason: collision with root package name */
        private A f9543d;

        private a() {
        }

        static <A> a<A> a(A a2, int i2, int i3) {
            a<A> aVar;
            synchronized (f9540a) {
                aVar = (a) f9540a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i2, i3);
            return aVar;
        }

        private void b(A a2, int i2, int i3) {
            this.f9543d = a2;
            this.f9542c = i2;
            this.f9541b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f9542c == aVar.f9542c && this.f9541b == aVar.f9541b && this.f9543d.equals(aVar.f9543d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f9541b * 31) + this.f9542c) * 31) + this.f9543d.hashCode();
        }

        public void a() {
            synchronized (f9540a) {
                f9540a.offer(this);
            }
        }
    }

    public t(long j2) {
        this.f9539a = new s(this, j2);
    }

    public B a(A a2, int i2, int i3) {
        a a3 = a.a(a2, i2, i3);
        B a4 = this.f9539a.a(a3);
        a3.a();
        return a4;
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.f9539a.b(a.a(a2, i2, i3), b2);
    }
}
