package com.bumptech.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.bumptech.glide.h.c;
import com.bumptech.glide.h.h;
import com.bumptech.glide.j;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.b.l;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HttpUrlFetcher */
public class k implements d<InputStream> {

    /* renamed from: a reason: collision with root package name */
    static final b f3585a = new a();

    /* renamed from: b reason: collision with root package name */
    private final l f3586b;

    /* renamed from: c reason: collision with root package name */
    private final int f3587c;

    /* renamed from: d reason: collision with root package name */
    private final b f3588d;

    /* renamed from: e reason: collision with root package name */
    private HttpURLConnection f3589e;

    /* renamed from: f reason: collision with root package name */
    private InputStream f3590f;

    /* renamed from: g reason: collision with root package name */
    private volatile boolean f3591g;

    /* compiled from: HttpUrlFetcher */
    private static class a implements b {
        a() {
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public k(l lVar, int i2) {
        this(lVar, i2, f3585a);
    }

    private static boolean b(int i2) {
        return i2 / 100 == 3;
    }

    public void a(j jVar, com.bumptech.glide.load.a.d.a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = "Finished http url fetcher fetch in ";
        String str2 = "HttpUrlFetcher";
        long a2 = h.a();
        try {
            aVar.a(a(this.f3586b.d(), 0, null, this.f3586b.b()));
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(h.a(a2));
                Log.v(str2, sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Failed to load data for url", e2);
            }
            aVar.a((Exception) e2);
            if (Log.isLoggable(str2, 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(h.a(a2));
                Log.v(str2, sb2.toString());
            }
            throw th;
        }
    }

    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    public void cancel() {
        this.f3591g = true;
    }

    k(l lVar, int i2, b bVar) {
        this.f3586b = lVar;
        this.f3587c = i2;
        this.f3588d = bVar;
    }

    public void b() {
        InputStream inputStream = this.f3590f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f3589e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f3589e = null;
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f3589e = this.f3588d.a(url);
            for (Entry entry : map.entrySet()) {
                this.f3589e.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            this.f3589e.setConnectTimeout(this.f3587c);
            this.f3589e.setReadTimeout(this.f3587c);
            this.f3589e.setUseCaches(false);
            this.f3589e.setDoInput(true);
            this.f3589e.setInstanceFollowRedirects(false);
            this.f3589e.connect();
            this.f3590f = this.f3589e.getInputStream();
            if (this.f3591g) {
                return null;
            }
            int responseCode = this.f3589e.getResponseCode();
            if (a(responseCode)) {
                return a(this.f3589e);
            }
            if (b(responseCode)) {
                String headerField = this.f3589e.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return a(url3, i2 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f3589e.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    private static boolean a(int i2) {
        return i2 / 100 == 2;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f3590f = c.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            String str = "HttpUrlFetcher";
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(httpURLConnection.getContentEncoding());
                Log.d(str, sb.toString());
            }
            this.f3590f = httpURLConnection.getInputStream();
        }
        return this.f3590f;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
