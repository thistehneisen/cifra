package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

public final class Aa {

    /* renamed from: a reason: collision with root package name */
    private final String f4839a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Uri f4840b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final String f4841c;
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final String f4842d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f4843e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f4844f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f4845g;

    /* renamed from: h reason: collision with root package name */
    private final boolean f4846h;

    /* renamed from: i reason: collision with root package name */
    private final Ea<Context, Boolean> f4847i;

    public Aa(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final C0439ta<Long> a(String str, long j2) {
        return C0439ta.b(this, str, j2);
    }

    private Aa(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, Ea<Context, Boolean> ea) {
        this.f4839a = null;
        this.f4840b = uri;
        this.f4841c = str2;
        this.f4842d = str3;
        this.f4843e = false;
        this.f4844f = false;
        this.f4845g = false;
        this.f4846h = false;
        this.f4847i = null;
    }

    public final C0439ta<Boolean> a(String str, boolean z) {
        return C0439ta.b(this, str, z);
    }

    public final C0439ta<Double> a(String str, double d2) {
        return C0439ta.b(this, str, -3.0d);
    }

    public final C0439ta<String> a(String str, String str2) {
        return C0439ta.b(this, str, str2);
    }
}
