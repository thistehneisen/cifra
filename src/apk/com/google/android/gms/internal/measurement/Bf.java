package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.b;
import java.util.ArrayList;

final class Bf extends a {

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f4870e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ String f4871f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Context f4872g;

    /* renamed from: h reason: collision with root package name */
    private final /* synthetic */ Bundle f4873h;

    /* renamed from: i reason: collision with root package name */
    private final /* synthetic */ Cf f4874i;

    Bf(Cf cf, String str, String str2, Context context, Bundle bundle) {
        this.f4874i = cf;
        this.f4870e = str;
        this.f4871f = str2;
        this.f4872g = context;
        this.f4873h = bundle;
        super(cf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r4 < r3) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ RemoteException -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[Catch:{ RemoteException -> 0x009e }] */
    public final void a() {
        String str;
        String str2;
        String str3;
        boolean z;
        int i2;
        boolean z2;
        try {
            this.f4874i.f4894l = new ArrayList();
            if (Cf.c(this.f4870e, this.f4871f)) {
                String str4 = this.f4871f;
                str2 = this.f4870e;
                str = str4;
                str3 = this.f4874i.f4890h;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            Cf.i(this.f4872g);
            if (!Cf.f4885c.booleanValue()) {
                if (str2 == null) {
                    z = false;
                    this.f4874i.p = this.f4874i.a(this.f4872g, z);
                    if (this.f4874i.p != null) {
                        Log.w(this.f4874i.f4890h, "Failed to connect to measurement client.");
                        return;
                    }
                    int d2 = Cf.h(this.f4872g);
                    int e2 = Cf.g(this.f4872g);
                    if (z) {
                        i2 = Math.max(d2, e2);
                    } else {
                        i2 = d2 > 0 ? d2 : e2;
                        if (d2 > 0) {
                        }
                        z2 = false;
                        Af af = new Af(16250, (long) i2, z2, str3, str2, str, this.f4873h);
                        this.f4874i.p.initialize(b.a(this.f4872g), af, this.f4895a);
                        return;
                    }
                    z2 = true;
                    Af af2 = new Af(16250, (long) i2, z2, str3, str2, str, this.f4873h);
                    this.f4874i.p.initialize(b.a(this.f4872g), af2, this.f4895a);
                    return;
                }
            }
            z = true;
            this.f4874i.p = this.f4874i.a(this.f4872g, z);
            if (this.f4874i.p != null) {
            }
        } catch (RemoteException e3) {
            this.f4874i.a((Exception) e3, true, false);
        }
    }
}
