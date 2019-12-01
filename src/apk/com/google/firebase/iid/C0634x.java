package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import b.d.b;
import b.g.a.a;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.firebase.iid.x reason: case insensitive filesystem */
final class C0634x {

    /* renamed from: a reason: collision with root package name */
    private final SharedPreferences f6849a;

    /* renamed from: b reason: collision with root package name */
    private final Context f6850b;

    /* renamed from: c reason: collision with root package name */
    private final ca f6851c;

    /* renamed from: d reason: collision with root package name */
    private final Map<String, ba> f6852d;

    public C0634x(Context context) {
        this(context, new ca());
    }

    private static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private final synchronized boolean c() {
        return this.f6849a.getAll().isEmpty();
    }

    public final synchronized String a() {
        return this.f6849a.getString("topic_operation_queue", "");
    }

    private C0634x(Context context, ca caVar) {
        String str = "FirebaseInstanceId";
        this.f6852d = new b();
        this.f6850b = context;
        this.f6849a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f6851c = caVar;
        File file = new File(a.a(this.f6850b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !c()) {
                    Log.i(str, "App restored, clearing state");
                    b();
                    FirebaseInstanceId.b().i();
                }
            } catch (IOException e2) {
                if (Log.isLoggable(str, 3)) {
                    String str2 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    public final synchronized void a(String str) {
        this.f6849a.edit().putString("topic_operation_queue", str).apply();
    }

    public final synchronized void b() {
        this.f6852d.clear();
        ca.a(this.f6850b);
        this.f6849a.edit().clear().commit();
    }

    public final synchronized void c(String str) {
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.f6849a.edit();
        for (String str2 : this.f6849a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized A a(String str, String str2, String str3) {
        return A.a(this.f6849a.getString(b(str, str2, str3), null));
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a2 = A.a(str4, str5, System.currentTimeMillis());
        if (a2 != null) {
            Editor edit = this.f6849a.edit();
            edit.putString(b(str, str2, str3), a2);
            edit.commit();
        }
    }

    public final synchronized ba b(String str) {
        ba baVar;
        ba baVar2 = (ba) this.f6852d.get(str);
        if (baVar2 != null) {
            return baVar2;
        }
        try {
            baVar = this.f6851c.a(this.f6850b, str);
        } catch (C0615d unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.b().i();
            baVar = this.f6851c.b(this.f6850b, str);
        }
        this.f6852d.put(str, baVar);
        return baVar;
    }
}
