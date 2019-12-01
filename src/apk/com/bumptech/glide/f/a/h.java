package com.bumptech.glide.f.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.j;
import com.bumptech.glide.f.b.b;
import com.bumptech.glide.f.c;

/* compiled from: Target */
public interface h<R> extends j {
    void a(g gVar);

    void a(c cVar);

    void a(R r, b<? super R> bVar);

    void b(g gVar);

    c getRequest();

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);
}
