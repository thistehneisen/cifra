package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.h.a.d.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator */
class k implements a<a> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ l f3974a;

    k(l lVar) {
        this.f3974a = lVar;
    }

    public a create() {
        try {
            return new a(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
