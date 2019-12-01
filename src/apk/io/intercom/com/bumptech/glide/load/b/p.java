package io.intercom.com.bumptech.glide.load.b;

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
    private final Map<String, List<o>> f9525a;

    /* renamed from: b reason: collision with root package name */
    private volatile Map<String, String> f9526b;

    /* compiled from: LazyHeaders */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private static final String f9527a = b();

        /* renamed from: b reason: collision with root package name */
        private static final Map<String, List<o>> f9528b;

        /* renamed from: c reason: collision with root package name */
        private boolean f9529c = true;

        /* renamed from: d reason: collision with root package name */
        private Map<String, List<o>> f9530d = f9528b;

        /* renamed from: e reason: collision with root package name */
        private boolean f9531e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f9527a)) {
                hashMap.put(C0730a.HEADER_USER_AGENT, Collections.singletonList(new b(f9527a)));
            }
            f9528b = Collections.unmodifiableMap(hashMap);
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
            this.f9529c = true;
            return new p(this.f9530d);
        }
    }

    /* compiled from: LazyHeaders */
    static final class b implements o {

        /* renamed from: a reason: collision with root package name */
        private final String f9532a;

        b(String str) {
            this.f9532a = str;
        }

        public String a() {
            return this.f9532a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return this.f9532a.equals(((b) obj).f9532a);
        }

        public int hashCode() {
            return this.f9532a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringHeaderFactory{value='");
            sb.append(this.f9532a);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    p(Map<String, List<o>> map) {
        this.f9525a = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.f9525a.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List list = (List) entry.getValue();
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
            if (!TextUtils.isEmpty(sb.toString())) {
                hashMap.put(entry.getKey(), sb.toString());
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f9526b == null) {
            synchronized (this) {
                if (this.f9526b == null) {
                    this.f9526b = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f9526b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        return this.f9525a.equals(((p) obj).f9525a);
    }

    public int hashCode() {
        return this.f9525a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.f9525a);
        sb.append('}');
        return sb.toString();
    }
}
