package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* renamed from: com.google.android.gms.common.internal.f reason: case insensitive filesystem */
public class C0311f extends a {
    public static final Creator<C0311f> CREATOR = new D();

    /* renamed from: a reason: collision with root package name */
    private final int f4736a;

    /* renamed from: b reason: collision with root package name */
    private final int f4737b;

    /* renamed from: c reason: collision with root package name */
    private int f4738c;

    /* renamed from: d reason: collision with root package name */
    String f4739d;

    /* renamed from: e reason: collision with root package name */
    IBinder f4740e;

    /* renamed from: f reason: collision with root package name */
    Scope[] f4741f;

    /* renamed from: g reason: collision with root package name */
    Bundle f4742g;

    /* renamed from: h reason: collision with root package name */
    Account f4743h;

    /* renamed from: i reason: collision with root package name */
    d[] f4744i;

    /* renamed from: j reason: collision with root package name */
    d[] f4745j;

    /* renamed from: k reason: collision with root package name */
    private boolean f4746k;

    public C0311f(int i2) {
        this.f4736a = 4;
        this.f4738c = f.f4660a;
        this.f4737b = i2;
        this.f4746k = true;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f4736a);
        b.a(parcel, 2, this.f4737b);
        b.a(parcel, 3, this.f4738c);
        b.a(parcel, 4, this.f4739d, false);
        b.a(parcel, 5, this.f4740e, false);
        b.a(parcel, 6, (T[]) this.f4741f, i2, false);
        b.a(parcel, 7, this.f4742g, false);
        b.a(parcel, 8, (Parcelable) this.f4743h, i2, false);
        b.a(parcel, 10, (T[]) this.f4744i, i2, false);
        b.a(parcel, 11, (T[]) this.f4745j, i2, false);
        b.a(parcel, 12, this.f4746k);
        b.a(parcel, a2);
    }

    C0311f(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, d[] dVarArr, d[] dVarArr2, boolean z) {
        this.f4736a = i2;
        this.f4737b = i3;
        this.f4738c = i4;
        String str2 = "com.google.android.gms";
        if (str2.equals(str)) {
            this.f4739d = str2;
        } else {
            this.f4739d = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = C0306a.a(C0316k.a.a(iBinder));
            }
            this.f4743h = account2;
        } else {
            this.f4740e = iBinder;
            this.f4743h = account;
        }
        this.f4741f = scopeArr;
        this.f4742g = bundle;
        this.f4744i = dVarArr;
        this.f4745j = dVarArr2;
        this.f4746k = z;
    }
}
