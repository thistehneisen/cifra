package c.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import c.b.a.a.a.a.C0037a;
import java.util.List;

/* compiled from: InstallReferrerClientImpl */
class d extends b {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public int f3034a = 0;

    /* renamed from: b reason: collision with root package name */
    private final Context f3035b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public c.b.a.a.a.a f3036c;

    /* renamed from: d reason: collision with root package name */
    private ServiceConnection f3037d;

    /* compiled from: InstallReferrerClientImpl */
    private final class a implements ServiceConnection {

        /* renamed from: a reason: collision with root package name */
        private final e f3038a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.a.a.b.a.a("InstallReferrerClient", "Install Referrer service connected.");
            d.this.f3036c = C0037a.a(iBinder);
            d.this.f3034a = 2;
            this.f3038a.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            c.a.a.b.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            d.this.f3036c = null;
            d.this.f3034a = 0;
            this.f3038a.onInstallReferrerServiceDisconnected();
        }

        private a(e eVar) {
            if (eVar != null) {
                this.f3038a = eVar;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
    }

    public d(Context context) {
        this.f3035b = context.getApplicationContext();
    }

    private boolean d() {
        try {
            if (this.f3035b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public f b() throws RemoteException {
        if (c()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f3035b.getPackageName());
            try {
                return new f(this.f3036c.b(bundle));
            } catch (RemoteException e2) {
                c.a.a.b.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f3034a = 0;
                throw e2;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }

    public boolean c() {
        return (this.f3034a != 2 || this.f3036c == null || this.f3037d == null) ? false : true;
    }

    public void a(e eVar) {
        String str = "InstallReferrerClient";
        if (c()) {
            c.a.a.b.a.a(str, "Service connection is valid. No need to re-initialize.");
            eVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i2 = this.f3034a;
        if (i2 == 1) {
            c.a.a.b.a.b(str, "Client is already in the process of connecting to the service.");
            eVar.onInstallReferrerSetupFinished(3);
        } else if (i2 == 3) {
            c.a.a.b.a.b(str, "Client was already closed and can't be reused. Please create another instance.");
            eVar.onInstallReferrerSetupFinished(3);
        } else {
            c.a.a.b.a.a(str, "Starting install referrer service setup.");
            this.f3037d = new a(eVar);
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            String str2 = "com.android.vending";
            intent.setComponent(new ComponentName(str2, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List queryIntentServices = this.f3035b.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String str3 = serviceInfo.packageName;
                    String str4 = resolveInfo.serviceInfo.name;
                    if (!str2.equals(str3) || str4 == null || !d()) {
                        c.a.a.b.a.b(str, "Play Store missing or incompatible. Version 8.3.73 or later required.");
                        this.f3034a = 0;
                        eVar.onInstallReferrerSetupFinished(2);
                        return;
                    }
                    if (this.f3035b.bindService(new Intent(intent), this.f3037d, 1)) {
                        c.a.a.b.a.a(str, "Service was bonded successfully.");
                        return;
                    }
                    c.a.a.b.a.b(str, "Connection to service is blocked.");
                    this.f3034a = 0;
                    eVar.onInstallReferrerSetupFinished(1);
                    return;
                }
            }
            this.f3034a = 0;
            c.a.a.b.a.a(str, "Install Referrer service unavailable on device.");
            eVar.onInstallReferrerSetupFinished(2);
        }
    }

    public void a() {
        this.f3034a = 3;
        if (this.f3037d != null) {
            c.a.a.b.a.a("InstallReferrerClient", "Unbinding from service.");
            this.f3035b.unbindService(this.f3037d);
            this.f3037d = null;
        }
        this.f3036c = null;
    }
}
