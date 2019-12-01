package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.internal.C0300c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.C0572sc;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Cf {

    /* renamed from: a reason: collision with root package name */
    private static volatile Cf f4883a = null;

    /* renamed from: b reason: collision with root package name */
    private static Boolean f4884b = null;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public static Boolean f4885c = null;

    /* renamed from: d reason: collision with root package name */
    private static boolean f4886d = false;

    /* renamed from: e reason: collision with root package name */
    private static Boolean f4887e = null;

    /* renamed from: f reason: collision with root package name */
    private static String f4888f = "use_dynamite_api";

    /* renamed from: g reason: collision with root package name */
    private static String f4889g = "allow_remote_dynamite";
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final String f4890h;

    /* renamed from: i reason: collision with root package name */
    protected final d f4891i;

    /* renamed from: j reason: collision with root package name */
    private final ExecutorService f4892j;

    /* renamed from: k reason: collision with root package name */
    private final com.google.android.gms.measurement.a.a f4893k;
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public List<Pair<C0572sc, c>> f4894l;
    private int m;
    /* access modifiers changed from: private */
    public boolean n;
    private String o;
    /* access modifiers changed from: private */
    public C0327ae p;

    abstract class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final long f4895a;

        /* renamed from: b reason: collision with root package name */
        final long f4896b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f4897c;

        a(Cf cf) {
            this(true);
        }

        /* access modifiers changed from: 0000 */
        public abstract void a() throws RemoteException;

        /* access modifiers changed from: protected */
        public void b() {
        }

        public void run() {
            if (Cf.this.n) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e2) {
                Cf.this.a(e2, false, this.f4897c);
                b();
            }
        }

        a(boolean z) {
            this.f4895a = Cf.this.f4891i.currentTimeMillis();
            this.f4896b = Cf.this.f4891i.a();
            this.f4897c = z;
        }
    }

    class b implements ActivityLifecycleCallbacks {
        b() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            Cf.this.a((a) new C0450v(this, activity, bundle));
        }

        public final void onActivityDestroyed(Activity activity) {
            Cf.this.a((a) new A(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            Cf.this.a((a) new C0456w(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            Cf.this.a((a) new C0462x(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Be be = new Be();
            Cf.this.a((a) new C0468y(this, activity, be));
            Bundle b2 = be.b(50);
            if (b2 != null) {
                bundle.putAll(b2);
            }
        }

        public final void onActivityStarted(Activity activity) {
            Cf.this.a((a) new C0444u(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            Cf.this.a((a) new C0474z(this, activity));
        }
    }

    static class c extends wf {

        /* renamed from: a reason: collision with root package name */
        private final C0572sc f4900a;

        c(C0572sc scVar) {
            this.f4900a = scVar;
        }

        public final int e() {
            return System.identityHashCode(this.f4900a);
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j2) {
            this.f4900a.onEvent(str, str2, bundle, j2);
        }
    }

    private Cf(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !c(str2, str3)) {
            this.f4890h = "FA";
        } else {
            this.f4890h = str;
        }
        this.f4891i = g.c();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f4892j = threadPoolExecutor;
        this.f4893k = new com.google.android.gms.measurement.a.a(this);
        boolean z = false;
        if (!(!f(context) || g())) {
            this.o = null;
            this.n = true;
            Log.w(this.f4890h, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!c(str2, str3)) {
            this.o = "fa";
            if (str2 == null || str3 == null) {
                boolean z2 = str2 == null;
                if (str3 == null) {
                    z = true;
                }
                if (z2 ^ z) {
                    Log.w(this.f4890h, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f4890h, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.n = true;
                return;
            }
        } else {
            this.o = str2;
        }
        Bf bf = new Bf(this, str2, str3, context, bundle);
        a((a) bf);
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f4890h, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new b());
        }
    }

    public static Cf a(Context context) {
        return a(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static boolean c(String str, String str2) {
        return (str2 == null || str == null || g()) ? false : true;
    }

    private static boolean f(Context context) {
        try {
            C0300c.a(context);
            if (C0300c.a() != null) {
                return true;
            }
        } catch (IllegalStateException unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static int g(Context context) {
        return DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int h(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static void i(Context context) {
        synchronized (Cf.class) {
            try {
                if (f4884b != null && f4885c != null) {
                    return;
                }
                if (a(context, "app_measurement_internal_disable_startup_flags")) {
                    f4884b = Boolean.valueOf(false);
                    f4885c = Boolean.valueOf(false);
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                f4884b = Boolean.valueOf(sharedPreferences.getBoolean(f4888f, false));
                f4885c = Boolean.valueOf(sharedPreferences.getBoolean(f4889g, false));
                Editor edit = sharedPreferences.edit();
                edit.remove(f4888f);
                edit.remove(f4889g);
                edit.apply();
            } catch (ClassCastException | IllegalStateException | NullPointerException e2) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e2);
                f4884b = Boolean.valueOf(false);
                f4885c = Boolean.valueOf(false);
            }
        }
    }

    public final void b(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, null);
    }

    public final String d() {
        Be be = new Be();
        a((a) new C0361g(this, be));
        return be.a(500);
    }

    public final String e() {
        Be be = new Be();
        a((a) new C0373i(this, be));
        return be.a(50);
    }

    public static Cf a(Context context, String str, String str2, String str3, Bundle bundle) {
        q.a(context);
        if (f4883a == null) {
            synchronized (Cf.class) {
                if (f4883a == null) {
                    Cf cf = new Cf(context, str, str2, str3, bundle);
                    f4883a = cf;
                }
            }
        }
        return f4883a;
    }

    private static boolean g() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void b(String str, String str2) {
        a((String) null, str, (Object) str2, false);
    }

    public final String c() {
        Be be = new Be();
        a((a) new C0385k(this, be));
        return be.a(500);
    }

    public final void b(String str) {
        a((a) new C0349e(this, str));
    }

    public final String b() {
        Be be = new Be();
        a((a) new C0379j(this, be));
        return be.a(500);
    }

    public final int c(String str) {
        Be be = new Be();
        a((a) new C0403n(this, str, be));
        Integer num = (Integer) Be.a(be.b(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public static boolean b(Context context) {
        i(context);
        synchronized (Cf.class) {
            if (!f4886d) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"measurement.dynamite.enabled", ""});
                    if ("true".equals(str)) {
                        f4887e = Boolean.valueOf(true);
                    } else if ("false".equals(str)) {
                        f4887e = Boolean.valueOf(false);
                    } else {
                        f4887e = null;
                    }
                    f4886d = true;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                    try {
                        Log.e("FA", "Unable to call SystemProperties.get()", e2);
                        f4887e = null;
                    } finally {
                        f4886d = true;
                    }
                }
            }
        }
        Boolean bool = f4887e;
        if (bool == null) {
            bool = f4884b;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public final void a(a aVar) {
        this.f4892j.execute(aVar);
    }

    /* access modifiers changed from: protected */
    public final C0327ae a(Context context, boolean z) {
        com.google.android.gms.dynamite.DynamiteModule.a aVar;
        if (z) {
            try {
                aVar = DynamiteModule.f4830l;
            } catch (LoadingException e2) {
                a((Exception) e2, true, false);
                return null;
            }
        } else {
            aVar = DynamiteModule.f4827i;
        }
        return qf.asInterface(DynamiteModule.a(context, aVar, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public final void a(Exception exc, boolean z, boolean z2) {
        this.n |= z;
        if (z) {
            Log.w(this.f4890h, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        String str = "Error with data collection. Data lost.";
        if (z2) {
            a(5, str, (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.f4890h, str, exc);
    }

    public final void a(C0572sc scVar) {
        q.a(scVar);
        a((a) new C0409o(this, scVar));
    }

    public final void a(String str, Bundle bundle) {
        a(null, str, bundle, false, true, null);
    }

    private final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l2) {
        C0421q qVar = new C0421q(this, l2, str, str2, bundle, z, z2);
        a((a) qVar);
    }

    public final void a(String str, String str2, Object obj) {
        a(str, str2, obj, true);
    }

    private final void a(String str, String str2, Object obj, boolean z) {
        C0438t tVar = new C0438t(this, str, str2, obj, z);
        a((a) tVar);
    }

    public final void a(Bundle bundle) {
        a((a) new C0432s(this, bundle));
    }

    public final void a(String str, String str2, Bundle bundle) {
        a((a) new C0336c(this, str, str2, bundle));
    }

    public final List<Bundle> a(String str, String str2) {
        Be be = new Be();
        a((a) new C0329b(this, str, str2, be));
        List<Bundle> list = (List) Be.a(be.b(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void a(Activity activity, String str, String str2) {
        a((a) new C0343d(this, activity, str, str2));
    }

    public final void a(String str) {
        a((a) new C0355f(this, str));
    }

    public final long a() {
        Be be = new Be();
        a((a) new C0367h(this, be));
        Long l2 = (Long) Be.a(be.b(500), Long.class);
        if (l2 != null) {
            return l2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f4891i.currentTimeMillis()).nextLong();
        int i2 = this.m + 1;
        this.m = i2;
        return nextLong + ((long) i2);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        Be be = new Be();
        C0397m mVar = new C0397m(this, str, str2, z, be);
        a((a) mVar);
        Bundle b2 = be.b(5000);
        if (b2 == null || b2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(b2.size());
        for (String str3 : b2.keySet()) {
            Object obj = b2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void a(int i2, String str, Object obj, Object obj2, Object obj3) {
        C0391l lVar = new C0391l(this, false, 5, str, obj, null, null);
        a((a) lVar);
    }

    public final void a(boolean z) {
        a((a) new C0415p(this, z));
    }

    private static boolean a(Context context, String str) {
        q.b(str);
        try {
            ApplicationInfo a2 = com.google.android.gms.common.b.c.a(context).a(context.getPackageName(), 128);
            if (a2 != null) {
                if (a2.metaData != null) {
                    return a2.metaData.getBoolean(str);
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }
}
