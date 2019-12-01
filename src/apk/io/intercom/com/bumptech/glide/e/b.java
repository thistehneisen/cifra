package io.intercom.com.bumptech.glide.e;

import io.intercom.com.bumptech.glide.load.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private final List<e> f9281a = new ArrayList();

    public synchronized List<e> a() {
        return this.f9281a;
    }

    public synchronized void a(e eVar) {
        this.f9281a.add(eVar);
    }
}
