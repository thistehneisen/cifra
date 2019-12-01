package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: NavUtils */
public final class h {
    public static void a(Activity activity, Intent intent) {
        if (VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public static boolean b(Activity activity, Intent intent) {
        if (VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return action != null && !action.equals("android.intent.action.MAIN");
    }

    public static String b(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Intent a(Activity activity) {
        Intent intent;
        if (VERSION.SDK_INT >= 16) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
        }
        String b2 = b(activity);
        if (b2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, b2);
        try {
            if (b((Context) activity, componentName) == null) {
                intent = Intent.makeMainActivity(componentName);
            } else {
                intent = new Intent().setComponent(componentName);
            }
            return intent;
        } catch (NameNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("getParentActivityIntent: bad parentActivityName '");
            sb.append(b2);
            sb.append("' in manifest");
            Log.e("NavUtils", sb.toString());
            return null;
        }
    }

    public static String b(Context context, ComponentName componentName) throws NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        int i2 = VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 640);
        if (VERSION.SDK_INT >= 16) {
            String str = activityInfo.parentActivityName;
            if (str != null) {
                return str;
            }
        }
        if (activityInfo.metaData == null) {
            return null;
        }
        String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (string == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(string);
            string = sb.toString();
        }
        return string;
    }

    public static Intent a(Context context, ComponentName componentName) throws NameNotFoundException {
        Intent intent;
        String b2 = b(context, componentName);
        if (b2 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b2);
        if (b(context, componentName2) == null) {
            intent = Intent.makeMainActivity(componentName2);
        } else {
            intent = new Intent().setComponent(componentName2);
        }
        return intent;
    }
}
