package io.intercom.com.bumptech.glide.a;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class a implements Callable<Void> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f9132a;

    a(b bVar) {
        this.f9132a = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return null;
     */
    public Void call() throws Exception {
        synchronized (this.f9132a) {
            if (this.f9132a.f9141i == null) {
                return null;
            }
            this.f9132a.g();
            if (this.f9132a.c()) {
                this.f9132a.f();
                this.f9132a.f9143k = 0;
            }
        }
    }
}
