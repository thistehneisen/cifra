package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.h.n;

/* compiled from: AttributeStrategy */
class c implements l {

    /* renamed from: a reason: collision with root package name */
    private final b f3900a = new b();

    /* renamed from: b reason: collision with root package name */
    private final h<a, Bitmap> f3901b = new h<>();

    /* compiled from: AttributeStrategy */
    static class a implements m {

        /* renamed from: a reason: collision with root package name */
        private final b f3902a;

        /* renamed from: b reason: collision with root package name */
        private int f3903b;

        /* renamed from: c reason: collision with root package name */
        private int f3904c;

        /* renamed from: d reason: collision with root package name */
        private Config f3905d;

        public a(b bVar) {
            this.f3902a = bVar;
        }

        public void a(int i2, int i3, Config config) {
            this.f3903b = i2;
            this.f3904c = i3;
            this.f3905d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3903b == aVar.f3903b && this.f3904c == aVar.f3904c && this.f3905d == aVar.f3905d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f3903b * 31) + this.f3904c) * 31;
            Config config = this.f3905d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.b(this.f3903b, this.f3904c, this.f3905d);
        }

        public void a() {
            this.f3902a.a(this);
        }
    }

    /* compiled from: AttributeStrategy */
    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: 0000 */
        public a a(int i2, int i3, Config config) {
            a aVar = (a) b();
            aVar.a(i2, i3, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public a a() {
            return new a(this);
        }
    }

    c() {
    }

    private static String d(Bitmap bitmap) {
        return b(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public void a(Bitmap bitmap) {
        this.f3901b.a(this.f3900a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public int b(Bitmap bitmap) {
        return n.a(bitmap);
    }

    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    public Bitmap get(int i2, int i3, Config config) {
        return (Bitmap) this.f3901b.a(this.f3900a.a(i2, i3, config));
    }

    public Bitmap removeLast() {
        return (Bitmap) this.f3901b.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeStrategy:\n  ");
        sb.append(this.f3901b);
        return sb.toString();
    }

    static String b(int i2, int i3, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        sb.append("], ");
        sb.append(config);
        return sb.toString();
    }

    public String a(int i2, int i3, Config config) {
        return b(i2, i3, config);
    }
}
