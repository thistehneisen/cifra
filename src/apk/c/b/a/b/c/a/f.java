package c.b.a.b.c.a;

import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.b.b;
import c.b.a.b.b.b.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class f extends b implements e {
    public f() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 3) {
            a((com.google.android.gms.common.b) c.a(parcel, com.google.android.gms.common.b.CREATOR), (b) c.a(parcel, b.CREATOR));
        } else if (i2 == 4) {
            a((Status) c.a(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            b((Status) c.a(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            a((Status) c.a(parcel, Status.CREATOR), (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR));
        } else if (i2 != 8) {
            return false;
        } else {
            a((k) c.a(parcel, k.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
