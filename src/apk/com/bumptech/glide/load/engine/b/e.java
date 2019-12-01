package com.bumptech.glide.load.engine.b;

import android.util.Log;
import com.bumptech.glide.a.b;
import com.bumptech.glide.a.b.C0043b;
import com.bumptech.glide.a.b.d;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper */
public class e implements a {

    /* renamed from: a reason: collision with root package name */
    private final l f3952a;

    /* renamed from: b reason: collision with root package name */
    private final File f3953b;

    /* renamed from: c reason: collision with root package name */
    private final long f3954c;

    /* renamed from: d reason: collision with root package name */
    private final c f3955d = new c();

    /* renamed from: e reason: collision with root package name */
    private b f3956e;

    @Deprecated
    protected e(File file, long j2) {
        this.f3953b = file;
        this.f3954c = j2;
        this.f3952a = new l();
    }

    public static a a(File file, long j2) {
        return new e(file, j2);
    }

    private synchronized b a() throws IOException {
        if (this.f3956e == null) {
            this.f3956e = b.a(this.f3953b, 1, 1, this.f3954c);
        }
        return this.f3956e;
    }

    public File a(f fVar) {
        String a2 = this.f3952a.a(fVar);
        String str = "DiskLruCacheWrapper";
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(a2);
            sb.append(" for for Key: ");
            sb.append(fVar);
            Log.v(str, sb.toString());
        }
        try {
            d c2 = a().c(a2);
            if (c2 != null) {
                return c2.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, "Unable to get from disk cache", e2);
            return null;
        }
    }

    public void a(f fVar, a.b bVar) {
        C0043b b2;
        String str = "DiskLruCacheWrapper";
        String a2 = this.f3952a.a(fVar);
        this.f3955d.a(a2);
        try {
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Put: Obtained: ");
                sb.append(a2);
                sb.append(" for for Key: ");
                sb.append(fVar);
                Log.v(str, sb.toString());
            }
            try {
                b a3 = a();
                if (a3.c(a2) == null) {
                    b2 = a3.b(a2);
                    if (b2 != null) {
                        if (bVar.a(b2.a(0))) {
                            b2.c();
                        }
                        b2.b();
                        this.f3955d.b(a2);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Had two simultaneous puts for: ");
                    sb2.append(a2);
                    throw new IllegalStateException(sb2.toString());
                }
            } catch (IOException e2) {
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                b2.b();
                throw th;
            }
        } finally {
            this.f3955d.b(a2);
        }
    }
}
