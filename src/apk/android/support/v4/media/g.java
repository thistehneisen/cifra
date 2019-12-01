package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;

/* compiled from: MediaDescriptionCompatApi23 */
class g {

    /* compiled from: MediaDescriptionCompatApi23 */
    static class a {
        public static void a(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
