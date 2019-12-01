package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.measurement.Aa;
import com.google.android.gms.internal.measurement.C0368ha;
import com.google.android.gms.internal.measurement.C0445ua;
import com.google.android.gms.internal.measurement.Od;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.measurement.internal.l reason: case insensitive filesystem */
public final class C0535l {
    public static Za<Integer> A;
    public static Za<Boolean> Aa;
    public static Za<String> B;
    public static Za<Boolean> Ba;
    public static Za<Long> C;
    public static Za<Boolean> Ca;
    public static Za<Long> D;
    public static Za<Boolean> Da;
    public static Za<Long> E;
    public static Za<Boolean> Ea;
    public static Za<Long> F;
    public static Za<Boolean> Fa;
    public static Za<Long> G;
    public static Za<Boolean> Ga;
    public static Za<Long> H;
    public static Za<Boolean> Ha;
    public static Za<Long> I;
    public static Za<Boolean> Ia;
    public static Za<Long> J;
    public static Za<Boolean> Ja;
    public static Za<Long> K;
    public static Za<Boolean> Ka;
    public static Za<Long> L;
    private static Za<Boolean> La;
    public static Za<Long> M;
    public static Za<Boolean> Ma;
    public static Za<Integer> N;
    public static Za<Boolean> Na;
    public static Za<Long> O;
    public static Za<Integer> P;
    public static Za<Integer> Q;
    public static Za<Long> R;
    public static Za<Boolean> S;
    public static Za<String> T;
    public static Za<Long> U;
    public static Za<Integer> V;
    public static Za<Double> W;
    public static Za<Integer> X;
    public static Za<Boolean> Y;
    public static Za<Boolean> Z;

    /* renamed from: a reason: collision with root package name */
    static ee f6003a;
    public static Za<Boolean> aa;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static List<Za<?>> f6004b = Collections.synchronizedList(new ArrayList());
    public static Za<Boolean> ba;

    /* renamed from: c reason: collision with root package name */
    private static Set<Za<?>> f6005c = Collections.synchronizedSet(new HashSet());
    public static Za<Boolean> ca;

    /* renamed from: d reason: collision with root package name */
    private static final Aa f6006d = new Aa(C0445ua.a("com.google.android.gms.measurement"));
    public static Za<Boolean> da;

    /* renamed from: e reason: collision with root package name */
    private static volatile Ob f6007e;
    public static Za<Boolean> ea;

    /* renamed from: f reason: collision with root package name */
    private static Boolean f6008f;
    public static Za<Boolean> fa;

    /* renamed from: g reason: collision with root package name */
    private static Za<Boolean> f6009g;
    public static Za<Boolean> ga;

    /* renamed from: h reason: collision with root package name */
    private static Za<Boolean> f6010h;
    public static Za<Boolean> ha;

    /* renamed from: i reason: collision with root package name */
    private static Za<Boolean> f6011i;
    public static Za<Boolean> ia;

    /* renamed from: j reason: collision with root package name */
    public static Za<Boolean> f6012j;
    public static Za<Boolean> ja;

    /* renamed from: k reason: collision with root package name */
    public static Za<Boolean> f6013k;
    public static Za<Boolean> ka;

    /* renamed from: l reason: collision with root package name */
    public static Za<String> f6014l = a("measurement.log_tag", "FA", "FA-SVC", C0521ia.f5945a);
    public static Za<Boolean> la;
    public static Za<Long> m;
    public static Za<Boolean> ma;
    public static Za<Long> n;
    public static Za<Boolean> na;
    public static Za<Long> o;
    public static Za<Boolean> oa;
    public static Za<String> p;
    public static Za<Boolean> pa;
    public static Za<String> q;
    public static Za<Boolean> qa;
    public static Za<Integer> r;
    public static Za<Boolean> ra;
    public static Za<Integer> s;
    public static Za<Boolean> sa;
    public static Za<Integer> t;
    public static Za<Boolean> ta;
    public static Za<Integer> u;
    public static Za<Boolean> ua;
    public static Za<Integer> v;
    public static Za<Boolean> va;
    public static Za<Integer> w;
    public static Za<Boolean> wa;
    public static Za<Integer> x;
    private static Za<Boolean> xa;
    public static Za<Integer> y;
    public static Za<Boolean> ya;
    public static Za<Integer> z;
    public static Za<Boolean> za;

    static {
        Boolean valueOf = Boolean.valueOf(false);
        f6009g = a("measurement.log_third_party_store_events_enabled", valueOf, valueOf, C0550o.f6044a);
        f6010h = a("measurement.log_installs_enabled", valueOf, valueOf, C0545n.f6034a);
        f6011i = a("measurement.log_upgrades_enabled", valueOf, valueOf, A.f5495a);
        f6012j = a("measurement.log_androidId_enabled", valueOf, valueOf, K.f5616a);
        f6013k = a("measurement.upload_dsid_enabled", valueOf, valueOf, Y.f5770a);
        Long valueOf2 = Long.valueOf(10000);
        m = a("measurement.ad_id_cache_time", valueOf2, valueOf2, C0585va.f6125a);
        Long valueOf3 = Long.valueOf(86400000);
        n = a("measurement.monitoring.sample_period_millis", valueOf3, valueOf3, Fa.f5547a);
        Long valueOf4 = Long.valueOf(3600000);
        o = a("measurement.config.cache_time", valueOf3, valueOf4, Sa.f5714a);
        String str = "https";
        p = a("measurement.config.url_scheme", str, str, Ya.f5771a);
        String str2 = "app-measurement.com";
        q = a("measurement.config.url_authority", str2, str2, C0560q.f6066a);
        Integer valueOf5 = Integer.valueOf(100);
        r = a("measurement.upload.max_bundles", valueOf5, valueOf5, C0555p.f6056a);
        Integer valueOf6 = Integer.valueOf(65536);
        s = a("measurement.upload.max_batch_size", valueOf6, valueOf6, C0569s.f6088a);
        t = a("measurement.upload.max_bundle_size", valueOf6, valueOf6, r.f6073a);
        Integer valueOf7 = Integer.valueOf(1000);
        u = a("measurement.upload.max_events_per_bundle", valueOf7, valueOf7, C0579u.f6113a);
        Integer valueOf8 = Integer.valueOf(100000);
        v = a("measurement.upload.max_events_per_day", valueOf8, valueOf8, C0574t.f6098a);
        w = a("measurement.upload.max_error_events_per_day", valueOf7, valueOf7, C0589w.f6140a);
        Integer valueOf9 = Integer.valueOf(50000);
        x = a("measurement.upload.max_public_events_per_day", valueOf9, valueOf9, C0584v.f6124a);
        Integer valueOf10 = Integer.valueOf(500);
        y = a("measurement.upload.max_conversions_per_day", valueOf10, valueOf10, C0599y.f6163a);
        Integer valueOf11 = Integer.valueOf(10);
        z = a("measurement.upload.max_realtime_events_per_day", valueOf11, valueOf11, C0594x.f6152a);
        Integer valueOf12 = Integer.valueOf(100000);
        A = a("measurement.store.max_stored_events_per_app", valueOf12, valueOf12, C0604z.f6175a);
        String str3 = "https://app-measurement.com/a";
        B = a("measurement.upload.url", str3, str3, D.f5530a);
        Long valueOf13 = Long.valueOf(43200000);
        C = a("measurement.upload.backoff_period", valueOf13, valueOf13, C.f5520a);
        D = a("measurement.upload.window_interval", valueOf4, valueOf4, F.f5546a);
        E = a("measurement.upload.interval", valueOf4, valueOf4, E.f5540a);
        F = a("measurement.upload.realtime_upload_interval", valueOf2, valueOf2, H.f5575a);
        Long valueOf14 = Long.valueOf(1000);
        G = a("measurement.upload.debug_upload_interval", valueOf14, valueOf14, G.f5568a);
        Long valueOf15 = Long.valueOf(500);
        H = a("measurement.upload.minimum_delay", valueOf15, valueOf15, J.f5602a);
        Long valueOf16 = Long.valueOf(60000);
        I = a("measurement.alarm_manager.minimum_interval", valueOf16, valueOf16, I.f5587a);
        J = a("measurement.upload.stale_data_deletion_interval", valueOf3, valueOf3, L.f5639a);
        Long valueOf17 = Long.valueOf(604800000);
        K = a("measurement.upload.refresh_blacklisted_config_interval", valueOf17, valueOf17, N.f5655a);
        Long valueOf18 = Long.valueOf(15000);
        L = a("measurement.upload.initial_upload_delay_time", valueOf18, valueOf18, M.f5647a);
        Long valueOf19 = Long.valueOf(1800000);
        M = a("measurement.upload.retry_time", valueOf19, valueOf19, P.f5678a);
        Integer valueOf20 = Integer.valueOf(6);
        N = a("measurement.upload.retry_count", valueOf20, valueOf20, O.f5662a);
        Long valueOf21 = Long.valueOf(2419200000L);
        O = a("measurement.upload.max_queue_time", valueOf21, valueOf21, S.f5713a);
        Integer valueOf22 = Integer.valueOf(4);
        P = a("measurement.lifetimevalue.max_currency_tracked", valueOf22, valueOf22, Q.f5685a);
        Integer valueOf23 = Integer.valueOf(200);
        Q = a("measurement.audience.filter_result_max_count", valueOf23, valueOf23, U.f5726a);
        Long valueOf24 = Long.valueOf(5000);
        R = a("measurement.service_client.idle_disconnect_millis", valueOf24, valueOf24, T.f5717a);
        S = a("measurement.test.boolean_flag", valueOf, valueOf, W.f5748a);
        String str4 = "---";
        T = a("measurement.test.string_flag", str4, str4, V.f5737a);
        Long valueOf25 = Long.valueOf(-1);
        U = a("measurement.test.long_flag", valueOf25, valueOf25, X.f5760a);
        Integer valueOf26 = Integer.valueOf(-2);
        V = a("measurement.test.int_flag", valueOf26, valueOf26, C0481aa.f5812a);
        Double valueOf27 = Double.valueOf(-3.0d);
        W = a("measurement.test.double_flag", valueOf27, valueOf27, Z.f5779a);
        Integer valueOf28 = Integer.valueOf(50);
        X = a("measurement.experiment.max_ids", valueOf28, valueOf28, C0491ca.f5843a);
        Y = a("measurement.validation.internal_limits_internal_event_params", valueOf, valueOf, C0486ba.f5835a);
        Boolean valueOf29 = Boolean.valueOf(true);
        Z = a("measurement.audience.dynamic_filters", valueOf29, valueOf29, C0506fa.f5909a);
        aa = a("measurement.reset_analytics.persist_time", valueOf, valueOf, C0501ea.f5890a);
        ba = a("measurement.validation.value_and_currency_params", valueOf29, valueOf29, C0516ha.f5936a);
        ca = a("measurement.sampling.time_zone_offset_enabled", valueOf, valueOf, C0511ga.f5926a);
        da = a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", valueOf, valueOf, C0526ja.f5957a);
        ea = a("measurement.fetch_config_with_admob_app_id", valueOf29, valueOf29, C0536la.f6015a);
        fa = a("measurement.client.sessions.session_id_enabled", valueOf, valueOf, C0531ka.f5976a);
        ga = a("measurement.service.sessions.session_number_enabled", valueOf, valueOf, C0546na.f6035a);
        ha = a("measurement.client.sessions.immediate_start_enabled_foreground", valueOf, valueOf, C0541ma.f6023a);
        ia = a("measurement.client.sessions.background_sessions_enabled", valueOf, valueOf, C0556pa.f6057a);
        ja = a("measurement.client.sessions.remove_expired_session_properties_enabled", valueOf, valueOf, C0551oa.f6045a);
        ka = a("measurement.service.sessions.session_number_backfill_enabled", valueOf, valueOf, C0565ra.f6074a);
        la = a("measurement.service.sessions.remove_disabled_session_number", valueOf, valueOf, C0561qa.f6067a);
        ma = a("measurement.collection.firebase_global_collection_flag_enabled", valueOf29, valueOf29, C0575ta.f6099a);
        na = a("measurement.collection.efficient_engagement_reporting_enabled", valueOf, valueOf, C0570sa.f6089a);
        oa = a("measurement.collection.redundant_engagement_removal_enabled", valueOf, valueOf, C0580ua.f6114a);
        pa = a("measurement.personalized_ads_signals_collection_enabled", valueOf29, valueOf29, C0595xa.f6153a);
        qa = a("measurement.personalized_ads_property_translation_enabled", valueOf29, valueOf29, C0590wa.f6141a);
        ra = a("measurement.collection.init_params_control_enabled", valueOf29, valueOf29, C0605za.f6176a);
        sa = a("measurement.upload.disable_is_uploader", valueOf29, valueOf29, C0600ya.f6164a);
        ta = a("measurement.experiment.enable_experiment_reporting", valueOf29, valueOf29, Ba.f5513a);
        ua = a("measurement.collection.log_event_and_bundle_v2", valueOf29, valueOf29, Aa.f5496a);
        va = a("measurement.collection.null_empty_event_name_fix", valueOf29, valueOf29, Da.f5531a);
        wa = a("measurement.audience.sequence_filters", valueOf, valueOf, Ca.f5521a);
        xa = a("measurement.audience.sequence_filters_bundle_timestamp", valueOf, valueOf, Ga.f5569a);
        ya = a("measurement.quality.checksum", valueOf, valueOf, null);
        za = a("measurement.module.collection.conditionally_omit_admob_app_id", valueOf29, valueOf29, Ia.f5588a);
        Aa = a("measurement.sdk.dynamite.use_dynamite2", valueOf, valueOf, Ha.f5576a);
        Ba = a("measurement.sdk.dynamite.allow_remote_dynamite", valueOf, valueOf, Ka.f5617a);
        Ca = a("measurement.sdk.collection.validate_param_names_alphabetical", valueOf, valueOf, Ja.f5603a);
        Da = a("measurement.collection.event_safelist", valueOf, valueOf, Ma.f5648a);
        Ea = a("measurement.service.audience.scoped_filters_v27", valueOf, valueOf, La.f5640a);
        Fa = a("measurement.service.audience.session_scoped_event_aggregates", valueOf, valueOf, Oa.f5663a);
        Ga = a("measurement.service.audience.session_scoped_user_engagement", valueOf, valueOf, Na.f5656a);
        Ha = a("measurement.service.audience.remove_disabled_session_scoped_user_engagement", valueOf, valueOf, Qa.f5686a);
        Ia = a("measurement.sdk.collection.retrieve_deeplink_from_bow", valueOf, valueOf, Pa.f5679a);
        Ja = a("measurement.app_launch.event_ordering_fix", valueOf, valueOf, Ra.f5695a);
        Ka = a("measurement.sdk.collection.last_deep_link_referrer", valueOf, valueOf, Ua.f5727a);
        La = a("measurement.sdk.collection.last_deep_link_referrer_campaign", valueOf, valueOf, Ta.f5718a);
        Ma = a("measurement.sdk.collection.last_gclid_from_referrer", valueOf, valueOf, Wa.f5749a);
        Na = a("measurement.upload.file_lock_state_check", valueOf, valueOf, Va.f5738a);
    }

    static final /* synthetic */ String Ba() {
        return Ia() ? Od.r() : Od.c();
    }

    private static boolean Ia() {
        if (f6003a != null) {
        }
        return false;
    }

    public static Map<String, String> a(Context context) {
        C0368ha a2 = C0368ha.a(context.getContentResolver(), C0445ua.a("com.google.android.gms.measurement"));
        return a2 == null ? Collections.emptyMap() : a2.a();
    }

    static final /* synthetic */ Long ya() {
        long j2;
        if (Ia()) {
            j2 = Od.p();
        } else {
            j2 = Od.b();
        }
        return Long.valueOf(j2);
    }

    static void a(Ob ob) {
        f6007e = ob;
    }

    static void a(Exception exc) {
        if (f6007e != null) {
            Context a2 = f6007e.a();
            if (f6008f == null) {
                f6008f = Boolean.valueOf(f.a().a(a2, (int) g.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0);
            }
            if (f6008f.booleanValue()) {
                f6007e.e().t().a("Got Exception on PhenotypeFlag.get on Play device", exc);
            }
        }
    }

    private static <V> Za<V> a(String str, V v2, V v3, _a<V> _aVar) {
        Za za2 = new Za(str, v2, v3, _aVar);
        f6004b.add(za2);
        return za2;
    }

    static void a(ee eeVar) {
        f6003a = eeVar;
    }
}
