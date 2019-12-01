package com.bumptech.glide.load.engine;

import android.util.Log;
import b.g.h.d;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.c.f.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath */
public class m<DataType, ResourceType, Transcode> {

    /* renamed from: a reason: collision with root package name */
    private final Class<DataType> f4067a;

    /* renamed from: b reason: collision with root package name */
    private final List<? extends j<DataType, ResourceType>> f4068b;

    /* renamed from: c reason: collision with root package name */
    private final e<ResourceType, Transcode> f4069c;

    /* renamed from: d reason: collision with root package name */
    private final d<List<Throwable>> f4070d;

    /* renamed from: e reason: collision with root package name */
    private final String f4071e;

    /* compiled from: DecodePath */
    interface a<ResourceType> {
        G<ResourceType> a(G<ResourceType> g2);
    }

    public m(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends j<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, d<List<Throwable>> dVar) {
        this.f4067a = cls;
        this.f4068b = list;
        this.f4069c = eVar;
        this.f4070d = dVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed DecodePath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.f4071e = sb.toString();
    }

    public G<Transcode> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, i iVar, a<ResourceType> aVar) throws GlideException {
        return this.f4069c.a(aVar.a(a(eVar, i2, i3, iVar)), iVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecodePath{ dataClass=");
        sb.append(this.f4067a);
        sb.append(", decoders=");
        sb.append(this.f4068b);
        sb.append(", transcoder=");
        sb.append(this.f4069c);
        sb.append('}');
        return sb.toString();
    }

    private G<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, i iVar) throws GlideException {
        Object a2 = this.f4070d.a();
        l.a(a2);
        List list = (List) a2;
        try {
            G<ResourceType> a3 = a(eVar, i2, i3, iVar, list);
            return a3;
        } finally {
            this.f4070d.a(list);
        }
    }

    private G<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, i iVar, List<Throwable> list) throws GlideException {
        int size = this.f4068b.size();
        G<ResourceType> g2 = null;
        for (int i4 = 0; i4 < size; i4++) {
            j jVar = (j) this.f4068b.get(i4);
            try {
                if (jVar.a(eVar.a(), iVar)) {
                    g2 = jVar.a(eVar.a(), i2, i3, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                String str = "DecodePath";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(jVar);
                    Log.v(str, sb.toString(), e2);
                }
                list.add(e2);
            }
            if (g2 != null) {
                break;
            }
        }
        if (g2 != null) {
            return g2;
        }
        throw new GlideException(this.f4071e, (List<Throwable>) new ArrayList<Throwable>(list));
    }
}
