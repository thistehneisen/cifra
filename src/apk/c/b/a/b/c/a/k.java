package c.b.a.b.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.a;

public final class k extends a {
    public static final Creator<k> CREATOR = new l();

    /* renamed from: a reason: collision with root package name */
    private final int f3080a;

    /* renamed from: b reason: collision with root package name */
    private final b f3081b;

    /* renamed from: c reason: collision with root package name */
    private final s f3082c;

    k(int i2, b bVar, s sVar) {
        this.f3080a = i2;
        this.f3081b = bVar;
        this.f3082c = sVar;
    }

    public final b f() {
        return this.f3081b;
    }

    public final s g() {
        return this.f3082c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3080a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (Parcelable) this.f3081b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) this.f3082c, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a2);
    }

    public k(int i2) {
        this(new b(8, null), null);
    }

    private k(b bVar, s sVar) {
        this(1, bVar, null);
    }
}
