package ru.touchin.roboswag.core.observables.storable;

import b.g.h.c;
import e.b.c.e;
import e.b.c.g;
import e.b.k;
import e.b.l;
import e.b.n;
import e.b.o;
import java.lang.reflect.Type;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import l.a.d.b.a.d;
import ru.touchin.roboswag.core.observables.storable.Converter.ConversionException;

/* compiled from: BaseStorable */
public abstract class h<TKey, TObject, TStoreObject, TReturnObject> {

    /* renamed from: a reason: collision with root package name */
    public static final d f11147a = new d("STORABLE");
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static final long f11148b = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: c reason: collision with root package name */
    private final TKey f11149c;

    /* renamed from: d reason: collision with root package name */
    private final Type f11150d;

    /* renamed from: e reason: collision with root package name */
    private final Type f11151e;

    /* renamed from: f reason: collision with root package name */
    private final l<TKey, TStoreObject> f11152f;

    /* renamed from: g reason: collision with root package name */
    private final Converter<TObject, TStoreObject> f11153g;

    /* renamed from: h reason: collision with root package name */
    private final e.b.j.b<ru.touchin.roboswag.core.utils.b<TStoreObject>> f11154h;

    /* renamed from: i reason: collision with root package name */
    private final k<ru.touchin.roboswag.core.utils.b<TStoreObject>> f11155i;

    /* renamed from: j reason: collision with root package name */
    private final k<ru.touchin.roboswag.core.utils.b<TObject>> f11156j;

    /* renamed from: k reason: collision with root package name */
    private final n f11157k;

    /* compiled from: BaseStorable */
    public static class a<TKey, TObject, TStoreObject> {

        /* renamed from: a reason: collision with root package name */
        protected final TKey f11158a;

        /* renamed from: b reason: collision with root package name */
        protected final Type f11159b;
        /* access modifiers changed from: private */

        /* renamed from: c reason: collision with root package name */
        public final Type f11160c;
        /* access modifiers changed from: private */

        /* renamed from: d reason: collision with root package name */
        public final l<TKey, TStoreObject> f11161d;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public final Converter<TObject, TStoreObject> f11162e;
        /* access modifiers changed from: private */

        /* renamed from: f reason: collision with root package name */
        public b f11163f;
        /* access modifiers changed from: private */

        /* renamed from: g reason: collision with root package name */
        public Migration<TKey> f11164g;
        /* access modifiers changed from: private */

        /* renamed from: h reason: collision with root package name */
        public TObject f11165h;
        /* access modifiers changed from: private */

        /* renamed from: i reason: collision with root package name */
        public n f11166i;
        /* access modifiers changed from: private */

        /* renamed from: j reason: collision with root package name */
        public long f11167j;

        protected a(TKey tkey, Type type, Type type2, l<TKey, TStoreObject> lVar, Converter<TObject, TStoreObject> converter) {
            this(tkey, type, type2, lVar, converter, null, null, null, null, h.f11148b);
        }

        protected a(a<TKey, TObject, TStoreObject> aVar) {
            this(aVar.f11158a, aVar.f11159b, aVar.f11160c, aVar.f11161d, aVar.f11162e, aVar.f11163f, aVar.f11164g, aVar.f11165h, aVar.f11166i, aVar.f11167j);
        }

        /* access modifiers changed from: protected */
        public TObject a() {
            return this.f11165h;
        }

        private a(TKey tkey, Type type, Type type2, l<TKey, TStoreObject> lVar, Converter<TObject, TStoreObject> converter, b bVar, Migration<TKey> migration, TObject tobject, n nVar, long j2) {
            this.f11158a = tkey;
            this.f11159b = type;
            this.f11160c = type2;
            this.f11161d = lVar;
            this.f11162e = converter;
            this.f11163f = bVar;
            this.f11164g = migration;
            this.f11165h = tobject;
            this.f11166i = nVar;
            this.f11167j = j2;
        }

        /* access modifiers changed from: protected */
        public void a(TObject tobject) {
            this.f11165h = tobject;
        }
    }

    /* compiled from: BaseStorable */
    public enum b {
        NO_CACHE,
        CACHE_STORE_VALUE,
        CACHE_ACTUAL_VALUE,
        CACHE_STORE_AND_ACTUAL_VALUE
    }

    public h(a<TKey, TObject, TStoreObject> aVar) {
        this(aVar.f11158a, aVar.f11159b, aVar.f11160c, aVar.f11161d, aVar.f11162e, aVar.f11163f, aVar.f11164g, aVar.f11165h, aVar.f11166i, aVar.f11167j);
    }

    public /* synthetic */ void b(Object obj, boolean z, ru.touchin.roboswag.core.utils.b bVar) throws Exception {
        this.f11154h.a(new ru.touchin.roboswag.core.utils.b(obj));
        if (z) {
            f11147a.b("Value of '%s' changed from '%s' to '%s'", this.f11149c, bVar, obj);
            return;
        }
        f11147a.b("Value of '%s' force changed to '%s'", this.f11149c, obj);
    }

    public abstract k<TReturnObject> c();

    /* access modifiers changed from: protected */
    public k<ru.touchin.roboswag.core.utils.b<TObject>> d() {
        return this.f11156j;
    }

    private static b a(Type type, Type type2) {
        boolean z = type instanceof Class;
        if (z && ru.touchin.roboswag.core.utils.a.a((Class) type)) {
            return b.CACHE_ACTUAL_VALUE;
        }
        if (!z || !ru.touchin.roboswag.core.utils.a.a((Class) type2)) {
            return b.NO_CACHE;
        }
        return b.CACHE_STORE_VALUE;
    }

    public o<TReturnObject> b() {
        return c().e();
    }

    private h(TKey tkey, Type type, Type type2, l<TKey, TStoreObject> lVar, Converter<TObject, TStoreObject> converter, b bVar, Migration<TKey> migration, TObject tobject, n nVar, long j2) {
        b bVar2;
        n nVar2;
        this.f11154h = e.b.j.b.j();
        this.f11149c = tkey;
        this.f11150d = type;
        this.f11151e = type2;
        this.f11152f = lVar;
        this.f11153g = converter;
        if (bVar != null) {
            bVar2 = bVar;
        } else {
            bVar2 = a(type, type2);
        }
        if (nVar != null) {
            nVar2 = nVar;
        } else {
            nVar2 = e.b.i.b.a(Executors.newSingleThreadExecutor());
        }
        this.f11157k = nVar2;
        this.f11155i = a(bVar2, migration, tobject, j2);
        this.f11156j = a(this.f11155i, bVar2, j2);
    }

    /* access modifiers changed from: private */
    public ru.touchin.roboswag.core.utils.b<TStoreObject> a(ru.touchin.roboswag.core.utils.b<TStoreObject> bVar, TObject tobject) throws ConversionException {
        if (bVar.a() != null || tobject == null) {
            return bVar;
        }
        try {
            this.f11153g.b(this.f11150d, this.f11151e, tobject);
            return new ru.touchin.roboswag.core.utils.b<>(tobject);
        } catch (ConversionException e2) {
            f11147a.b(e2, "Exception while converting default value of '%s' from '%s' from store %s", this.f11149c, tobject, this.f11152f);
            throw e2;
        }
    }

    private k<ru.touchin.roboswag.core.utils.b<TStoreObject>> a(Migration<TKey> migration) {
        o a2 = this.f11152f.a(this.f11151e, this.f11149c).a((e<? super Throwable>) new d<Object>(this));
        if (migration == null) {
            return a2.b(this.f11157k).a(this.f11157k).f().a(1).j().b(1);
        }
        migration.a(this.f11149c);
        throw null;
    }

    public /* synthetic */ void a(Throwable th) throws Exception {
        f11147a.b(th, "Exception while trying to load value of '%s' from store %s", this.f11149c, this.f11152f);
    }

    private k<ru.touchin.roboswag.core.utils.b<TStoreObject>> a(b bVar, Migration<TKey> migration, TObject tobject, long j2) {
        k<ru.touchin.roboswag.core.utils.b<TStoreObject>> b2 = a(migration).a((l<? extends T>) this.f11154h).b((g<? super T, ? extends R>) new a<Object,Object>(this, tobject));
        return (bVar == b.CACHE_STORE_VALUE || bVar == b.CACHE_STORE_AND_ACTUAL_VALUE) ? e.b.g.a.a((k<T>) new l.a.d.b.b.b<T>(b2.a(1), j2, TimeUnit.MILLISECONDS)) : b2;
    }

    private k<ru.touchin.roboswag.core.utils.b<TObject>> a(k<ru.touchin.roboswag.core.utils.b<TStoreObject>> kVar, b bVar, long j2) {
        k<ru.touchin.roboswag.core.utils.b<TObject>> b2 = kVar.b((g<? super T, ? extends R>) new b<Object,Object>(this));
        return (bVar == b.CACHE_ACTUAL_VALUE || bVar == b.CACHE_STORE_AND_ACTUAL_VALUE) ? e.b.g.a.a((k<T>) new l.a.d.b.b.b<T>(b2.a(1), j2, TimeUnit.MILLISECONDS)) : b2;
    }

    public /* synthetic */ ru.touchin.roboswag.core.utils.b a(ru.touchin.roboswag.core.utils.b bVar) throws Exception {
        try {
            Converter<TObject, TStoreObject> converter = this.f11153g;
            Type type = this.f11150d;
            Type type2 = this.f11151e;
            Object a2 = bVar.a();
            converter.a(type, type2, a2);
            return new ru.touchin.roboswag.core.utils.b(a2);
        } catch (ConversionException e2) {
            f11147a.b(e2, "Exception while trying to converting value of '%s' from store %s by %s", this.f11149c, bVar, this.f11152f, this.f11153g);
            throw e2;
        }
    }

    private e.b.b a(TObject tobject, boolean z) {
        return (z ? this.f11155i.e() : o.a(new ru.touchin.roboswag.core.utils.b(null))).a(this.f11157k).b((g<? super T, ? extends e.b.d>) new e<Object,Object>(this, tobject, z));
    }

    public /* synthetic */ e.b.d a(Object obj, boolean z, ru.touchin.roboswag.core.utils.b bVar) throws Exception {
        try {
            this.f11153g.b(this.f11150d, this.f11151e, obj);
            if (!z || !c.a(obj, bVar.a())) {
                return this.f11152f.a(this.f11151e, this.f11149c, obj).a((e<? super Throwable>) new f<Object>(this, obj)).a(this.f11157k).a((e.b.d) e.b.b.a((e.b.c.a) new c(this, obj, z, bVar)));
            }
            return e.b.b.b();
        } catch (ConversionException e2) {
            f11147a.b(e2, "Exception while trying to store value of '%s' from store %s by %s", this.f11149c, obj, this.f11152f, this.f11153g);
            return e.b.b.a((Throwable) e2);
        }
    }

    public /* synthetic */ void a(Object obj, Throwable th) throws Exception {
        f11147a.b(th, "Exception while trying to store value of '%s' from store %s by %s", this.f11149c, obj, this.f11152f, this.f11153g);
    }

    public e.b.b a(TObject tobject) {
        return a(tobject, true);
    }
}
