package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;

/* compiled from: MediaSessionCompat */
class i implements Creator<Token> {
    i() {
    }

    public Token createFromParcel(Parcel parcel) {
        Object obj;
        if (VERSION.SDK_INT >= 21) {
            obj = parcel.readParcelable(null);
        } else {
            obj = parcel.readStrongBinder();
        }
        return new Token(obj);
    }

    public Token[] newArray(int i2) {
        return new Token[i2];
    }
}
