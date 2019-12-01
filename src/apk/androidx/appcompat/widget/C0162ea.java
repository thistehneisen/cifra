package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: androidx.appcompat.widget.ea reason: case insensitive filesystem */
/* compiled from: SearchView */
class C0162ea implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f958a;

    C0162ea(SearchView searchView) {
        this.f958a = searchView;
    }

    public void onClick(View view) {
        SearchView searchView = this.f958a;
        if (view == searchView.u) {
            searchView.f();
        } else if (view == searchView.w) {
            searchView.e();
        } else if (view == searchView.v) {
            searchView.g();
        } else if (view == searchView.x) {
            searchView.i();
        } else if (view == searchView.q) {
            searchView.c();
        }
    }
}
