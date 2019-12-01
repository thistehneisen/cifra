package io.intercom.com.bumptech.glide.f;

import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.load.a;
import io.intercom.com.bumptech.glide.load.engine.GlideException;

/* compiled from: RequestListener */
public interface f<R> {
    boolean onLoadFailed(GlideException glideException, Object obj, h<R> hVar, boolean z);

    boolean onResourceReady(R r, Object obj, h<R> hVar, a aVar, boolean z);
}
