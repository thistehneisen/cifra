package io.intercom.com.bumptech.glide;

import io.intercom.com.bumptech.glide.e.a;
import io.intercom.com.bumptech.glide.e.b;
import io.intercom.com.bumptech.glide.e.c;
import io.intercom.com.bumptech.glide.e.d;
import io.intercom.com.bumptech.glide.e.e;
import io.intercom.com.bumptech.glide.e.f;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.v;
import io.intercom.com.bumptech.glide.load.b.w;
import io.intercom.com.bumptech.glide.load.engine.B;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.k;
import io.intercom.com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: a reason: collision with root package name */
    private final w f9122a = new w(this.f9131j);

    /* renamed from: b reason: collision with root package name */
    private final a f9123b = new a();

    /* renamed from: c reason: collision with root package name */
    private final e f9124c = new e();

    /* renamed from: d reason: collision with root package name */
    private final f f9125d = new f();

    /* renamed from: e reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.a.e f9126e = new io.intercom.com.bumptech.glide.load.a.e();

    /* renamed from: f reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.c.f.e f9127f = new io.intercom.com.bumptech.glide.load.c.f.e();

    /* renamed from: g reason: collision with root package name */
    private final b f9128g = new b();

    /* renamed from: h reason: collision with root package name */
    private final d f9129h = new d();

    /* renamed from: i reason: collision with root package name */
    private final c f9130i = new c();

    /* renamed from: j reason: collision with root package name */
    private final b.g.h.d<List<Throwable>> f9131j = io.intercom.com.bumptech.glide.h.a.d.a();

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

    private <Data, TResource, Transcode> List<k<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f9124c.b(cls, cls2)) {
            for (Class cls5 : this.f9127f.b(cls4, cls3)) {
                k kVar = new k(cls, cls4, cls5, this.f9124c.a(cls, cls4), this.f9127f.a(cls4, cls5), this.f9131j);
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, io.intercom.com.bumptech.glide.load.d<Data> dVar) {
        this.f9123b.a(cls, dVar);
        return this;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f9129h.a(cls, cls2);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class b2 : this.f9122a.a(cls)) {
                for (Class cls4 : this.f9124c.b(b2, cls2)) {
                    if (!this.f9127f.b(cls4, cls3).isEmpty() && !a2.contains(cls4)) {
                        a2.add(cls4);
                    }
                }
            }
            this.f9129h.a(cls, cls2, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, io.intercom.com.bumptech.glide.load.k<Data, TResource> kVar) {
        a("legacy_append", cls, cls2, kVar);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, io.intercom.com.bumptech.glide.load.k<Data, TResource> kVar) {
        this.f9124c.a(str, kVar, cls, cls2);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f9124c.a((List<String>) arrayList);
        return this;
    }

    public <TResource> Registry a(Class<TResource> cls, l<TResource> lVar) {
        this.f9125d.a(cls, lVar);
        return this;
    }

    public Registry a(io.intercom.com.bumptech.glide.load.a.c.a<?> aVar) {
        this.f9126e.a(aVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, io.intercom.com.bumptech.glide.load.c.f.d<TResource, Transcode> dVar) {
        this.f9127f.a(cls, cls2, dVar);
        return this;
    }

    public Registry a(io.intercom.com.bumptech.glide.load.e eVar) {
        this.f9128g.a(eVar);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, v<Model, Data> vVar) {
        this.f9122a.a(cls, cls2, vVar);
        return this;
    }

    public <Data, TResource, Transcode> B<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        B<Data, TResource, Transcode> b2 = this.f9130i.b(cls, cls2, cls3);
        if (b2 == null && !this.f9130i.a(cls, cls2, cls3)) {
            List c2 = c(cls, cls2, cls3);
            if (c2.isEmpty()) {
                b2 = null;
            } else {
                b2 = new B<>(cls, cls2, cls3, c2, this.f9131j);
            }
            this.f9130i.a(cls, cls2, cls3, b2);
        }
        return b2;
    }

    public <X> io.intercom.com.bumptech.glide.load.d<X> c(X x) throws NoSourceEncoderAvailableException {
        io.intercom.com.bumptech.glide.load.d<X> a2 = this.f9123b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean b(E<?> e2) {
        return this.f9125d.a(e2.c()) != null;
    }

    public <X> io.intercom.com.bumptech.glide.load.a.c<X> b(X x) {
        return this.f9126e.a(x);
    }

    public <X> l<X> a(E<X> e2) throws NoResultEncoderAvailableException {
        l<X> a2 = this.f9125d.a(e2.c());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(e2.c());
    }

    public <Model> List<u<Model, ?>> a(Model model) {
        List<u<Model, ?>> a2 = this.f9122a.a(model);
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    public List<io.intercom.com.bumptech.glide.load.e> a() {
        List<io.intercom.com.bumptech.glide.load.e> a2 = this.f9128g.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new NoImageHeaderParserException();
    }
}
