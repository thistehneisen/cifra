package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b.g.d.a.b;
import b.g.d.a.c;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.appcompat.view.menu.c reason: case insensitive filesystem */
/* compiled from: BaseMenuWrapper */
abstract class C0150c<T> extends C0151d<T> {

    /* renamed from: b reason: collision with root package name */
    final Context f605b;

    /* renamed from: c reason: collision with root package name */
    private Map<b, MenuItem> f606c;

    /* renamed from: d reason: collision with root package name */
    private Map<c, SubMenu> f607d;

    C0150c(Context context, T t) {
        super(t);
        this.f605b = context;
    }

    /* access modifiers changed from: 0000 */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f606c == null) {
            this.f606c = new b.d.b();
        }
        MenuItem menuItem2 = (MenuItem) this.f606c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a2 = x.a(this.f605b, bVar);
        this.f606c.put(bVar, a2);
        return a2;
    }

    /* access modifiers changed from: 0000 */
    public final void b() {
        Map<b, MenuItem> map = this.f606c;
        if (map != null) {
            map.clear();
        }
        Map<c, SubMenu> map2 = this.f607d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(int i2) {
        Map<b, MenuItem> map = this.f606c;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (i2 == ((MenuItem) it.next()).getItemId()) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.f607d == null) {
            this.f607d = new b.d.b();
        }
        SubMenu subMenu2 = (SubMenu) this.f607d.get(cVar);
        if (subMenu2 == null) {
            subMenu2 = x.a(this.f605b, cVar);
            this.f607d.put(cVar, subMenu2);
        }
        return subMenu2;
    }

    /* access modifiers changed from: 0000 */
    public final void a(int i2) {
        Map<b, MenuItem> map = this.f606c;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i2 == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }
}
