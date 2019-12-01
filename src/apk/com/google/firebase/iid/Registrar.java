package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.a.d;
import com.google.firebase.c.f;
import com.google.firebase.c.g;
import com.google.firebase.components.e;
import com.google.firebase.components.j;
import com.google.firebase.components.q;
import java.util.Arrays;
import java.util.List;

@Keep
public final class Registrar implements j {

    private static class a implements com.google.firebase.iid.a.a {

        /* renamed from: a reason: collision with root package name */
        private final FirebaseInstanceId f6787a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.f6787a = firebaseInstanceId;
        }
    }

    @Keep
    public final List<e<?>> getComponents() {
        com.google.firebase.components.e.a a2 = e.a(FirebaseInstanceId.class);
        a2.a(q.a(FirebaseApp.class));
        a2.a(q.a(d.class));
        a2.a(q.a(g.class));
        a2.a(r.f6835a);
        a2.a();
        e b2 = a2.b();
        com.google.firebase.components.e.a a3 = e.a(com.google.firebase.iid.a.a.class);
        a3.a(q.a(FirebaseInstanceId.class));
        a3.a(C0628q.f6834a);
        return Arrays.asList(new e[]{b2, a3.b(), f.a("fire-iid", "18.0.0")});
    }
}
