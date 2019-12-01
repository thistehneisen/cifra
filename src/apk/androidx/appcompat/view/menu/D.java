package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.l.a;

/* compiled from: SubMenuBuilder */
public class D extends l implements SubMenu {
    private l B;
    private p C;

    public D(Context context, l lVar, p pVar) {
        super(context);
        this.B = lVar;
        this.C = pVar;
    }

    public void a(a aVar) {
        this.B.a(aVar);
    }

    public boolean b(p pVar) {
        return this.B.b(pVar);
    }

    public String d() {
        p pVar = this.C;
        int itemId = pVar != null ? pVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.d());
        sb.append(":");
        sb.append(itemId);
        return sb.toString();
    }

    public MenuItem getItem() {
        return this.C;
    }

    public l m() {
        return this.B.m();
    }

    public boolean o() {
        return this.B.o();
    }

    public boolean p() {
        return this.B.p();
    }

    public boolean q() {
        return this.B.q();
    }

    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(l lVar, MenuItem menuItem) {
        return super.a(lVar, menuItem) || this.B.a(lVar, menuItem);
    }

    public SubMenu setHeaderIcon(int i2) {
        super.d(i2);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        super.e(i2);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.C.setIcon(i2);
        return this;
    }

    public boolean a(p pVar) {
        return this.B.a(pVar);
    }
}
