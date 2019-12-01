package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.a.C0002a;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: MediaControllerCompat */
public abstract class c implements DeathRecipient {

    /* renamed from: a reason: collision with root package name */
    final Object f349a;

    /* renamed from: b reason: collision with root package name */
    a f350b;

    /* renamed from: c reason: collision with root package name */
    a f351c;

    /* compiled from: MediaControllerCompat */
    private class a extends Handler {
    }

    /* compiled from: MediaControllerCompat */
    private static class b implements android.support.v4.media.session.f.a {

        /* renamed from: a reason: collision with root package name */
        private final WeakReference<c> f352a;

        b(c cVar) {
            this.f352a = new WeakReference<>(cVar);
        }

        public void a(String str, Bundle bundle) {
            c cVar = (c) this.f352a.get();
            if (cVar == null) {
                return;
            }
            if (cVar.f351c == null || VERSION.SDK_INT >= 23) {
                cVar.a(str, bundle);
            }
        }

        public void b() {
            c cVar = (c) this.f352a.get();
            if (cVar != null) {
                cVar.a();
            }
        }

        public void b(Object obj) {
            c cVar = (c) this.f352a.get();
            if (cVar != null && cVar.f351c == null) {
                cVar.a(PlaybackStateCompat.a(obj));
            }
        }

        public void a(Object obj) {
            c cVar = (c) this.f352a.get();
            if (cVar != null) {
                cVar.a(MediaMetadataCompat.a(obj));
            }
        }

        public void a(List<?> list) {
            c cVar = (c) this.f352a.get();
            if (cVar != null) {
                cVar.a(QueueItem.a(list));
            }
        }

        public void a(CharSequence charSequence) {
            c cVar = (c) this.f352a.get();
            if (cVar != null) {
                cVar.a(charSequence);
            }
        }

        public void a(Bundle bundle) {
            c cVar = (c) this.f352a.get();
            if (cVar != null) {
                cVar.a(bundle);
            }
        }

        public void a(int i2, int i3, int i4, int i5, int i6) {
            c cVar = (c) this.f352a.get();
            if (cVar != null) {
                e eVar = new e(i2, i3, i4, i5, i6);
                cVar.a(eVar);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.c$c reason: collision with other inner class name */
    /* compiled from: MediaControllerCompat */
    private static class C0004c extends C0002a {

        /* renamed from: a reason: collision with root package name */
        private final WeakReference<c> f353a;

        C0004c(c cVar) {
            this.f353a = new WeakReference<>(cVar);
        }

        public void a(String str, Bundle bundle) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(1, str, bundle);
            }
        }

        public void b() throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(8, null, null);
            }
        }

        public void b(boolean z) throws RemoteException {
        }

        public void c() throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(13, null, null);
            }
        }

        public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(2, playbackStateCompat, null);
            }
        }

        public void b(int i2) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(12, Integer.valueOf(i2), null);
            }
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(3, mediaMetadataCompat, null);
            }
        }

        public void a(List<QueueItem> list) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(5, list, null);
            }
        }

        public void a(CharSequence charSequence) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(6, charSequence, null);
            }
        }

        public void a(boolean z) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(11, Boolean.valueOf(z), null);
            }
        }

        public void a(int i2) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(9, Integer.valueOf(i2), null);
            }
        }

        public void a(Bundle bundle) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(7, bundle, null);
            }
        }

        public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            c cVar = (c) this.f353a.get();
            if (cVar != null) {
                cVar.a(4, parcelableVolumeInfo != null ? new e(parcelableVolumeInfo.f326a, parcelableVolumeInfo.f327b, parcelableVolumeInfo.f328c, parcelableVolumeInfo.f329d, parcelableVolumeInfo.f330e) : null, null);
            }
        }
    }

    public c() {
        if (VERSION.SDK_INT >= 21) {
            this.f349a = f.a(new b(this));
            return;
        }
        C0004c cVar = new C0004c(this);
        this.f351c = cVar;
        this.f349a = cVar;
    }

    public void a() {
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, Object obj, Bundle bundle) {
        a aVar = this.f350b;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(i2, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void a(Bundle bundle) {
    }

    public void a(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void a(PlaybackStateCompat playbackStateCompat) {
    }

    public void a(e eVar) {
    }

    public void a(CharSequence charSequence) {
    }

    public void a(String str, Bundle bundle) {
    }

    public void a(List<QueueItem> list) {
    }

    public void binderDied() {
        a(8, null, null);
    }
}
