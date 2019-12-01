package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.Ha;
import com.google.android.gms.internal.measurement.r;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.db reason: case insensitive filesystem */
public final class C0497db extends r implements C0487bb {
    C0497db(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void a(C0525j jVar, ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) jVar);
        Ha.a(h2, (Parcelable) aeVar);
        b(1, h2);
    }

    public final void b(ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) aeVar);
        b(18, h2);
    }

    public final void c(ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) aeVar);
        b(4, h2);
    }

    public final void d(ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) aeVar);
        b(6, h2);
    }

    public final void a(Rd rd, ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) rd);
        Ha.a(h2, (Parcelable) aeVar);
        b(2, h2);
    }

    public final void a(C0525j jVar, String str, String str2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) jVar);
        h2.writeString(str);
        h2.writeString(str2);
        b(5, h2);
    }

    public final byte[] a(C0525j jVar, String str) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) jVar);
        h2.writeString(str);
        Parcel a2 = a(9, h2);
        byte[] createByteArray = a2.createByteArray();
        a2.recycle();
        return createByteArray;
    }

    public final void a(long j2, String str, String str2, String str3) throws RemoteException {
        Parcel h2 = h();
        h2.writeLong(j2);
        h2.writeString(str);
        h2.writeString(str2);
        h2.writeString(str3);
        b(10, h2);
    }

    public final String a(ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) aeVar);
        Parcel a2 = a(11, h2);
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    public final void a(de deVar, ae aeVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) deVar);
        Ha.a(h2, (Parcelable) aeVar);
        b(12, h2);
    }

    public final void a(de deVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) deVar);
        b(13, h2);
    }

    public final List<Rd> a(String str, String str2, boolean z, ae aeVar) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, z);
        Ha.a(h2, (Parcelable) aeVar);
        Parcel a2 = a(14, h2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(Rd.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    public final List<Rd> a(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        h2.writeString(str3);
        Ha.a(h2, z);
        Parcel a2 = a(15, h2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(Rd.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    public final List<de> a(String str, String str2, ae aeVar) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, (Parcelable) aeVar);
        Parcel a2 = a(16, h2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(de.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }

    public final List<de> a(String str, String str2, String str3) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        h2.writeString(str3);
        Parcel a2 = a(17, h2);
        ArrayList createTypedArrayList = a2.createTypedArrayList(de.CREATOR);
        a2.recycle();
        return createTypedArrayList;
    }
}
