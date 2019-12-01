package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import java.io.IOException;

/* renamed from: com.google.firebase.iid.z reason: case insensitive filesystem */
final class C0636z implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final long f6858a;

    /* renamed from: b reason: collision with root package name */
    private final WakeLock f6859b = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");

    /* renamed from: c reason: collision with root package name */
    private final FirebaseInstanceId f6860c;

    /* renamed from: d reason: collision with root package name */
    private final B f6861d;

    C0636z(FirebaseInstanceId firebaseInstanceId, C0627p pVar, B b2, long j2) {
        this.f6860c = firebaseInstanceId;
        this.f6861d = b2;
        this.f6858a = j2;
        this.f6859b.setReferenceCounted(false);
    }

    private final boolean c() {
        String str = "FirebaseInstanceId";
        A f2 = this.f6860c.f();
        if (!this.f6860c.l() && !this.f6860c.a(f2)) {
            return true;
        }
        try {
            String g2 = this.f6860c.g();
            if (g2 == null) {
                Log.e(str, "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Token successfully retrieved");
            }
            if (f2 == null || (f2 != null && !g2.equals(f2.f6732b))) {
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", g2);
                Context a2 = a();
                Intent intent2 = new Intent(a2, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException | SecurityException e2) {
            String str2 = "Token retrieval failed: ";
            String valueOf = String.valueOf(e2.getMessage());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final Context a() {
        return this.f6860c.e().b();
    }

    /* access modifiers changed from: 0000 */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        try {
            if (C0635y.a().a(a())) {
                this.f6859b.acquire();
            }
            this.f6860c.a(true);
            if (!this.f6860c.j()) {
                this.f6860c.a(false);
            } else if (!C0635y.a().b(a()) || b()) {
                if (!c() || !this.f6861d.a(this.f6860c)) {
                    this.f6860c.a(this.f6858a);
                } else {
                    this.f6860c.a(false);
                }
                if (C0635y.a().a(a())) {
                    this.f6859b.release();
                }
            } else {
                new D(this).a();
                if (C0635y.a().a(a())) {
                    this.f6859b.release();
                }
            }
        } finally {
            if (C0635y.a().a(a())) {
                this.f6859b.release();
            }
        }
    }
}
