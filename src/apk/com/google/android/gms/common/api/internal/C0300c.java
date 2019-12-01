package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.O;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.u;

@Deprecated
/* renamed from: com.google.android.gms.common.api.internal.c reason: case insensitive filesystem */
public final class C0300c {

    /* renamed from: a reason: collision with root package name */
    private static final Object f4601a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static C0300c f4602b;

    /* renamed from: c reason: collision with root package name */
    private final String f4603c;

    /* renamed from: d reason: collision with root package name */
    private final Status f4604d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f4605e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f4606f;

    C0300c(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(i.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            if (resources.getInteger(identifier) == 0) {
                z = false;
            }
            this.f4606f = !z;
        } else {
            this.f4606f = false;
        }
        this.f4605e = z;
        String a2 = O.a(context);
        if (a2 == null) {
            a2 = new u(context).a("google_app_id");
        }
        if (TextUtils.isEmpty(a2)) {
            this.f4604d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f4603c = null;
            return;
        }
        this.f4603c = a2;
        this.f4604d = Status.f4519a;
    }

    public static Status a(Context context) {
        Status status;
        q.a(context, (Object) "Context must not be null.");
        synchronized (f4601a) {
            if (f4602b == null) {
                f4602b = new C0300c(context);
            }
            status = f4602b.f4604d;
        }
        return status;
    }

    public static boolean b() {
        return a("isMeasurementExplicitlyDisabled").f4606f;
    }

    public static String a() {
        return a("getGoogleAppId").f4603c;
    }

    private static C0300c a(String str) {
        C0300c cVar;
        synchronized (f4601a) {
            if (f4602b != null) {
                cVar = f4602b;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return cVar;
    }
}
