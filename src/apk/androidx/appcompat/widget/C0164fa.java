package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* renamed from: androidx.appcompat.widget.fa reason: case insensitive filesystem */
/* compiled from: SearchView */
class C0164fa implements OnKeyListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f960a;

    C0164fa(SearchView searchView) {
        this.f960a = searchView;
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        SearchView searchView = this.f960a;
        if (searchView.ga == null) {
            return false;
        }
        if (searchView.q.isPopupShowing() && this.f960a.q.getListSelection() != -1) {
            return this.f960a.a(view, i2, keyEvent);
        }
        if (this.f960a.q.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView searchView2 = this.f960a;
        searchView2.a(0, (String) null, searchView2.q.getText().toString());
        return true;
    }
}
