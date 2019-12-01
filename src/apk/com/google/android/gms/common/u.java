package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.J;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;

public final class u extends a {
    public static final Creator<u> CREATOR = new v();

    /* renamed from: a reason: collision with root package name */
    private final String f4789a;

    /* renamed from: b reason: collision with root package name */
    private final o f4790b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f4791c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f4792d;

    u(String str, IBinder iBinder, boolean z, boolean z2) {
        this.f4789a = str;
        this.f4790b = a(iBinder);
        this.f4791c = z;
        this.f4792d = z2;
    }

    private static o a(IBinder iBinder) {
        byte[] bArr;
        String str = "Could not unwrap certificate";
        String str2 = "GoogleCertificatesQuery";
        p pVar = null;
        if (iBinder == null) {
            return null;
        }
        try {
            com.google.android.gms.dynamic.a f2 = J.a(iBinder).f();
            if (f2 == null) {
                bArr = null;
            } else {
                bArr = (byte[]) b.a(f2);
            }
            if (bArr != null) {
                pVar = new p(bArr);
            } else {
                Log.e(str2, str);
            }
            return pVar;
        } catch (RemoteException e2) {
            Log.e(str2, str, e2);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f4789a, false);
        o oVar = this.f4790b;
        if (oVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            oVar = null;
        } else {
            oVar.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (IBinder) oVar, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f4791c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f4792d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a2);
    }

    u(String str, o oVar, boolean z, boolean z2) {
        this.f4789a = str;
        this.f4790b = oVar;
        this.f4791c = z;
        this.f4792d = z2;
    }
}
