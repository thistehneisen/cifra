package com.bumptech.glide.load.a;

import com.bumptech.glide.j;

/* compiled from: DataFetcher */
public interface d<T> {

    /* compiled from: DataFetcher */
    public interface a<T> {
        void a(Exception exc);

        void a(T t);
    }

    Class<T> a();

    void a(j jVar, a<? super T> aVar);

    void b();

    com.bumptech.glide.load.a c();

    void cancel();
}
