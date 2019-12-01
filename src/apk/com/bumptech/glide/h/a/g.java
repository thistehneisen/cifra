package com.bumptech.glide.h.a;

/* compiled from: StateVerifier */
public abstract class g {

    /* compiled from: StateVerifier */
    private static class a extends g {

        /* renamed from: a reason: collision with root package name */
        private volatile boolean f3513a;

        a() {
            super();
        }

        public void a(boolean z) {
            this.f3513a = z;
        }

        public void b() {
            if (this.f3513a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static g a() {
        return new a();
    }

    /* access modifiers changed from: 0000 */
    public abstract void a(boolean z);

    public abstract void b();

    private g() {
    }
}
