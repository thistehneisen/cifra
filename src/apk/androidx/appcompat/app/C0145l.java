package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.appcompat.app.AlertController.a;

/* renamed from: androidx.appcompat.app.l reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0145l implements OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecycleListView f494a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ AlertController f495b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ a f496c;

    C0145l(a aVar, RecycleListView recycleListView, AlertController alertController) {
        this.f496c = aVar;
        this.f494a = recycleListView;
        this.f495b = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean[] zArr = this.f496c.F;
        if (zArr != null) {
            zArr[i2] = this.f494a.isItemChecked(i2);
        }
        this.f496c.J.onClick(this.f495b.f382b, i2, this.f494a.isItemChecked(i2));
    }
}
