package com.bumptech.glide.load.engine;

import b.g.h.d;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath */
public class D<Data, ResourceType, Transcode> {

    /* renamed from: a reason: collision with root package name */
    private final Class<Data> f3858a;

    /* renamed from: b reason: collision with root package name */
    private final d<List<Throwable>> f3859b;

    /* renamed from: c reason: collision with root package name */
    private final List<? extends m<Data, ResourceType, Transcode>> f3860c;

    /* renamed from: d reason: collision with root package name */
    private final String f3861d;

    public D(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<m<Data, ResourceType, Transcode>> list, d<List<Throwable>> dVar) {
        this.f3858a = cls;
        this.f3859b = dVar;
        l.a(list);
        this.f3860c = list;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.f3861d = sb.toString();
    }

    public G<Transcode> a(e<Data> eVar, i iVar, int i2, int i3, a<ResourceType> aVar) throws GlideException {
        Object a2 = this.f3859b.a();
        l.a(a2);
        List list = (List) a2;
        try {
            G<Transcode> a3 = a(eVar, iVar, i2, i3, aVar, list);
            return a3;
        } finally {
            this.f3859b.a(list);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        sb.append(Arrays.toString(this.f3860c.toArray()));
        sb.append('}');
        return sb.toString();
    }

    private G<Transcode> a(e<Data> eVar, i iVar, int i2, int i3, a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f3860c.size();
        G<Transcode> g2 = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                g2 = ((m) this.f3860c.get(i4)).a(eVar, i2, i3, iVar, aVar);
            } catch (GlideException e2) {
                list2.add(e2);
            }
            if (g2 != null) {
                break;
            }
        }
        if (g2 != null) {
            return g2;
        }
        throw new GlideException(this.f3861d, (List<Throwable>) new ArrayList<Throwable>(list2));
    }
}
