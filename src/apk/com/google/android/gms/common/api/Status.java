package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0321p;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Status extends a implements h, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new k();

    /* renamed from: a reason: collision with root package name */
    public static final Status f4519a = new Status(0);

    /* renamed from: b reason: collision with root package name */
    public static final Status f4520b = new Status(14);

    /* renamed from: c reason: collision with root package name */
    public static final Status f4521c = new Status(8);

    /* renamed from: d reason: collision with root package name */
    public static final Status f4522d = new Status(15);

    /* renamed from: e reason: collision with root package name */
    public static final Status f4523e = new Status(16);

    /* renamed from: f reason: collision with root package name */
    private static final Status f4524f = new Status(17);

    /* renamed from: g reason: collision with root package name */
    public static final Status f4525g = new Status(18);

    /* renamed from: h reason: collision with root package name */
    private final int f4526h;

    /* renamed from: i reason: collision with root package name */
    private final int f4527i;

    /* renamed from: j reason: collision with root package name */
    private final String f4528j;

    /* renamed from: k reason: collision with root package name */
    private final PendingIntent f4529k;

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f4526h = i2;
        this.f4527i = i3;
        this.f4528j = str;
        this.f4529k = pendingIntent;
    }

    public final Status e() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f4526h != status.f4526h || this.f4527i != status.f4527i || !C0321p.a(this.f4528j, status.f4528j) || !C0321p.a(this.f4529k, status.f4529k)) {
            return false;
        }
        return true;
    }

    public final int f() {
        return this.f4527i;
    }

    public final String g() {
        return this.f4528j;
    }

    public final boolean h() {
        return this.f4527i <= 0;
    }

    public final int hashCode() {
        return C0321p.a(Integer.valueOf(this.f4526h), Integer.valueOf(this.f4527i), this.f4528j, this.f4529k);
    }

    public final String i() {
        String str = this.f4528j;
        if (str != null) {
            return str;
        }
        return b.a(this.f4527i);
    }

    public final String toString() {
        C0321p.a a2 = C0321p.a((Object) this);
        a2.a("statusCode", i());
        a2.a("resolution", this.f4529k);
        return a2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, f());
        b.a(parcel, 2, g(), false);
        b.a(parcel, 3, (Parcelable) this.f4529k, i2, false);
        b.a(parcel, 1000, this.f4526h);
        b.a(parcel, a2);
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }
}
