package io.fabric.sdk.android.a.e;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.a.b.n;
import io.fabric.sdk.android.a.b.o;
import io.fabric.sdk.android.a.d.c;
import io.fabric.sdk.android.a.d.d;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController */
class k implements u {

    /* renamed from: a reason: collision with root package name */
    private final y f8931a;

    /* renamed from: b reason: collision with root package name */
    private final x f8932b;

    /* renamed from: c reason: collision with root package name */
    private final n f8933c;

    /* renamed from: d reason: collision with root package name */
    private final h f8934d;

    /* renamed from: e reason: collision with root package name */
    private final z f8935e;

    /* renamed from: f reason: collision with root package name */
    private final l f8936f;

    /* renamed from: g reason: collision with root package name */
    private final c f8937g = new d(this.f8936f);

    /* renamed from: h reason: collision with root package name */
    private final o f8938h;

    public k(l lVar, y yVar, n nVar, x xVar, h hVar, z zVar, o oVar) {
        this.f8936f = lVar;
        this.f8931a = yVar;
        this.f8933c = nVar;
        this.f8932b = xVar;
        this.f8934d = hVar;
        this.f8935e = zVar;
        this.f8938h = oVar;
    }

    private v b(t tVar) {
        String str = "Fabric";
        v vVar = null;
        try {
            if (t.SKIP_CACHE_LOOKUP.equals(tVar)) {
                return null;
            }
            JSONObject a2 = this.f8934d.a();
            if (a2 != null) {
                v a3 = this.f8932b.a(this.f8933c, a2);
                if (a3 != null) {
                    a(a2, "Loaded cached settings: ");
                    long a4 = this.f8933c.a();
                    if (!t.IGNORE_CACHE_EXPIRATION.equals(tVar)) {
                        if (a3.a(a4)) {
                            f.e().d(str, "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        f.e().d(str, "Returning cached settings.");
                        return a3;
                    } catch (Exception e2) {
                        e = e2;
                        vVar = a3;
                        f.e().b(str, "Failed to get cached settings", e);
                        return vVar;
                    }
                } else {
                    f.e().b(str, "Failed to transform cached settings data.", null);
                    return null;
                }
            } else {
                f.e().d(str, "No cached settings data found.");
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            f.e().b(str, "Failed to get cached settings", e);
            return vVar;
        }
    }

    public v a() {
        return a(t.USE_CACHE);
    }

    /* access modifiers changed from: 0000 */
    public String c() {
        return io.fabric.sdk.android.a.b.l.a(io.fabric.sdk.android.a.b.l.n(this.f8936f.getContext()));
    }

    /* access modifiers changed from: 0000 */
    public String d() {
        return this.f8937g.get().getString("existing_instance_identifier", "");
    }

    public v a(t tVar) {
        String str = "Fabric";
        v vVar = null;
        if (!this.f8938h.a()) {
            f.e().d(str, "Not fetching settings, because data collection is disabled by Firebase.");
            return null;
        }
        try {
            if (!f.g() && !b()) {
                vVar = b(tVar);
            }
            if (vVar == null) {
                JSONObject a2 = this.f8935e.a(this.f8931a);
                if (a2 != null) {
                    vVar = this.f8932b.a(this.f8933c, a2);
                    this.f8934d.a(vVar.f8977g, a2);
                    a(a2, "Loaded settings: ");
                    a(c());
                }
            }
            if (vVar == null) {
                vVar = b(t.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e2) {
            f.e().b(str, "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e2);
        }
        return vVar;
    }

    private void a(JSONObject jSONObject, String str) throws JSONException {
        io.fabric.sdk.android.o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jSONObject.toString());
        e2.d("Fabric", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        return !d().equals(c());
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"CommitPrefEdits"})
    public boolean a(String str) {
        Editor edit = this.f8937g.edit();
        edit.putString("existing_instance_identifier", str);
        return this.f8937g.a(edit);
    }
}
