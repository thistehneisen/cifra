package io.intercom.com.bumptech.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.share.Constants;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.h.d;
import io.intercom.com.bumptech.glide.load.HttpException;
import io.intercom.com.bumptech.glide.load.b.l;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HttpUrlFetcher */
public class i implements b<InputStream> {

    /* renamed from: a reason: collision with root package name */
    static final b f9455a = new a();

    /* renamed from: b reason: collision with root package name */
    private final l f9456b;

    /* renamed from: c reason: collision with root package name */
    private final int f9457c;

    /* renamed from: d reason: collision with root package name */
    private final b f9458d;

    /* renamed from: e reason: collision with root package name */
    private HttpURLConnection f9459e;

    /* renamed from: f reason: collision with root package name */
    private InputStream f9460f;

    /* renamed from: g reason: collision with root package name */
    private volatile boolean f9461g;

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

    public i(l lVar, int i2) {
        this(lVar, i2, f9455a);
    }

    public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super InputStream> aVar) {
        String str = "HttpUrlFetcher";
        long a2 = d.a();
        try {
            InputStream a3 = a(this.f9456b.c(), 0, null, this.f9456b.b());
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(d.a(a2));
                sb.append(" ms and loaded ");
                sb.append(a3);
                Log.v(str, sb.toString());
            }
            aVar.a(a3);
        } catch (IOException e2) {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to load data for url", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public void b() {
        InputStream inputStream = this.f9460f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f9459e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f9459e = null;
    }

    public io.intercom.com.bumptech.glide.load.a c() {
        return io.intercom.com.bumptech.glide.load.a.REMOTE;
    }

    public void cancel() {
        this.f9461g = true;
    }

    i(l lVar, int i2, b bVar) {
        this.f9456b = lVar;
        this.f9457c = i2;
        this.f9458d = bVar;
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
            this.f9459e = this.f9458d.a(url);
            for (Entry entry : map.entrySet()) {
                this.f9459e.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            this.f9459e.setConnectTimeout(this.f9457c);
            this.f9459e.setReadTimeout(this.f9457c);
            this.f9459e.setUseCaches(false);
            this.f9459e.setDoInput(true);
            this.f9459e.setInstanceFollowRedirects(false);
            this.f9459e.connect();
            this.f9460f = this.f9459e.getInputStream();
            if (this.f9461g) {
                return null;
            }
            int responseCode = this.f9459e.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                return a(this.f9459e);
            }
            if (i3 == 3) {
                String headerField = this.f9459e.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return a(url3, i2 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f9459e.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f9460f = io.intercom.com.bumptech.glide.h.b.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            String str = "HttpUrlFetcher";
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(httpURLConnection.getContentEncoding());
                Log.d(str, sb.toString());
            }
            this.f9460f = httpURLConnection.getInputStream();
        }
        return this.f9460f;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
