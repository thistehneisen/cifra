package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new l();

    /* renamed from: a reason: collision with root package name */
    final int f331a;

    /* renamed from: b reason: collision with root package name */
    final long f332b;

    /* renamed from: c reason: collision with root package name */
    final long f333c;

    /* renamed from: d reason: collision with root package name */
    final float f334d;

    /* renamed from: e reason: collision with root package name */
    final long f335e;

    /* renamed from: f reason: collision with root package name */
    final int f336f;

    /* renamed from: g reason: collision with root package name */
    final CharSequence f337g;

    /* renamed from: h reason: collision with root package name */
    final long f338h;

    /* renamed from: i reason: collision with root package name */
    List<CustomAction> f339i;

    /* renamed from: j reason: collision with root package name */
    final long f340j;

    /* renamed from: k reason: collision with root package name */
    final Bundle f341k;

    /* renamed from: l reason: collision with root package name */
    private Object f342l;

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new m();

        /* renamed from: a reason: collision with root package name */
        private final String f343a;

        /* renamed from: b reason: collision with root package name */
        private final CharSequence f344b;

        /* renamed from: c reason: collision with root package name */
        private final int f345c;

        /* renamed from: d reason: collision with root package name */
        private final Bundle f346d;

        /* renamed from: e reason: collision with root package name */
        private Object f347e;

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f343a = str;
            this.f344b = charSequence;
            this.f345c = i2;
            this.f346d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(a.a(obj), a.d(obj), a.c(obj), a.b(obj));
            customAction.f347e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Action:mName='");
            sb.append(this.f344b);
            sb.append(", mIcon=");
            sb.append(this.f345c);
            sb.append(", mExtras=");
            sb.append(this.f346d);
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f343a);
            TextUtils.writeToParcel(this.f344b, parcel, i2);
            parcel.writeInt(this.f345c);
            parcel.writeBundle(this.f346d);
        }

        CustomAction(Parcel parcel) {
            this.f343a = parcel.readString();
            this.f344b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f345c = parcel.readInt();
            this.f346d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f331a = i2;
        this.f332b = j2;
        this.f333c = j3;
        this.f334d = f2;
        this.f335e = j4;
        this.f336f = i3;
        this.f337g = charSequence;
        this.f338h = j5;
        this.f339i = new ArrayList(list);
        this.f340j = j6;
        this.f341k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        List list;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> d2 = n.d(obj);
        if (d2 != null) {
            ArrayList arrayList = new ArrayList(d2.size());
            for (Object a2 : d2) {
                arrayList.add(CustomAction.a(a2));
            }
            list = arrayList;
        } else {
            list = null;
        }
        if (VERSION.SDK_INT >= 22) {
            bundle = o.a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(n.i(obj), n.h(obj), n.c(obj), n.g(obj), n.a(obj), 0, n.e(obj), n.f(obj), list, n.b(obj), bundle);
        playbackStateCompat.f342l = obj2;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=");
        sb.append(this.f331a);
        sb.append(", position=");
        sb.append(this.f332b);
        sb.append(", buffered position=");
        sb.append(this.f333c);
        sb.append(", speed=");
        sb.append(this.f334d);
        sb.append(", updated=");
        sb.append(this.f338h);
        sb.append(", actions=");
        sb.append(this.f335e);
        sb.append(", error code=");
        sb.append(this.f336f);
        sb.append(", error message=");
        sb.append(this.f337g);
        sb.append(", custom actions=");
        sb.append(this.f339i);
        sb.append(", active item id=");
        sb.append(this.f340j);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f331a);
        parcel.writeLong(this.f332b);
        parcel.writeFloat(this.f334d);
        parcel.writeLong(this.f338h);
        parcel.writeLong(this.f333c);
        parcel.writeLong(this.f335e);
        TextUtils.writeToParcel(this.f337g, parcel, i2);
        parcel.writeTypedList(this.f339i);
        parcel.writeLong(this.f340j);
        parcel.writeBundle(this.f341k);
        parcel.writeInt(this.f336f);
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f331a = parcel.readInt();
        this.f332b = parcel.readLong();
        this.f334d = parcel.readFloat();
        this.f338h = parcel.readLong();
        this.f333c = parcel.readLong();
        this.f335e = parcel.readLong();
        this.f337g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f339i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f340j = parcel.readLong();
        this.f341k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f336f = parcel.readInt();
    }
}
