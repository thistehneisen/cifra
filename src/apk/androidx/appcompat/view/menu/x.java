package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b.g.d.a.a;
import b.g.d.a.b;
import b.g.d.a.c;

/* compiled from: MenuWrapperFactory */
public final class x {
    public static Menu a(Context context, a aVar) {
        return new y(context, aVar);
    }

    public static MenuItem a(Context context, b bVar) {
        if (VERSION.SDK_INT >= 16) {
            return new r(context, bVar);
        }
        return new q(context, bVar);
    }

    public static SubMenu a(Context context, c cVar) {
        return new E(context, cVar);
    }
}
