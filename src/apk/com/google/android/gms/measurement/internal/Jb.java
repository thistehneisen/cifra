package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import b.d.b;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.C;
import com.google.android.gms.internal.measurement.C.a;
import com.google.android.gms.internal.measurement.C0337ca;
import com.google.android.gms.internal.measurement.C0344da;
import com.google.android.gms.internal.measurement.C0350ea;
import com.google.android.gms.internal.measurement.C0413od;
import com.google.android.gms.internal.measurement.C0425qd;
import com.google.android.gms.internal.measurement.D;
import com.google.android.gms.internal.measurement.F;
import com.google.android.gms.internal.measurement.M;
import java.io.IOException;
import java.util.Map;

public final class Jb extends Ld implements he {

    /* renamed from: d reason: collision with root package name */
    private static int f5604d = 65535;

    /* renamed from: e reason: collision with root package name */
    private static int f5605e = 2;

    /* renamed from: f reason: collision with root package name */
    private final Map<String, Map<String, String>> f5606f = new b();

    /* renamed from: g reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f5607g = new b();

    /* renamed from: h reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f5608h = new b();

    /* renamed from: i reason: collision with root package name */
    private final Map<String, C0344da> f5609i = new b();

    /* renamed from: j reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f5610j = new b();

    /* renamed from: k reason: collision with root package name */
    private final Map<String, String> f5611k = new b();

    Jb(Kd kd) {
        super(kd);
    }

    private final void i(String str) {
        t();
        j();
        q.b(str);
        if (this.f5609i.get(str) == null) {
            byte[] d2 = p().d(str);
            if (d2 == null) {
                this.f5606f.put(str, null);
                this.f5607g.put(str, null);
                this.f5608h.put(str, null);
                this.f5609i.put(str, null);
                this.f5611k.put(str, null);
                this.f5610j.put(str, null);
                return;
            }
            C0344da a2 = a(str, d2);
            this.f5606f.put(str, a(a2));
            a(str, a2);
            this.f5609i.put(str, a2);
            this.f5611k.put(str, null);
        }
    }

    /* access modifiers changed from: protected */
    public final C0344da a(String str) {
        t();
        j();
        q.b(str);
        i(str);
        return (C0344da) this.f5609i.get(str);
    }

    /* access modifiers changed from: protected */
    public final String b(String str) {
        j();
        return (String) this.f5611k.get(str);
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        j();
        this.f5611k.put(str, null);
    }

    /* access modifiers changed from: 0000 */
    public final void d(String str) {
        j();
        this.f5609i.remove(str);
    }

    /* access modifiers changed from: 0000 */
    public final boolean e(String str) {
        j();
        C0344da a2 = a(str);
        if (a2 == null) {
            return false;
        }
        Boolean bool = a2.f5161j;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final long f(String str) {
        String a2 = a(str, "measurement.account.time_zone_offset_minutes");
        if (!TextUtils.isEmpty(a2)) {
            try {
                return Long.parseLong(a2);
            } catch (NumberFormatException e2) {
                e().w().a("Unable to parse timezone offset. appId", C0532kb.a(str), e2);
            }
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final boolean g(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: 0000 */
    public final boolean h(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_public"));
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

    public final /* bridge */ /* synthetic */ Sd n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ ce o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ ke p() {
        return super.p();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    /* access modifiers changed from: 0000 */
    public final boolean b(String str, String str2) {
        j();
        i(str);
        if (g(str) && Wd.e(str2)) {
            return true;
        }
        if (h(str) && Wd.a(str2)) {
            return true;
        }
        Map map = (Map) this.f5607g.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final boolean c(String str, String str2) {
        j();
        i(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f5608h.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final int d(String str, String str2) {
        j();
        i(str);
        Map map = (Map) this.f5610j.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final String a(String str, String str2) {
        j();
        i(str);
        Map map = (Map) this.f5606f.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    private static Map<String, String> a(C0344da daVar) {
        b bVar = new b();
        if (daVar != null) {
            M[] mArr = daVar.f5157f;
            if (mArr != null) {
                for (M m : mArr) {
                    if (m != null) {
                        bVar.put(m.o(), m.p());
                    }
                }
            }
        }
        return bVar;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    private final void a(String str, C0344da daVar) {
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        if (daVar != null) {
            C0350ea[] eaVarArr = daVar.f5158g;
            if (eaVarArr != null) {
                for (C0350ea eaVar : eaVarArr) {
                    if (TextUtils.isEmpty(eaVar.f5167d)) {
                        e().w().a("EventConfig contained null event name");
                    } else {
                        String a2 = C0553oc.a(eaVar.f5167d);
                        if (!TextUtils.isEmpty(a2)) {
                            eaVar.f5167d = a2;
                        }
                        bVar.put(eaVar.f5167d, eaVar.f5168e);
                        bVar2.put(eaVar.f5167d, eaVar.f5169f);
                        Integer num = eaVar.f5170g;
                        if (num != null) {
                            if (num.intValue() < f5605e || eaVar.f5170g.intValue() > f5604d) {
                                e().w().a("Invalid sampling rate. Event name, sample rate", eaVar.f5167d, eaVar.f5170g);
                            } else {
                                bVar3.put(eaVar.f5167d, eaVar.f5170g);
                            }
                        }
                    }
                }
            }
        }
        this.f5607g.put(str, bVar);
        this.f5608h.put(str, bVar2);
        this.f5610j.put(str, bVar3);
    }

    /* access modifiers changed from: protected */
    public final boolean a(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        boolean z;
        String str3 = str;
        t();
        j();
        q.b(str);
        C0344da a2 = a(str, bArr);
        if (a2 == null) {
            return false;
        }
        a(str3, a2);
        this.f5609i.put(str3, a2);
        this.f5611k.put(str3, str2);
        this.f5606f.put(str3, a(a2));
        ce o = o();
        C0337ca[] caVarArr = a2.f5159h;
        q.a(caVarArr);
        for (C0337ca caVar : caVarArr) {
            if (caVar.f5137f != null) {
                int i2 = 0;
                while (true) {
                    C[] cArr = caVar.f5137f;
                    if (i2 >= cArr.length) {
                        break;
                    }
                    a aVar = (a) cArr[i2].k();
                    a aVar2 = (a) aVar.clone();
                    String a3 = C0553oc.a(aVar.j());
                    if (a3 != null) {
                        aVar2.a(a3);
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z2 = z;
                    for (int i3 = 0; i3 < aVar.k(); i3++) {
                        D a4 = aVar.a(i3);
                        String a5 = C0548nc.a(a4.u());
                        if (a5 != null) {
                            D.a aVar3 = (D.a) a4.k();
                            aVar3.a(a5);
                            aVar2.a(i3, (D) aVar3.A());
                            z2 = true;
                        }
                    }
                    if (z2) {
                        caVar.f5137f[i2] = (C) aVar2.A();
                    }
                    i2++;
                }
            }
            if (caVar.f5136e != null) {
                int i4 = 0;
                while (true) {
                    F[] fArr = caVar.f5136e;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    F f2 = fArr[i4];
                    String a6 = C0563qc.a(f2.p());
                    if (a6 != null) {
                        F[] fArr2 = caVar.f5136e;
                        F.a aVar4 = (F.a) f2.k();
                        aVar4.a(a6);
                        fArr2[i4] = (F) aVar4.A();
                    }
                    i4++;
                }
            }
        }
        o.p().a(str3, caVarArr);
        try {
            a2.f5159h = null;
            bArr2 = new byte[a2.b()];
            a2.a(C0425qd.a(bArr2, 0, bArr2.length));
        } catch (IOException e2) {
            e().w().a("Unable to serialize reduced-size config. Storing full config instead. appId", C0532kb.a(str), e2);
            bArr2 = bArr;
        }
        ke p = p();
        q.b(str);
        p.j();
        p.t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) p.x().update("apps", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                p.e().t().a("Failed to update remote config (got 0). appId", C0532kb.a(str));
            }
        } catch (SQLiteException e3) {
            p.e().t().a("Error storing remote config. appId", C0532kb.a(str), e3);
        }
        return true;
    }

    private final C0344da a(String str, byte[] bArr) {
        if (bArr == null) {
            return new C0344da();
        }
        C0413od a2 = C0413od.a(bArr, 0, bArr.length);
        C0344da daVar = new C0344da();
        try {
            daVar.a(a2);
            e().B().a("Parsed config. version, gmp_app_id", daVar.f5154c, daVar.f5155d);
            return daVar;
        } catch (IOException e2) {
            e().w().a("Unable to merge remote config. appId", C0532kb.a(str), e2);
            return new C0344da();
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
