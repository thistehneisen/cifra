package androidx.appcompat.app;

import android.view.View;

/* renamed from: androidx.appcompat.app.h reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0141h implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f482a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f483b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ AlertController f484c;

    C0141h(AlertController alertController, View view, View view2) {
        this.f484c = alertController;
        this.f482a = view;
        this.f483b = view2;
    }

    public void run() {
        AlertController.a(this.f484c.f387g, this.f482a, this.f483b);
    }
}
