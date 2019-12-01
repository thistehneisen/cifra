package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C0321p;
import com.google.android.gms.common.internal.C0321p.a;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.m;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public final class c {

    /* renamed from: a reason: collision with root package name */
    private final String f6668a;

    /* renamed from: b reason: collision with root package name */
    private final String f6669b;

    /* renamed from: c reason: collision with root package name */
    private final String f6670c;

    /* renamed from: d reason: collision with root package name */
    private final String f6671d;

    /* renamed from: e reason: collision with root package name */
    private final String f6672e;

    /* renamed from: f reason: collision with root package name */
    private final String f6673f;

    /* renamed from: g reason: collision with root package name */
    private final String f6674g;

    private c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        q.b(!m.a(str), "ApplicationId must be set.");
        this.f6669b = str;
        this.f6668a = str2;
        this.f6670c = str3;
        this.f6671d = str4;
        this.f6672e = str5;
        this.f6673f = str6;
        this.f6674g = str7;
    }

    public static c a(Context context) {
        u uVar = new u(context);
        String a2 = uVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        c cVar = new c(a2, uVar.a("google_api_key"), uVar.a("firebase_database_url"), uVar.a("ga_trackingId"), uVar.a("gcm_defaultSenderId"), uVar.a("google_storage_bucket"), uVar.a("project_id"));
        return cVar;
    }

    public String b() {
        return this.f6672e;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (C0321p.a(this.f6669b, cVar.f6669b) && C0321p.a(this.f6668a, cVar.f6668a) && C0321p.a(this.f6670c, cVar.f6670c) && C0321p.a(this.f6671d, cVar.f6671d) && C0321p.a(this.f6672e, cVar.f6672e) && C0321p.a(this.f6673f, cVar.f6673f) && C0321p.a(this.f6674g, cVar.f6674g)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return C0321p.a(this.f6669b, this.f6668a, this.f6670c, this.f6671d, this.f6672e, this.f6673f, this.f6674g);
    }

    public String toString() {
        a a2 = C0321p.a((Object) this);
        a2.a("applicationId", this.f6669b);
        a2.a("apiKey", this.f6668a);
        a2.a("databaseUrl", this.f6670c);
        a2.a("gcmSenderId", this.f6672e);
        a2.a("storageBucket", this.f6673f);
        a2.a("projectId", this.f6674g);
        return a2.toString();
    }

    public String a() {
        return this.f6669b;
    }
}
