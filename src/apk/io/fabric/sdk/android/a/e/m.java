package io.fabric.sdk.android.a.e;

import io.fabric.sdk.android.a.b.C0730a;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException;
import io.fabric.sdk.android.services.network.d;
import io.fabric.sdk.android.services.network.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DefaultSettingsSpiCall */
class m extends C0730a implements z {
    public m(l lVar, String str, String str2, g gVar) {
        this(lVar, str, str2, gVar, d.GET);
    }

    private Map<String, String> b(y yVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", yVar.f8988h);
        hashMap.put("display_version", yVar.f8987g);
        hashMap.put("source", Integer.toString(yVar.f8989i));
        String str = yVar.f8990j;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = yVar.f8986f;
        if (!io.fabric.sdk.android.a.b.l.b(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0087  */
    public JSONObject a(y yVar) {
        HttpRequest httpRequest;
        o e2;
        StringBuilder sb;
        String str = C0730a.HEADER_REQUEST_ID;
        String str2 = "Settings request ID: ";
        String str3 = "Fabric";
        JSONObject jSONObject = null;
        try {
            Map b2 = b(yVar);
            httpRequest = getHttpRequest(b2);
            try {
                a(httpRequest, yVar);
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Requesting settings from ");
                sb2.append(getUrl());
                e3.d(str3, sb2.toString());
                o e4 = f.e();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Settings query params were: ");
                sb3.append(b2);
                e4.d(str3, sb3.toString());
                jSONObject = a(httpRequest);
                if (httpRequest != null) {
                    e2 = f.e();
                    sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(httpRequest.d(str));
                    e2.d(str3, sb.toString());
                }
            } catch (HttpRequestException e5) {
                e = e5;
                try {
                    f.e().b(str3, "Settings request failed.", e);
                    if (httpRequest != null) {
                    }
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    if (httpRequest != null) {
                        o e6 = f.e();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        sb4.append(httpRequest.d(str));
                        e6.d(str3, sb4.toString());
                    }
                    throw th;
                }
            }
        } catch (HttpRequestException e7) {
            e = e7;
            httpRequest = null;
            f.e().b(str3, "Settings request failed.", e);
            if (httpRequest != null) {
                e2 = f.e();
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(httpRequest.d(str));
                e2.d(str3, sb.toString());
            }
            return jSONObject;
        } catch (Throwable th2) {
            th = th2;
            httpRequest = null;
            if (httpRequest != null) {
            }
            throw th;
        }
        return jSONObject;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 202 || i2 == 203;
    }

    m(l lVar, String str, String str2, g gVar, d dVar) {
        super(lVar, str, str2, gVar, dVar);
    }

    /* access modifiers changed from: 0000 */
    public JSONObject a(HttpRequest httpRequest) {
        int g2 = httpRequest.g();
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Settings result was: ");
        sb.append(g2);
        String str = "Fabric";
        e2.d(str, sb.toString());
        if (a(g2)) {
            return a(httpRequest.a());
        }
        o e3 = f.e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to retrieve settings from ");
        sb2.append(getUrl());
        e3.b(str, sb2.toString());
        return null;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            o e3 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse settings JSON from ");
            sb.append(getUrl());
            String str2 = "Fabric";
            e3.c(str2, sb.toString(), e2);
            o e4 = f.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Settings response ");
            sb2.append(str);
            e4.d(str2, sb2.toString());
            return null;
        }
    }

    private HttpRequest a(HttpRequest httpRequest, y yVar) {
        a(httpRequest, C0730a.HEADER_API_KEY, yVar.f8981a);
        a(httpRequest, C0730a.HEADER_CLIENT_TYPE, C0730a.ANDROID_CLIENT_TYPE);
        a(httpRequest, C0730a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        a(httpRequest, C0730a.HEADER_ACCEPT, C0730a.ACCEPT_JSON_VALUE);
        a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", yVar.f8982b);
        a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", yVar.f8983c);
        a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", yVar.f8984d);
        a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", yVar.f8985e);
        return httpRequest;
    }

    private void a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.c(str, str2);
        }
    }
}
