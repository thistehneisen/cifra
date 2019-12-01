package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar.c;

/* compiled from: ToolbarActionBar */
class G implements c {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ H f424a;

    G(H h2) {
        this.f424a = h2;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f424a.f427c.onMenuItemSelected(0, menuItem);
    }
}
