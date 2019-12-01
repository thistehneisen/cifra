package com.google.firebase.iid;

import com.google.android.gms.tasks.C0609a;
import com.google.android.gms.tasks.g;

final /* synthetic */ class Q implements C0609a {

    /* renamed from: a reason: collision with root package name */
    private final FirebaseInstanceId f6784a;

    /* renamed from: b reason: collision with root package name */
    private final String f6785b;

    /* renamed from: c reason: collision with root package name */
    private final String f6786c;

    Q(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.f6784a = firebaseInstanceId;
        this.f6785b = str;
        this.f6786c = str2;
    }

    public final Object a(g gVar) {
        return this.f6784a.a(this.f6785b, this.f6786c, gVar);
    }
}
