package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.a.b.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FabricKitsFinder */
class h implements Callable<Map<String, n>> {

    /* renamed from: a reason: collision with root package name */
    final String f9023a;

    h(String str) {
        this.f9023a = str;
    }

    private n a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                String property = properties.getProperty("fabric-identifier");
                String property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid format of fabric file,");
                    sb.append(zipEntry.getName());
                    throw new IllegalStateException(sb.toString());
                }
                n nVar = new n(property, property2, property3);
                l.a((Closeable) inputStream);
                return nVar;
            } catch (IOException e2) {
                e = e2;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error when parsing fabric properties ");
                    sb2.append(zipEntry.getName());
                    f.e().b("Fabric", sb2.toString(), e);
                    l.a((Closeable) inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    l.a((Closeable) inputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Error when parsing fabric properties ");
            sb22.append(zipEntry.getName());
            f.e().b("Fabric", sb22.toString(), e);
            l.a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            l.a((Closeable) inputStream);
            throw th;
        }
    }

    private Map<String, n> b() {
        HashMap hashMap = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            n nVar = new n("com.google.firebase.firebase-ads", "0.0.0", "binary");
            hashMap.put(nVar.b(), nVar);
            f.e().c("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private Map<String, n> c() throws Exception {
        HashMap hashMap = new HashMap();
        ZipFile a2 = a();
        Enumeration entries = a2.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > 7) {
                n a3 = a(zipEntry, a2);
                if (a3 != null) {
                    hashMap.put(a3.b(), a3);
                    f.e().c("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a3.b(), a3.c()}));
                }
            }
        }
        if (a2 != null) {
            try {
                a2.close();
            } catch (IOException unused) {
            }
        }
        return hashMap;
    }

    public Map<String, n> call() throws Exception {
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(b());
        hashMap.putAll(c());
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("finish scanning in ");
        sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
        e2.c("Fabric", sb.toString());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public ZipFile a() throws IOException {
        return new ZipFile(this.f9023a);
    }
}
