package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class r extends a {
    public static final Creator<r> CREATOR = new z();

    /* renamed from: a reason: collision with root package name */
    private final int f4758a;

    /* renamed from: b reason: collision with root package name */
    private final Account f4759b;

    /* renamed from: c reason: collision with root package name */
    private final int f4760c;

    /* renamed from: d reason: collision with root package name */
    private final GoogleSignInAccount f4761d;

    r(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f4758a = i2;
        this.f4759b = account;
        this.f4760c = i3;
        this.f4761d = googleSignInAccount;
    }

    public Account f() {
        return this.f4759b;
    }

    public int g() {
        return this.f4760c;
    }

    public GoogleSignInAccount h() {
        return this.f4761d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f4758a);
        b.a(parcel, 2, (Parcelable) f(), i2, false);
        b.a(parcel, 3, g());
        b.a(parcel, 4, (Parcelable) h(), i2, false);
        b.a(parcel, a2);
    }

    public r(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
