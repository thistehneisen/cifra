package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* renamed from: com.google.android.gms.common.internal.i reason: case insensitive filesystem */
public abstract class C0314i {

    /* renamed from: a reason: collision with root package name */
    private static final Object f4747a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static C0314i f4748b;

    /* renamed from: com.google.android.gms.common.internal.i$a */
    protected static final class a {

        /* renamed from: a reason: collision with root package name */
        private final String f4749a;

        /* renamed from: b reason: collision with root package name */
        private final String f4750b;

        /* renamed from: c reason: collision with root package name */
        private final ComponentName f4751c = null;

        /* renamed from: d reason: collision with root package name */
        private final int f4752d;

        public a(String str, String str2, int i2) {
            q.b(str);
            this.f4749a = str;
            q.b(str2);
            this.f4750b = str2;
            this.f4752d = i2;
        }

        public final ComponentName a() {
            return this.f4751c;
        }

        public final String b() {
            return this.f4750b;
        }

        public final int c() {
            return this.f4752d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C0321p.a(this.f4749a, aVar.f4749a) && C0321p.a(this.f4750b, aVar.f4750b) && C0321p.a(this.f4751c, aVar.f4751c) && this.f4752d == aVar.f4752d;
        }

        public final int hashCode() {
            return C0321p.a(this.f4749a, this.f4750b, this.f4751c, Integer.valueOf(this.f4752d));
        }

        public final String toString() {
            String str = this.f4749a;
            return str == null ? this.f4751c.flattenToString() : str;
        }

        public final Intent a(Context context) {
            String str = this.f4749a;
            if (str != null) {
                return new Intent(str).setPackage(this.f4750b);
            }
            return new Intent().setComponent(this.f4751c);
        }
    }

    public static C0314i a(Context context) {
        synchronized (f4747a) {
            if (f4748b == null) {
                f4748b = new E(context.getApplicationContext());
            }
        }
        return f4748b;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void b(a aVar, ServiceConnection serviceConnection, String str);

    public final void a(String str, String str2, int i2, ServiceConnection serviceConnection, String str3) {
        b(new a(str, str2, i2), serviceConnection, str3);
    }
}
