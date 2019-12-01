package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.d.c;
import com.bumptech.glide.e;
import com.bumptech.glide.f;
import com.bumptech.glide.integration.okhttp3.c.a;
import com.bumptech.glide.load.b.l;
import com.bumptech.glide.load.b.v;
import java.io.InputStream;

@Deprecated
public class OkHttpGlideModule implements c {
    public void a(Context context, e eVar, Registry registry) {
        registry.b(l.class, InputStream.class, (v<? extends Model, ? extends Data>) new a<Object,Object>());
    }

    public void a(Context context, f fVar) {
    }
}
