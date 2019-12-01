package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b.g.d.a.a;

/* compiled from: MenuWrapperICS */
class y extends C0150c<a> implements Menu {
    y(Context context, a aVar) {
        super(context, aVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(((a) this.f608a).add(charSequence));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((a) this.f608a).addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr2[i6] = a(menuItemArr3[i6]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a) this.f608a).addSubMenu(charSequence));
    }

    public void clear() {
        b();
        ((a) this.f608a).clear();
    }

    public void close() {
        ((a) this.f608a).close();
    }

    public MenuItem findItem(int i2) {
        return a(((a) this.f608a).findItem(i2));
    }

    public MenuItem getItem(int i2) {
        return a(((a) this.f608a).getItem(i2));
    }

    public boolean hasVisibleItems() {
        return ((a) this.f608a).hasVisibleItems();
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return ((a) this.f608a).isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return ((a) this.f608a).performIdentifierAction(i2, i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return ((a) this.f608a).performShortcut(i2, keyEvent, i3);
    }

    public void removeGroup(int i2) {
        a(i2);
        ((a) this.f608a).removeGroup(i2);
    }

    public void removeItem(int i2) {
        b(i2);
        ((a) this.f608a).removeItem(i2);
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        ((a) this.f608a).setGroupCheckable(i2, z, z2);
    }

    public void setGroupEnabled(int i2, boolean z) {
        ((a) this.f608a).setGroupEnabled(i2, z);
    }

    public void setGroupVisible(int i2, boolean z) {
        ((a) this.f608a).setGroupVisible(i2, z);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.f608a).setQwertyMode(z);
    }

    public int size() {
        return ((a) this.f608a).size();
    }

    public MenuItem add(int i2) {
        return a(((a) this.f608a).add(i2));
    }

    public SubMenu addSubMenu(int i2) {
        return a(((a) this.f608a).addSubMenu(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(((a) this.f608a).add(i2, i3, i4, charSequence));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return a(((a) this.f608a).addSubMenu(i2, i3, i4, charSequence));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(((a) this.f608a).add(i2, i3, i4, i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return a(((a) this.f608a).addSubMenu(i2, i3, i4, i5));
    }
}
