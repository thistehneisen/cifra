package com.google.firebase.c;

import com.google.firebase.components.e;
import com.google.firebase.components.e.a;
import com.google.firebase.components.f;
import com.google.firebase.components.q;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public class c implements g {

    /* renamed from: a reason: collision with root package name */
    private final String f6678a;

    /* renamed from: b reason: collision with root package name */
    private final d f6679b;

    c(Set<e> set, d dVar) {
        this.f6678a = a(set);
        this.f6679b = dVar;
    }

    public static e<g> b() {
        a a2 = e.a(g.class);
        a2.a(q.b(e.class));
        a2.a(b.a());
        return a2.b();
    }

    public String a() {
        if (this.f6679b.b().isEmpty()) {
            return this.f6678a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6678a);
        sb.append(' ');
        sb.append(a(this.f6679b.b()));
        return sb.toString();
    }

    private static String a(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            sb.append(eVar.a());
            sb.append('/');
            sb.append(eVar.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    static /* synthetic */ g a(f fVar) {
        return new c(fVar.d(e.class), d.a());
    }
}
