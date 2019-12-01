package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d.a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher */
public abstract class m<T> implements d<T> {

    /* renamed from: a reason: collision with root package name */
    private final Uri f3594a;

    /* renamed from: b reason: collision with root package name */
    private final ContentResolver f3595b;

    /* renamed from: c reason: collision with root package name */
    private T f3596c;

    public m(ContentResolver contentResolver, Uri uri) {
        this.f3595b = contentResolver;
        this.f3594a = uri;
    }

    /* access modifiers changed from: protected */
    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public final void a(j jVar, a<? super T> aVar) {
        try {
            this.f3596c = a(this.f3594a, this.f3595b);
            aVar.a(this.f3596c);
        } catch (FileNotFoundException e2) {
            String str = "LocalUriFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    public void b() {
        T t = this.f3596c;
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
