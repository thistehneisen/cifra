package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: Toolbar */
class va implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Toolbar f1054a;

    va(Toolbar toolbar) {
        this.f1054a = toolbar;
    }

    public void onClick(View view) {
        this.f1054a.collapseActionView();
    }
}
