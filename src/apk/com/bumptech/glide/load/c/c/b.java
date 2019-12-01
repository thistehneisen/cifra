package com.bumptech.glide.load.c.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.c.e.c;
import com.bumptech.glide.load.engine.B;
import com.bumptech.glide.load.engine.G;

/* compiled from: DrawableResource */
public abstract class b<T extends Drawable> implements G<T>, B {

    /* renamed from: a reason: collision with root package name */
    protected final T f3790a;

    public b(T t) {
        l.a(t);
        this.f3790a = (Drawable) t;
    }

    public void d() {
        T t = this.f3790a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof c) {
            ((c) t).c().prepareToDraw();
        }
    }

    public final T get() {
        ConstantState constantState = this.f3790a.getConstantState();
        if (constantState == null) {
            return this.f3790a;
        }
        return constantState.newDrawable();
    }
}
