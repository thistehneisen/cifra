package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.h.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy */
public class o implements l {

    /* renamed from: a reason: collision with root package name */
    private static final Config[] f3934a;

    /* renamed from: b reason: collision with root package name */
    private static final Config[] f3935b = f3934a;

    /* renamed from: c reason: collision with root package name */
    private static final Config[] f3936c = {Config.RGB_565};

    /* renamed from: d reason: collision with root package name */
    private static final Config[] f3937d = {Config.ARGB_4444};

    /* renamed from: e reason: collision with root package name */
    private static final Config[] f3938e = {Config.ALPHA_8};

    /* renamed from: f reason: collision with root package name */
    private final b f3939f = new b();

    /* renamed from: g reason: collision with root package name */
    private final h<a, Bitmap> f3940g = new h<>();

    /* renamed from: h reason: collision with root package name */
    private final Map<Config, NavigableMap<Integer, Integer>> f3941h = new HashMap();

    /* compiled from: SizeConfigStrategy */
    static final class a implements m {

        /* renamed from: a reason: collision with root package name */
        private final b f3942a;

        /* renamed from: b reason: collision with root package name */
        int f3943b;

        /* renamed from: c reason: collision with root package name */
        private Config f3944c;

        public a(b bVar) {
            this.f3942a = bVar;
        }

        public void a(int i2, Config config) {
            this.f3943b = i2;
            this.f3944c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3943b != aVar.f3943b || !n.b((Object) this.f3944c, (Object) aVar.f3944c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f3943b * 31;
            Config config = this.f3944c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.a(this.f3943b, this.f3944c);
        }

        public void a() {
            this.f3942a.a(this);
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

    static {
        Config[] configArr = {Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            configArr = (Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Config.RGBA_F16;
        }
        f3934a = configArr;
    }

    private a b(int i2, Config config) {
        a a2 = this.f3939f.a(i2, config);
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
                this.f3939f.a(a2);
                return this.f3939f.a(num.intValue(), config2);
            }
        }
        return a2;
    }

    public void a(Bitmap bitmap) {
        a a2 = this.f3939f.a(n.a(bitmap), bitmap.getConfig());
        this.f3940g.a(a2, bitmap);
        NavigableMap b2 = b(bitmap.getConfig());
        Integer num = (Integer) b2.get(Integer.valueOf(a2.f3943b));
        Integer valueOf = Integer.valueOf(a2.f3943b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        b2.put(valueOf, Integer.valueOf(i2));
    }

    public String c(Bitmap bitmap) {
        return a(n.a(bitmap), bitmap.getConfig());
    }

    public Bitmap get(int i2, int i3, Config config) {
        a b2 = b(n.a(i2, i3, config), config);
        Bitmap bitmap = (Bitmap) this.f3940g.a(b2);
        if (bitmap != null) {
            a(Integer.valueOf(b2.f3943b), bitmap);
            bitmap.reconfigure(i2, i3, config);
        }
        return bitmap;
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f3940g.a();
        if (bitmap != null) {
            a(Integer.valueOf(n.a(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f3940g);
        sb.append(", sortedSizes=(");
        for (Entry entry : this.f3941h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f3941h.isEmpty()) {
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
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f3941h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f3941h.put(config, treeMap);
        return treeMap;
    }

    public int b(Bitmap bitmap) {
        return n.a(bitmap);
    }

    public String a(int i2, int i3, Config config) {
        return a(n.a(i2, i3, config), config);
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
        if (VERSION.SDK_INT >= 26 && Config.RGBA_F16.equals(config)) {
            return f3935b;
        }
        int i2 = n.f3933a[config.ordinal()];
        if (i2 == 1) {
            return f3934a;
        }
        if (i2 == 2) {
            return f3936c;
        }
        if (i2 == 3) {
            return f3937d;
        }
        if (i2 == 4) {
            return f3938e;
        }
        return new Config[]{config};
    }
}
