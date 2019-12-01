package com.google.firebase.iid;

import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;

final /* synthetic */ class S implements f {

    /* renamed from: a reason: collision with root package name */
    private final FirebaseInstanceId f6788a;

    /* renamed from: b reason: collision with root package name */
    private final String f6789b;

    /* renamed from: c reason: collision with root package name */
    private final String f6790c;

    /* renamed from: d reason: collision with root package name */
    private final String f6791d;

    S(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f6788a = firebaseInstanceId;
        this.f6789b = str;
        this.f6790c = str2;
        this.f6791d = str3;
    }

    public final g a(Object obj) {
        return this.f6788a.b(this.f6789b, this.f6790c, this.f6791d, (String) obj);
    }
}
