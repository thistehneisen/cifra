package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.a;
import com.touchin.vtb.GlideModule;
import java.util.Collections;
import java.util.Set;

/* compiled from: GeneratedAppGlideModuleImpl */
final class b extends a {

    /* renamed from: a reason: collision with root package name */
    private final GlideModule f3312a = new GlideModule();

    b() {
        String str = "Glide";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Discovered AppGlideModule from annotation: com.touchin.vtb.GlideModule");
            Log.d(str, "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    public void a(Context context, f fVar) {
        this.f3312a.a(context, fVar);
    }

    public Set<Class<?>> b() {
        return Collections.emptySet();
    }

    public void a(Context context, e eVar, Registry registry) {
        new a().a(context, eVar, registry);
        this.f3312a.a(context, eVar, registry);
    }

    /* access modifiers changed from: 0000 */
    public c c() {
        return new c();
    }

    public boolean a() {
        return this.f3312a.a();
    }
}
