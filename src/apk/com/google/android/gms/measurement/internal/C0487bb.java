package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.bb reason: case insensitive filesystem */
public interface C0487bb extends IInterface {
    String a(ae aeVar) throws RemoteException;

    List<Rd> a(ae aeVar, boolean z) throws RemoteException;

    List<de> a(String str, String str2, ae aeVar) throws RemoteException;

    List<de> a(String str, String str2, String str3) throws RemoteException;

    List<Rd> a(String str, String str2, String str3, boolean z) throws RemoteException;

    List<Rd> a(String str, String str2, boolean z, ae aeVar) throws RemoteException;

    void a(long j2, String str, String str2, String str3) throws RemoteException;

    void a(Rd rd, ae aeVar) throws RemoteException;

    void a(de deVar) throws RemoteException;

    void a(de deVar, ae aeVar) throws RemoteException;

    void a(C0525j jVar, ae aeVar) throws RemoteException;

    void a(C0525j jVar, String str, String str2) throws RemoteException;

    byte[] a(C0525j jVar, String str) throws RemoteException;

    void b(ae aeVar) throws RemoteException;

    void c(ae aeVar) throws RemoteException;

    void d(ae aeVar) throws RemoteException;
}
