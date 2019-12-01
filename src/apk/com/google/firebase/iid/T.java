package com.google.firebase.iid;

import com.google.firebase.a.a;
import com.google.firebase.a.b;

final /* synthetic */ class T implements b {

    /* renamed from: a reason: collision with root package name */
    private final a f6792a;

    T(a aVar) {
        this.f6792a = aVar;
    }

    public final void a(a aVar) {
        a aVar2 = this.f6792a;
        synchronized (aVar2) {
            if (aVar2.a()) {
                FirebaseInstanceId.this.n();
            }
        }
    }
}
