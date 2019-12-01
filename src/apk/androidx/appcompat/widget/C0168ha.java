package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: androidx.appcompat.widget.ha reason: case insensitive filesystem */
/* compiled from: SearchView */
class C0168ha implements OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f972a;

    C0168ha(SearchView searchView) {
        this.f972a = searchView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f972a.a(i2, 0, (String) null);
    }
}
