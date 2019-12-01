package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new g();

        /* renamed from: a reason: collision with root package name */
        private final MediaDescriptionCompat f319a;

        /* renamed from: b reason: collision with root package name */
        private final long f320b;

        /* renamed from: c reason: collision with root package name */
        private Object f321c;

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j2 != -1) {
                this.f319a = mediaDescriptionCompat;
                this.f320b = j2;
                this.f321c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.a(j.a(obj)), j.b(obj));
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaSession.QueueItem {Description=");
            sb.append(this.f319a);
            sb.append(", Id=");
            sb.append(this.f320b);
            sb.append(" }");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f319a.writeToParcel(parcel, i2);
            parcel.writeLong(this.f320b);
        }

        public static List<QueueItem> a(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a2 : list) {
                arrayList.add(a(a2));
            }
            return arrayList;
        }

        QueueItem(Parcel parcel) {
            this.f319a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f320b = parcel.readLong();
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new h();

        /* renamed from: a reason: collision with root package name */
        ResultReceiver f322a;

        ResultReceiverWrapper(Parcel parcel) {
            this.f322a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.f322a.writeToParcel(parcel, i2);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new i();

        /* renamed from: a reason: collision with root package name */
        private final Object f323a;

        /* renamed from: b reason: collision with root package name */
        private b f324b;

        /* renamed from: c reason: collision with root package name */
        private Bundle f325c;

        Token(Object obj) {
            this(obj, null, null);
        }

        public void a(b bVar) {
            this.f324b = bVar;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f323a;
            if (obj2 == null) {
                if (token.f323a != null) {
                    z = false;
                }
                return z;
            }
            Object obj3 = token.f323a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f323a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public b n() {
            return this.f324b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f323a, i2);
            } else {
                parcel.writeStrongBinder((IBinder) this.f323a);
            }
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f323a = obj;
            this.f324b = bVar;
            this.f325c = bundle;
        }

        public void a(Bundle bundle) {
            this.f325c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }
}
