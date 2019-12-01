package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources */
class ra extends V {

    /* renamed from: b reason: collision with root package name */
    private final WeakReference<Context> f1036b;

    public ra(Context context, Resources resources) {
        super(resources);
        this.f1036b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i2) throws NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = (Context) this.f1036b.get();
        if (!(drawable == null || context == null)) {
            C0175o.a();
            C0175o.a(context, i2, drawable);
        }
        return drawable;
    }
}
