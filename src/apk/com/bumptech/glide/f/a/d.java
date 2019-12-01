package com.bumptech.glide.f.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.f.b.b;
import com.bumptech.glide.f.b.b.a;

/* compiled from: ImageViewTarget */
public abstract class d<Z> extends i<ImageView, Z> implements a {

    /* renamed from: i reason: collision with root package name */
    private Animatable f3443i;

    public d(ImageView imageView) {
        super(imageView);
    }

    private void b(Z z) {
        if (z instanceof Animatable) {
            this.f3443i = (Animatable) z;
            this.f3443i.start();
            return;
        }
        this.f3443i = null;
    }

    private void c(Z z) {
        a(z);
        b(z);
    }

    public void a(Drawable drawable) {
        ((ImageView) this.f3448d).setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Z z);

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f3443i;
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

    public void onStart() {
        Animatable animatable = this.f3443i;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f3443i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void a(Z z, b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            c(z);
        } else {
            b(z);
        }
    }
}
