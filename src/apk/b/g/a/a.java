package b.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;

/* compiled from: ContextCompat */
public class a {

    /* renamed from: a reason: collision with root package name */
    private static final Object f2474a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static TypedValue f2475b;

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    public static ColorStateList b(Context context, int i2) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        return context.getResources().getColorStateList(i2);
    }

    public static Drawable c(Context context, int i2) {
        int i3;
        int i4 = VERSION.SDK_INT;
        if (i4 >= 21) {
            return context.getDrawable(i2);
        }
        if (i4 >= 16) {
            return context.getResources().getDrawable(i2);
        }
        synchronized (f2474a) {
            if (f2475b == null) {
                f2475b = new TypedValue();
            }
            context.getResources().getValue(i2, f2475b, true);
            i3 = f2475b.resourceId;
        }
        return context.getResources().getDrawable(i3);
    }

    public static int a(Context context, int i2) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i2);
        }
        return context.getResources().getColor(i2);
    }

    public static boolean b(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static File a(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        return r4;
     */
    private static synchronized File a(File file) {
        synchronized (a.class) {
            if (!file.exists() && !file.mkdirs()) {
                if (file.exists()) {
                    return file;
                }
                String str = "ContextCompat";
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to create files subdir ");
                sb.append(file.getPath());
                Log.w(str, sb.toString());
                return null;
            }
        }
    }
}
