package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import androidx.core.app.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21 implements d {

    /* renamed from: a reason: collision with root package name */
    final Object f314a;

    /* renamed from: b reason: collision with root package name */
    private final List<c> f315b;

    /* renamed from: c reason: collision with root package name */
    private HashMap<c, a> f316c;

    /* renamed from: d reason: collision with root package name */
    final Token f317d;

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: a reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f318a;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i2, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = (MediaControllerCompat$MediaControllerImplApi21) this.f318a.get();
            if (mediaControllerCompat$MediaControllerImplApi21 != null && bundle != null) {
                synchronized (mediaControllerCompat$MediaControllerImplApi21.f314a) {
                    mediaControllerCompat$MediaControllerImplApi21.f317d.a(android.support.v4.media.session.b.a.a(f.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerCompat$MediaControllerImplApi21.f317d.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerCompat$MediaControllerImplApi21.a();
                }
            }
        }
    }

    private static class a extends C0004c {
        a(c cVar) {
            super(cVar);
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        public void b() throws RemoteException {
            throw new AssertionError();
        }

        public void a(List<QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        public void a(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        public void a(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (this.f317d.n() != null) {
            for (c cVar : this.f315b) {
                a aVar = new a(cVar);
                this.f316c.put(cVar, aVar);
                cVar.f351c = aVar;
                try {
                    this.f317d.n().a(aVar);
                    cVar.a(13, null, null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            this.f315b.clear();
        }
    }
}
