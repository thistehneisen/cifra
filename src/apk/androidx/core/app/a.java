package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;

/* compiled from: ActivityCompat */
class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ String[] f1248a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Activity f1249b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ int f1250c;

    a(String[] strArr, Activity activity, int i2) {
        this.f1248a = strArr;
        this.f1249b = activity;
        this.f1250c = i2;
    }

    public void run() {
        int[] iArr = new int[this.f1248a.length];
        PackageManager packageManager = this.f1249b.getPackageManager();
        String packageName = this.f1249b.getPackageName();
        int length = this.f1248a.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = packageManager.checkPermission(this.f1248a[i2], packageName);
        }
        ((androidx.core.app.b.a) this.f1249b).onRequestPermissionsResult(this.f1250c, this.f1248a, iArr);
    }
}
