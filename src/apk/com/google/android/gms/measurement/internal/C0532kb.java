package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;

/* renamed from: com.google.android.gms.measurement.internal.kb reason: case insensitive filesystem */
public final class C0532kb extends C0528jc {
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public char f5977c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public long f5978d = -1;

    /* renamed from: e reason: collision with root package name */
    private String f5979e;

    /* renamed from: f reason: collision with root package name */
    private final C0542mb f5980f = new C0542mb(this, 6, false, false);

    /* renamed from: g reason: collision with root package name */
    private final C0542mb f5981g = new C0542mb(this, 6, true, false);

    /* renamed from: h reason: collision with root package name */
    private final C0542mb f5982h = new C0542mb(this, 6, false, true);

    /* renamed from: i reason: collision with root package name */
    private final C0542mb f5983i = new C0542mb(this, 5, false, false);

    /* renamed from: j reason: collision with root package name */
    private final C0542mb f5984j = new C0542mb(this, 5, true, false);

    /* renamed from: k reason: collision with root package name */
    private final C0542mb f5985k = new C0542mb(this, 5, false, true);

    /* renamed from: l reason: collision with root package name */
    private final C0542mb f5986l = new C0542mb(this, 4, false, false);
    private final C0542mb m = new C0542mb(this, 3, false, false);
    private final C0542mb n = new C0542mb(this, 2, false, false);

    C0532kb(Ob ob) {
        super(ob);
    }

    private final String D() {
        String str;
        synchronized (this) {
            if (this.f5979e == null) {
                if (this.f5987a.p() != null) {
                    this.f5979e = this.f5987a.p();
                } else {
                    this.f5979e = fe.o();
                }
            }
            str = this.f5979e;
        }
        return str;
    }

    protected static Object a(String str) {
        if (str == null) {
            return null;
        }
        return new C0537lb(str);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final C0542mb A() {
        return this.m;
    }

    public final C0542mb B() {
        return this.n;
    }

    public final String C() {
        Pair<String, Long> a2 = f().f6102e.a();
        if (a2 == null || a2 == C0576tb.f6100c) {
            return null;
        }
        String valueOf = String.valueOf(a2.second);
        String str = (String) a2.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return false;
    }

    public final C0542mb t() {
        return this.f5980f;
    }

    public final C0542mb u() {
        return this.f5981g;
    }

    public final C0542mb v() {
        return this.f5982h;
    }

    public final C0542mb w() {
        return this.f5983i;
    }

    public final C0542mb x() {
        return this.f5984j;
    }

    public final C0542mb y() {
        return this.f5985k;
    }

    public final C0542mb z() {
        return this.f5986l;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i2)) {
            a(i2, a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i2 >= 5) {
            q.a(str);
            Ib l2 = this.f5987a.l();
            if (l2 == null) {
                a(6, "Scheduler not set. Not logging error/warn");
            } else if (!l2.o()) {
                a(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i2 < 0) {
                    i2 = 0;
                }
                C0527jb jbVar = new C0527jb(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3);
                l2.a((Runnable) jbVar);
            }
        }
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2) {
        return Log.isLoggable(D(), i2);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, String str) {
        Log.println(i2, D(), str);
    }

    static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String a2 = a(z, obj);
        String a3 = a(z, obj2);
        String a4 = a(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(a4)) {
            sb.append(str2);
            sb.append(a4);
        }
        return sb.toString();
    }

    private static String a(boolean z, Object obj) {
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        String str2 = "-";
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = str2;
            }
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + 43 + str.length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String b2 = b(Ob.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && b(className).equals(b2)) {
                            sb2.append(": ");
                            sb2.append(stackTraceElement);
                            break;
                        }
                    }
                    i2++;
                }
                return sb2.toString();
            } else if (obj instanceof C0537lb) {
                return ((C0537lb) obj).f6016a;
            } else {
                if (z) {
                    return str2;
                }
                return String.valueOf(obj);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
