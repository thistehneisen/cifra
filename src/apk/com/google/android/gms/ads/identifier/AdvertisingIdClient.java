package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c.b.a.b.b.a.d;
import c.b.a.b.b.a.e;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.q;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    private com.google.android.gms.common.a zze;
    private d zzf;
    private boolean zzg;
    private final Object zzh;
    private a zzi;
    private final boolean zzj;
    private final long zzk;

    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String str = this.zzq;
            boolean z = this.zzr;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    static class a extends Thread {

        /* renamed from: a reason: collision with root package name */
        private WeakReference<AdvertisingIdClient> f4485a;

        /* renamed from: b reason: collision with root package name */
        private long f4486b;

        /* renamed from: c reason: collision with root package name */
        CountDownLatch f4487c = new CountDownLatch(1);

        /* renamed from: d reason: collision with root package name */
        boolean f4488d = false;

        public a(AdvertisingIdClient advertisingIdClient, long j2) {
            this.f4485a = new WeakReference<>(advertisingIdClient);
            this.f4486b = j2;
            start();
        }

        private final void a() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f4485a.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f4488d = true;
            }
        }

        public final void run() {
            try {
                if (!this.f4487c.await(this.f4486b, TimeUnit.MILLISECONDS)) {
                    a();
                }
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    private AdvertisingIdClient(Context context, long j2, boolean z, boolean z2) {
        this.zzh = new Object();
        q.a(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
        }
        this.mContext = context;
        this.zzg = false;
        this.zzk = j2;
        this.zzj = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        b bVar = new b(context);
        boolean a2 = bVar.a("gads:ad_id_app_context:enabled", false);
        float a3 = bVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String a4 = bVar.a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, a2, bVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zza(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, a2, a3, SystemClock.elapsedRealtime() - elapsedRealtime, a4, null);
            advertisingIdClient.finish();
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
            throw th;
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        b bVar = new b(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, bVar.a("gads:ad_id_app_context:enabled", false), bVar.a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            return advertisingIdClient.zzb();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static d zza(Context context, com.google.android.gms.common.a aVar) throws IOException {
        try {
            return e.a(aVar.a(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private static com.google.android.gms.common.a zza(Context context, boolean z) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int a2 = f.a().a(context, (int) g.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (a2 == 0 || a2 == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (com.google.android.gms.common.a.a.a().a(context, intent, aVar, 1)) {
                        return aVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    private final void zza() {
        synchronized (this.zzh) {
            if (this.zzi != null) {
                this.zzi.f4487c.countDown();
                this.zzi.join();
            }
            if (this.zzk > 0) {
                this.zzi = new a(this, this.zzk);
            }
        }
    }

    private final void zza(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        q.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                finish();
            }
            this.zze = zza(this.mContext, this.zzj);
            this.zzf = zza(this.mContext, this.zze);
            this.zzg = true;
            if (z) {
                zza();
            }
        }
    }

    private final boolean zza(Info info, boolean z, float f2, long j2, String str, Throwable th) {
        if (Math.random() > ((double) f2)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        String str3 = "0";
        hashMap.put("app_context", z ? str2 : str3);
        if (info != null) {
            if (!info.isLimitAdTrackingEnabled()) {
                str2 = str3;
            }
            hashMap.put("limit_ad_tracking", str2);
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j2));
        new a(this, hashMap).start();
        return true;
    }

    private final boolean zzb() throws IOException {
        boolean d2;
        q.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.f4488d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
            q.a(this.zze);
            q.a(this.zzf);
            d2 = this.zzf.d();
        }
        zza();
        return d2;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return;
     */
    public final void finish() {
        q.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext != null && this.zze != null) {
                try {
                    if (this.zzg) {
                        com.google.android.gms.common.a.a.a().a(this.mContext, this.zze);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.zzg = false;
                this.zzf = null;
                this.zze = null;
            }
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        q.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.f4488d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
            q.a(this.zze);
            q.a(this.zzf);
            info = new Info(this.zzf.getId(), this.zzf.c(true));
        }
        zza();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zza(true);
    }
}
