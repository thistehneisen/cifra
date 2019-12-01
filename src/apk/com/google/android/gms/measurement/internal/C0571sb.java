package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.measurement.internal.sb reason: case insensitive filesystem */
final class C0571sb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final URL f6090a;

    /* renamed from: b reason: collision with root package name */
    private final byte[] f6091b;

    /* renamed from: c reason: collision with root package name */
    private final C0562qb f6092c;

    /* renamed from: d reason: collision with root package name */
    private final String f6093d;

    /* renamed from: e reason: collision with root package name */
    private final Map<String, String> f6094e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ C0552ob f6095f;

    public C0571sb(C0552ob obVar, String str, URL url, byte[] bArr, Map<String, String> map, C0562qb qbVar) {
        this.f6095f = obVar;
        q.b(str);
        q.a(url);
        q.a(qbVar);
        this.f6090a = url;
        this.f6091b = bArr;
        this.f6092c = qbVar;
        this.f6093d = str;
        this.f6094e = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6 A[SYNTHETIC, Splitter:B:44:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0101 A[SYNTHETIC, Splitter:B:57:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011b  */
    public final void run() {
        Map map;
        Throwable th;
        int i2;
        HttpURLConnection httpURLConnection;
        Map map2;
        String str = "Error closing HTTP compressed POST connection output stream. appId";
        this.f6095f.i();
        OutputStream outputStream = null;
        try {
            httpURLConnection = this.f6095f.a(this.f6090a);
            try {
                if (this.f6094e != null) {
                    for (Entry entry : this.f6094e.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f6091b != null) {
                    byte[] c2 = this.f6095f.n().c(this.f6091b);
                    this.f6095f.e().B().a("Uploading data. size", Integer.valueOf(c2.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(c2.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(c2);
                        outputStream2.close();
                    } catch (IOException e2) {
                        map2 = null;
                        th = e2;
                        outputStream = outputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        map = null;
                        outputStream = outputStream2;
                        i2 = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        Ib d2 = this.f6095f.d();
                        C0557pb pbVar = new C0557pb(this.f6093d, this.f6092c, i2, null, null, map);
                        d2.a((Runnable) pbVar);
                        throw th;
                    }
                }
                i2 = httpURLConnection.getResponseCode();
                try {
                    map = httpURLConnection.getHeaderFields();
                    try {
                        byte[] a2 = C0552ob.a(httpURLConnection);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        Ib d3 = this.f6095f.d();
                        C0557pb pbVar2 = new C0557pb(this.f6093d, this.f6092c, i2, null, a2, map);
                        d3.a((Runnable) pbVar2);
                    } catch (IOException e3) {
                        e = e3;
                        th = e;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        Ib d4 = this.f6095f.d();
                        C0557pb pbVar3 = new C0557pb(this.f6093d, this.f6092c, i2, th, null, map);
                        d4.a((Runnable) pbVar3);
                    } catch (Throwable th3) {
                        th = th3;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        Ib d22 = this.f6095f.d();
                        C0557pb pbVar4 = new C0557pb(this.f6093d, this.f6092c, i2, null, null, map);
                        d22.a((Runnable) pbVar4);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    th = e;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    Ib d42 = this.f6095f.d();
                    C0557pb pbVar32 = new C0557pb(this.f6093d, this.f6092c, i2, th, null, map);
                    d42.a((Runnable) pbVar32);
                } catch (Throwable th4) {
                    th = th4;
                    map = null;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    Ib d222 = this.f6095f.d();
                    C0557pb pbVar42 = new C0557pb(this.f6093d, this.f6092c, i2, null, null, map);
                    d222.a((Runnable) pbVar42);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                map2 = null;
                th = e;
                i2 = 0;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                Ib d422 = this.f6095f.d();
                C0557pb pbVar322 = new C0557pb(this.f6093d, this.f6092c, i2, th, null, map);
                d422.a((Runnable) pbVar322);
            } catch (Throwable th5) {
                th = th5;
                map = null;
                i2 = 0;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                Ib d2222 = this.f6095f.d();
                C0557pb pbVar422 = new C0557pb(this.f6093d, this.f6092c, i2, null, null, map);
                d2222.a((Runnable) pbVar422);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            map2 = null;
            th = e;
            i2 = 0;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e7) {
                    this.f6095f.e().t().a(str, C0532kb.a(this.f6093d), e7);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            Ib d4222 = this.f6095f.d();
            C0557pb pbVar3222 = new C0557pb(this.f6093d, this.f6092c, i2, th, null, map);
            d4222.a((Runnable) pbVar3222);
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            map = null;
            i2 = 0;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                    this.f6095f.e().t().a(str, C0532kb.a(this.f6093d), e8);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            Ib d22222 = this.f6095f.d();
            C0557pb pbVar4222 = new C0557pb(this.f6093d, this.f6092c, i2, null, null, map);
            d22222.a((Runnable) pbVar4222);
            throw th;
        }
    }
}
