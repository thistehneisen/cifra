package com.google.android.gms.common.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.c;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a reason: collision with root package name */
    private static final Object f4509a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static volatile a f4510b;

    /* renamed from: c reason: collision with root package name */
    private static boolean f4511c = false;

    /* renamed from: d reason: collision with root package name */
    private final List<String> f4512d;

    /* renamed from: e reason: collision with root package name */
    private final List<String> f4513e;

    /* renamed from: f reason: collision with root package name */
    private final List<String> f4514f;

    /* renamed from: g reason: collision with root package name */
    private final List<String> f4515g;

    private a() {
        List<String> list = Collections.EMPTY_LIST;
        this.f4512d = list;
        this.f4513e = list;
        this.f4514f = list;
        this.f4515g = list;
    }

    public static a a() {
        if (f4510b == null) {
            synchronized (f4509a) {
                if (f4510b == null) {
                    f4510b = new a();
                }
            }
        }
        return f4510b;
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = c.b(context, component.getPackageName());
        }
        if (!z) {
            return context.bindService(intent, serviceConnection, i2);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    @SuppressLint({"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
