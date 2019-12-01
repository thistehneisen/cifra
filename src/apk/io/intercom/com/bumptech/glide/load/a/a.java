package io.intercom.com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import io.intercom.com.bumptech.glide.h;
import java.io.IOException;

/* compiled from: AssetPathFetcher */
public abstract class a<T> implements b<T> {

    /* renamed from: a reason: collision with root package name */
    private final String f9431a;

    /* renamed from: b reason: collision with root package name */
    private final AssetManager f9432b;

    /* renamed from: c reason: collision with root package name */
    private T f9433c;

    public a(AssetManager assetManager, String str) {
        this.f9432b = assetManager;
        this.f9431a = str;
    }

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str) throws IOException;

    public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super T> aVar) {
        try {
            this.f9433c = a(this.f9432b, this.f9431a);
            aVar.a(this.f9433c);
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
        T t = this.f9433c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    public io.intercom.com.bumptech.glide.load.a c() {
        return io.intercom.com.bumptech.glide.load.a.LOCAL;
    }

    public void cancel() {
    }
}
