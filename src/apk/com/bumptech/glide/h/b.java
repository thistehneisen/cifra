package com.bumptech.glide.h;

import b.d.i;

/* compiled from: CachedHashCodeArrayMap */
public final class b<K, V> extends b.d.b<K, V> {

    /* renamed from: i reason: collision with root package name */
    private int f3514i;

    public V a(int i2, V v) {
        this.f3514i = 0;
        return super.a(i2, v);
    }

    public V c(int i2) {
        this.f3514i = 0;
        return super.c(i2);
    }

    public void clear() {
        this.f3514i = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.f3514i == 0) {
            this.f3514i = super.hashCode();
        }
        return this.f3514i;
    }

    public V put(K k2, V v) {
        this.f3514i = 0;
        return super.put(k2, v);
    }

    public void a(i<? extends K, ? extends V> iVar) {
        this.f3514i = 0;
        super.a(iVar);
    }
}
