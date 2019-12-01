package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.d.d;
import com.bumptech.glide.e;
import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.v;
import java.io.InputStream;

/* compiled from: OkHttpLibraryGlideModule */
public final class a extends d {
    public void a(Context context, e eVar, Registry registry) {
        registry.b(l.class, InputStream.class, (v<? extends Model, ? extends Data>) new com.bumptech.glide.integration.okhttp3.c.a<Object,Object>());
    }
}
