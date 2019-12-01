package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AlertController.a;

/* renamed from: androidx.appcompat.app.k reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0144k implements OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ AlertController f492a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f493b;

    C0144k(a aVar, AlertController alertController) {
        this.f493b = aVar;
        this.f492a = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f493b.x.onClick(this.f492a.f382b, i2);
        if (!this.f493b.H) {
            this.f492a.f382b.dismiss();
        }
    }
}
