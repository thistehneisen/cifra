package com.google.android.gms.internal.measurement;

public final class Qd implements Rd {
    private static final C0439ta<Long> A;
    private static final C0439ta<Long> B;
    private static final C0439ta<Long> C;
    private static final C0439ta<Long> D;
    private static final C0439ta<Long> E;
    private static final C0439ta<Long> F;
    private static final C0439ta<Long> G;
    private static final C0439ta<Long> H;
    private static final C0439ta<String> I;
    private static final C0439ta<Long> J;

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Long> f5021a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Long> f5022b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<String> f5023c;

    /* renamed from: d reason: collision with root package name */
    private static final C0439ta<String> f5024d;

    /* renamed from: e reason: collision with root package name */
    private static final C0439ta<String> f5025e;

    /* renamed from: f reason: collision with root package name */
    private static final C0439ta<Long> f5026f;

    /* renamed from: g reason: collision with root package name */
    private static final C0439ta<Long> f5027g;

    /* renamed from: h reason: collision with root package name */
    private static final C0439ta<Long> f5028h;

    /* renamed from: i reason: collision with root package name */
    private static final C0439ta<Long> f5029i;

    /* renamed from: j reason: collision with root package name */
    private static final C0439ta<Long> f5030j;

    /* renamed from: k reason: collision with root package name */
    private static final C0439ta<Long> f5031k;

    /* renamed from: l reason: collision with root package name */
    private static final C0439ta<Long> f5032l;
    private static final C0439ta<Long> m;
    private static final C0439ta<Long> n;
    private static final C0439ta<Long> o;
    private static final C0439ta<Long> p;
    private static final C0439ta<Long> q;
    private static final C0439ta<String> r;
    private static final C0439ta<Long> s;
    private static final C0439ta<Long> t;
    private static final C0439ta<Long> u;
    private static final C0439ta<Long> v;
    private static final C0439ta<Long> w;
    private static final C0439ta<Long> x;
    private static final C0439ta<Long> y;
    private static final C0439ta<Long> z;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5021a = aa.a("measurement.ad_id_cache_time", 10000);
        f5022b = aa.a("measurement.config.cache_time", 3600000);
        f5023c = aa.a("measurement.log_tag", "FA");
        f5024d = aa.a("measurement.config.url_authority", "app-measurement.com");
        f5025e = aa.a("measurement.config.url_scheme", "https");
        f5026f = aa.a("measurement.upload.debug_upload_interval", 1000);
        f5027g = aa.a("measurement.lifetimevalue.max_currency_tracked", 4);
        f5028h = aa.a("measurement.store.max_stored_events_per_app", 100000);
        f5029i = aa.a("measurement.experiment.max_ids", 50);
        f5030j = aa.a("measurement.audience.filter_result_max_count", 200);
        f5031k = aa.a("measurement.alarm_manager.minimum_interval", 60000);
        f5032l = aa.a("measurement.upload.minimum_delay", 500);
        m = aa.a("measurement.monitoring.sample_period_millis", 86400000);
        n = aa.a("measurement.upload.realtime_upload_interval", 10000);
        o = aa.a("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        p = aa.a("measurement.config.cache_time.service", 86400000);
        q = aa.a("measurement.service_client.idle_disconnect_millis", 5000);
        r = aa.a("measurement.log_tag.service", "FA-SVC");
        s = aa.a("measurement.upload.stale_data_deletion_interval", 86400000);
        t = aa.a("measurement.upload.backoff_period", 43200000);
        u = aa.a("measurement.upload.initial_upload_delay_time", 15000);
        v = aa.a("measurement.upload.interval", 3600000);
        w = aa.a("measurement.upload.max_bundle_size", 65536);
        x = aa.a("measurement.upload.max_bundles", 100);
        y = aa.a("measurement.upload.max_conversions_per_day", 500);
        z = aa.a("measurement.upload.max_error_events_per_day", 1000);
        A = aa.a("measurement.upload.max_events_per_bundle", 1000);
        B = aa.a("measurement.upload.max_events_per_day", 100000);
        C = aa.a("measurement.upload.max_public_events_per_day", 50000);
        D = aa.a("measurement.upload.max_queue_time", 2419200000L);
        E = aa.a("measurement.upload.max_realtime_events_per_day", 10);
        F = aa.a("measurement.upload.max_batch_size", 65536);
        G = aa.a("measurement.upload.retry_count", 6);
        H = aa.a("measurement.upload.retry_time", 1800000);
        I = aa.a("measurement.upload.url", "https://app-measurement.com/a");
        J = aa.a("measurement.upload.window_interval", 3600000);
    }

    public final long A() {
        return ((Long) E.a()).longValue();
    }

    public final long B() {
        return ((Long) n.a()).longValue();
    }

    public final long C() {
        return ((Long) f5022b.a()).longValue();
    }

    public final long D() {
        return ((Long) u.a()).longValue();
    }

    public final long E() {
        return ((Long) f5029i.a()).longValue();
    }

    public final long F() {
        return ((Long) D.a()).longValue();
    }

    public final long G() {
        return ((Long) f5021a.a()).longValue();
    }

    public final long H() {
        return ((Long) t.a()).longValue();
    }

    public final long I() {
        return ((Long) f5028h.a()).longValue();
    }

    public final long J() {
        return ((Long) C.a()).longValue();
    }

    public final long a() {
        return ((Long) J.a()).longValue();
    }

    public final long b() {
        return ((Long) s.a()).longValue();
    }

    public final long c() {
        return ((Long) f5027g.a()).longValue();
    }

    public final long d() {
        return ((Long) B.a()).longValue();
    }

    public final String e() {
        return (String) I.a();
    }

    public final String f() {
        return (String) r.a();
    }

    public final long g() {
        return ((Long) f5026f.a()).longValue();
    }

    public final long h() {
        return ((Long) A.a()).longValue();
    }

    public final long i() {
        return ((Long) y.a()).longValue();
    }

    public final long j() {
        return ((Long) m.a()).longValue();
    }

    public final long k() {
        return ((Long) H.a()).longValue();
    }

    public final long l() {
        return ((Long) q.a()).longValue();
    }

    public final String m() {
        return (String) f5025e.a();
    }

    public final long n() {
        return ((Long) z.a()).longValue();
    }

    public final long o() {
        return ((Long) x.a()).longValue();
    }

    public final long p() {
        return ((Long) f5032l.a()).longValue();
    }

    public final long q() {
        return ((Long) G.a()).longValue();
    }

    public final long r() {
        return ((Long) p.a()).longValue();
    }

    public final String s() {
        return (String) f5024d.a();
    }

    public final long t() {
        return ((Long) w.a()).longValue();
    }

    public final long u() {
        return ((Long) f5031k.a()).longValue();
    }

    public final long v() {
        return ((Long) F.a()).longValue();
    }

    public final long w() {
        return ((Long) o.a()).longValue();
    }

    public final String x() {
        return (String) f5023c.a();
    }

    public final long y() {
        return ((Long) v.a()).longValue();
    }

    public final long z() {
        return ((Long) f5030j.a()).longValue();
    }
}
