package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.q;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class a {

    /* renamed from: a reason: collision with root package name */
    private static final Lock f4503a = new ReentrantLock();

    /* renamed from: b reason: collision with root package name */
    private static a f4504b;

    /* renamed from: c reason: collision with root package name */
    private final Lock f4505c = new ReentrantLock();

    /* renamed from: d reason: collision with root package name */
    private final SharedPreferences f4506d;

    private a(Context context) {
        this.f4506d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        q.a(context);
        f4503a.lock();
        try {
            if (f4504b == null) {
                f4504b = new a(context.getApplicationContext());
            }
            return f4504b;
        } finally {
            f4503a.unlock();
        }
    }

    private final String b(String str) {
        this.f4505c.lock();
        try {
            return this.f4506d.getString(str, null);
        } finally {
            this.f4505c.unlock();
        }
    }

    public GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }

    private final GoogleSignInAccount a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b2 = b(a("googleSignInAccount", str));
        if (b2 != null) {
            try {
                return GoogleSignInAccount.a(b2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }
}
