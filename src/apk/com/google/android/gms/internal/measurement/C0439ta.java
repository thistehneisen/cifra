package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.measurement.ta reason: case insensitive filesystem */
public abstract class C0439ta<T> {

    /* renamed from: a reason: collision with root package name */
    private static final Object f5373a = new Object();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b reason: collision with root package name */
    private static Context f5374b = null;

    /* renamed from: c reason: collision with root package name */
    private static boolean f5375c = false;

    /* renamed from: d reason: collision with root package name */
    private static final AtomicInteger f5376d = new AtomicInteger();

    /* renamed from: e reason: collision with root package name */
    private final Aa f5377e;

    /* renamed from: f reason: collision with root package name */
    private final String f5378f;

    /* renamed from: g reason: collision with root package name */
    private final T f5379g;

    /* renamed from: h reason: collision with root package name */
    private volatile int f5380h;

    /* renamed from: i reason: collision with root package name */
    private volatile T f5381i;

    private C0439ta(Aa aa, String str, T t) {
        this.f5380h = -1;
        if (aa.f4840b != null) {
            this.f5377e = aa;
            this.f5378f = str;
            this.f5379g = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void a(Context context) {
        synchronized (f5373a) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f5374b != context) {
                synchronized (C0368ha.class) {
                    C0368ha.f5207a.clear();
                }
                synchronized (C0475za.class) {
                    C0475za.f5443a.clear();
                }
                synchronized (C0422qa.class) {
                    C0422qa.f5340a = null;
                }
                f5376d.incrementAndGet();
                f5374b = context;
            }
        }
    }

    static void b() {
        f5376d.incrementAndGet();
    }

    private final T d() {
        C0392la laVar;
        Aa aa = this.f5377e;
        String str = (String) C0422qa.a(f5374b).a("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        if (!(str != null && C0362ga.f5191c.matcher(str).matches())) {
            if (this.f5377e.f4840b == null) {
                Context context = f5374b;
                Aa aa2 = this.f5377e;
                laVar = C0475za.a(context, (String) null);
            } else if (C0427ra.a(f5374b, this.f5377e.f4840b)) {
                Aa aa3 = this.f5377e;
                laVar = C0368ha.a(f5374b.getContentResolver(), this.f5377e.f4840b);
            } else {
                laVar = null;
            }
            if (laVar != null) {
                Object a2 = laVar.a(c());
                if (a2 != null) {
                    return a(a2);
                }
            }
        } else {
            String str2 = "PhenotypeFlag";
            if (Log.isLoggable(str2, 3)) {
                String str3 = "Bypass reading Phenotype values for flag: ";
                String valueOf = String.valueOf(c());
                Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            }
        }
        return null;
    }

    private final T e() {
        Aa aa = this.f5377e;
        Object a2 = C0422qa.a(f5374b).a(a(this.f5377e.f4841c));
        if (a2 != null) {
            return a(a2);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public abstract T a(Object obj);

    public final String c() {
        return a(this.f5377e.f4842d);
    }

    /* access modifiers changed from: private */
    public static C0439ta<Long> b(Aa aa, String str, long j2) {
        return new C0457wa(aa, str, Long.valueOf(j2));
    }

    /* access modifiers changed from: private */
    public static C0439ta<Boolean> b(Aa aa, String str, boolean z) {
        return new C0451va(aa, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static C0439ta<Double> b(Aa aa, String str, double d2) {
        return new C0469ya(aa, str, Double.valueOf(d2));
    }

    /* access modifiers changed from: private */
    public static C0439ta<String> b(Aa aa, String str, String str2) {
        return new C0463xa(aa, str, str2);
    }

    /* synthetic */ C0439ta(Aa aa, String str, Object obj, C0457wa waVar) {
        this(aa, str, obj);
    }

    private final String a(String str) {
        if (str != null && str.isEmpty()) {
            return this.f5378f;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f5378f);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final T a() {
        int i2 = f5376d.get();
        if (this.f5380h < i2) {
            synchronized (this) {
                if (this.f5380h < i2) {
                    if (f5374b != null) {
                        Aa aa = this.f5377e;
                        T d2 = d();
                        if (d2 == null) {
                            d2 = e();
                            if (d2 == null) {
                                d2 = this.f5379g;
                            }
                        }
                        this.f5381i = d2;
                        this.f5380h = i2;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.f5381i;
    }
}
