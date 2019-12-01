package c.b.a.b.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class i extends a {
    public static final Creator<i> CREATOR = new j();

    /* renamed from: a reason: collision with root package name */
    private final int f3078a;

    /* renamed from: b reason: collision with root package name */
    private final r f3079b;

    i(int i2, r rVar) {
        this.f3078a = i2;
        this.f3079b = rVar;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f3078a);
        b.a(parcel, 2, (Parcelable) this.f3079b, i2, false);
        b.a(parcel, a2);
    }

    public i(r rVar) {
        this(1, rVar);
    }
}
