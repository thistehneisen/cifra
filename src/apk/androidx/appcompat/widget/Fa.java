package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class Fa extends Resources {

    /* renamed from: a reason: collision with root package name */
    private static boolean f783a = false;

    /* renamed from: b reason: collision with root package name */
    private final WeakReference<Context> f784b;

    public Fa(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f784b = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: 0000 */
    public final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    public Drawable getDrawable(int i2) throws NotFoundException {
        Context context = (Context) this.f784b.get();
        if (context != null) {
            return C0175o.a().a(context, this, i2);
        }
        return super.getDrawable(i2);
    }

    public static void a(boolean z) {
        f783a = z;
    }

    public static boolean a() {
        return f783a;
    }
}
