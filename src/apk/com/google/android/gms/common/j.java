package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import androidx.fragment.app.C0190e;
import androidx.fragment.app.C0200o;
import com.google.android.gms.common.internal.q;

public class j extends C0190e {

    /* renamed from: l reason: collision with root package name */
    private Dialog f4777l = null;
    private OnCancelListener m = null;

    public Dialog a(Bundle bundle) {
        if (this.f4777l == null) {
            b(false);
        }
        return this.f4777l;
    }

    public void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = this.m;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static j a(Dialog dialog, OnCancelListener onCancelListener) {
        j jVar = new j();
        q.a(dialog, (Object) "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        jVar.f4777l = dialog2;
        if (onCancelListener != null) {
            jVar.m = onCancelListener;
        }
        return jVar;
    }

    public void a(C0200o oVar, String str) {
        super.a(oVar, str);
    }
}
