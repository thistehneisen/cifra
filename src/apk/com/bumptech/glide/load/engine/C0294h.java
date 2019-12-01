package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.b.a.b;
import com.bumptech.glide.load.i;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.h reason: case insensitive filesystem */
/* compiled from: DataCacheWriter */
class C0294h<DataType> implements b {

    /* renamed from: a reason: collision with root package name */
    private final d<DataType> f4018a;

    /* renamed from: b reason: collision with root package name */
    private final DataType f4019b;

    /* renamed from: c reason: collision with root package name */
    private final i f4020c;

    C0294h(d<DataType> dVar, DataType datatype, i iVar) {
        this.f4018a = dVar;
        this.f4019b = datatype;
        this.f4020c = iVar;
    }

    public boolean a(File file) {
        return this.f4018a.a(this.f4019b, file, this.f4020c);
    }
}
