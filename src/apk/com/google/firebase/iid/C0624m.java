package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.h;

/* renamed from: com.google.firebase.iid.m reason: case insensitive filesystem */
abstract class C0624m<T> {

    /* renamed from: a reason: collision with root package name */
    final int f6825a;

    /* renamed from: b reason: collision with root package name */
    final h<T> f6826b = new h<>();

    /* renamed from: c reason: collision with root package name */
    final int f6827c;

    /* renamed from: d reason: collision with root package name */
    final Bundle f6828d;

    C0624m(int i2, int i3, Bundle bundle) {
        this.f6825a = i2;
        this.f6827c = i3;
        this.f6828d = bundle;
    }

    /* access modifiers changed from: 0000 */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: 0000 */
    public final void a(T t) {
        String str = "MessengerIpcClient";
        if (Log.isLoggable(str, 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d(str, sb.toString());
        }
        this.f6826b.a(t);
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean a();

    public String toString() {
        int i2 = this.f6827c;
        int i3 = this.f6825a;
        boolean a2 = a();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(a2);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final void a(zzam zzam) {
        String str = "MessengerIpcClient";
        if (Log.isLoggable(str, 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzam);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d(str, sb.toString());
        }
        this.f6826b.a((Exception) zzam);
    }
}
