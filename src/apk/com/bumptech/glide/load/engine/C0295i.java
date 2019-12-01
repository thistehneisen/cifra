package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.f;

/* renamed from: com.bumptech.glide.load.engine.i reason: case insensitive filesystem */
/* compiled from: DataFetcherGenerator */
interface C0295i {

    /* renamed from: com.bumptech.glide.load.engine.i$a */
    /* compiled from: DataFetcherGenerator */
    public interface a {
        void a(f fVar, Exception exc, d<?> dVar, com.bumptech.glide.load.a aVar);

        void a(f fVar, Object obj, d<?> dVar, com.bumptech.glide.load.a aVar, f fVar2);

        void b();
    }

    boolean a();

    void cancel();
}
