package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class Rc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final URL f5699a;

    /* renamed from: b reason: collision with root package name */
    private final byte[] f5700b = null;

    /* renamed from: c reason: collision with root package name */
    private final Oc f5701c;

    /* renamed from: d reason: collision with root package name */
    private final String f5702d;

    /* renamed from: e reason: collision with root package name */
    private final Map<String, String> f5703e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Pc f5704f;

    public Rc(Pc pc, String str, URL url, byte[] bArr, Map<String, String> map, Oc oc) {
        this.f5704f = pc;
        q.b(str);
        q.a(url);
        q.a(oc);
        this.f5699a = url;
        this.f5701c = oc;
        this.f5702d = str;
        this.f5703e = null;
    }

    private final void b(int i2, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        Ib d2 = this.f5704f.d();
        Qc qc = new Qc(this, i2, exc, bArr, map);
        d2.a((Runnable) qc);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void a(int i2, Exception exc, byte[] bArr, Map map) {
        this.f5701c.a(this.f5702d, i2, exc, bArr, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d  */
    public final void run() {
        int i2;
        HttpURLConnection httpURLConnection;
        Map map;
        int i3;
        Map map2;
        int responseCode;
        Map headerFields;
        this.f5704f.i();
        try {
            httpURLConnection = this.f5704f.a(this.f5699a);
            try {
                if (this.f5703e != null) {
                    for (Entry entry : this.f5703e.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
            } catch (IOException e2) {
                e = e2;
                map = null;
                i2 = 0;
                if (httpURLConnection != null) {
                }
                b(i2, e, null, map);
            } catch (Throwable th) {
                th = th;
                map2 = null;
                i3 = 0;
                if (httpURLConnection != null) {
                }
                b(i3, null, null, map2);
                throw th;
            }
            try {
                headerFields = httpURLConnection.getHeaderFields();
            } catch (IOException e3) {
                e = e3;
                i2 = responseCode;
                map = null;
                if (httpURLConnection != null) {
                }
                b(i2, e, null, map);
            } catch (Throwable th2) {
                th = th2;
                i3 = responseCode;
                map2 = null;
                if (httpURLConnection != null) {
                }
                b(i3, null, null, map2);
                throw th;
            }
            try {
                byte[] a2 = Pc.a(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                b(responseCode, null, a2, headerFields);
            } catch (IOException e4) {
                Exception exc = e4;
                i2 = responseCode;
                map = headerFields;
                e = exc;
                if (httpURLConnection != null) {
                }
                b(i2, e, null, map);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                i3 = responseCode;
                map2 = headerFields;
                th = th4;
                if (httpURLConnection != null) {
                }
                b(i3, null, null, map2);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            map = null;
            httpURLConnection = null;
            i2 = 0;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i2, e, null, map);
        } catch (Throwable th5) {
            th = th5;
            map2 = null;
            httpURLConnection = null;
            i3 = 0;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            b(i3, null, null, map2);
            throw th;
        }
    }
}
