package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* compiled from: MediaDescriptionCompatApi21 */
class f {

    /* compiled from: MediaDescriptionCompatApi21 */
    static class a {
        public static Object a() {
            return new Builder();
        }

        public static void b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void a(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }

        public static void a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static Object a(Object obj) {
            return ((Builder) obj).build();
        }
    }

    public static CharSequence a(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bundle b(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static Bitmap c(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri d(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static String e(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence f(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence g(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static void a(Object obj, Parcel parcel, int i2) {
        ((MediaDescription) obj).writeToParcel(parcel, i2);
    }

    public static Object a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
