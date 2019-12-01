package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.g.d.a.c;

/* compiled from: SubMenuWrapperICS */
class E extends y implements SubMenu {
    E(Context context, c cVar) {
        super(context, cVar);
    }

    public c c() {
        return (c) this.f608a;
    }

    public void clearHeader() {
        c().clearHeader();
    }

    public MenuItem getItem() {
        return a(c().getItem());
    }

    public SubMenu setHeaderIcon(int i2) {
        c().setHeaderIcon(i2);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        c().setHeaderTitle(i2);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        c().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i2) {
        c().setIcon(i2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        c().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        c().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        c().setIcon(drawable);
        return this;
    }
}
