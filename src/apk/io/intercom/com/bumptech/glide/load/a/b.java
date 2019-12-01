package io.intercom.com.bumptech.glide.load.a;

import io.intercom.com.bumptech.glide.h;

/* compiled from: DataFetcher */
public interface b<T> {

    /* compiled from: DataFetcher */
    public interface a<T> {
        void a(Exception exc);

        void a(T t);
    }

    Class<T> a();

    void a(h hVar, a<? super T> aVar);

    void b();

    io.intercom.com.bumptech.glide.load.a c();

    void cancel();
}
