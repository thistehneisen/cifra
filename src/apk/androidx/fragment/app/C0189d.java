package androidx.fragment.app;

import android.app.Dialog;

/* renamed from: androidx.fragment.app.d reason: case insensitive filesystem */
/* compiled from: DialogFragment */
class C0189d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0190e f1521a;

    C0189d(C0190e eVar) {
        this.f1521a = eVar;
    }

    public void run() {
        C0190e eVar = this.f1521a;
        Dialog dialog = eVar.f1529h;
        if (dialog != null) {
            eVar.onDismiss(dialog);
        }
    }
}
