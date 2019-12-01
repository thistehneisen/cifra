package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import b.g.a.b;

/* renamed from: com.google.android.gms.internal.measurement.qa reason: case insensitive filesystem */
final class C0422qa implements C0392la {

    /* renamed from: a reason: collision with root package name */
    static C0422qa f5340a;

    /* renamed from: b reason: collision with root package name */
    private final Context f5341b;

    private C0422qa(Context context) {
        this.f5341b = context;
        this.f5341b.getContentResolver().registerContentObserver(C0362ga.f5189a, true, new C0433sa(this, null));
    }

    static C0422qa a(Context context) {
        C0422qa qaVar;
        synchronized (C0422qa.class) {
            if (f5340a == null) {
                f5340a = b.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C0422qa(context) : new C0422qa();
            }
            qaVar = f5340a;
        }
        return qaVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final String a(String str) {
        if (this.f5341b == null) {
            return null;
        }
        try {
            return (String) C0410oa.a(new C0416pa(this, str));
        } catch (SecurityException e2) {
            String str2 = "Unable to read GServices for: ";
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ String b(String str) {
        return C0362ga.a(this.f5341b.getContentResolver(), str, (String) null);
    }

    private C0422qa() {
        this.f5341b = null;
    }
}
