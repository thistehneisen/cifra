package androidx.core.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat */
public final class f {

    /* compiled from: BundleCompat */
    static class a {

        /* renamed from: a reason: collision with root package name */
        private static Method f1256a;

        /* renamed from: b reason: collision with root package name */
        private static boolean f1257b;

        public static IBinder a(Bundle bundle, String str) {
            String str2 = "BundleCompatBaseImpl";
            if (!f1257b) {
                try {
                    f1256a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f1256a.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(str2, "Failed to retrieve getIBinder method", e2);
                }
                f1257b = true;
            }
            Method method = f1256a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Log.i(str2, "Failed to invoke getIBinder via reflection", e3);
                    f1256a = null;
                }
            }
            return null;
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.a(bundle, str);
    }
}
