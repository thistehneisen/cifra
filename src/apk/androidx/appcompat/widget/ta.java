package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView.e;
import androidx.appcompat.widget.Toolbar.c;

/* compiled from: Toolbar */
class ta implements e {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Toolbar f1047a;

    ta(Toolbar toolbar) {
        this.f1047a = toolbar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        c cVar = this.f1047a.mOnMenuItemClickListener;
        if (cVar != null) {
            return cVar.onMenuItemClick(menuItem);
        }
        return false;
    }
}
