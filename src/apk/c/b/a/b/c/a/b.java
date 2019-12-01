package c.b.a.b.c.a;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b extends a implements h {
    public static final Creator<b> CREATOR = new c();

    /* renamed from: a reason: collision with root package name */
    private final int f3075a;

    /* renamed from: b reason: collision with root package name */
    private int f3076b;

    /* renamed from: c reason: collision with root package name */
    private Intent f3077c;

    b(int i2, int i3, Intent intent) {
        this.f3075a = i2;
        this.f3076b = i3;
        this.f3077c = intent;
    }

    public final Status e() {
        if (this.f3076b == 0) {
            return Status.f4519a;
        }
        return Status.f4523e;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3075a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3076b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) this.f3077c, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a2);
    }

    public b() {
        this(0, null);
    }

    private b(int i2, Intent intent) {
        this(2, 0, null);
    }
}
