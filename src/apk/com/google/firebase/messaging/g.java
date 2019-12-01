package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import c.b.a.b.b.d.i;
import c.b.a.b.b.d.m;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.tasks.j;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class g implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private final URL f6876a;

    /* renamed from: b reason: collision with root package name */
    private com.google.android.gms.tasks.g<Bitmap> f6877b;

    /* renamed from: c reason: collision with root package name */
    private volatile InputStream f6878c;

    private g(URL url) {
        this.f6876a = url;
    }

    public static g b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new g(new URL(str));
        } catch (MalformedURLException unused) {
            String str2 = "Not downloading image, bad URL: ";
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
    }

    public final void a(Executor executor) {
        this.f6877b = j.a(executor, (Callable<TResult>) new h<TResult>(this));
    }

    public final void close() {
        c.b.a.b.b.d.j.a(this.f6878c);
    }

    public final com.google.android.gms.tasks.g<Bitmap> a() {
        com.google.android.gms.tasks.g<Bitmap> gVar = this.f6877b;
        q.a(gVar);
        return gVar;
    }

    private static /* synthetic */ void a(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                m.a(th, th2);
            }
        } else {
            inputStream.close();
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x00a7=Splitter:B:28:0x00a7, B:12:0x006b=Splitter:B:12:0x006b} */
    public final Bitmap b() throws IOException {
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        Throwable th3;
        String valueOf = String.valueOf(this.f6876a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        String str = "FirebaseMessaging";
        Log.i(str, sb.toString());
        try {
            inputStream = this.f6876a.openConnection().getInputStream();
            InputStream a2 = i.a(inputStream, 1048576);
            try {
                this.f6878c = inputStream;
                Bitmap decodeStream = BitmapFactory.decodeStream(a2);
                if (decodeStream != null) {
                    if (Log.isLoggable(str, 3)) {
                        String valueOf2 = String.valueOf(this.f6876a);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                        sb2.append("Successfully downloaded image: ");
                        sb2.append(valueOf2);
                        Log.d(str, sb2.toString());
                    }
                    a(null, a2);
                    if (inputStream != null) {
                        a(null, inputStream);
                    }
                    return decodeStream;
                }
                String valueOf3 = String.valueOf(this.f6876a);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
                sb3.append("Failed to decode image: ");
                sb3.append(valueOf3);
                String sb4 = sb3.toString();
                Log.w(str, sb4);
                throw new IOException(sb4);
            } catch (Throwable th4) {
                Throwable th5 = th4;
                th2 = r3;
                th3 = th5;
            }
            a(th2, a2);
            throw th3;
        } catch (IOException e2) {
            String valueOf4 = String.valueOf(this.f6876a);
            StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf4).length() + 26);
            sb5.append("Failed to download image: ");
            sb5.append(valueOf4);
            Log.w(str, sb5.toString());
            throw e2;
        } catch (Throwable th6) {
            if (inputStream != null) {
                a(th, inputStream);
            }
            throw th6;
        }
    }
}
