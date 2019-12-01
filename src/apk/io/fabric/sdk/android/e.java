package io.fabric.sdk.android;

import java.util.concurrent.CountDownLatch;

/* compiled from: Fabric */
class e implements j {

    /* renamed from: a reason: collision with root package name */
    final CountDownLatch f8997a = new CountDownLatch(this.f8998b);

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f8998b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ f f8999c;

    e(f fVar, int i2) {
        this.f8999c = fVar;
        this.f8998b = i2;
    }

    public void a(Object obj) {
        this.f8997a.countDown();
        if (this.f8997a.getCount() == 0) {
            this.f8999c.f9011l.set(true);
            this.f8999c.f9006g.a(this.f8999c);
        }
    }

    public void a(Exception exc) {
        this.f8999c.f9006g.a(exc);
    }
}
