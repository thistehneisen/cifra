package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.Af;

/* renamed from: com.google.android.gms.measurement.internal.rc reason: case insensitive filesystem */
public final class C0567rc {

    /* renamed from: a reason: collision with root package name */
    final Context f6078a;

    /* renamed from: b reason: collision with root package name */
    String f6079b;

    /* renamed from: c reason: collision with root package name */
    String f6080c;

    /* renamed from: d reason: collision with root package name */
    String f6081d;

    /* renamed from: e reason: collision with root package name */
    Boolean f6082e;

    /* renamed from: f reason: collision with root package name */
    long f6083f;

    /* renamed from: g reason: collision with root package name */
    Af f6084g;

    /* renamed from: h reason: collision with root package name */
    boolean f6085h = true;

    public C0567rc(Context context, Af af) {
        q.a(context);
        Context applicationContext = context.getApplicationContext();
        q.a(applicationContext);
        this.f6078a = applicationContext;
        if (af != null) {
            this.f6084g = af;
            this.f6079b = af.f4857f;
            this.f6080c = af.f4856e;
            this.f6081d = af.f4855d;
            this.f6085h = af.f4854c;
            this.f6083f = af.f4853b;
            Bundle bundle = af.f4858g;
            if (bundle != null) {
                this.f6082e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
