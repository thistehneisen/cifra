package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ListPopupWindow */
class Q implements OnItemSelectedListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ S f853a;

    Q(S s) {
        this.f853a = s;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (i2 != -1) {
            L l2 = this.f853a.f859f;
            if (l2 != null) {
                l2.setListSelectionHidden(false);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
