package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class A {

    /* renamed from: a reason: collision with root package name */
    private static final long f6731a = TimeUnit.DAYS.toMillis(7);

    /* renamed from: b reason: collision with root package name */
    final String f6732b;

    /* renamed from: c reason: collision with root package name */
    private final String f6733c;

    /* renamed from: d reason: collision with root package name */
    private final long f6734d;

    private A(String str, String str2, long j2) {
        this.f6732b = str;
        this.f6733c = str2;
        this.f6734d = j2;
    }

    static A a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new A(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new A(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean b(String str) {
        return System.currentTimeMillis() > this.f6734d + f6731a || !str.equals(this.f6733c);
    }

    static String a(String str, String str2, long j2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String a(A a2) {
        if (a2 == null) {
            return null;
        }
        return a2.f6732b;
    }
}
