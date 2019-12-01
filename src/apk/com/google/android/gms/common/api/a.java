package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.C0308c;
import com.google.android.gms.common.internal.C0316k;
import com.google.android.gms.common.internal.q;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a reason: collision with root package name */
    private final C0059a<?, O> f4530a;

    /* renamed from: b reason: collision with root package name */
    private final i<?, O> f4531b = null;

    /* renamed from: c reason: collision with root package name */
    private final g<?> f4532c;

    /* renamed from: d reason: collision with root package name */
    private final j<?> f4533d;

    /* renamed from: e reason: collision with root package name */
    private final String f4534e;

    /* renamed from: com.google.android.gms.common.api.a$a reason: collision with other inner class name */
    public static abstract class C0059a<T extends f, O> extends e<T, O> {
        public abstract T a(Context context, Looper looper, C0308c cVar, O o, d dVar, e eVar);
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a reason: collision with other inner class name */
        public interface C0060a extends c, C0061d {
            Account a();
        }

        public interface b extends c {
            GoogleSignInAccount b();
        }

        public interface c extends d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$d reason: collision with other inner class name */
        public interface C0061d extends d {
        }

        public interface e extends c, C0061d {
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a(com.google.android.gms.common.internal.C0307b.c cVar);

        void a(com.google.android.gms.common.internal.C0307b.e eVar);

        void a(C0316k kVar, Set<Scope> set);

        boolean a();

        String b();

        void c();

        boolean d();

        int e();

        com.google.android.gms.common.d[] f();

        boolean g();

        boolean isConnected();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public interface h<T extends IInterface> extends b {
        T a(IBinder iBinder);

        void a(int i2, T t);

        String h();

        String i();
    }

    public static abstract class i<T extends h, O> extends e<T, O> {
    }

    public static final class j<C extends h> extends c<C> {
    }

    public <C extends f> a(String str, C0059a<C, O> aVar, g<C> gVar) {
        q.a(aVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        q.a(gVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.f4534e = str;
        this.f4530a = aVar;
        this.f4532c = gVar;
        this.f4533d = null;
    }

    public final String a() {
        return this.f4534e;
    }

    public final C0059a<?, O> b() {
        q.b(this.f4530a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f4530a;
    }
}
