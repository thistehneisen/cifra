package com.google.firebase.a;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public interface d {
    <T> void a(Class<T> cls, b<? super T> bVar);

    <T> void a(Class<T> cls, Executor executor, b<? super T> bVar);
}
