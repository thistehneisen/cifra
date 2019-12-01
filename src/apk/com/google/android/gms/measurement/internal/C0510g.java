package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.g reason: case insensitive filesystem */
public final class C0510g {

    /* renamed from: a reason: collision with root package name */
    final String f5920a;

    /* renamed from: b reason: collision with root package name */
    final String f5921b;

    /* renamed from: c reason: collision with root package name */
    private final String f5922c;

    /* renamed from: d reason: collision with root package name */
    final long f5923d;

    /* renamed from: e reason: collision with root package name */
    final long f5924e;

    /* renamed from: f reason: collision with root package name */
    final C0520i f5925f;

    private C0510g(Ob ob, String str, String str2, String str3, long j2, long j3, C0520i iVar) {
        q.b(str2);
        q.b(str3);
        q.a(iVar);
        this.f5920a = str2;
        this.f5921b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f5922c = str;
        this.f5923d = j2;
        this.f5924e = j3;
        long j4 = this.f5924e;
        if (j4 != 0 && j4 > this.f5923d) {
            ob.e().w().a("Event created with reverse previous/current timestamps. appId, name", C0532kb.a(str2), C0532kb.a(str3));
        }
        this.f5925f = iVar;
    }

    /* access modifiers changed from: 0000 */
    public final C0510g a(Ob ob, long j2) {
        C0510g gVar = new C0510g(ob, this.f5922c, this.f5920a, this.f5921b, this.f5923d, j2, this.f5925f);
        return gVar;
    }

    public final String toString() {
        String str = this.f5920a;
        String str2 = this.f5921b;
        String valueOf = String.valueOf(this.f5925f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    C0510g(Ob ob, String str, String str2, String str3, long j2, long j3, Bundle bundle) {
        C0520i iVar;
        q.b(str2);
        q.b(str3);
        this.f5920a = str2;
        this.f5921b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f5922c = str;
        this.f5923d = j2;
        this.f5924e = j3;
        long j4 = this.f5924e;
        if (j4 != 0 && j4 > this.f5923d) {
            ob.e().w().a("Event created with reverse previous/current timestamps. appId", C0532kb.a(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            iVar = new C0520i(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    ob.e().t().a("Param name can't be null");
                    it.remove();
                } else {
                    Object a2 = ob.G().a(str4, bundle2.get(str4));
                    if (a2 == null) {
                        ob.e().w().a("Param value can't be null", ob.F().b(str4));
                        it.remove();
                    } else {
                        ob.G().a(bundle2, str4, a2);
                    }
                }
            }
            iVar = new C0520i(bundle2);
        }
        this.f5925f = iVar;
    }
}
