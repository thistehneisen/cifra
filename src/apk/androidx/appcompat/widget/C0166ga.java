package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* renamed from: androidx.appcompat.widget.ga reason: case insensitive filesystem */
/* compiled from: SearchView */
class C0166ga implements OnEditorActionListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f969a;

    C0166ga(SearchView searchView) {
        this.f969a = searchView;
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        this.f969a.g();
        return true;
    }
}
