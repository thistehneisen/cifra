package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import b.k.a.a;
import com.appsflyer.share.Constants;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.firebase.iid.y reason: case insensitive filesystem */
public final class C0635y {

    /* renamed from: a reason: collision with root package name */
    private static C0635y f6853a;

    /* renamed from: b reason: collision with root package name */
    private String f6854b = null;

    /* renamed from: c reason: collision with root package name */
    private Boolean f6855c = null;

    /* renamed from: d reason: collision with root package name */
    private Boolean f6856d = null;

    /* renamed from: e reason: collision with root package name */
    private final Queue<Intent> f6857e = new ArrayDeque();

    private C0635y() {
    }

    public static synchronized C0635y a() {
        C0635y yVar;
        synchronized (C0635y.class) {
            if (f6853a == null) {
                f6853a = new C0635y();
            }
            yVar = f6853a;
        }
        return yVar;
    }

    private final synchronized String c(Context context, Intent intent) {
        if (this.f6854b != null) {
            return this.f6854b;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            if (resolveService.serviceInfo != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    if (serviceInfo.name != null) {
                        if (serviceInfo.name.startsWith(".")) {
                            String valueOf = String.valueOf(context.getPackageName());
                            String valueOf2 = String.valueOf(serviceInfo.name);
                            this.f6854b = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                        } else {
                            this.f6854b = serviceInfo.name;
                        }
                        return this.f6854b;
                    }
                }
                String str = "FirebaseInstanceId";
                String str2 = serviceInfo.packageName;
                String str3 = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length());
                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb.append(str2);
                sb.append(Constants.URL_PATH_DELIMITER);
                sb.append(str3);
                Log.e(str, sb.toString());
                return null;
            }
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    public final Intent b() {
        return (Intent) this.f6857e.poll();
    }

    private final int b(Context context, Intent intent) {
        ComponentName componentName;
        String c2 = c(context, intent);
        String str = "FirebaseInstanceId";
        if (c2 != null) {
            if (Log.isLoggable(str, 3)) {
                String str2 = "Restricting intent to a specific service: ";
                String valueOf = String.valueOf(c2);
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            intent.setClassName(context.getPackageName(), c2);
        }
        try {
            if (a(context)) {
                componentName = a.b(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d(str, "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e(str, "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e2) {
            Log.e(str, "Error while delivering the message to the serviceIntent", e2);
            return 401;
        } catch (IllegalStateException e3) {
            String valueOf2 = String.valueOf(e3);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            Log.e(str, sb.toString());
            return 402;
        }
    }

    public final int a(Context context, Intent intent) {
        String str = "FirebaseInstanceId";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Starting service");
        }
        this.f6857e.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return b(context, intent2);
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(Context context) {
        if (this.f6855c == null) {
            this.f6855c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f6855c.booleanValue()) {
            String str = "FirebaseInstanceId";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.f6855c.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final boolean b(Context context) {
        if (this.f6856d == null) {
            this.f6856d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f6855c.booleanValue()) {
            String str = "FirebaseInstanceId";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.f6856d.booleanValue();
    }
}
