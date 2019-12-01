package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import b.g.a.b;
import java.util.Calendar;

/* compiled from: TwilightManager */
class J {

    /* renamed from: a reason: collision with root package name */
    private static J f441a;

    /* renamed from: b reason: collision with root package name */
    private final Context f442b;

    /* renamed from: c reason: collision with root package name */
    private final LocationManager f443c;

    /* renamed from: d reason: collision with root package name */
    private final a f444d = new a();

    /* compiled from: TwilightManager */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        boolean f445a;

        /* renamed from: b reason: collision with root package name */
        long f446b;

        /* renamed from: c reason: collision with root package name */
        long f447c;

        /* renamed from: d reason: collision with root package name */
        long f448d;

        /* renamed from: e reason: collision with root package name */
        long f449e;

        /* renamed from: f reason: collision with root package name */
        long f450f;

        a() {
        }
    }

    J(Context context, LocationManager locationManager) {
        this.f442b = context;
        this.f443c = locationManager;
    }

    static J a(Context context) {
        if (f441a == null) {
            Context applicationContext = context.getApplicationContext();
            f441a = new J(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f441a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a2 = b.a(this.f442b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (b.a(this.f442b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        if (location == null || a2 == null) {
            if (location != null) {
                a2 = location;
            }
            return a2;
        }
        if (location.getTime() > a2.getTime()) {
            a2 = location;
        }
        return a2;
    }

    private boolean c() {
        return this.f444d.f450f > System.currentTimeMillis();
    }

    /* access modifiers changed from: 0000 */
    public boolean a() {
        a aVar = this.f444d;
        if (c()) {
            return aVar.f445a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f445a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }

    private Location a(String str) {
        try {
            if (this.f443c.isProviderEnabled(str)) {
                return this.f443c.getLastKnownLocation(str);
            }
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
        }
        return null;
    }

    private void a(Location location) {
        long j2;
        a aVar = this.f444d;
        long currentTimeMillis = System.currentTimeMillis();
        I a2 = I.a();
        I i2 = a2;
        i2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = a2.f438b;
        i2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.f440d == 1;
        long j4 = a2.f439c;
        long j5 = j3;
        long j6 = a2.f438b;
        long j7 = j4;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j8 = a2.f439c;
        if (j7 == -1 || j6 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            long j9 = currentTimeMillis > j6 ? 0 + j8 : currentTimeMillis > j7 ? 0 + j6 : 0 + j7;
            j2 = j9 + 60000;
        }
        aVar.f445a = z2;
        aVar.f446b = j5;
        aVar.f447c = j7;
        aVar.f448d = j6;
        aVar.f449e = j8;
        aVar.f450f = j2;
    }
}
