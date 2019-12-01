package android.support.v4.media;

import a.a.a.a.c;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;

class MediaBrowserCompat$SearchResultReceiver extends c {

    /* renamed from: d reason: collision with root package name */
    private final String f286d;

    /* renamed from: e reason: collision with root package name */
    private final Bundle f287e;

    /* renamed from: f reason: collision with root package name */
    private final d f288f;

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i2 == 0 && bundle != null) {
            String str = "search_results";
            if (bundle.containsKey(str)) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(str);
                ArrayList arrayList = null;
                if (parcelableArray != null) {
                    arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
                    }
                }
                this.f288f.a(this.f286d, this.f287e, arrayList);
                return;
            }
        }
        this.f288f.a(this.f286d, this.f287e);
    }
}
