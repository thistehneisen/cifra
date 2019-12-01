package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.internal.C0298a;
import com.google.android.gms.common.api.internal.C0298a.C0062a;
import com.google.android.gms.common.internal.C0321p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.k;
import com.google.android.gms.common.util.l;
import com.google.firebase.c.f;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public class FirebaseApp {

    /* renamed from: a reason: collision with root package name */
    private static final List<String> f6631a = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});

    /* renamed from: b reason: collision with root package name */
    private static final List<String> f6632b = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");

    /* renamed from: c reason: collision with root package name */
    private static final List<String> f6633c = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});

    /* renamed from: d reason: collision with root package name */
    private static final List<String> f6634d = Arrays.asList(new String[0]);

    /* renamed from: e reason: collision with root package name */
    private static final Set<String> f6635e = Collections.emptySet();
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public static final Object f6636f = new Object();

    /* renamed from: g reason: collision with root package name */
    private static final Executor f6637g = new c();

    /* renamed from: h reason: collision with root package name */
    static final Map<String, FirebaseApp> f6638h = new b.d.b();

    /* renamed from: i reason: collision with root package name */
    private final Context f6639i;

    /* renamed from: j reason: collision with root package name */
    private final String f6640j;

    /* renamed from: k reason: collision with root package name */
    private final c f6641k;

    /* renamed from: l reason: collision with root package name */
    private final n f6642l;
    private final SharedPreferences m;
    private final com.google.firebase.a.c n;
    /* access modifiers changed from: private */
    public final AtomicBoolean o = new AtomicBoolean(false);
    private final AtomicBoolean p = new AtomicBoolean();
    private final AtomicBoolean q;
    private final List<a> r = new CopyOnWriteArrayList();
    private final List<Object> s = new CopyOnWriteArrayList();

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    public interface a {
        void a(boolean z);
    }

    @TargetApi(14)
    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class b implements C0062a {

        /* renamed from: a reason: collision with root package name */
        private static AtomicReference<b> f6643a = new AtomicReference<>();

        private b() {
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (k.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f6643a.get() == null) {
                    b bVar = new b();
                    if (f6643a.compareAndSet(null, bVar)) {
                        C0298a.a(application);
                        C0298a.a().a((C0062a) bVar);
                    }
                }
            }
        }

        public void a(boolean z) {
            synchronized (FirebaseApp.f6636f) {
                Iterator it = new ArrayList(FirebaseApp.f6638h.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.o.get()) {
                        firebaseApp.a(z);
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class c implements Executor {

        /* renamed from: a reason: collision with root package name */
        private static final Handler f6644a = new Handler(Looper.getMainLooper());

        private c() {
        }

        public void execute(Runnable runnable) {
            f6644a.post(runnable);
        }
    }

    @TargetApi(24)
    /* compiled from: com.google.firebase:firebase-common@@17.0.0 */
    private static class d extends BroadcastReceiver {

        /* renamed from: a reason: collision with root package name */
        private static AtomicReference<d> f6645a = new AtomicReference<>();

        /* renamed from: b reason: collision with root package name */
        private final Context f6646b;

        public d(Context context) {
            this.f6646b = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f6645a.get() == null) {
                d dVar = new d(context);
                if (f6645a.compareAndSet(null, dVar)) {
                    context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f6636f) {
                for (FirebaseApp a2 : FirebaseApp.f6638h.values()) {
                    a2.g();
                }
            }
            a();
        }

        public void a() {
            this.f6646b.unregisterReceiver(this);
        }
    }

    protected FirebaseApp(Context context, String str, c cVar) {
        q.a(context);
        this.f6639i = context;
        q.b(str);
        this.f6640j = str;
        q.a(cVar);
        this.f6641k = cVar;
        this.m = context.getSharedPreferences(a(str), 0);
        this.q = new AtomicBoolean(h());
        List a2 = h.a(context).a();
        this.f6642l = new n(f6637g, a2, e.a(context, Context.class, new Class[0]), e.a(this, FirebaseApp.class, new Class[0]), e.a(cVar, c.class, new Class[0]), f.a("fire-android", ""), f.a("fire-core", "17.0.0"), com.google.firebase.c.c.b());
        this.n = (com.google.firebase.a.c) this.f6642l.a(com.google.firebase.a.c.class);
    }

    private void f() {
        q.b(!this.p.get(), "FirebaseApp was deleted");
    }

    /* access modifiers changed from: private */
    public void g() {
        boolean b2 = b.g.a.a.b(this.f6639i);
        if (b2) {
            d.b(this.f6639i);
        } else {
            this.f6642l.a(e());
        }
        a(FirebaseApp.class, this, f6631a, b2);
        if (e()) {
            a(FirebaseApp.class, this, f6632b, b2);
            a(Context.class, this.f6639i, f6633c, b2);
        }
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (f6636f) {
            firebaseApp = (FirebaseApp) f6638h.get("[DEFAULT]");
            if (firebaseApp == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Default FirebaseApp is not initialized in this process ");
                sb.append(l.a());
                sb.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(sb.toString());
            }
        }
        return firebaseApp;
    }

    private boolean h() {
        String str = "firebase_data_collection_default_enabled";
        if (this.m.contains(str)) {
            return this.m.getBoolean(str, true);
        }
        try {
            PackageManager packageManager = this.f6639i.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f6639i.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str))) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return true;
    }

    public String c() {
        f();
        return this.f6640j;
    }

    public c d() {
        f();
        return this.f6641k;
    }

    public boolean e() {
        return "[DEFAULT]".equals(c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f6640j.equals(((FirebaseApp) obj).c());
    }

    public int hashCode() {
        return this.f6640j.hashCode();
    }

    public boolean isDataCollectionDefaultEnabled() {
        f();
        return this.q.get();
    }

    public String toString() {
        com.google.android.gms.common.internal.C0321p.a a2 = C0321p.a((Object) this);
        a2.a("name", this.f6640j);
        a2.a("options", this.f6641k);
        return a2.toString();
    }

    public Context b() {
        f();
        return this.f6639i;
    }

    public static FirebaseApp a(Context context) {
        synchronized (f6636f) {
            if (f6638h.containsKey("[DEFAULT]")) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            c a2 = c.a(context);
            if (a2 == null) {
                Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            FirebaseApp a3 = a(context, a2);
            return a3;
        }
    }

    private static String b(String str) {
        return str.trim();
    }

    public static FirebaseApp a(Context context, c cVar) {
        return a(context, cVar, "[DEFAULT]");
    }

    public static FirebaseApp a(Context context, c cVar, String str) {
        FirebaseApp firebaseApp;
        b.b(context);
        String b2 = b(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f6636f) {
            boolean z = !f6638h.containsKey(b2);
            StringBuilder sb = new StringBuilder();
            sb.append("FirebaseApp name ");
            sb.append(b2);
            sb.append(" already exists!");
            q.b(z, sb.toString());
            q.a(context, (Object) "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, b2, cVar);
            f6638h.put(b2, firebaseApp);
        }
        firebaseApp.g();
        return firebaseApp;
    }

    public <T> T a(Class<T> cls) {
        f();
        return this.f6642l.a((Class) cls);
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("com.google.firebase.common.prefs:");
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a a2 : this.r) {
            a2.a(z);
        }
    }

    private <T> void a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        for (String str : iterable) {
            String str2 = "FirebaseApp";
            if (z) {
                try {
                    if (!f6634d.contains(str)) {
                    }
                } catch (ClassNotFoundException unused) {
                    if (!f6635e.contains(str)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(" is not linked. Skipping initialization.");
                        Log.d(str2, sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" is missing, but is required. Check if it has been removed by Proguard.");
                        throw new IllegalStateException(sb2.toString());
                    }
                } catch (NoSuchMethodException unused2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("#getInstance has been removed by Proguard. Add keep rule to prevent it.");
                    throw new IllegalStateException(sb3.toString());
                } catch (InvocationTargetException e2) {
                    Log.wtf(str2, "Firebase API initialization failure.", e2);
                } catch (IllegalAccessException e3) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to initialize ");
                    sb4.append(str);
                    Log.wtf(str2, sb4.toString(), e3);
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }
}
