package com.bumptech.glide.a;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class a implements Callable<Void> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f3274a;

    a(b bVar) {
        this.f3274a = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return null;
     */
    public Void call() throws Exception {
        synchronized (this.f3274a) {
            if (this.f3274a.f3283i == null) {
                return null;
            }
            this.f3274a.g();
            if (this.f3274a.c()) {
                this.f3274a.f();
                this.f3274a.f3285k = 0;
            }
        }
    }
}
