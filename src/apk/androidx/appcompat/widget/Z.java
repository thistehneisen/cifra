package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SearchView */
class Z implements TextWatcher {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ SearchView f937a;

    Z(SearchView searchView) {
        this.f937a = searchView;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f937a.b(charSequence);
    }
}
