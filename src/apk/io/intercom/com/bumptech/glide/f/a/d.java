package io.intercom.com.bumptech.glide.f.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import io.intercom.com.bumptech.glide.f.b.d.a;

/* compiled from: ImageViewTarget */
public abstract class d<Z> extends i<ImageView, Z> implements a {

    /* renamed from: h reason: collision with root package name */
    private Animatable f9301h;

    public d(ImageView imageView) {
        super(imageView);
    }

    private void b(Z z) {
        if (z instanceof Animatable) {
            this.f9301h = (Animatable) z;
            this.f9301h.start();
            return;
        }
        this.f9301h = null;
    }

    private void c(Z z) {
        a(z);
        b(z);
    }

    public Drawable a() {
        return ((ImageView) this.f9304c).getDrawable();
    }

    /* access modifiers changed from: protected */
    public abstract void a(Z z);

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f9301h;
        if (animatable != null) {
            animatable.stop();
        }
        c(null);
        a(drawable);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        c(null);
        a(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        c(null);
        a(drawable);
    }

    public void onResourceReady(Z z, io.intercom.com.bumptech.glide.f.b.d<? super Z> dVar) {
        if (dVar == null || !dVar.a(z, this)) {
            c(z);
        } else {
            b(z);
        }
    }

    public void onStart() {
        Animatable animatable = this.f9301h;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f9301h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void a(Drawable drawable) {
        ((ImageView) this.f9304c).setImageDrawable(drawable);
    }
}
