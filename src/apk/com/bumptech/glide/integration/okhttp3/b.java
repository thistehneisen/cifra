package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import com.bumptech.glide.h.c;
import com.bumptech.glide.j;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.l;
import i.C0721j;
import i.C0721j.a;
import i.C0722k;
import i.J;
import i.M;
import i.O;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

/* compiled from: OkHttpStreamFetcher */
public class b implements d<InputStream>, C0722k {

    /* renamed from: a reason: collision with root package name */
    private final a f3535a;

    /* renamed from: b reason: collision with root package name */
    private final l f3536b;

    /* renamed from: c reason: collision with root package name */
    private InputStream f3537c;

    /* renamed from: d reason: collision with root package name */
    private O f3538d;

    /* renamed from: e reason: collision with root package name */
    private d.a<? super InputStream> f3539e;

    /* renamed from: f reason: collision with root package name */
    private volatile C0721j f3540f;

    public b(a aVar, l lVar) {
        this.f3535a = aVar;
        this.f3536b = lVar;
    }

    public void a(j jVar, d.a<? super InputStream> aVar) {
        J.a aVar2 = new J.a();
        aVar2.b(this.f3536b.c());
        for (Entry entry : this.f3536b.b().entrySet()) {
            aVar2.a((String) entry.getKey(), (String) entry.getValue());
        }
        J a2 = aVar2.a();
        this.f3539e = aVar;
        this.f3540f = this.f3535a.a(a2);
        this.f3540f.a(this);
    }

    public void b() {
        try {
            if (this.f3537c != null) {
                this.f3537c.close();
            }
        } catch (IOException unused) {
        }
        O o = this.f3538d;
        if (o != null) {
            o.close();
        }
        this.f3539e = null;
    }

    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    public void cancel() {
        C0721j jVar = this.f3540f;
        if (jVar != null) {
            jVar.cancel();
        }
    }

    public void a(C0721j jVar, IOException iOException) {
        String str = "OkHttpFetcher";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "OkHttp failed to obtain result", iOException);
        }
        this.f3539e.a((Exception) iOException);
    }

    public void a(C0721j jVar, M m) {
        this.f3538d = m.a();
        if (m.f()) {
            O o = this.f3538d;
            com.bumptech.glide.h.l.a(o);
            this.f3537c = c.a(this.f3538d.a(), o.b());
            this.f3539e.a(this.f3537c);
            return;
        }
        this.f3539e.a((Exception) new HttpException(m.g(), m.c()));
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
