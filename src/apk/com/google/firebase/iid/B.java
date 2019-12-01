package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import b.d.b;
import com.google.android.gms.tasks.h;
import java.io.IOException;
import java.util.Map;

final class B {

    /* renamed from: a reason: collision with root package name */
    private int f6735a = 0;

    /* renamed from: b reason: collision with root package name */
    private final Map<Integer, h<Void>> f6736b = new b();

    /* renamed from: c reason: collision with root package name */
    private final C0634x f6737c;

    B(C0634x xVar) {
        this.f6737c = xVar;
    }

    private final String b() {
        String a2;
        synchronized (this.f6737c) {
            a2 = this.f6737c.a();
        }
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split(",");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                return split[1];
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized boolean a() {
        return b() != null;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (a(r5, r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = (com.google.android.gms.tasks.h) r4.f6736b.remove(java.lang.Integer.valueOf(r4.f6735a));
        a(r0);
        r4.f6735a++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r2.a(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    public final boolean a(FirebaseInstanceId firebaseInstanceId) {
        while (true) {
            synchronized (this) {
                String b2 = b();
                if (b2 == null) {
                    if (FirebaseInstanceId.h()) {
                        Log.d("FirebaseInstanceId", "topic sync succeeded");
                    }
                }
            }
        }
        while (true) {
        }
    }

    private final synchronized boolean a(String str) {
        synchronized (this.f6737c) {
            String a2 = this.f6737c.a();
            String str2 = ",";
            String valueOf = String.valueOf(str);
            if (!a2.startsWith(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2))) {
                return false;
            }
            String str3 = ",";
            String valueOf2 = String.valueOf(str);
            this.f6737c.a(a2.substring((valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3)).length()));
            return true;
        }
    }

    private static boolean a(FirebaseInstanceId firebaseInstanceId, String str) {
        String str2 = "FirebaseInstanceId";
        String[] split = str.split("!");
        if (split.length == 2) {
            String str3 = split[0];
            String str4 = split[1];
            char c2 = 65535;
            try {
                int hashCode = str3.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85) {
                        if (str3.equals("U")) {
                            c2 = 1;
                        }
                    }
                } else if (str3.equals("S")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    firebaseInstanceId.a(str4);
                    if (FirebaseInstanceId.h()) {
                        Log.d(str2, "subscribe operation succeeded");
                    }
                } else if (c2 == 1) {
                    firebaseInstanceId.b(str4);
                    if (FirebaseInstanceId.h()) {
                        Log.d(str2, "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e2) {
                String str5 = "Topic sync failed: ";
                String valueOf = String.valueOf(e2.getMessage());
                Log.e(str2, valueOf.length() != 0 ? str5.concat(valueOf) : new String(str5));
                return false;
            }
        }
        return true;
    }
}
