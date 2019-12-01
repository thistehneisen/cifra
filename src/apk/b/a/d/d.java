package b.a.d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import b.a.i;

/* compiled from: ContextThemeWrapper */
public class d extends ContextWrapper {

    /* renamed from: a reason: collision with root package name */
    private int f2188a;

    /* renamed from: b reason: collision with root package name */
    private Theme f2189b;

    /* renamed from: c reason: collision with root package name */
    private LayoutInflater f2190c;

    /* renamed from: d reason: collision with root package name */
    private Configuration f2191d;

    /* renamed from: e reason: collision with root package name */
    private Resources f2192e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f2192e == null) {
            Configuration configuration = this.f2191d;
            if (configuration == null) {
                this.f2192e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.f2192e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f2192e;
    }

    private void c() {
        boolean z = this.f2189b == null;
        if (z) {
            this.f2189b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2189b.setTo(theme);
            }
        }
        a(this.f2189b, this.f2188a, z);
    }

    public int a() {
        return this.f2188a;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2190c == null) {
            this.f2190c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2190c;
    }

    public Theme getTheme() {
        Theme theme = this.f2189b;
        if (theme != null) {
            return theme;
        }
        if (this.f2188a == 0) {
            this.f2188a = i.Theme_AppCompat_Light;
        }
        c();
        return this.f2189b;
    }

    public void setTheme(int i2) {
        if (this.f2188a != i2) {
            this.f2188a = i2;
            c();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.f2188a = i2;
    }

    /* access modifiers changed from: protected */
    public void a(Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }

    public d(Context context, Theme theme) {
        super(context);
        this.f2189b = theme;
    }
}
