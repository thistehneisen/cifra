package io.intercom.com.bumptech.glide.load.engine;

import android.util.Log;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.a.c;
import io.intercom.com.bumptech.glide.load.c.f.d;
import io.intercom.com.bumptech.glide.load.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath */
public class k<DataType, ResourceType, Transcode> {

    /* renamed from: a reason: collision with root package name */
    private final Class<DataType> f9927a;

    /* renamed from: b reason: collision with root package name */
    private final List<? extends io.intercom.com.bumptech.glide.load.k<DataType, ResourceType>> f9928b;

    /* renamed from: c reason: collision with root package name */
    private final d<ResourceType, Transcode> f9929c;

    /* renamed from: d reason: collision with root package name */
    private final b.g.h.d<List<Throwable>> f9930d;

    /* renamed from: e reason: collision with root package name */
    private final String f9931e;

    /* compiled from: DecodePath */
    interface a<ResourceType> {
        E<ResourceType> a(E<ResourceType> e2);
    }

    public k(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends io.intercom.com.bumptech.glide.load.k<DataType, ResourceType>> list, d<ResourceType, Transcode> dVar, b.g.h.d<List<Throwable>> dVar2) {
        this.f9927a = cls;
        this.f9928b = list;
        this.f9929c = dVar;
        this.f9930d = dVar2;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed DecodePath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.f9931e = sb.toString();
    }

    public E<Transcode> a(c<DataType> cVar, int i2, int i3, j jVar, a<ResourceType> aVar) throws GlideException {
        return this.f9929c.a(aVar.a(a(cVar, i2, i3, jVar)), jVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecodePath{ dataClass=");
        sb.append(this.f9927a);
        sb.append(", decoders=");
        sb.append(this.f9928b);
        sb.append(", transcoder=");
        sb.append(this.f9929c);
        sb.append('}');
        return sb.toString();
    }

    private E<ResourceType> a(c<DataType> cVar, int i2, int i3, j jVar) throws GlideException {
        Object a2 = this.f9930d.a();
        h.a(a2);
        List list = (List) a2;
        try {
            E<ResourceType> a3 = a(cVar, i2, i3, jVar, list);
            return a3;
        } finally {
            this.f9930d.a(list);
        }
    }

    private E<ResourceType> a(c<DataType> cVar, int i2, int i3, j jVar, List<Throwable> list) throws GlideException {
        int size = this.f9928b.size();
        E<ResourceType> e2 = null;
        for (int i4 = 0; i4 < size; i4++) {
            io.intercom.com.bumptech.glide.load.k kVar = (io.intercom.com.bumptech.glide.load.k) this.f9928b.get(i4);
            try {
                if (kVar.a(cVar.a(), jVar)) {
                    e2 = kVar.a(cVar.a(), i2, i3, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e3) {
                String str = "DecodePath";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(kVar);
                    Log.v(str, sb.toString(), e3);
                }
                list.add(e3);
            }
            if (e2 != null) {
                break;
            }
        }
        if (e2 != null) {
            return e2;
        }
        throw new GlideException(this.f9931e, (List<Throwable>) new ArrayList<Throwable>(list));
    }
}
