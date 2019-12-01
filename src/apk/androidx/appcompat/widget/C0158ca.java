package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* renamed from: androidx.appcompat.widget.ca reason: case insensitive filesystem */
/* compiled from: SearchView */
class C0158ca implements OnFocusChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f954a;

    C0158ca(SearchView searchView) {
        this.f954a = searchView;
    }

    public void onFocusChange(View view, boolean z) {
        SearchView searchView = this.f954a;
        OnFocusChangeListener onFocusChangeListener = searchView.N;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
