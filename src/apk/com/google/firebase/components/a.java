package com.google.firebase.components;

import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
abstract class a implements f {
    a() {
    }

    public <T> T a(Class<T> cls) {
        com.google.firebase.b.a b2 = b(cls);
        if (b2 == null) {
            return null;
        }
        return b2.get();
    }

    public <T> Set<T> d(Class<T> cls) {
        return (Set) c(cls).get();
    }
}
