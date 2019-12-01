package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Rd extends a {
    public static final Creator<Rd> CREATOR = new Ud();

    /* renamed from: a reason: collision with root package name */
    private final int f5705a;

    /* renamed from: b reason: collision with root package name */
    public final String f5706b;

    /* renamed from: c reason: collision with root package name */
    public final long f5707c;

    /* renamed from: d reason: collision with root package name */
    public final Long f5708d;

    /* renamed from: e reason: collision with root package name */
    private final Float f5709e;

    /* renamed from: f reason: collision with root package name */
    public final String f5710f;

    /* renamed from: g reason: collision with root package name */
    public final String f5711g;

    /* renamed from: h reason: collision with root package name */
    public final Double f5712h;

    Rd(Td td) {
        this(td.f5723c, td.f5724d, td.f5725e, td.f5722b);
    }

    public final Object f() {
        Long l2 = this.f5708d;
        if (l2 != null) {
            return l2;
        }
        Double d2 = this.f5712h;
        if (d2 != null) {
            return d2;
        }
        String str = this.f5710f;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f5705a);
        b.a(parcel, 2, this.f5706b, false);
        b.a(parcel, 3, this.f5707c);
        b.a(parcel, 4, this.f5708d, false);
        b.a(parcel, 5, (Float) null, false);
        b.a(parcel, 6, this.f5710f, false);
        b.a(parcel, 7, this.f5711g, false);
        b.a(parcel, 8, this.f5712h, false);
        b.a(parcel, a2);
    }

    Rd(String str, long j2, Object obj, String str2) {
        q.b(str);
        this.f5705a = 2;
        this.f5706b = str;
        this.f5707c = j2;
        this.f5711g = str2;
        if (obj == null) {
            this.f5708d = null;
            this.f5709e = null;
            this.f5712h = null;
            this.f5710f = null;
        } else if (obj instanceof Long) {
            this.f5708d = (Long) obj;
            this.f5709e = null;
            this.f5712h = null;
            this.f5710f = null;
        } else if (obj instanceof String) {
            this.f5708d = null;
            this.f5709e = null;
            this.f5712h = null;
            this.f5710f = (String) obj;
        } else if (obj instanceof Double) {
            this.f5708d = null;
            this.f5709e = null;
            this.f5712h = (Double) obj;
            this.f5710f = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    Rd(String str, long j2, String str2) {
        q.b(str);
        this.f5705a = 2;
        this.f5706b = str;
        this.f5707c = 0;
        this.f5708d = null;
        this.f5709e = null;
        this.f5712h = null;
        this.f5710f = null;
        this.f5711g = null;
    }

    Rd(int i2, String str, long j2, Long l2, Float f2, String str2, String str3, Double d2) {
        this.f5705a = i2;
        this.f5706b = str;
        this.f5707c = j2;
        this.f5708d = l2;
        Double d3 = null;
        this.f5709e = null;
        if (i2 == 1) {
            if (f2 != null) {
                d3 = Double.valueOf(f2.doubleValue());
            }
            this.f5712h = d3;
        } else {
            this.f5712h = d2;
        }
        this.f5710f = str2;
        this.f5711g = str3;
    }
}
