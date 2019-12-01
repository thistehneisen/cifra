package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1242a = (IconCompat) versionedParcel.a(remoteActionCompat.f1242a, 1);
        remoteActionCompat.f1243b = versionedParcel.a(remoteActionCompat.f1243b, 2);
        remoteActionCompat.f1244c = versionedParcel.a(remoteActionCompat.f1244c, 3);
        remoteActionCompat.f1245d = (PendingIntent) versionedParcel.a(remoteActionCompat.f1245d, 4);
        remoteActionCompat.f1246e = versionedParcel.a(remoteActionCompat.f1246e, 5);
        remoteActionCompat.f1247f = versionedParcel.a(remoteActionCompat.f1247f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b((c) remoteActionCompat.f1242a, 1);
        versionedParcel.b(remoteActionCompat.f1243b, 2);
        versionedParcel.b(remoteActionCompat.f1244c, 3);
        versionedParcel.b((Parcelable) remoteActionCompat.f1245d, 4);
        versionedParcel.b(remoteActionCompat.f1246e, 5);
        versionedParcel.b(remoteActionCompat.f1247f, 6);
    }
}
