package io.intercom.com.bumptech.glide.f.a;

import android.graphics.drawable.Drawable;
import io.intercom.com.bumptech.glide.c.j;
import io.intercom.com.bumptech.glide.f.b.d;
import io.intercom.com.bumptech.glide.f.c;

/* compiled from: Target */
public interface h<R> extends j {
    c getRequest();

    void getSize(g gVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, d<? super R> dVar);

    void removeCallback(g gVar);

    void setRequest(c cVar);
}
