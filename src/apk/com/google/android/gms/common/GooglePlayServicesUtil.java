package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.C0310e;

public final class GooglePlayServicesUtil extends g {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = g.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i2, Activity activity, int i3) {
        return getErrorDialog(i2, activity, i3, null);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, Context context, int i3) {
        return g.getErrorPendingIntent(i2, context, i3);
    }

    @Deprecated
    public static String getErrorString(int i2) {
        return g.getErrorString(i2);
    }

    public static Context getRemoteContext(Context context) {
        return g.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return g.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return g.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        return g.isUserRecoverableError(i2);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i2, Activity activity, int i3, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i2, activity, null, i3, onCancelListener);
    }

    @Deprecated
    public static void showErrorNotification(int i2, Context context) {
        e a2 = e.a();
        if (g.isPlayServicesPossiblyUpdating(context, i2) || g.isPlayStorePossiblyUpdating(context, i2)) {
            a2.c(context);
        } else {
            a2.b(context, i2);
        }
    }

    @Deprecated
    public static Dialog getErrorDialog(int i2, Activity activity, int i3, OnCancelListener onCancelListener) {
        if (g.isPlayServicesPossiblyUpdating(activity, i2)) {
            i2 = 18;
        }
        return e.a().a(activity, i2, i3, onCancelListener);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i2) {
        return g.isGooglePlayServicesAvailable(context, i2);
    }

    public static boolean showErrorDialogFragment(int i2, Activity activity, Fragment fragment, int i3, OnCancelListener onCancelListener) {
        if (g.isPlayServicesPossiblyUpdating(activity, i2)) {
            i2 = 18;
        }
        e a2 = e.a();
        if (fragment == null) {
            return a2.b(activity, i2, i3, onCancelListener);
        }
        Dialog a3 = e.a((Context) activity, i2, C0310e.a(fragment, e.a().a((Context) activity, i2, "d"), i3), onCancelListener);
        if (a3 == null) {
            return false;
        }
        e.a(activity, a3, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i2, Activity activity, int i3) {
        return showErrorDialogFragment(i2, activity, i3, null);
    }
}
