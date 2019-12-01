package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.j.a;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
class l {

    /* renamed from: a reason: collision with root package name */
    private static final Object f1296a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static Field f1297b;

    /* renamed from: c reason: collision with root package name */
    private static boolean f1298c;

    /* renamed from: d reason: collision with root package name */
    private static final Object f1299d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = (Bundle) list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f1296a) {
            if (f1298c) {
                return null;
            }
            try {
                if (f1297b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1298c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1297b = declaredField;
                }
                Bundle bundle = (Bundle) f1297b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1297b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1298c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f1298c = true;
                return null;
            }
        }
    }

    public static Bundle a(Builder builder, a aVar) {
        builder.addAction(aVar.e(), aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }

    static Bundle a(a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.e());
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    private static Bundle a(m mVar) {
        new Bundle();
        mVar.a();
        throw null;
    }

    private static Bundle[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        if (mVarArr.length <= 0) {
            return bundleArr;
        }
        a(mVarArr[0]);
        throw null;
    }
}
