package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.widget.T;

/* compiled from: CascadingMenuPopup */
class h implements T {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ i f615a;

    h(i iVar) {
        this.f615a = iVar;
    }

    public void a(l lVar, MenuItem menuItem) {
        a aVar = null;
        this.f615a.f622h.removeCallbacksAndMessages(null);
        int size = this.f615a.f624j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (lVar == ((a) this.f615a.f624j.get(i2)).f628b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            int i3 = i2 + 1;
            if (i3 < this.f615a.f624j.size()) {
                aVar = (a) this.f615a.f624j.get(i3);
            }
            this.f615a.f622h.postAtTime(new g(this, aVar, menuItem, lVar), lVar, SystemClock.uptimeMillis() + 200);
        }
    }

    public void b(l lVar, MenuItem menuItem) {
        this.f615a.f622h.removeCallbacksAndMessages(lVar);
    }
}
