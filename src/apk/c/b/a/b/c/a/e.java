package c.b.a.b.c.a;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.b;

public interface e extends IInterface {
    void a(k kVar) throws RemoteException;

    void a(Status status) throws RemoteException;

    void a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void a(b bVar, b bVar2) throws RemoteException;

    void b(Status status) throws RemoteException;
}
