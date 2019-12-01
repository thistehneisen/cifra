package com.bumptech.glide;

import com.bumptech.glide.e.a;
import com.bumptech.glide.e.b;
import com.bumptech.glide.e.c;
import com.bumptech.glide.e.d;
import com.bumptech.glide.e.e;
import com.bumptech.glide.e.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.g;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.w;
import com.bumptech.glide.load.engine.D;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: a reason: collision with root package name */
    private final w f3264a = new w(this.f3273j);

    /* renamed from: b reason: collision with root package name */
    private final a f3265b = new a();

    /* renamed from: c reason: collision with root package name */
    private final e f3266c = new e();

    /* renamed from: d reason: collision with root package name */
    private final f f3267d = new f();

    /* renamed from: e reason: collision with root package name */
    private final g f3268e = new g();

    /* renamed from: f reason: collision with root package name */
    private final com.bumptech.glide.load.c.f.f f3269f = new com.bumptech.glide.load.c.f.f();

    /* renamed from: g reason: collision with root package name */
    private final b f3270g = new b();

    /* renamed from: h reason: collision with root package name */
    private final d f3271h = new d();

    /* renamed from: i reason: collision with root package name */
    private final c f3272i = new c();

    /* renamed from: j reason: collision with root package name */
    private final b.g.h.d<List<Throwable>> f3273j = com.bumptech.glide.h.a.d.a();

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(obj);
            super(sb.toString());
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(cls);
            sb.append(" and data: ");
            sb.append(cls2);
            super(sb.toString());
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find result encoder for resource class: ");
            sb.append(cls);
            sb.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            super(sb.toString());
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find source encoder for data class: ");
            sb.append(cls);
            super(sb.toString());
        }
    }

    public Registry() {
        a(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    private <Data, TResource, Transcode> List<m<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f3266c.b(cls, cls2)) {
            for (Class cls5 : this.f3269f.b(cls4, cls3)) {
                m mVar = new m(cls, cls4, cls5, this.f3266c.a(cls, cls4), this.f3269f.a(cls4, cls5), this.f3273j);
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        this.f3265b.a(cls, dVar);
        return this;
    }

    public <Model, Data> Registry b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        this.f3264a.b(cls, cls2, vVar);
        return this;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        a("legacy_append", cls, cls2, jVar);
        return this;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f3271h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class b2 : this.f3264a.a(cls)) {
                for (Class cls4 : this.f3266c.b(b2, cls2)) {
                    if (!this.f3269f.b(cls4, cls3).isEmpty() && !a2.contains(cls4)) {
                        a2.add(cls4);
                    }
                }
            }
            this.f3271h.a(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, j<Data, TResource> jVar) {
        this.f3266c.a(str, jVar, cls, cls2);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f3266c.a((List<String>) arrayList);
        return this;
    }

    public <TResource> Registry a(Class<TResource> cls, k<TResource> kVar) {
        this.f3267d.a(cls, kVar);
        return this;
    }

    public Registry a(com.bumptech.glide.load.a.e.a<?> aVar) {
        this.f3268e.a(aVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.c.f.e<TResource, Transcode> eVar) {
        this.f3269f.a(cls, cls2, eVar);
        return this;
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.f3270g.a(imageHeaderParser);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, v<Model, Data> vVar) {
        this.f3264a.a(cls, cls2, vVar);
        return this;
    }

    public <Data, TResource, Transcode> D<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        D<Data, TResource, Transcode> a2 = this.f3272i.a(cls, cls2, cls3);
        if (this.f3272i.a(a2)) {
            return null;
        }
        if (a2 == null) {
            List c2 = c(cls, cls2, cls3);
            if (c2.isEmpty()) {
                a2 = null;
            } else {
                a2 = new D<>(cls, cls2, cls3, c2, this.f3273j);
            }
            this.f3272i.a(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public <X> com.bumptech.glide.load.d<X> c(X x) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.d<X> a2 = this.f3265b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean b(G<?> g2) {
        return this.f3267d.a(g2.c()) != null;
    }

    public <X> com.bumptech.glide.load.a.e<X> b(X x) {
        return this.f3268e.a(x);
    }

    public <X> k<X> a(G<X> g2) throws NoResultEncoderAvailableException {
        k<X> a2 = this.f3267d.a(g2.c());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(g2.c());
    }

    public <Model> List<u<Model, ?>> a(Model model) {
        List<u<Model, ?>> a2 = this.f3264a.a(model);
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.f3270g.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new NoImageHeaderParserException();
    }
}
