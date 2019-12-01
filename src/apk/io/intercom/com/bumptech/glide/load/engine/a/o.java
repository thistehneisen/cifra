package io.intercom.com.bumptech.glide.load.engine.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import io.intercom.com.bumptech.glide.h.j;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
/* compiled from: SizeConfigStrategy */
public class o implements l {

    /* renamed from: a reason: collision with root package name */
    private static final Config[] f9795a = {Config.ARGB_8888, null};

    /* renamed from: b reason: collision with root package name */
    private static final Config[] f9796b = {Config.RGB_565};

    /* renamed from: c reason: collision with root package name */
    private static final Config[] f9797c = {Config.ARGB_4444};

    /* renamed from: d reason: collision with root package name */
    private static final Config[] f9798d = {Config.ALPHA_8};

    /* renamed from: e reason: collision with root package name */
    private final b f9799e = new b();

    /* renamed from: f reason: collision with root package name */
    private final h<a, Bitmap> f9800f = new h<>();

    /* renamed from: g reason: collision with root package name */
    private final Map<Config, NavigableMap<Integer, Integer>> f9801g = new HashMap();

    /* compiled from: SizeConfigStrategy */
    static final class a implements m {

        /* renamed from: a reason: collision with root package name */
        private final b f9802a;

        /* renamed from: b reason: collision with root package name */
        int f9803b;

        /* renamed from: c reason: collision with root package name */
        private Config f9804c;

        public a(b bVar) {
            this.f9802a = bVar;
        }

        public void a(int i2, Config config) {
            this.f9803b = i2;
            this.f9804c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f9803b != aVar.f9803b || !j.b((Object) this.f9804c, (Object) aVar.f9804c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f9803b * 31;
            Config config = this.f9804c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.a(this.f9803b, this.f9804c);
        }

        public void a() {
            this.f9802a.a(this);
        }
    }

    /* compiled from: SizeConfigStrategy */
    static class b extends d<a> {
        b() {
        }

        public a a(int i2, Config config) {
            a aVar = (a) b();
            aVar.a(i2, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public a a() {
            return new a(this);
        }
    }

    private a b(int i2, Config config) {
        a a2 = this.f9799e.a(i2, config);
        Config[] a3 = a(config);
        int length = a3.length;
        int i3 = 0;
        while (i3 < length) {
            Config config2 = a3[i3];
            Integer num = (Integer) b(config2).ceilingKey(Integer.valueOf(i2));
            if (num == null || num.intValue() > i2 * 8) {
                i3++;
            } else {
                if (num.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f9799e.a(a2);
                return this.f9799e.a(num.intValue(), config2);
            }
        }
        return a2;
    }

    public void a(Bitmap bitmap) {
        a a2 = this.f9799e.a(j.a(bitmap), bitmap.getConfig());
        this.f9800f.a(a2, bitmap);
        NavigableMap b2 = b(bitmap.getConfig());
        Integer num = (Integer) b2.get(Integer.valueOf(a2.f9803b));
        Integer valueOf = Integer.valueOf(a2.f9803b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        b2.put(valueOf, Integer.valueOf(i2));
    }

    public String c(Bitmap bitmap) {
        return a(j.a(bitmap), bitmap.getConfig());
    }

    public Bitmap get(int i2, int i3, Config config) {
        a b2 = b(j.a(i2, i3, config), config);
        Bitmap bitmap = (Bitmap) this.f9800f.a(b2);
        if (bitmap != null) {
            a(Integer.valueOf(b2.f9803b), bitmap);
            bitmap.reconfigure(i2, i3, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        }
        return bitmap;
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f9800f.a();
        if (bitmap != null) {
            a(Integer.valueOf(j.a(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f9800f);
        sb.append(", sortedSizes=(");
        for (Entry entry : this.f9801g.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f9801g.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap b2 = b(bitmap.getConfig());
        Integer num2 = (Integer) b2.get(num);
        if (num2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(num);
            sb.append(", removed: ");
            sb.append(c(bitmap));
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num2.intValue() == 1) {
            b2.remove(num);
        } else {
            b2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> b(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f9801g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9801g.put(config, treeMap);
        return treeMap;
    }

    public int b(Bitmap bitmap) {
        return j.a(bitmap);
    }

    public String a(int i2, int i3, Config config) {
        return a(j.a(i2, i3, config), config);
    }

    static String a(int i2, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i2);
        sb.append("](");
        sb.append(config);
        sb.append(")");
        return sb.toString();
    }

    private static Config[] a(Config config) {
        int i2 = n.f9794a[config.ordinal()];
        if (i2 == 1) {
            return f9795a;
        }
        if (i2 == 2) {
            return f9796b;
        }
        if (i2 == 3) {
            return f9797c;
        }
        if (i2 == 4) {
            return f9798d;
        }
        return new Config[]{config};
    }
}
