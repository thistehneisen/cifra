package com.google.firebase.components;

import com.google.firebase.b.a;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
final /* synthetic */ class k implements a {

    /* renamed from: a reason: collision with root package name */
    private final n f6698a;

    /* renamed from: b reason: collision with root package name */
    private final e f6699b;

    private k(n nVar, e eVar) {
        this.f6698a = nVar;
        this.f6699b = eVar;
    }

    public static a a(n nVar, e eVar) {
        return new k(nVar, eVar);
    }

    public Object get() {
        return this.f6699b.b().a(new u(this.f6699b, this.f6698a));
    }
}
