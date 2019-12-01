package io.intercom.com.bumptech.glide.load.c.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.c.e.c;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.z;

/* compiled from: DrawableResource */
public abstract class b<T extends Drawable> implements E<T>, z {

    /* renamed from: a reason: collision with root package name */
    protected final T f9654a;

    public b(T t) {
        h.a(t);
        this.f9654a = (Drawable) t;
    }

    public void d() {
        T t = this.f9654a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof c) {
            ((c) t).c().prepareToDraw();
        }
    }

    public final T get() {
        ConstantState constantState = this.f9654a.getConstantState();
        if (constantState == null) {
            return this.f9654a;
        }
        return constantState.newDrawable();
    }
}
