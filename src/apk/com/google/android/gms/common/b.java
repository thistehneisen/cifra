package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0321p;
import com.google.android.gms.common.internal.safeparcel.a;
import io.intercom.android.sdk.metrics.MetricTracker.Object;

public final class b extends a {
    public static final Creator<b> CREATOR = new k();

    /* renamed from: a reason: collision with root package name */
    public static final b f4639a = new b(0);

    /* renamed from: b reason: collision with root package name */
    private final int f4640b;

    /* renamed from: c reason: collision with root package name */
    private final int f4641c;

    /* renamed from: d reason: collision with root package name */
    private final PendingIntent f4642d;

    /* renamed from: e reason: collision with root package name */
    private final String f4643e;

    b(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f4640b = i2;
        this.f4641c = i3;
        this.f4642d = pendingIntent;
        this.f4643e = str;
    }

    static String a(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4641c == bVar.f4641c && C0321p.a(this.f4642d, bVar.f4642d) && C0321p.a(this.f4643e, bVar.f4643e);
    }

    public final int f() {
        return this.f4641c;
    }

    public final String g() {
        return this.f4643e;
    }

    public final PendingIntent h() {
        return this.f4642d;
    }

    public final int hashCode() {
        return C0321p.a(Integer.valueOf(this.f4641c), this.f4642d, this.f4643e);
    }

    public final boolean i() {
        return (this.f4641c == 0 || this.f4642d == null) ? false : true;
    }

    public final boolean j() {
        return this.f4641c == 0;
    }

    public final String toString() {
        C0321p.a a2 = C0321p.a((Object) this);
        a2.a("statusCode", a(this.f4641c));
        a2.a("resolution", this.f4642d);
        a2.a(Object.MESSAGE, this.f4643e);
        return a2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f4640b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, f());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) h(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, g(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a2);
    }

    public b(int i2) {
        this(i2, null, null);
    }

    public b(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public b(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}
