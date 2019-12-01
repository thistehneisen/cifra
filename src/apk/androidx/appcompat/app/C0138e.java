package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.b;

/* renamed from: androidx.appcompat.app.e reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0138e implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f473a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f474b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ AlertController f475c;

    C0138e(AlertController alertController, View view, View view2) {
        this.f475c = alertController;
        this.f473a = view;
        this.f474b = view2;
    }

    public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        AlertController.a(nestedScrollView, this.f473a, this.f474b);
    }
}
