package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.File;

/* compiled from: BitmapDrawableEncoder */
public class b implements k<BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    private final e f3718a;

    /* renamed from: b reason: collision with root package name */
    private final k<Bitmap> f3719b;

    public b(e eVar, k<Bitmap> kVar) {
        this.f3718a = eVar;
        this.f3719b = kVar;
    }

    public boolean a(G<BitmapDrawable> g2, File file, i iVar) {
        return this.f3719b.a(new d(((BitmapDrawable) g2.get()).getBitmap(), this.f3718a), file, iVar);
    }

    public c a(i iVar) {
        return this.f3719b.a(iVar);
    }
}
