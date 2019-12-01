package io.intercom.com.bumptech.glide;

import io.intercom.com.bumptech.glide.f.e;
import io.intercom.com.bumptech.glide.f.f;

/* compiled from: RequestBuilder */
class i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ e f9408a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ k f9409b;

    i(k kVar, e eVar) {
        this.f9409b = kVar;
        this.f9408a = eVar;
    }

    public void run() {
        if (!this.f9408a.isCancelled()) {
            k kVar = this.f9409b;
            e eVar = this.f9408a;
            kVar.a(eVar, (f<TranscodeType>) eVar);
        }
    }
}
