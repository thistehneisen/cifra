package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface tf extends IInterface {
    int e() throws RemoteException;

    void onEvent(String str, String str2, Bundle bundle, long j2) throws RemoteException;
}
