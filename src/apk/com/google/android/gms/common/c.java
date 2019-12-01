package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.q;

public class c extends DialogFragment {

    /* renamed from: a reason: collision with root package name */
    private Dialog f4649a = null;

    /* renamed from: b reason: collision with root package name */
    private OnCancelListener f4650b = null;

    public static c a(Dialog dialog, OnCancelListener onCancelListener) {
        c cVar = new c();
        q.a(dialog, (Object) "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        cVar.f4649a = dialog2;
        if (onCancelListener != null) {
            cVar.f4650b = onCancelListener;
        }
        return cVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = this.f4650b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f4649a == null) {
            setShowsDialog(false);
        }
        return this.f4649a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
