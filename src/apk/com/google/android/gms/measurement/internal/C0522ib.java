package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.ib reason: case insensitive filesystem */
public final class C0522ib extends C0528jc {

    /* renamed from: c reason: collision with root package name */
    private static final AtomicReference<String[]> f5946c = new AtomicReference<>();

    /* renamed from: d reason: collision with root package name */
    private static final AtomicReference<String[]> f5947d = new AtomicReference<>();

    /* renamed from: e reason: collision with root package name */
    private static final AtomicReference<String[]> f5948e = new AtomicReference<>();

    C0522ib(Ob ob) {
        super(ob);
    }

    private final boolean t() {
        b();
        return this.f5987a.m() && this.f5987a.e().a(3);
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (!t()) {
            return str;
        }
        return a(str, C0553oc.f6048b, C0553oc.f6047a, f5946c);
    }

    /* access modifiers changed from: protected */
    public final String b(String str) {
        if (str == null) {
            return null;
        }
        if (!t()) {
            return str;
        }
        return a(str, C0548nc.f6037b, C0548nc.f6036a, f5947d);
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!t()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return a(str, C0563qc.f6069b, C0563qc.f6068a, f5948e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("experiment_id");
        sb.append("(");
        sb.append(str);
        sb.append(")");
        return sb.toString();
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

    private static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        q.a(strArr);
        q.a(strArr2);
        q.a(atomicReference);
        q.a(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (Wd.e(str, strArr[i2])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i2] == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArr2[i2]);
                        sb.append("(");
                        sb.append(strArr[i2]);
                        sb.append(")");
                        strArr3[i2] = sb.toString();
                    }
                    str2 = strArr3[i2];
                }
                return str2;
            }
        }
        return str;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    /* access modifiers changed from: protected */
    public final String a(C0525j jVar) {
        if (jVar == null) {
            return null;
        }
        if (!t()) {
            return jVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(jVar.f5955c);
        sb.append(",name=");
        sb.append(a(jVar.f5953a));
        sb.append(",params=");
        sb.append(a(jVar.f5954b));
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String a(C0510g gVar) {
        if (gVar == null) {
            return null;
        }
        if (!t()) {
            return gVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Event{appId='");
        sb.append(gVar.f5920a);
        sb.append("', name='");
        sb.append(a(gVar.f5921b));
        sb.append("', params=");
        sb.append(a(gVar.f5925f));
        sb.append("}");
        return sb.toString();
    }

    private final String a(C0520i iVar) {
        if (iVar == null) {
            return null;
        }
        if (!t()) {
            return iVar.toString();
        }
        return a(iVar.f());
    }

    /* access modifiers changed from: protected */
    public final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!t()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(b(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
