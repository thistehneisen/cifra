package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import b.g.a.a;
import com.google.android.gms.common.util.d;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.measurement.internal.d reason: case insensitive filesystem */
public final class C0495d extends C0528jc {

    /* renamed from: c reason: collision with root package name */
    private long f5862c;

    /* renamed from: d reason: collision with root package name */
    private String f5863d;

    /* renamed from: e reason: collision with root package name */
    private Boolean f5864e;

    /* renamed from: f reason: collision with root package name */
    private AccountManager f5865f;

    /* renamed from: g reason: collision with root package name */
    private Boolean f5866g;

    /* renamed from: h reason: collision with root package name */
    private long f5867h;

    C0495d(Ob ob) {
        super(ob);
    }

    public final boolean a(Context context) {
        if (this.f5864e == null) {
            b();
            this.f5864e = Boolean.valueOf(false);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f5864e = Boolean.valueOf(true);
                }
            } catch (NameNotFoundException unused) {
            }
        }
        return this.f5864e.booleanValue();
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        Calendar instance = Calendar.getInstance();
        this.f5862c = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f5863d = sb.toString();
        return false;
    }

    public final long t() {
        p();
        return this.f5862c;
    }

    public final String u() {
        p();
        return this.f5863d;
    }

    /* access modifiers changed from: 0000 */
    public final long v() {
        j();
        return this.f5867h;
    }

    /* access modifiers changed from: 0000 */
    public final void w() {
        j();
        this.f5866g = null;
        this.f5867h = 0;
    }

    /* access modifiers changed from: 0000 */
    public final boolean x() {
        String str = "com.google";
        j();
        long currentTimeMillis = c().currentTimeMillis();
        if (currentTimeMillis - this.f5867h > 86400000) {
            this.f5866g = null;
        }
        Boolean bool = this.f5866g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (a.a(a(), "android.permission.GET_ACCOUNTS") != 0) {
            e().x().a("Permission error checking for dasher/unicorn accounts");
            this.f5867h = currentTimeMillis;
            this.f5866g = Boolean.valueOf(false);
            return false;
        }
        if (this.f5865f == null) {
            this.f5865f = AccountManager.get(a());
        }
        try {
            Account[] accountArr = (Account[]) this.f5865f.getAccountsByTypeAndFeatures(str, new String[]{"service_HOSTED"}, null, null).getResult();
            if (accountArr == null || accountArr.length <= 0) {
                Account[] accountArr2 = (Account[]) this.f5865f.getAccountsByTypeAndFeatures(str, new String[]{"service_uca"}, null, null).getResult();
                if (accountArr2 != null && accountArr2.length > 0) {
                    this.f5866g = Boolean.valueOf(true);
                    this.f5867h = currentTimeMillis;
                    return true;
                }
                this.f5867h = currentTimeMillis;
                this.f5866g = Boolean.valueOf(false);
                return false;
            }
            this.f5866g = Boolean.valueOf(true);
            this.f5867h = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
            e().u().a("Exception checking account types", e2);
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
