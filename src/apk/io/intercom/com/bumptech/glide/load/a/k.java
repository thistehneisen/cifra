package io.intercom.com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.a.b.a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher */
public abstract class k<T> implements b<T> {

    /* renamed from: a reason: collision with root package name */
    private final Uri f9464a;

    /* renamed from: b reason: collision with root package name */
    private final ContentResolver f9465b;

    /* renamed from: c reason: collision with root package name */
    private T f9466c;

    public k(ContentResolver contentResolver, Uri uri) {
        this.f9465b = contentResolver;
        this.f9464a = uri;
    }

    /* access modifiers changed from: protected */
    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public final void a(h hVar, a<? super T> aVar) {
        try {
            this.f9466c = a(this.f9464a, this.f9465b);
            aVar.a(this.f9466c);
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
        T t = this.f9466c;
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
