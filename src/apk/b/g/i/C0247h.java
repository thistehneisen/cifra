package b.g.i;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import b.g.d.a.b;

/* renamed from: b.g.i.h reason: case insensitive filesystem */
/* compiled from: MenuItemCompat */
public final class C0247h {
    public static MenuItem a(MenuItem menuItem, C0241b bVar) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof b) {
            ((b) menuItem).setTooltipText(charSequence);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof b) {
            ((b) menuItem).setContentDescription(charSequence);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof b) {
            ((b) menuItem).setNumericShortcut(c2, i2);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, i2);
        }
    }

    public static void a(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof b) {
            ((b) menuItem).setAlphabeticShortcut(c2, i2);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, i2);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof b) {
            ((b) menuItem).setIconTintList(colorStateList);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof b) {
            ((b) menuItem).setIconTintMode(mode);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
