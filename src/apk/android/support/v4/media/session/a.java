package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.text.TextUtils;
import java.util.List;

/* compiled from: IMediaControllerCallback */
public interface a extends IInterface {

    /* renamed from: android.support.v4.media.session.a$a reason: collision with other inner class name */
    /* compiled from: IMediaControllerCallback */
    public static abstract class C0002a extends Binder implements a {
        public C0002a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v1, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v3, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v4, types: [android.support.v4.media.session.PlaybackStateCompat] */
        /* JADX WARNING: type inference failed for: r3v6, types: [android.support.v4.media.session.PlaybackStateCompat] */
        /* JADX WARNING: type inference failed for: r3v7, types: [android.support.v4.media.MediaMetadataCompat] */
        /* JADX WARNING: type inference failed for: r3v9, types: [android.support.v4.media.MediaMetadataCompat] */
        /* JADX WARNING: type inference failed for: r3v10, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r3v12, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r3v13, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v15, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r3v16, types: [android.support.v4.media.session.ParcelableVolumeInfo] */
        /* JADX WARNING: type inference failed for: r3v18, types: [android.support.v4.media.session.ParcelableVolumeInfo] */
        /* JADX WARNING: type inference failed for: r3v19 */
        /* JADX WARNING: type inference failed for: r3v20 */
        /* JADX WARNING: type inference failed for: r3v21 */
        /* JADX WARNING: type inference failed for: r3v22 */
        /* JADX WARNING: type inference failed for: r3v23 */
        /* JADX WARNING: type inference failed for: r3v24 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.support.v4.media.session.PlaybackStateCompat, android.os.Bundle, android.support.v4.media.MediaMetadataCompat, java.lang.CharSequence, android.support.v4.media.session.ParcelableVolumeInfo]
          uses: [android.os.Bundle, android.support.v4.media.session.PlaybackStateCompat, android.support.v4.media.MediaMetadataCompat, java.lang.CharSequence, android.support.v4.media.session.ParcelableVolumeInfo]
          mth insns count: 101
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 7 */
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = "android.support.v4.media.session.IMediaControllerCallback";
            if (i2 != 1598968902) {
                boolean z = false;
                ? r3 = 0;
                switch (i2) {
                    case 1:
                        parcel.enforceInterface(str);
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        a(readString, r3);
                        return true;
                    case 2:
                        parcel.enforceInterface(str);
                        b();
                        return true;
                    case 3:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            r3 = (PlaybackStateCompat) PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                        }
                        a((PlaybackStateCompat) r3);
                        return true;
                    case 4:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            r3 = (MediaMetadataCompat) MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                        }
                        a((MediaMetadataCompat) r3);
                        return true;
                    case 5:
                        parcel.enforceInterface(str);
                        a((List<QueueItem>) parcel.createTypedArrayList(QueueItem.CREATOR));
                        return true;
                    case 6:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            r3 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                        }
                        a((CharSequence) r3);
                        return true;
                    case 7:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            r3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        a((Bundle) r3);
                        return true;
                    case 8:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            r3 = (ParcelableVolumeInfo) ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                        }
                        a((ParcelableVolumeInfo) r3);
                        return true;
                    case 9:
                        parcel.enforceInterface(str);
                        a(parcel.readInt());
                        return true;
                    case 10:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        b(z);
                        return true;
                    case 11:
                        parcel.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(z);
                        return true;
                    case 12:
                        parcel.enforceInterface(str);
                        b(parcel.readInt());
                        return true;
                    case 13:
                        parcel.enforceInterface(str);
                        c();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    void a(int i2) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void a(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void a(CharSequence charSequence) throws RemoteException;

    void a(String str, Bundle bundle) throws RemoteException;

    void a(List<QueueItem> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b() throws RemoteException;

    void b(int i2) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void c() throws RemoteException;
}
