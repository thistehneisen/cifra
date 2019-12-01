package io.intercom.com.bumptech.glide.f.b;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import io.intercom.com.bumptech.glide.f.b.d.a;

/* compiled from: DrawableCrossFadeTransition */
public class b implements d<Drawable> {

    /* renamed from: a reason: collision with root package name */
    private final int f9320a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f9321b;

    public b(int i2, boolean z) {
        this.f9320a = i2;
        this.f9321b = z;
    }

    public boolean a(Drawable drawable, a aVar) {
        Drawable a2 = aVar.a();
        if (a2 == null) {
            a2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{a2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f9321b);
        transitionDrawable.startTransition(this.f9320a);
        aVar.a(transitionDrawable);
        return true;
    }
}
