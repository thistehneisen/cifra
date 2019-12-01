package io.fabric.sdk.android.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* compiled from: IdManager */
public class y {

    /* renamed from: a reason: collision with root package name */
    private static final Pattern f8858a = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: b reason: collision with root package name */
    private static final String f8859b = Pattern.quote(Constants.URL_PATH_DELIMITER);

    /* renamed from: c reason: collision with root package name */
    private final ReentrantLock f8860c = new ReentrantLock();

    /* renamed from: d reason: collision with root package name */
    private final A f8861d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f8862e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f8863f;

    /* renamed from: g reason: collision with root package name */
    private final Context f8864g;

    /* renamed from: h reason: collision with root package name */
    private final String f8865h;

    /* renamed from: i reason: collision with root package name */
    private final String f8866i;

    /* renamed from: j reason: collision with root package name */
    private final Collection<l> f8867j;

    /* renamed from: k reason: collision with root package name */
    C0733d f8868k;

    /* renamed from: l reason: collision with root package name */
    C0731b f8869l;
    boolean m;
    x n;

    /* compiled from: IdManager */
    public enum a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int protobufIndex;

        private a(int i2) {
            this.protobufIndex = i2;
        }
    }

    public y(Context context, String str, String str2, Collection<l> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection != null) {
            this.f8864g = context;
            this.f8865h = str;
            this.f8866i = str2;
            this.f8867j = collection;
            this.f8861d = new A();
            this.f8868k = new C0733d(context);
            this.n = new x();
            this.f8862e = l.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            String str3 = "Fabric";
            if (!this.f8862e) {
                o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Device ID collection disabled for ");
                sb.append(context.getPackageName());
                e2.d(str3, sb.toString());
            }
            this.f8863f = l.a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f8863f) {
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("User information collection disabled for ");
                sb2.append(context.getPackageName());
                e3.d(str3, sb2.toString());
            }
        } else {
            throw new IllegalArgumentException("kits must not be null");
        }
    }

    private String b(String str) {
        return str.replaceAll(f8859b, "");
    }

    private Boolean m() {
        C0731b b2 = b();
        if (b2 != null) {
            return Boolean.valueOf(b2.f8808b);
        }
        return null;
    }

    public boolean a() {
        return this.f8863f;
    }

    public String c() {
        return this.f8865h;
    }

    public String d() {
        String str = this.f8866i;
        if (str != null) {
            return str;
        }
        SharedPreferences i2 = l.i(this.f8864g);
        a(i2);
        String string = i2.getString("crashlytics.installation.id", null);
        return string == null ? b(i2) : string;
    }

    public Map<a, String> e() {
        HashMap hashMap = new HashMap();
        for (l lVar : this.f8867j) {
            if (lVar instanceof q) {
                for (Entry entry : ((q) lVar).getDeviceIdentifiers().entrySet()) {
                    a(hashMap, (a) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String f() {
        return this.f8861d.a(this.f8864g);
    }

    public String g() {
        return String.format(Locale.US, "%s/%s", new Object[]{b(Build.MANUFACTURER), b(Build.MODEL)});
    }

    public String h() {
        return b(VERSION.INCREMENTAL);
    }

    public String i() {
        return b(VERSION.RELEASE);
    }

    public String j() {
        StringBuilder sb = new StringBuilder();
        sb.append(i());
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(h());
        return sb.toString();
    }

    public Boolean k() {
        if (l()) {
            return m();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return this.f8862e && !this.n.e(this.f8864g);
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return f8858a.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    @SuppressLint({"CommitPrefEdits"})
    private String b(SharedPreferences sharedPreferences) {
        String str = "crashlytics.installation.id";
        this.f8860c.lock();
        try {
            String string = sharedPreferences.getString(str, null);
            if (string == null) {
                string = a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString(str, string).commit();
            }
            return string;
        } finally {
            this.f8860c.unlock();
        }
    }

    private void a(SharedPreferences sharedPreferences) {
        C0731b b2 = b();
        if (b2 != null) {
            a(sharedPreferences, b2.f8807a);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private void a(SharedPreferences sharedPreferences, String str) {
        String str2 = "crashlytics.advertising.id";
        this.f8860c.lock();
        try {
            if (!TextUtils.isEmpty(str)) {
                String string = sharedPreferences.getString(str2, null);
                if (TextUtils.isEmpty(string)) {
                    sharedPreferences.edit().putString(str2, str).commit();
                } else if (!string.equals(str)) {
                    sharedPreferences.edit().remove("crashlytics.installation.id").putString(str2, str).commit();
                }
                this.f8860c.unlock();
            }
        } finally {
            this.f8860c.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized C0731b b() {
        if (!this.m) {
            this.f8869l = this.f8868k.a();
            this.m = true;
        }
        return this.f8869l;
    }

    private void a(Map<a, String> map, a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }
}
