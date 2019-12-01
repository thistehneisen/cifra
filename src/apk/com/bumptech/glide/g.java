package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.f.a.e;
import com.bumptech.glide.f.a.i;
import com.bumptech.glide.f.f;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.engine.u;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: GlideContext */
public class g extends ContextWrapper {

    /* renamed from: a reason: collision with root package name */
    static final o<?, ?> f3487a = new d();

    /* renamed from: b reason: collision with root package name */
    private final b f3488b;

    /* renamed from: c reason: collision with root package name */
    private final Registry f3489c;

    /* renamed from: d reason: collision with root package name */
    private final e f3490d;

    /* renamed from: e reason: collision with root package name */
    private final f f3491e;

    /* renamed from: f reason: collision with root package name */
    private final List<com.bumptech.glide.f.e<Object>> f3492f;

    /* renamed from: g reason: collision with root package name */
    private final Map<Class<?>, o<?, ?>> f3493g;

    /* renamed from: h reason: collision with root package name */
    private final u f3494h;

    /* renamed from: i reason: collision with root package name */
    private final boolean f3495i;

    /* renamed from: j reason: collision with root package name */
    private final int f3496j;

    public g(Context context, b bVar, Registry registry, e eVar, f fVar, Map<Class<?>, o<?, ?>> map, List<com.bumptech.glide.f.e<Object>> list, u uVar, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f3488b = bVar;
        this.f3489c = registry;
        this.f3490d = eVar;
        this.f3491e = fVar;
        this.f3492f = list;
        this.f3493g = map;
        this.f3494h = uVar;
        this.f3495i = z;
        this.f3496j = i2;
    }

    public <T> o<?, T> a(Class<T> cls) {
        o<?, T> oVar = (o) this.f3493g.get(cls);
        if (oVar == null) {
            for (Entry entry : this.f3493g.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    oVar = (o) entry.getValue();
                }
            }
        }
        return oVar == null ? f3487a : oVar;
    }

    public List<com.bumptech.glide.f.e<Object>> b() {
        return this.f3492f;
    }

    public f c() {
        return this.f3491e;
    }

    public u d() {
        return this.f3494h;
    }

    public int e() {
        return this.f3496j;
    }

    public Registry f() {
        return this.f3489c;
    }

    public boolean g() {
        return this.f3495i;
    }

    public <X> i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f3490d.a(imageView, cls);
    }

    public b a() {
        return this.f3488b;
    }
}
