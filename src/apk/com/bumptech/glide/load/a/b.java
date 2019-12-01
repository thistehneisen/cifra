package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d.a;
import java.io.IOException;

/* compiled from: AssetPathFetcher */
public abstract class b<T> implements d<T> {

    /* renamed from: a reason: collision with root package name */
    private final String f3570a;

    /* renamed from: b reason: collision with root package name */
    private final AssetManager f3571b;

    /* renamed from: c reason: collision with root package name */
    private T f3572c;

    public b(AssetManager assetManager, String str) {
        this.f3571b = assetManager;
        this.f3570a = str;
    }

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str) throws IOException;

    public void a(j jVar, a<? super T> aVar) {
        try {
            this.f3572c = a(this.f3571b, this.f3570a);
            aVar.a(this.f3572c);
        } catch (IOException e2) {
            String str = "AssetPathFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    public void b() {
        T t = this.f3572c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    public void cancel() {
    }
}
