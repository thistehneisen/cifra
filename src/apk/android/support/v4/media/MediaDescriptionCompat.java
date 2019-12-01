package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new e();

    /* renamed from: a reason: collision with root package name */
    private final String f289a;

    /* renamed from: b reason: collision with root package name */
    private final CharSequence f290b;

    /* renamed from: c reason: collision with root package name */
    private final CharSequence f291c;

    /* renamed from: d reason: collision with root package name */
    private final CharSequence f292d;

    /* renamed from: e reason: collision with root package name */
    private final Bitmap f293e;

    /* renamed from: f reason: collision with root package name */
    private final Uri f294f;

    /* renamed from: g reason: collision with root package name */
    private final Bundle f295g;

    /* renamed from: h reason: collision with root package name */
    private final Uri f296h;

    /* renamed from: i reason: collision with root package name */
    private Object f297i;

    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private String f298a;

        /* renamed from: b reason: collision with root package name */
        private CharSequence f299b;

        /* renamed from: c reason: collision with root package name */
        private CharSequence f300c;

        /* renamed from: d reason: collision with root package name */
        private CharSequence f301d;

        /* renamed from: e reason: collision with root package name */
        private Bitmap f302e;

        /* renamed from: f reason: collision with root package name */
        private Uri f303f;

        /* renamed from: g reason: collision with root package name */
        private Bundle f304g;

        /* renamed from: h reason: collision with root package name */
        private Uri f305h;

        public a a(String str) {
            this.f298a = str;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f300c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f299b = charSequence;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f301d = charSequence;
            return this;
        }

        public a b(Uri uri) {
            this.f305h = uri;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.f302e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f303f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.f304g = bundle;
            return this;
        }

        public MediaDescriptionCompat a() {
            MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(this.f298a, this.f299b, this.f300c, this.f301d, this.f302e, this.f303f, this.f304g, this.f305h);
            return mediaDescriptionCompat;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f289a = str;
        this.f290b = charSequence;
        this.f291c = charSequence2;
        this.f292d = charSequence3;
        this.f293e = bitmap;
        this.f294f = uri;
        this.f295g = bundle;
        this.f296h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        a aVar = new a();
        aVar.a(f.e(obj));
        aVar.c(f.g(obj));
        aVar.b(f.f(obj));
        aVar.a(f.a(obj));
        aVar.a(f.c(obj));
        aVar.a(f.d(obj));
        Bundle b2 = f.b(obj);
        String str = "android.support.v4.media.description.MEDIA_URI";
        if (b2 != null) {
            MediaSessionCompat.a(b2);
            uri = (Uri) b2.getParcelable(str);
        } else {
            uri = null;
        }
        if (uri != null) {
            String str2 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
            if (!b2.containsKey(str2) || b2.size() != 2) {
                b2.remove(str);
                b2.remove(str2);
            }
            aVar.a(bundle);
            if (uri == null) {
                aVar.b(uri);
            } else if (VERSION.SDK_INT >= 23) {
                aVar.b(g.a(obj));
            }
            MediaDescriptionCompat a2 = aVar.a();
            a2.f297i = obj;
            return a2;
        }
        bundle = b2;
        aVar.a(bundle);
        if (uri == null) {
        }
        MediaDescriptionCompat a22 = aVar.a();
        a22.f297i = obj;
        return a22;
    }

    public int describeContents() {
        return 0;
    }

    public Object n() {
        if (this.f297i != null || VERSION.SDK_INT < 21) {
            return this.f297i;
        }
        Object a2 = a.a();
        a.a(a2, this.f289a);
        a.c(a2, this.f290b);
        a.b(a2, this.f291c);
        a.a(a2, this.f292d);
        a.a(a2, this.f293e);
        a.a(a2, this.f294f);
        Bundle bundle = this.f295g;
        if (VERSION.SDK_INT < 23 && this.f296h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f296h);
        }
        a.a(a2, bundle);
        if (VERSION.SDK_INT >= 23) {
            a.a(a2, this.f296h);
        }
        this.f297i = a.a(a2);
        return this.f297i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f290b);
        String str = ", ";
        sb.append(str);
        sb.append(this.f291c);
        sb.append(str);
        sb.append(this.f292d);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f289a);
            TextUtils.writeToParcel(this.f290b, parcel, i2);
            TextUtils.writeToParcel(this.f291c, parcel, i2);
            TextUtils.writeToParcel(this.f292d, parcel, i2);
            parcel.writeParcelable(this.f293e, i2);
            parcel.writeParcelable(this.f294f, i2);
            parcel.writeBundle(this.f295g);
            parcel.writeParcelable(this.f296h, i2);
            return;
        }
        f.a(n(), parcel, i2);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f289a = parcel.readString();
        this.f290b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f291c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f292d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f293e = (Bitmap) parcel.readParcelable(classLoader);
        this.f294f = (Uri) parcel.readParcelable(classLoader);
        this.f295g = parcel.readBundle(classLoader);
        this.f296h = (Uri) parcel.readParcelable(classLoader);
    }
}
