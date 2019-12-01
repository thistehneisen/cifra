package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.j.b;
import androidx.core.app.j.d;
import com.google.android.gms.common.util.k;
import com.google.android.gms.tasks.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class f {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6872a;

    /* renamed from: b reason: collision with root package name */
    private final Context f6873b;

    /* renamed from: c reason: collision with root package name */
    private final e f6874c;

    /* renamed from: d reason: collision with root package name */
    private final Bundle f6875d;

    public f(Context context, Bundle bundle, Executor executor) {
        this.f6872a = executor;
        this.f6873b = context;
        this.f6875d = bundle;
        this.f6874c = new e(context, context.getPackageName());
    }

    /* access modifiers changed from: 0000 */
    public final boolean a() {
        boolean z;
        if ("1".equals(e.a(this.f6875d, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.f6873b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!k.g()) {
                SystemClock.sleep(10);
            }
            int myPid = Process.myPid();
            List runningAppProcesses = ((ActivityManager) this.f6873b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                    if (runningAppProcessInfo.pid == myPid) {
                        if (runningAppProcessInfo.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        g b2 = g.b(e.a(this.f6875d, "gcm.n.image"));
        if (b2 != null) {
            b2.a(this.f6872a);
        }
        d a2 = this.f6874c.a(this.f6875d);
        d dVar = a2.f6865a;
        String str = "FirebaseMessaging";
        if (b2 != null) {
            try {
                Bitmap bitmap = (Bitmap) j.a(b2.a(), 5, TimeUnit.SECONDS);
                dVar.a(bitmap);
                b bVar = new b();
                bVar.b(bitmap);
                bVar.a((Bitmap) null);
                dVar.a((androidx.core.app.j.f) bVar);
            } catch (ExecutionException unused) {
            } catch (InterruptedException unused2) {
                Log.w(str, "Interrupted while downloading image, showing notification without it");
                b2.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused3) {
                Log.w(str, "Failed to download image in time, showing notification without it");
                b2.close();
            }
        }
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Showing notification");
        }
        ((NotificationManager) this.f6873b.getSystemService("notification")).notify(a2.f6866b, 0, a2.f6865a.a());
        return true;
    }
}
