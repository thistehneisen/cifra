package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: SearchView */
class ia implements OnItemSelectedListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f976a;

    ia(SearchView searchView) {
        this.f976a = searchView;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f976a.d(i2);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
