package io.fabric.sdk.android.a.e;

import android.content.res.Resources.NotFoundException;
import io.fabric.sdk.android.a.b.C0730a;
import io.fabric.sdk.android.a.b.D;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.n;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.d;
import io.fabric.sdk.android.services.network.g;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;

/* renamed from: io.fabric.sdk.android.a.e.a reason: case insensitive filesystem */
/* compiled from: AbstractAppSpiCall */
abstract class C0736a extends C0730a implements f {
    public C0736a(l lVar, String str, String str2, g gVar, d dVar) {
        super(lVar, str, str2, gVar, dVar);
    }

    private HttpRequest b(HttpRequest httpRequest, d dVar) {
        String str = "Failed to close app icon InputStream.";
        httpRequest.e("app[identifier]", dVar.f8911b);
        httpRequest.e("app[name]", dVar.f8915f);
        httpRequest.e("app[display_version]", dVar.f8912c);
        httpRequest.e("app[build_version]", dVar.f8913d);
        httpRequest.a("app[source]", (Number) Integer.valueOf(dVar.f8916g));
        httpRequest.e("app[minimum_sdk_version]", dVar.f8917h);
        httpRequest.e("app[built_sdk_version]", dVar.f8918i);
        if (!io.fabric.sdk.android.a.b.l.b(dVar.f8914e)) {
            httpRequest.e("app[instance_identifier]", dVar.f8914e);
        }
        if (dVar.f8919j != null) {
            InputStream inputStream = null;
            try {
                inputStream = this.kit.getContext().getResources().openRawResource(dVar.f8919j.f8945b);
                httpRequest.e("app[icon][hash]", dVar.f8919j.f8944a);
                httpRequest.a("app[icon][data]", "icon.png", "application/octet-stream", inputStream);
                httpRequest.a("app[icon][width]", (Number) Integer.valueOf(dVar.f8919j.f8946c));
                httpRequest.a("app[icon][height]", (Number) Integer.valueOf(dVar.f8919j.f8947d));
            } catch (NotFoundException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find app icon with resource ID: ");
                sb.append(dVar.f8919j.f8945b);
                f.e().b("Fabric", sb.toString(), e2);
            } catch (Throwable th) {
                io.fabric.sdk.android.a.b.l.a((Closeable) inputStream, str);
                throw th;
            }
            io.fabric.sdk.android.a.b.l.a((Closeable) inputStream, str);
        }
        Collection<n> collection = dVar.f8920k;
        if (collection != null) {
            for (n nVar : collection) {
                httpRequest.e(b(nVar), nVar.c());
                httpRequest.e(a(nVar), nVar.a());
            }
        }
        return httpRequest;
    }

    public boolean a(d dVar) {
        HttpRequest httpRequest = getHttpRequest();
        a(httpRequest, dVar);
        b(httpRequest, dVar);
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending app info to ");
        sb.append(getUrl());
        String str = "Fabric";
        e2.d(str, sb.toString());
        if (dVar.f8919j != null) {
            o e3 = f.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("App icon hash is ");
            sb2.append(dVar.f8919j.f8944a);
            e3.d(str, sb2.toString());
            o e4 = f.e();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("App icon size is ");
            sb3.append(dVar.f8919j.f8946c);
            sb3.append("x");
            sb3.append(dVar.f8919j.f8947d);
            e4.d(str, sb3.toString());
        }
        int g2 = httpRequest.g();
        String str2 = "POST".equals(httpRequest.k()) ? "Create" : "Update";
        o e5 = f.e();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        sb4.append(" app request ID: ");
        sb4.append(httpRequest.d(C0730a.HEADER_REQUEST_ID));
        e5.d(str, sb4.toString());
        o e6 = f.e();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Result was ");
        sb5.append(g2);
        e6.d(str, sb5.toString());
        return D.a(g2) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, d dVar) {
        httpRequest.c(C0730a.HEADER_API_KEY, dVar.f8910a);
        httpRequest.c(C0730a.HEADER_CLIENT_TYPE, C0730a.ANDROID_CLIENT_TYPE);
        httpRequest.c(C0730a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        return httpRequest;
    }

    /* access modifiers changed from: 0000 */
    public String a(n nVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{nVar.b()});
    }

    /* access modifiers changed from: 0000 */
    public String b(n nVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{nVar.b()});
    }
}
