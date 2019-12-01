package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class pa extends ContextWrapper {

    /* renamed from: a reason: collision with root package name */
    private static final Object f1026a = new Object();

    /* renamed from: b reason: collision with root package name */
    private static ArrayList<WeakReference<pa>> f1027b;

    /* renamed from: c reason: collision with root package name */
    private final Resources f1028c;

    /* renamed from: d reason: collision with root package name */
    private final Theme f1029d;

    private pa(Context context) {
        super(context);
        if (Fa.b()) {
            this.f1028c = new Fa(this, context.getResources());
            this.f1029d = this.f1028c.newTheme();
            this.f1029d.setTo(context.getTheme());
            return;
        }
        this.f1028c = new ra(this, context.getResources());
        this.f1029d = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f1026a) {
            if (f1027b == null) {
                f1027b = new ArrayList<>();
            } else {
                for (int size = f1027b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = (WeakReference) f1027b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1027b.remove(size);
                    }
                }
                for (int size2 = f1027b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = (WeakReference) f1027b.get(size2);
                    pa paVar = weakReference2 != null ? (pa) weakReference2.get() : null;
                    if (paVar != null && paVar.getBaseContext() == context) {
                        return paVar;
                    }
                }
            }
            pa paVar2 = new pa(context);
            f1027b.add(new WeakReference(paVar2));
            return paVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof pa) || (context.getResources() instanceof ra) || (context.getResources() instanceof Fa)) {
            return false;
        }
        if (VERSION.SDK_INT < 21 || Fa.b()) {
            return true;
        }
        return false;
    }

    public AssetManager getAssets() {
        return this.f1028c.getAssets();
    }

    public Resources getResources() {
        return this.f1028c;
    }

    public Theme getTheme() {
        Theme theme = this.f1029d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i2) {
        Theme theme = this.f1029d;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
