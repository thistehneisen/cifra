package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.a.b.o;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.j;
import io.fabric.sdk.android.services.concurrency.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric */
public class f {

    /* renamed from: a reason: collision with root package name */
    static volatile f f9000a;

    /* renamed from: b reason: collision with root package name */
    static final o f9001b = new c();

    /* renamed from: c reason: collision with root package name */
    private final Context f9002c;

    /* renamed from: d reason: collision with root package name */
    private final Map<Class<? extends l>, l> f9003d;

    /* renamed from: e reason: collision with root package name */
    private final ExecutorService f9004e;

    /* renamed from: f reason: collision with root package name */
    private final Handler f9005f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public final j<f> f9006g;

    /* renamed from: h reason: collision with root package name */
    private final j<?> f9007h;

    /* renamed from: i reason: collision with root package name */
    private final y f9008i;

    /* renamed from: j reason: collision with root package name */
    private b f9009j;

    /* renamed from: k reason: collision with root package name */
    private WeakReference<Activity> f9010k;
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public AtomicBoolean f9011l = new AtomicBoolean(false);
    final o m;
    final boolean n;

    /* compiled from: Fabric */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        private final Context f9012a;

        /* renamed from: b reason: collision with root package name */
        private l[] f9013b;

        /* renamed from: c reason: collision with root package name */
        private r f9014c;

        /* renamed from: d reason: collision with root package name */
        private Handler f9015d;

        /* renamed from: e reason: collision with root package name */
        private o f9016e;

        /* renamed from: f reason: collision with root package name */
        private boolean f9017f;

        /* renamed from: g reason: collision with root package name */
        private String f9018g;

        /* renamed from: h reason: collision with root package name */
        private String f9019h;

        /* renamed from: i reason: collision with root package name */
        private j<f> f9020i;

        public a(Context context) {
            if (context != null) {
                this.f9012a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public a a(l... lVarArr) {
            if (this.f9013b == null) {
                if (!o.a(this.f9012a).a()) {
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (l lVar : lVarArr) {
                        String identifier = lVar.getIdentifier();
                        char c2 = 65535;
                        int hashCode = identifier.hashCode();
                        if (hashCode != 607220212) {
                            if (hashCode == 1830452504 && identifier.equals("com.crashlytics.sdk.android:crashlytics")) {
                                c2 = 0;
                            }
                        } else if (identifier.equals("com.crashlytics.sdk.android:answers")) {
                            c2 = 1;
                        }
                        if (c2 == 0 || c2 == 1) {
                            arrayList.add(lVar);
                        } else if (!z) {
                            f.e().a("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                            z = true;
                        }
                    }
                    lVarArr = (l[]) arrayList.toArray(new l[0]);
                }
                this.f9013b = lVarArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        public f a() {
            Map map;
            if (this.f9014c == null) {
                this.f9014c = r.a();
            }
            if (this.f9015d == null) {
                this.f9015d = new Handler(Looper.getMainLooper());
            }
            if (this.f9016e == null) {
                if (this.f9017f) {
                    this.f9016e = new c(3);
                } else {
                    this.f9016e = new c();
                }
            }
            if (this.f9019h == null) {
                this.f9019h = this.f9012a.getPackageName();
            }
            if (this.f9020i == null) {
                this.f9020i = j.f9024a;
            }
            l[] lVarArr = this.f9013b;
            if (lVarArr == null) {
                map = new HashMap();
            } else {
                map = f.b((Collection<? extends l>) Arrays.asList(lVarArr));
            }
            Map map2 = map;
            Context applicationContext = this.f9012a.getApplicationContext();
            f fVar = new f(applicationContext, map2, this.f9014c, this.f9015d, this.f9016e, this.f9017f, this.f9020i, new y(applicationContext, this.f9019h, this.f9018g, map2.values()), f.d(this.f9012a));
            return fVar;
        }
    }

    f(Context context, Map<Class<? extends l>, l> map, r rVar, Handler handler, o oVar, boolean z, j jVar, y yVar, Activity activity) {
        this.f9002c = context;
        this.f9003d = map;
        this.f9004e = rVar;
        this.f9005f = handler;
        this.m = oVar;
        this.n = z;
        this.f9006g = jVar;
        this.f9007h = a(map.size());
        this.f9008i = yVar;
        a(activity);
    }

    private static void c(f fVar) {
        f9000a = fVar;
        fVar.i();
    }

    /* access modifiers changed from: private */
    public static Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public static o e() {
        if (f9000a == null) {
            return f9001b;
        }
        return f9000a.m;
    }

    public static boolean g() {
        if (f9000a == null) {
            return false;
        }
        return f9000a.n;
    }

    static f h() {
        if (f9000a != null) {
            return f9000a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    private void i() {
        this.f9009j = new b(this.f9002c);
        this.f9009j.a(new d(this));
        c(this.f9002c);
    }

    public String c() {
        return "io.fabric.sdk.android:fabric";
    }

    public String f() {
        return "1.4.8.32";
    }

    public ExecutorService b() {
        return this.f9004e;
    }

    /* access modifiers changed from: private */
    public static Map<Class<? extends l>, l> b(Collection<? extends l> collection) {
        HashMap hashMap = new HashMap(collection.size());
        a((Map<Class<? extends l>, l>) hashMap, collection);
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    public void c(Context context) {
        StringBuilder sb;
        Future b2 = b(context);
        Collection d2 = d();
        p pVar = new p(b2, d2);
        ArrayList<l> arrayList = new ArrayList<>(d2);
        Collections.sort(arrayList);
        pVar.injectParameters(context, this, j.f9024a, this.f9008i);
        for (l injectParameters : arrayList) {
            injectParameters.injectParameters(context, this, this.f9007h, this.f9008i);
        }
        pVar.initialize();
        String str = "Fabric";
        String str2 = " [Version: ";
        if (e().a(str, 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(c());
            sb.append(str2);
            sb.append(f());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (l lVar : arrayList) {
            lVar.initializationTask.addDependency(pVar.initializationTask);
            a(this.f9003d, lVar);
            lVar.initialize();
            if (sb != null) {
                sb.append(lVar.getIdentifier());
                sb.append(str2);
                sb.append(lVar.getVersion());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            e().d(str, sb.toString());
        }
    }

    public Collection<l> d() {
        return this.f9003d.values();
    }

    public static f a(Context context, l... lVarArr) {
        if (f9000a == null) {
            synchronized (f.class) {
                if (f9000a == null) {
                    a aVar = new a(context);
                    aVar.a(lVarArr);
                    c(aVar.a());
                }
            }
        }
        return f9000a;
    }

    /* access modifiers changed from: 0000 */
    public Future<Map<String, n>> b(Context context) {
        return b().submit(new h(context.getPackageCodePath()));
    }

    public f a(Activity activity) {
        this.f9010k = new WeakReference<>(activity);
        return this;
    }

    public Activity a() {
        WeakReference<Activity> weakReference = this.f9010k;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void a(Map<Class<? extends l>, l> map, l lVar) {
        Class[] value;
        j jVar = lVar.dependsOnAnnotation;
        if (jVar != null) {
            for (Class cls : jVar.value()) {
                if (cls.isInterface()) {
                    for (l lVar2 : map.values()) {
                        if (cls.isAssignableFrom(lVar2.getClass())) {
                            lVar.initializationTask.addDependency(lVar2.initializationTask);
                        }
                    }
                } else if (((l) map.get(cls)) != null) {
                    lVar.initializationTask.addDependency(((l) map.get(cls)).initializationTask);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    public static <T extends l> T a(Class<T> cls) {
        return (l) h().f9003d.get(cls);
    }

    private static void a(Map<Class<? extends l>, l> map, Collection<? extends l> collection) {
        for (l lVar : collection) {
            map.put(lVar.getClass(), lVar);
            if (lVar instanceof m) {
                a(map, ((m) lVar).getKits());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public j<?> a(int i2) {
        return new e(this, i2);
    }
}
