package com.google.firebase.c;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public class d {

    /* renamed from: a reason: collision with root package name */
    private static volatile d f6680a;

    /* renamed from: b reason: collision with root package name */
    private final Set<e> f6681b = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = f6680a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f6680a;
                if (dVar == null) {
                    dVar = new d();
                    f6680a = dVar;
                }
            }
        }
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    public Set<e> b() {
        Set<e> unmodifiableSet;
        synchronized (this.f6681b) {
            unmodifiableSet = Collections.unmodifiableSet(this.f6681b);
        }
        return unmodifiableSet;
    }
}
