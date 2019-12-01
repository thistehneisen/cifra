package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
final class Nc implements ActivityLifecycleCallbacks {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0582uc f5659a;

    private Nc(C0582uc ucVar) {
        this.f5659a = ucVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ Exception -> 0x01d6, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0123 A[Catch:{ Exception -> 0x01d6, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015f A[SYNTHETIC, Splitter:B:75:0x015f] */
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        Bundle bundle2;
        boolean z;
        Bundle bundle3;
        Activity activity2 = activity;
        Bundle bundle4 = bundle;
        String str2 = "referrer";
        try {
            this.f5659a.e().B().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.f5659a.m();
                        String str3 = "auto";
                        String str4 = Wd.a(intent) ? "gs" : str3;
                        String queryParameter = data.getQueryParameter(str2);
                        String str5 = "Activity created with data 'referrer' without required params";
                        String str6 = "utm_medium";
                        String str7 = "_cis";
                        String str8 = "utm_source";
                        String str9 = "utm_campaign";
                        String str10 = "gclid";
                        if (!this.f5659a.g().a(C0535l.Ka)) {
                            if (this.f5659a.g().a(C0535l.Ma)) {
                            }
                            str = str5;
                            bundle2 = null;
                            if (bundle4 == null) {
                                bundle3 = this.f5659a.m().a(data);
                                if (bundle3 != null) {
                                    bundle3.putString(str7, "intent");
                                    if (!this.f5659a.g().a(C0535l.Ka) || bundle3.containsKey(str10) || bundle2 == null || !bundle2.containsKey(str10)) {
                                        z = false;
                                    } else {
                                        z = false;
                                        bundle3.putString("_cer", String.format("gclid=%s", new Object[]{bundle2.getString(str10)}));
                                    }
                                    this.f5659a.b(str4, "_cmp", bundle3);
                                } else {
                                    z = false;
                                }
                            } else {
                                z = false;
                                bundle3 = null;
                            }
                            if (this.f5659a.g().a(C0535l.Ma) && bundle2 != null && bundle2.containsKey(str10) && (bundle3 == null || !bundle3.containsKey(str10))) {
                                this.f5659a.a(str3, "_lgclid", (Object) bundle2.getString(str10), true);
                            }
                            if (TextUtils.isEmpty(queryParameter)) {
                                this.f5659a.s().a(activity2, bundle4);
                                return;
                            }
                            if (queryParameter.contains(str10) && (queryParameter.contains(str9) || queryParameter.contains(str8) || queryParameter.contains(str6) || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) {
                                z = true;
                            }
                            if (!z) {
                                this.f5659a.e().A().a(str);
                                this.f5659a.s().a(activity2, bundle4);
                                return;
                            }
                            this.f5659a.e().A().a("Activity created with referrer", queryParameter);
                            if (!TextUtils.isEmpty(queryParameter)) {
                                this.f5659a.a(str3, "_ldl", (Object) queryParameter, true);
                            }
                            this.f5659a.s().a(activity2, bundle4);
                            return;
                        }
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains(str10) || queryParameter.contains(str9) || queryParameter.contains(str8) || queryParameter.contains(str6)) {
                                Wd m = this.f5659a.m();
                                String str11 = "https://google.com/search?";
                                str = str5;
                                String valueOf = String.valueOf(queryParameter);
                                Bundle a2 = m.a(Uri.parse(valueOf.length() != 0 ? str11.concat(valueOf) : new String(str11)));
                                if (a2 != null) {
                                    a2.putString(str7, str2);
                                }
                                bundle2 = a2;
                                if (bundle4 == null) {
                                }
                                this.f5659a.a(str3, "_lgclid", (Object) bundle2.getString(str10), true);
                                if (TextUtils.isEmpty(queryParameter)) {
                                }
                            } else {
                                this.f5659a.e().A().a(str5);
                            }
                        }
                        str = str5;
                        bundle2 = null;
                        if (bundle4 == null) {
                        }
                        this.f5659a.a(str3, "_lgclid", (Object) bundle2.getString(str10), true);
                        if (TextUtils.isEmpty(queryParameter)) {
                        }
                    }
                }
                this.f5659a.s().a(activity2, bundle4);
            }
        } catch (Exception e2) {
            this.f5659a.e().t().a("Throwable caught in onActivityCreated", e2);
        } finally {
            this.f5659a.s().a(activity2, bundle4);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f5659a.s().a(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.f5659a.s().b(activity);
        C0608zd u = this.f5659a.u();
        u.d().a((Runnable) new Ed(u, u.c().a()));
    }

    public final void onActivityResumed(Activity activity) {
        this.f5659a.s().c(activity);
        C0608zd u = this.f5659a.u();
        u.d().a((Runnable) new Fd(u, u.c().a()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f5659a.s().b(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    /* synthetic */ Nc(C0582uc ucVar, C0577tc tcVar) {
        this(ucVar);
    }
}
