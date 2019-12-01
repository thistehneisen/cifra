package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;

/* renamed from: com.google.android.gms.common.internal.e reason: case insensitive filesystem */
public abstract class C0310e implements OnClickListener {
    public static C0310e a(Activity activity, Intent intent, int i2) {
        return new v(intent, activity, i2);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            a();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }

    public static C0310e a(Fragment fragment, Intent intent, int i2) {
        return new w(intent, fragment, i2);
    }
}
