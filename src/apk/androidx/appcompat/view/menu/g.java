package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* compiled from: CascadingMenuPopup */
class g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f611a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ MenuItem f612b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ l f613c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ h f614d;

    g(h hVar, a aVar, MenuItem menuItem, l lVar) {
        this.f614d = hVar;
        this.f611a = aVar;
        this.f612b = menuItem;
        this.f613c = lVar;
    }

    public void run() {
        a aVar = this.f611a;
        if (aVar != null) {
            this.f614d.f615a.B = true;
            aVar.f628b.a(false);
            this.f614d.f615a.B = false;
        }
        if (this.f612b.isEnabled() && this.f612b.hasSubMenu()) {
            this.f613c.a(this.f612b, 4);
        }
    }
}
