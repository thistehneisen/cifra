package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import b.d.b;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new h();

    /* renamed from: a reason: collision with root package name */
    static final b<String, Integer> f306a = new b<>();

    /* renamed from: b reason: collision with root package name */
    private static final String[] f307b = {"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};

    /* renamed from: c reason: collision with root package name */
    private static final String[] f308c;

    /* renamed from: d reason: collision with root package name */
    private static final String[] f309d;

    /* renamed from: e reason: collision with root package name */
    final Bundle f310e;

    /* renamed from: f reason: collision with root package name */
    private Object f311f;

    static {
        b<String, Integer> bVar = f306a;
        Integer valueOf = Integer.valueOf(1);
        bVar.put("android.media.metadata.TITLE", valueOf);
        f306a.put("android.media.metadata.ARTIST", valueOf);
        b<String, Integer> bVar2 = f306a;
        Integer valueOf2 = Integer.valueOf(0);
        bVar2.put("android.media.metadata.DURATION", valueOf2);
        f306a.put("android.media.metadata.ALBUM", valueOf);
        f306a.put("android.media.metadata.AUTHOR", valueOf);
        f306a.put("android.media.metadata.WRITER", valueOf);
        f306a.put("android.media.metadata.COMPOSER", valueOf);
        f306a.put("android.media.metadata.COMPILATION", valueOf);
        f306a.put("android.media.metadata.DATE", valueOf);
        f306a.put("android.media.metadata.YEAR", valueOf2);
        f306a.put("android.media.metadata.GENRE", valueOf);
        f306a.put("android.media.metadata.TRACK_NUMBER", valueOf2);
        f306a.put("android.media.metadata.NUM_TRACKS", valueOf2);
        f306a.put("android.media.metadata.DISC_NUMBER", valueOf2);
        f306a.put("android.media.metadata.ALBUM_ARTIST", valueOf);
        b<String, Integer> bVar3 = f306a;
        Integer valueOf3 = Integer.valueOf(2);
        String str = "android.media.metadata.ART";
        bVar3.put(str, valueOf3);
        String str2 = "android.media.metadata.ART_URI";
        f306a.put(str2, valueOf);
        String str3 = "android.media.metadata.ALBUM_ART";
        f306a.put(str3, valueOf3);
        String str4 = "android.media.metadata.ALBUM_ART_URI";
        f306a.put(str4, valueOf);
        b<String, Integer> bVar4 = f306a;
        Integer valueOf4 = Integer.valueOf(3);
        bVar4.put("android.media.metadata.USER_RATING", valueOf4);
        f306a.put("android.media.metadata.RATING", valueOf4);
        f306a.put("android.media.metadata.DISPLAY_TITLE", valueOf);
        f306a.put("android.media.metadata.DISPLAY_SUBTITLE", valueOf);
        f306a.put("android.media.metadata.DISPLAY_DESCRIPTION", valueOf);
        String str5 = "android.media.metadata.DISPLAY_ICON";
        f306a.put(str5, valueOf3);
        String str6 = "android.media.metadata.DISPLAY_ICON_URI";
        f306a.put(str6, valueOf);
        f306a.put("android.media.metadata.MEDIA_ID", valueOf);
        f306a.put("android.media.metadata.BT_FOLDER_TYPE", valueOf2);
        f306a.put("android.media.metadata.MEDIA_URI", valueOf);
        f306a.put("android.media.metadata.ADVERTISEMENT", valueOf2);
        f306a.put("android.media.metadata.DOWNLOAD_STATUS", valueOf2);
        f308c = new String[]{str5, str, str3};
        f309d = new String[]{str6, str2, str4};
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f310e = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        i.a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.f311f = obj;
        return mediaMetadataCompat;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f310e);
    }
}
