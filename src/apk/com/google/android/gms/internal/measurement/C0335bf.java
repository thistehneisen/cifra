package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;

/* renamed from: com.google.android.gms.internal.measurement.bf reason: case insensitive filesystem */
public final class C0335bf extends r implements C0327ae {
    C0335bf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeLong(j2);
        b(23, h2);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, (Parcelable) bundle);
        b(9, h2);
    }

    public final void endAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeLong(j2);
        b(24, h2);
    }

    public final void generateEventId(sf sfVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) sfVar);
        b(22, h2);
    }

    public final void getCachedAppInstanceId(sf sfVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) sfVar);
        b(19, h2);
    }

    public final void getConditionalUserProperties(String str, String str2, sf sfVar) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, (IInterface) sfVar);
        b(10, h2);
    }

    public final void getCurrentScreenClass(sf sfVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) sfVar);
        b(17, h2);
    }

    public final void getCurrentScreenName(sf sfVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) sfVar);
        b(16, h2);
    }

    public final void getGmpAppId(sf sfVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) sfVar);
        b(21, h2);
    }

    public final void getMaxUserProperties(String str, sf sfVar) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        Ha.a(h2, (IInterface) sfVar);
        b(6, h2);
    }

    public final void getUserProperties(String str, String str2, boolean z, sf sfVar) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, z);
        Ha.a(h2, (IInterface) sfVar);
        b(5, h2);
    }

    public final void initialize(a aVar, Af af, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        Ha.a(h2, (Parcelable) af);
        h2.writeLong(j2);
        b(1, h2);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, (Parcelable) bundle);
        Ha.a(h2, z);
        Ha.a(h2, z2);
        h2.writeLong(j2);
        b(2, h2);
    }

    public final void logHealthData(int i2, String str, a aVar, a aVar2, a aVar3) throws RemoteException {
        Parcel h2 = h();
        h2.writeInt(i2);
        h2.writeString(str);
        Ha.a(h2, (IInterface) aVar);
        Ha.a(h2, (IInterface) aVar2);
        Ha.a(h2, (IInterface) aVar3);
        b(33, h2);
    }

    public final void onActivityCreated(a aVar, Bundle bundle, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        Ha.a(h2, (Parcelable) bundle);
        h2.writeLong(j2);
        b(27, h2);
    }

    public final void onActivityDestroyed(a aVar, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        h2.writeLong(j2);
        b(28, h2);
    }

    public final void onActivityPaused(a aVar, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        h2.writeLong(j2);
        b(29, h2);
    }

    public final void onActivityResumed(a aVar, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        h2.writeLong(j2);
        b(30, h2);
    }

    public final void onActivitySaveInstanceState(a aVar, sf sfVar, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        Ha.a(h2, (IInterface) sfVar);
        h2.writeLong(j2);
        b(31, h2);
    }

    public final void onActivityStarted(a aVar, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        h2.writeLong(j2);
        b(25, h2);
    }

    public final void onActivityStopped(a aVar, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        h2.writeLong(j2);
        b(26, h2);
    }

    public final void registerOnMeasurementEventListener(tf tfVar) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) tfVar);
        b(35, h2);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) bundle);
        h2.writeLong(j2);
        b(8, h2);
    }

    public final void setCurrentScreen(a aVar, String str, String str2, long j2) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (IInterface) aVar);
        h2.writeString(str);
        h2.writeString(str2);
        h2.writeLong(j2);
        b(15, h2);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, z);
        b(39, h2);
    }

    public final void setUserProperty(String str, String str2, a aVar, boolean z, long j2) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, (IInterface) aVar);
        Ha.a(h2, z);
        h2.writeLong(j2);
        b(4, h2);
    }
}
