package com.google.firebase.components;

import com.google.firebase.b.a;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
final /* synthetic */ class l implements a {

    /* renamed from: a reason: collision with root package name */
    private final Set f6700a;

    private l(Set set) {
        this.f6700a = set;
    }

    public static a a(Set set) {
        return new l(set);
    }

    public Object get() {
        return n.a(this.f6700a);
    }
}
