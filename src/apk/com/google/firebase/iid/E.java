package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import c.b.a.b.b.d.a;
import c.b.a.b.b.d.b;
import c.b.a.b.b.d.f;
import java.util.concurrent.ExecutorService;

public abstract class E extends Service {
    private final Object lock;
    final ExecutorService zzt;
    private Binder zzu;
    private int zzv;
    private int zzw;

    public E() {
        b a2 = a.a();
        String valueOf = String.valueOf(getClass().getSimpleName());
        String str = "Firebase-";
        this.zzt = a2.a(new com.google.android.gms.common.util.a.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)), f.f3053a);
        this.lock = new Object();
        this.zzw = 0;
    }

    /* access modifiers changed from: private */
    public final void zza(Intent intent) {
        if (intent != null) {
            b.k.a.a.a(intent);
        }
        synchronized (this.lock) {
            this.zzw--;
            if (this.zzw == 0) {
                stopSelfResult(this.zzv);
            }
        }
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzu == null) {
            this.zzu = new I(this);
        }
        return this.zzu;
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.lock) {
            this.zzv = i3;
            this.zzw++;
        }
        Intent zzb = zzb(intent);
        if (zzb == null) {
            zza(intent);
            return 2;
        } else if (zzc(zzb)) {
            zza(intent);
            return 2;
        } else {
            this.zzt.execute(new C(this, zzb, intent));
            return 3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Intent zzb(Intent intent);

    public abstract boolean zzc(Intent intent);

    public abstract void zzd(Intent intent);
}
