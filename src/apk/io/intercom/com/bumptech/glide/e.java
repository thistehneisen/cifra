package io.intercom.com.bumptech.glide;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import io.intercom.com.bumptech.glide.f.a.i;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.engine.s;
import java.util.Map;
import java.util.Map.Entry;

@TargetApi(14)
/* compiled from: GlideContext */
public class e extends ContextWrapper {

    /* renamed from: a reason: collision with root package name */
    static final o<?, ?> f9269a = new b();

    /* renamed from: b reason: collision with root package name */
    private final Handler f9270b = new Handler(Looper.getMainLooper());

    /* renamed from: c reason: collision with root package name */
    private final b f9271c;

    /* renamed from: d reason: collision with root package name */
    private final Registry f9272d;

    /* renamed from: e reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.f.a.e f9273e;

    /* renamed from: f reason: collision with root package name */
    private final g f9274f;

    /* renamed from: g reason: collision with root package name */
    private final Map<Class<?>, o<?, ?>> f9275g;

    /* renamed from: h reason: collision with root package name */
    private final s f9276h;

    /* renamed from: i reason: collision with root package name */
    private final int f9277i;

    public e(Context context, b bVar, Registry registry, io.intercom.com.bumptech.glide.f.a.e eVar, g gVar, Map<Class<?>, o<?, ?>> map, s sVar, int i2) {
        super(context.getApplicationContext());
        this.f9271c = bVar;
        this.f9272d = registry;
        this.f9273e = eVar;
        this.f9274f = gVar;
        this.f9275g = map;
        this.f9276h = sVar;
        this.f9277i = i2;
    }

    public <T> o<?, T> a(Class<T> cls) {
        o<?, T> oVar = (o) this.f9275g.get(cls);
        if (oVar == null) {
            for (Entry entry : this.f9275g.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    oVar = (o) entry.getValue();
                }
            }
        }
        return oVar == null ? f9269a : oVar;
    }

    public g b() {
        return this.f9274f;
    }

    public s c() {
        return this.f9276h;
    }

    public int d() {
        return this.f9277i;
    }

    public Handler e() {
        return this.f9270b;
    }

    public Registry f() {
        return this.f9272d;
    }

    public <X> i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f9273e.a(imageView, cls);
    }

    public b a() {
        return this.f9271c;
    }
}
