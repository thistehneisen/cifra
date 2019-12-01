package b.a.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.ViewConfiguration;
import b.a.b;
import b.a.d;
import b.a.j;

/* compiled from: ActionBarPolicy */
public class a {

    /* renamed from: a reason: collision with root package name */
    private Context f2185a;

    private a(Context context) {
        this.f2185a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int b() {
        return this.f2185a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f2185a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            return 5;
        }
        if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            return 4;
        }
        return i2 >= 360 ? 3 : 2;
    }

    public int d() {
        return this.f2185a.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f2185a.obtainStyledAttributes(null, j.ActionBar, b.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = this.f2185a.getResources();
        if (!f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.f2185a.getResources().getBoolean(b.abc_action_bar_embed_tabs);
    }

    public boolean g() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f2185a).hasPermanentMenuKey();
    }

    public boolean a() {
        return this.f2185a.getApplicationInfo().targetSdkVersion < 14;
    }
}
