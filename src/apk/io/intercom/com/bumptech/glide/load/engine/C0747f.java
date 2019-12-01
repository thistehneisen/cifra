package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.d;
import io.intercom.com.bumptech.glide.load.engine.b.a.b;
import io.intercom.com.bumptech.glide.load.j;
import java.io.File;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.f reason: case insensitive filesystem */
/* compiled from: DataCacheWriter */
class C0747f<DataType> implements b {

    /* renamed from: a reason: collision with root package name */
    private final d<DataType> f9879a;

    /* renamed from: b reason: collision with root package name */
    private final DataType f9880b;

    /* renamed from: c reason: collision with root package name */
    private final j f9881c;

    C0747f(d<DataType> dVar, DataType datatype, j jVar) {
        this.f9879a = dVar;
        this.f9880b = datatype;
        this.f9881c = jVar;
    }

    public boolean a(File file) {
        return this.f9879a.a(this.f9880b, file, this.f9881c);
    }
}
