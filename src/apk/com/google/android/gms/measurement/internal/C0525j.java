package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* renamed from: com.google.android.gms.measurement.internal.j reason: case insensitive filesystem */
public final class C0525j extends a {
    public static final Creator<C0525j> CREATOR = new C0540m();

    /* renamed from: a reason: collision with root package name */
    public final String f5953a;

    /* renamed from: b reason: collision with root package name */
    public final C0520i f5954b;

    /* renamed from: c reason: collision with root package name */
    public final String f5955c;

    /* renamed from: d reason: collision with root package name */
    public final long f5956d;

    public C0525j(String str, C0520i iVar, String str2, long j2) {
        this.f5953a = str;
        this.f5954b = iVar;
        this.f5955c = str2;
        this.f5956d = j2;
    }

    public final String toString() {
        String str = this.f5955c;
        String str2 = this.f5953a;
        String valueOf = String.valueOf(this.f5954b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f5953a, false);
        b.a(parcel, 3, (Parcelable) this.f5954b, i2, false);
        b.a(parcel, 4, this.f5955c, false);
        b.a(parcel, 5, this.f5956d);
        b.a(parcel, a2);
    }

    C0525j(C0525j jVar, long j2) {
        q.a(jVar);
        this.f5953a = jVar.f5953a;
        this.f5954b = jVar.f5954b;
        this.f5955c = jVar.f5955c;
        this.f5956d = j2;
    }
}
