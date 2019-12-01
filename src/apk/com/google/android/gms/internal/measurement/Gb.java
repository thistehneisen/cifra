package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface Gb extends IInterface {
    Bundle d(Bundle bundle) throws RemoteException;
}
