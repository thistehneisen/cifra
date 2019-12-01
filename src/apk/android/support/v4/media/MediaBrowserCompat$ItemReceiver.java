package android.support.v4.media;

import a.a.a.a.c;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

class MediaBrowserCompat$ItemReceiver extends c {

    /* renamed from: d reason: collision with root package name */
    private final String f282d;

    /* renamed from: e reason: collision with root package name */
    private final b f283e;

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i2 == 0 && bundle != null) {
            String str = "media_item";
            if (bundle.containsKey(str)) {
                Parcelable parcelable = bundle.getParcelable(str);
                if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
                    this.f283e.a((MediaBrowserCompat$MediaItem) parcelable);
                } else {
                    this.f283e.a(this.f282d);
                }
                return;
            }
        }
        this.f283e.a(this.f282d);
    }
}
