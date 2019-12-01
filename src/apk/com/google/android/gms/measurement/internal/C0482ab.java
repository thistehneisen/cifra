package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C0322a;
import com.google.android.gms.internal.measurement.Ha;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.ab reason: case insensitive filesystem */
public abstract class C0482ab extends C0322a implements C0487bb {
    public C0482ab() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                a((C0525j) Ha.a(parcel, C0525j.CREATOR), (ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                a((Rd) Ha.a(parcel, Rd.CREATOR), (ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                c((ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                a((C0525j) Ha.a(parcel, C0525j.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                d((ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                List a2 = a((ae) Ha.a(parcel, ae.CREATOR), Ha.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a2);
                break;
            case 9:
                byte[] a3 = a((C0525j) Ha.a(parcel, C0525j.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(a3);
                break;
            case 10:
                a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String a4 = a((ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(a4);
                break;
            case 12:
                a((de) Ha.a(parcel, de.CREATOR), (ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                a((de) Ha.a(parcel, de.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                List a5 = a(parcel.readString(), parcel.readString(), Ha.a(parcel), (ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a5);
                break;
            case 15:
                List a6 = a(parcel.readString(), parcel.readString(), parcel.readString(), Ha.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a6);
                break;
            case 16:
                List a7 = a(parcel.readString(), parcel.readString(), (ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a7);
                break;
            case 17:
                List a8 = a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(a8);
                break;
            case 18:
                b((ae) Ha.a(parcel, ae.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
