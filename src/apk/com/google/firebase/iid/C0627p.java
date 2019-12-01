package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.k;
import com.google.firebase.FirebaseApp;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* renamed from: com.google.firebase.iid.p reason: case insensitive filesystem */
public final class C0627p {

    /* renamed from: a reason: collision with root package name */
    private final Context f6829a;

    /* renamed from: b reason: collision with root package name */
    private String f6830b;

    /* renamed from: c reason: collision with root package name */
    private String f6831c;

    /* renamed from: d reason: collision with root package name */
    private int f6832d;

    /* renamed from: e reason: collision with root package name */
    private int f6833e = 0;

    public C0627p(Context context) {
        this.f6829a = context;
    }

    private final synchronized void e() {
        PackageInfo a2 = a(this.f6829a.getPackageName());
        if (a2 != null) {
            this.f6830b = Integer.toString(a2.versionCode);
            this.f6831c = a2.versionName;
        }
    }

    public final synchronized int a() {
        if (this.f6833e != 0) {
            return this.f6833e;
        }
        PackageManager packageManager = this.f6829a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!k.i()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f6833e = 1;
                return this.f6833e;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (k.i()) {
                this.f6833e = 2;
            } else {
                this.f6833e = 1;
            }
            return this.f6833e;
        }
        this.f6833e = 2;
        return this.f6833e;
    }

    public final synchronized String b() {
        if (this.f6830b == null) {
            e();
        }
        return this.f6830b;
    }

    public final synchronized String c() {
        if (this.f6831c == null) {
            e();
        }
        return this.f6831c;
    }

    public final synchronized int d() {
        if (this.f6832d == 0) {
            PackageInfo a2 = a("com.google.android.gms");
            if (a2 != null) {
                this.f6832d = a2.versionCode;
            }
        }
        return this.f6832d;
    }

    public static String a(FirebaseApp firebaseApp) {
        String b2 = firebaseApp.d().b();
        if (b2 != null) {
            return b2;
        }
        String a2 = firebaseApp.d().a();
        if (!a2.startsWith("1:")) {
            return a2;
        }
        String[] split = a2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final PackageInfo a(String str) {
        try {
            return this.f6829a.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}
