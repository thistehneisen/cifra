package io.fabric.sdk.android.a.e;

import io.fabric.sdk.android.a.d.b;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: DefaultCachedSettingsIo */
class j implements h {

    /* renamed from: a reason: collision with root package name */
    private final l f8930a;

    public j(l lVar) {
        this.f8930a = lVar;
    }

    public JSONObject a() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        String str = "Error while closing settings cache file.";
        String str2 = "Fabric";
        f.e().d(str2, "Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(new b(this.f8930a).a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(io.fabric.sdk.android.a.b.l.b((InputStream) fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        f.e().b(str2, "Failed to fetch cached settings", e);
                        io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream, str);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream2, str);
                        throw th;
                    }
                }
            } else {
                f.e().d(str2, "No cached settings found.");
                jSONObject = null;
            }
            io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream2, str);
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            f.e().b(str2, "Failed to fetch cached settings", e);
            io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream, str);
            return null;
        } catch (Throwable th3) {
            th = th3;
            io.fabric.sdk.android.a.b.l.a((Closeable) fileInputStream2, str);
            throw th;
        }
    }

    public void a(long j2, JSONObject jSONObject) {
        String str = "Failed to close settings writer.";
        String str2 = "Fabric";
        f.e().d(str2, "Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put("expires_at", j2);
                FileWriter fileWriter2 = new FileWriter(new File(new b(this.f8930a).a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    io.fabric.sdk.android.a.b.l.a((Closeable) fileWriter2, str);
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    try {
                        f.e().b(str2, "Failed to cache settings", e);
                        io.fabric.sdk.android.a.b.l.a((Closeable) fileWriter, str);
                    } catch (Throwable th) {
                        th = th;
                        io.fabric.sdk.android.a.b.l.a((Closeable) fileWriter, str);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    io.fabric.sdk.android.a.b.l.a((Closeable) fileWriter, str);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                f.e().b(str2, "Failed to cache settings", e);
                io.fabric.sdk.android.a.b.l.a((Closeable) fileWriter, str);
            }
        }
    }
}
