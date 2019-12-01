package io.intercom.com.bumptech.glide.load.engine;

import b.g.h.d;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.a.c;
import io.intercom.com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath */
public class B<Data, ResourceType, Transcode> {

    /* renamed from: a reason: collision with root package name */
    private final Class<Data> f9720a;

    /* renamed from: b reason: collision with root package name */
    private final d<List<Throwable>> f9721b;

    /* renamed from: c reason: collision with root package name */
    private final List<? extends k<Data, ResourceType, Transcode>> f9722c;

    /* renamed from: d reason: collision with root package name */
    private final String f9723d;

    public B(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<k<Data, ResourceType, Transcode>> list, d<List<Throwable>> dVar) {
        this.f9720a = cls;
        this.f9721b = dVar;
        h.a(list);
        this.f9722c = list;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.f9723d = sb.toString();
    }

    public E<Transcode> a(c<Data> cVar, j jVar, int i2, int i3, a<ResourceType> aVar) throws GlideException {
        Object a2 = this.f9721b.a();
        h.a(a2);
        List list = (List) a2;
        try {
            E<Transcode> a3 = a(cVar, jVar, i2, i3, aVar, list);
            return a3;
        } finally {
            this.f9721b.a(list);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        List<? extends k<Data, ResourceType, Transcode>> list = this.f9722c;
        sb.append(Arrays.toString(list.toArray(new k[list.size()])));
        sb.append('}');
        return sb.toString();
    }

    private E<Transcode> a(c<Data> cVar, j jVar, int i2, int i3, a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f9722c.size();
        E<Transcode> e2 = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                e2 = ((k) this.f9722c.get(i4)).a(cVar, i2, i3, jVar, aVar);
            } catch (GlideException e3) {
                list2.add(e3);
            }
            if (e2 != null) {
                break;
            }
        }
        if (e2 != null) {
            return e2;
        }
        throw new GlideException(this.f9723d, (List<Throwable>) new ArrayList<Throwable>(list2));
    }
}
