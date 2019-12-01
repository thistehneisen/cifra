package com.google.firebase.iid;

import com.google.android.gms.tasks.g;

final /* synthetic */ class P implements C0630t {

    /* renamed from: a reason: collision with root package name */
    private final FirebaseInstanceId f6779a;

    /* renamed from: b reason: collision with root package name */
    private final String f6780b;

    /* renamed from: c reason: collision with root package name */
    private final String f6781c;

    /* renamed from: d reason: collision with root package name */
    private final String f6782d;

    /* renamed from: e reason: collision with root package name */
    private final String f6783e;

    P(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3, String str4) {
        this.f6779a = firebaseInstanceId;
        this.f6780b = str;
        this.f6781c = str2;
        this.f6782d = str3;
        this.f6783e = str4;
    }

    public final g a() {
        return this.f6779a.a(this.f6780b, this.f6781c, this.f6782d, this.f6783e);
    }
}
