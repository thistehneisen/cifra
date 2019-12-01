package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import b.d.d;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.c reason: case insensitive filesystem */
public final class C0308c {

    /* renamed from: a reason: collision with root package name */
    private final Account f4716a;

    /* renamed from: b reason: collision with root package name */
    private final Set<Scope> f4717b;

    /* renamed from: c reason: collision with root package name */
    private final Set<Scope> f4718c;

    /* renamed from: d reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b> f4719d;

    /* renamed from: e reason: collision with root package name */
    private final int f4720e;

    /* renamed from: f reason: collision with root package name */
    private final View f4721f;

    /* renamed from: g reason: collision with root package name */
    private final String f4722g;

    /* renamed from: h reason: collision with root package name */
    private final String f4723h;

    /* renamed from: i reason: collision with root package name */
    private final c.b.a.b.c.a f4724i;

    /* renamed from: j reason: collision with root package name */
    private Integer f4725j;

    /* renamed from: com.google.android.gms.common.internal.c$a */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private Account f4726a;

        /* renamed from: b reason: collision with root package name */
        private d<Scope> f4727b;

        /* renamed from: c reason: collision with root package name */
        private Map<com.google.android.gms.common.api.a<?>, b> f4728c;

        /* renamed from: d reason: collision with root package name */
        private int f4729d = 0;

        /* renamed from: e reason: collision with root package name */
        private View f4730e;

        /* renamed from: f reason: collision with root package name */
        private String f4731f;

        /* renamed from: g reason: collision with root package name */
        private String f4732g;

        /* renamed from: h reason: collision with root package name */
        private c.b.a.b.c.a f4733h = c.b.a.b.c.a.f3066a;

        public final a a(Account account) {
            this.f4726a = account;
            return this;
        }

        public final a b(String str) {
            this.f4731f = str;
            return this;
        }

        public final a a(Collection<Scope> collection) {
            if (this.f4727b == null) {
                this.f4727b = new d<>();
            }
            this.f4727b.addAll(collection);
            return this;
        }

        public final a a(String str) {
            this.f4732g = str;
            return this;
        }

        public final C0308c a() {
            C0308c cVar = new C0308c(this.f4726a, this.f4727b, this.f4728c, this.f4729d, this.f4730e, this.f4731f, this.f4732g, this.f4733h);
            return cVar;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$b */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        public final Set<Scope> f4734a;
    }

    public C0308c(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i2, View view, String str, String str2, c.b.a.b.c.a aVar) {
        this.f4716a = account;
        this.f4717b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.f4719d = map;
        this.f4721f = view;
        this.f4720e = i2;
        this.f4722g = str;
        this.f4723h = str2;
        this.f4724i = aVar;
        HashSet hashSet = new HashSet(this.f4717b);
        for (b bVar : this.f4719d.values()) {
            hashSet.addAll(bVar.f4734a);
        }
        this.f4718c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.f4716a;
    }

    public final Account b() {
        Account account = this.f4716a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> c() {
        return this.f4718c;
    }

    public final Integer d() {
        return this.f4725j;
    }

    public final String e() {
        return this.f4723h;
    }

    public final String f() {
        return this.f4722g;
    }

    public final Set<Scope> g() {
        return this.f4717b;
    }

    public final c.b.a.b.c.a h() {
        return this.f4724i;
    }

    public final void a(Integer num) {
        this.f4725j = num;
    }
}
