package androidx.appcompat.app;

import android.view.View;

/* renamed from: androidx.appcompat.app.f reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0139f implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f476a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f477b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ AlertController f478c;

    C0139f(AlertController alertController, View view, View view2) {
        this.f478c = alertController;
        this.f476a = view;
        this.f477b = view2;
    }

    public void run() {
        AlertController.a(this.f478c.A, this.f476a, this.f477b);
    }
}
