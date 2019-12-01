package com.touchin.vtb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.o;
import com.bumptech.glide.f.a;
import com.bumptech.glide.f.f;
import com.bumptech.glide.n;

/* compiled from: GlideRequests */
public class e extends n {
    public e(com.bumptech.glide.e eVar, i iVar, o oVar, Context context) {
        super(eVar, iVar, oVar, context);
    }

    public d<Drawable> b() {
        return (d) super.b();
    }

    public <ResourceType> d<ResourceType> a(Class<ResourceType> cls) {
        return new d<>(this.f4141d, this, cls, this.f4142e);
    }

    public d<Bitmap> a() {
        return (d) super.a();
    }

    public d<Drawable> a(String str) {
        return (d) super.a(str);
    }

    /* access modifiers changed from: protected */
    public void a(f fVar) {
        if (fVar instanceof c) {
            super.a(fVar);
        } else {
            super.a((f) new c().a((a) fVar));
        }
    }
}
