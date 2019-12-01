package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* renamed from: androidx.appcompat.app.g reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0140g implements OnScrollListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f479a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f480b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ AlertController f481c;

    C0140g(AlertController alertController, View view, View view2) {
        this.f481c = alertController;
        this.f479a = view;
        this.f480b = view2;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AlertController.a(absListView, this.f479a, this.f480b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
