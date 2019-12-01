package io.intercom.com.bumptech.glide.h.a;

/* compiled from: StateVerifier */
public abstract class f {

    /* compiled from: StateVerifier */
    private static class a extends f {

        /* renamed from: a reason: collision with root package name */
        private volatile boolean f9390a;

        a() {
            super();
        }

        public void a(boolean z) {
            this.f9390a = z;
        }

        public void b() {
            if (this.f9390a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static f a() {
        return new a();
    }

    /* access modifiers changed from: 0000 */
    public abstract void a(boolean z);

    public abstract void b();

    private f() {
    }
}
