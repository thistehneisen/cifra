package android.support.v4.media;

import a.a.a.a.c;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

class MediaBrowserCompat$CustomActionResultReceiver extends c {

    /* renamed from: d reason: collision with root package name */
    private final String f279d;

    /* renamed from: e reason: collision with root package name */
    private final Bundle f280e;

    /* renamed from: f reason: collision with root package name */
    private final a f281f;

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
        if (this.f281f != null) {
            MediaSessionCompat.a(bundle);
            if (i2 == -1) {
                this.f281f.a(this.f279d, this.f280e, bundle);
            } else if (i2 == 0) {
                this.f281f.c(this.f279d, this.f280e, bundle);
            } else if (i2 != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown result code: ");
                sb.append(i2);
                sb.append(" (extras=");
                sb.append(this.f280e);
                sb.append(", resultData=");
                sb.append(bundle);
                sb.append(")");
                Log.w("MediaBrowserCompat", sb.toString());
            } else {
                this.f281f.b(this.f279d, this.f280e, bundle);
            }
        }
    }
}
