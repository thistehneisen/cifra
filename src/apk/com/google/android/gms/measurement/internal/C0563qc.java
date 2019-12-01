package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.qc reason: case insensitive filesystem */
public class C0563qc {

    /* renamed from: a reason: collision with root package name */
    public static final String[] f6068a = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "session_number", "ga_session_number", "session_id", "ga_session_id", "last_gclid"};

    /* renamed from: b reason: collision with root package name */
    public static final String[] f6069b = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte", "_se", "_npa", "_sno", "_sno", "_sid", "_sid", "_lgclid"};

    public static String a(String str) {
        return Sc.a(str, f6068a, f6069b);
    }
}
