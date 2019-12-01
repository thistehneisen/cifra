package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.tasks.C0609a;
import com.google.android.gms.tasks.h;
import com.google.firebase.FirebaseApp;
import com.google.firebase.c.g;
import java.io.IOException;
import java.util.concurrent.Executor;

final class V implements C0613b {

    /* renamed from: a reason: collision with root package name */
    private final FirebaseApp f6796a;

    /* renamed from: b reason: collision with root package name */
    private final C0627p f6797b;

    /* renamed from: c reason: collision with root package name */
    private final C0633w f6798c;

    /* renamed from: d reason: collision with root package name */
    private final Executor f6799d;

    /* renamed from: e reason: collision with root package name */
    private final g f6800e;

    V(FirebaseApp firebaseApp, C0627p pVar, Executor executor, g gVar) {
        this(firebaseApp, pVar, executor, new C0633w(firebaseApp.b(), pVar), gVar);
    }

    public final com.google.android.gms.tasks.g<String> a(String str, String str2, String str3, String str4) {
        return b(a(str, str3, str4, new Bundle()));
    }

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return this.f6797b.a() != 0;
    }

    public final com.google.android.gms.tasks.g<Void> b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        String str4 = "/topics/";
        bundle.putString("gcm.topic", valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), bundle)));
    }

    private V(FirebaseApp firebaseApp, C0627p pVar, Executor executor, C0633w wVar, g gVar) {
        this.f6796a = firebaseApp;
        this.f6797b = pVar;
        this.f6798c = wVar;
        this.f6799d = executor;
        this.f6800e = gVar;
    }

    public final com.google.android.gms.tasks.g<Void> a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        String str4 = "/topics/";
        bundle.putString("gcm.topic", valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), bundle)));
    }

    private final com.google.android.gms.tasks.g<String> b(com.google.android.gms.tasks.g<Bundle> gVar) {
        return gVar.a(this.f6799d, (C0609a<TResult, TContinuationResult>) new W<TResult,TContinuationResult>(this));
    }

    private final com.google.android.gms.tasks.g<Bundle> a(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString(AppsFlyerProperties.APP_ID, str);
        bundle.putString("gmp_app_id", this.f6796a.d().a());
        bundle.putString("gmsv", Integer.toString(this.f6797b.d()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.f6797b.b());
        bundle.putString("app_ver_name", this.f6797b.c());
        bundle.putString("cliv", "fiid-12451000");
        bundle.putString("Firebase-Client", this.f6800e.a());
        h hVar = new h();
        this.f6799d.execute(new U(this, bundle, hVar));
        return hVar.a();
    }

    /* access modifiers changed from: private */
    public static String a(Bundle bundle) throws IOException {
        String str = "SERVICE_NOT_AVAILABLE";
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException(str);
            }
        } else {
            throw new IOException(str);
        }
    }

    private final <T> com.google.android.gms.tasks.g<Void> a(com.google.android.gms.tasks.g<T> gVar) {
        return gVar.a(J.a(), (C0609a<TResult, TContinuationResult>) new X<TResult,TContinuationResult>(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(Bundle bundle, h hVar) {
        try {
            hVar.a(this.f6798c.a(bundle));
        } catch (IOException e2) {
            hVar.a((Exception) e2);
        }
    }
}
