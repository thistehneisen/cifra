package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import b.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.ha reason: case insensitive filesystem */
public final class C0368ha implements C0392la {

    /* renamed from: a reason: collision with root package name */
    static final Map<Uri, C0368ha> f5207a = new b();

    /* renamed from: b reason: collision with root package name */
    private static final String[] f5208b = {"key", "value"};

    /* renamed from: c reason: collision with root package name */
    private final ContentResolver f5209c;

    /* renamed from: d reason: collision with root package name */
    private final Uri f5210d;

    /* renamed from: e reason: collision with root package name */
    private final Object f5211e = new Object();

    /* renamed from: f reason: collision with root package name */
    private volatile Map<String, String> f5212f;

    /* renamed from: g reason: collision with root package name */
    private final List<C0398ma> f5213g = new ArrayList();

    private C0368ha(ContentResolver contentResolver, Uri uri) {
        this.f5209c = contentResolver;
        this.f5210d = uri;
        this.f5209c.registerContentObserver(uri, false, new C0380ja(this, null));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    public static C0368ha a(ContentResolver contentResolver, Uri uri) {
        C0368ha haVar;
        synchronized (C0368ha.class) {
            haVar = (C0368ha) f5207a.get(uri);
            if (haVar == null) {
                C0368ha haVar2 = new C0368ha(contentResolver, uri);
                try {
                    f5207a.put(uri, haVar2);
                } catch (SecurityException unused) {
                }
                haVar = haVar2;
            }
        }
        return haVar;
    }

    private final Map<String, String> d() {
        try {
            return (Map) C0410oa.a(new C0386ka(this));
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    public final void b() {
        synchronized (this.f5211e) {
            this.f5212f = null;
            C0439ta.b();
        }
        synchronized (this) {
            for (C0398ma a2 : this.f5213g) {
                a2.a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Map c() {
        Map map;
        Cursor query = this.f5209c.query(this.f5210d, f5208b, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new b(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }

    public final Map<String, String> a() {
        Map<String, String> map = this.f5212f;
        if (map == null) {
            synchronized (this.f5211e) {
                map = this.f5212f;
                if (map == null) {
                    map = d();
                    this.f5212f = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final /* synthetic */ Object a(String str) {
        return (String) a().get(str);
    }
}
