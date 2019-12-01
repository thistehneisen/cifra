package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.d.C0060a;
import com.google.android.gms.common.api.a.d.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.internal.C0299b.a;
import com.google.android.gms.common.api.internal.D;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.C0308c;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class c<O extends d> {

    /* renamed from: a reason: collision with root package name */
    private final Context f4535a;

    /* renamed from: b reason: collision with root package name */
    private final a<O> f4536b;

    /* renamed from: c reason: collision with root package name */
    private final O f4537c;

    /* renamed from: d reason: collision with root package name */
    private final D<O> f4538d;

    /* renamed from: e reason: collision with root package name */
    private final int f4539e;

    public f a(Looper looper, a<O> aVar) {
        return this.f4536b.b().a(this.f4535a, looper, a().a(), this.f4537c, aVar, aVar);
    }

    public final int b() {
        return this.f4539e;
    }

    public final D<O> c() {
        return this.f4538d;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    public C0308c.a a() {
        Account account;
        O o;
        Set set;
        C0308c.a aVar = new C0308c.a();
        O o2 = this.f4537c;
        if (o2 instanceof b) {
            GoogleSignInAccount b2 = ((b) o2).b();
            if (b2 != null) {
                account = b2.f();
                aVar.a(account);
                o = this.f4537c;
                if (o instanceof b) {
                    GoogleSignInAccount b3 = ((b) o).b();
                    if (b3 != null) {
                        set = b3.n();
                        aVar.a((Collection<Scope>) set);
                        aVar.a(this.f4535a.getClass().getName());
                        aVar.b(this.f4535a.getPackageName());
                        return aVar;
                    }
                }
                set = Collections.emptySet();
                aVar.a((Collection<Scope>) set);
                aVar.a(this.f4535a.getClass().getName());
                aVar.b(this.f4535a.getPackageName());
                return aVar;
            }
        }
        O o3 = this.f4537c;
        account = o3 instanceof C0060a ? ((C0060a) o3).a() : null;
        aVar.a(account);
        o = this.f4537c;
        if (o instanceof b) {
        }
        set = Collections.emptySet();
        aVar.a((Collection<Scope>) set);
        aVar.a(this.f4535a.getClass().getName());
        aVar.b(this.f4535a.getPackageName());
        return aVar;
    }

    public v a(Context context, Handler handler) {
        return new v(context, handler, a().a());
    }
}
