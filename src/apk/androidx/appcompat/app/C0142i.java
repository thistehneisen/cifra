package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController.RecycleListView;
import androidx.appcompat.app.AlertController.a;

/* renamed from: androidx.appcompat.app.i reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0142i extends ArrayAdapter<CharSequence> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecycleListView f485a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f486b;

    C0142i(a aVar, Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
        this.f486b = aVar;
        this.f485a = recycleListView;
        super(context, i2, i3, charSequenceArr);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i2, view, viewGroup);
        boolean[] zArr = this.f486b.F;
        if (zArr != null && zArr[i2]) {
            this.f485a.setItemChecked(i2, true);
        }
        return view2;
    }
}
