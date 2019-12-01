package io.fabric.sdk.android.a.b;

import io.fabric.sdk.android.f;

/* renamed from: io.fabric.sdk.android.a.b.c reason: case insensitive filesystem */
/* compiled from: AdvertisingInfoProvider */
class C0732c extends j {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0731b f8809a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0733d f8810b;

    C0732c(C0733d dVar, C0731b bVar) {
        this.f8810b = dVar;
        this.f8809a = bVar;
    }

    public void onRun() {
        C0731b a2 = this.f8810b.e();
        if (!this.f8809a.equals(a2)) {
            f.e().d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            this.f8810b.c(a2);
        }
    }
}
