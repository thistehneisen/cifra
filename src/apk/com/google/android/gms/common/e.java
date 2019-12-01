package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.j;
import androidx.core.app.j.c;
import androidx.core.app.j.f;
import androidx.fragment.app.C0195j;
import c.b.a.b.a.b;
import c.b.a.b.b.b.d;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C0309d;
import com.google.android.gms.common.internal.C0310e;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.k;

public class e extends f {

    /* renamed from: c reason: collision with root package name */
    private static final Object f4654c = new Object();

    /* renamed from: d reason: collision with root package name */
    private static final e f4655d = new e();

    /* renamed from: e reason: collision with root package name */
    public static final int f4656e = f.f4660a;

    /* renamed from: f reason: collision with root package name */
    private String f4657f;

    @SuppressLint({"HandlerLeak"})
    private class a extends d {

        /* renamed from: a reason: collision with root package name */
        private final Context f4658a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f4658a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int b2 = e.this.b(this.f4658a);
            if (e.this.b(b2)) {
                e.this.b(this.f4658a, b2);
            }
        }
    }

    e() {
    }

    public static e a() {
        return f4655d;
    }

    public boolean b(Activity activity, int i2, int i3, OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i2, i3, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final void c(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000);
    }

    public Dialog a(Activity activity, int i2, int i3, OnCancelListener onCancelListener) {
        return a((Context) activity, i2, C0310e.a(activity, a((Context) activity, i2, "d"), i3), onCancelListener);
    }

    public void b(Context context, int i2) {
        a(context, i2, (String) null, a(context, i2, 0, "n"));
    }

    private final String b() {
        String str;
        synchronized (f4654c) {
            str = this.f4657f;
        }
        return str;
    }

    public final boolean a(Context context, b bVar, int i2) {
        PendingIntent a2 = a(context, bVar);
        if (a2 == null) {
            return false;
        }
        a(context, bVar.f(), (String) null, GoogleApiActivity.a(context, a2, i2));
        return true;
    }

    public int b(Context context) {
        return super.b(context);
    }

    public int a(Context context, int i2) {
        return super.a(context, i2);
    }

    public final boolean b(int i2) {
        return super.b(i2);
    }

    public Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return super.a(context, i2, i3);
    }

    public PendingIntent a(Context context, b bVar) {
        if (bVar.i()) {
            return bVar.h();
        }
        return a(context, bVar.f(), 0);
    }

    public final String a(int i2) {
        return super.a(i2);
    }

    static Dialog a(Context context, int i2, C0310e eVar, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C0309d.b(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String a2 = C0309d.a(context, i2);
        if (a2 != null) {
            builder.setPositiveButton(a2, eVar);
        }
        String e2 = C0309d.e(context, i2);
        if (e2 != null) {
            builder.setTitle(e2);
        }
        return builder.create();
    }

    static void a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        if (activity instanceof C0195j) {
            j.a(dialog, onCancelListener).a(((C0195j) activity).getSupportFragmentManager(), str);
            return;
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void a(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            c(context);
        } else if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String d2 = C0309d.d(context, i2);
            String c2 = C0309d.c(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            j.d dVar = new j.d(context);
            dVar.b(true);
            dVar.a(true);
            dVar.c((CharSequence) d2);
            c cVar = new c();
            cVar.a((CharSequence) c2);
            dVar.a((f) cVar);
            if (h.b(context)) {
                q.b(k.f());
                dVar.d(context.getApplicationInfo().icon);
                dVar.c(2);
                if (h.c(context)) {
                    dVar.a(c.b.a.b.a.a.common_full_open_on_phone, (CharSequence) resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    dVar.a(pendingIntent);
                }
            } else {
                dVar.d(17301642);
                dVar.d((CharSequence) resources.getString(b.common_google_play_services_notification_ticker));
                dVar.a(System.currentTimeMillis());
                dVar.a(pendingIntent);
                dVar.b((CharSequence) c2);
            }
            if (k.i()) {
                q.b(k.i());
                String b2 = b();
                if (b2 == null) {
                    b2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(b2);
                    String b3 = C0309d.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(b2, b3, 4));
                    } else if (!b3.equals(notificationChannel.getName())) {
                        notificationChannel.setName(b3);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                dVar.b(b2);
            }
            Notification a2 = dVar.a();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                g.sCanceledAvailabilityNotification.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, a2);
        }
    }
}
