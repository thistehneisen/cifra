package com.bumptech.glide.load.b;

import android.text.TextUtils;
import io.fabric.sdk.android.a.b.C0730a;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LazyHeaders */
public final class p implements n {

    /* renamed from: a reason: collision with root package name */
    private final Map<String, List<o>> f3655a;

    /* renamed from: b reason: collision with root package name */
    private volatile Map<String, String> f3656b;

    /* compiled from: LazyHeaders */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private static final String f3657a = b();

        /* renamed from: b reason: collision with root package name */
        private static final Map<String, List<o>> f3658b;

        /* renamed from: c reason: collision with root package name */
        private boolean f3659c = true;

        /* renamed from: d reason: collision with root package name */
        private Map<String, List<o>> f3660d = f3658b;

        /* renamed from: e reason: collision with root package name */
        private boolean f3661e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f3657a)) {
                hashMap.put(C0730a.HEADER_USER_AGENT, Collections.singletonList(new b(f3657a)));
            }
            f3658b = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public p a() {
            this.f3659c = true;
            return new p(this.f3660d);
        }
    }

    /* compiled from: LazyHeaders */
    static final class b implements o {

        /* renamed from: a reason: collision with root package name */
        private final String f3662a;

        b(String str) {
            this.f3662a = str;
        }

        public String a() {
            return this.f3662a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return this.f3662a.equals(((b) obj).f3662a);
        }

        public int hashCode() {
            return this.f3662a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringHeaderFactory{value='");
            sb.append(this.f3662a);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    p(Map<String, List<o>> map) {
        this.f3655a = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.f3655a.entrySet()) {
            String a2 = a((List) entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f3656b == null) {
            synchronized (this) {
                if (this.f3656b == null) {
                    this.f3656b = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f3656b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        return this.f3655a.equals(((p) obj).f3655a);
    }

    public int hashCode() {
        return this.f3655a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.f3655a);
        sb.append('}');
        return sb.toString();
    }

    private String a(List<o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = ((o) list.get(i2)).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
