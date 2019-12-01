package io.fabric.sdk.android;

import android.util.Log;

/* compiled from: DefaultLogger */
public class c implements o {

    /* renamed from: a reason: collision with root package name */
    private int f8995a;

    public c(int i2) {
        this.f8995a = i2;
    }

    public boolean a(String str, int i2) {
        return this.f8995a <= i2 || Log.isLoggable(str, i2);
    }

    public void b(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void a(int i2) {
        this.f8995a = i2;
    }

    public c() {
        this.f8995a = 4;
    }

    public void a(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void b(String str, String str2) {
        b(str, str2, null);
    }

    public void c(String str, String str2) {
        e(str, str2, null);
    }

    public void d(String str, String str2) {
        c(str, str2, null);
    }

    public void e(String str, String str2) {
        d(str, str2, null);
    }

    public void a(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    public void a(int i2, String str, String str2) {
        a(i2, str, str2, false);
    }

    public void a(int i2, String str, String str2, boolean z) {
        if (z || a(str, i2)) {
            Log.println(i2, str, str2);
        }
    }
}
