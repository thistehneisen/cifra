package io.intercom.com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import io.intercom.com.bumptech.glide.h.j;

/* compiled from: AttributeStrategy */
class c implements l {

    /* renamed from: a reason: collision with root package name */
    private final b f9761a = new b();

    /* renamed from: b reason: collision with root package name */
    private final h<a, Bitmap> f9762b = new h<>();

    /* compiled from: AttributeStrategy */
    static class a implements m {

        /* renamed from: a reason: collision with root package name */
        private final b f9763a;

        /* renamed from: b reason: collision with root package name */
        private int f9764b;

        /* renamed from: c reason: collision with root package name */
        private int f9765c;

        /* renamed from: d reason: collision with root package name */
        private Config f9766d;

        public a(b bVar) {
            this.f9763a = bVar;
        }

        public void a(int i2, int i3, Config config) {
            this.f9764b = i2;
            this.f9765c = i3;
            this.f9766d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f9764b == aVar.f9764b && this.f9765c == aVar.f9765c && this.f9766d == aVar.f9766d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f9764b * 31) + this.f9765c) * 31;
            Config config = this.f9766d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.b(this.f9764b, this.f9765c, this.f9766d);
        }

        public void a() {
            this.f9763a.a(this);
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
        this.f9762b.a(this.f9761a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public int b(Bitmap bitmap) {
        return j.a(bitmap);
    }

    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    public Bitmap get(int i2, int i3, Config config) {
        return (Bitmap) this.f9762b.a(this.f9761a.a(i2, i3, config));
    }

    public Bitmap removeLast() {
        return (Bitmap) this.f9762b.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeStrategy:\n  ");
        sb.append(this.f9762b);
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
