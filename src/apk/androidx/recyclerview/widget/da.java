package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck */
class da {

    /* renamed from: a reason: collision with root package name */
    final b f1893a;

    /* renamed from: b reason: collision with root package name */
    a f1894b = new a();

    /* compiled from: ViewBoundsCheck */
    static class a {

        /* renamed from: a reason: collision with root package name */
        int f1895a = 0;

        /* renamed from: b reason: collision with root package name */
        int f1896b;

        /* renamed from: c reason: collision with root package name */
        int f1897c;

        /* renamed from: d reason: collision with root package name */
        int f1898d;

        /* renamed from: e reason: collision with root package name */
        int f1899e;

        a() {
        }

        /* access modifiers changed from: 0000 */
        public int a(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, int i3, int i4, int i5) {
            this.f1896b = i2;
            this.f1897c = i3;
            this.f1898d = i4;
            this.f1899e = i5;
        }

        /* access modifiers changed from: 0000 */
        public void b() {
            this.f1895a = 0;
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            this.f1895a = i2 | this.f1895a;
        }

        /* access modifiers changed from: 0000 */
        public boolean a() {
            int i2 = this.f1895a;
            if ((i2 & 7) != 0 && (i2 & (a(this.f1898d, this.f1896b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f1895a;
            if ((i3 & 112) != 0 && (i3 & (a(this.f1898d, this.f1897c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f1895a;
            if ((i4 & 1792) != 0 && (i4 & (a(this.f1899e, this.f1896b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f1895a;
            if ((i5 & 28672) == 0 || (i5 & (a(this.f1899e, this.f1897c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: ViewBoundsCheck */
    interface b {
        int a();

        int a(View view);

        View a(int i2);

        int b();

        int b(View view);
    }

    da(b bVar) {
        this.f1893a = bVar;
    }

    /* access modifiers changed from: 0000 */
    public View a(int i2, int i3, int i4, int i5) {
        int a2 = this.f1893a.a();
        int b2 = this.f1893a.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a3 = this.f1893a.a(i2);
            this.f1894b.a(a2, b2, this.f1893a.a(a3), this.f1893a.b(a3));
            if (i4 != 0) {
                this.f1894b.b();
                this.f1894b.a(i4);
                if (this.f1894b.a()) {
                    return a3;
                }
            }
            if (i5 != 0) {
                this.f1894b.b();
                this.f1894b.a(i5);
                if (this.f1894b.a()) {
                    view = a3;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(View view, int i2) {
        this.f1894b.a(this.f1893a.a(), this.f1893a.b(), this.f1893a.a(view), this.f1893a.b(view));
        if (i2 == 0) {
            return false;
        }
        this.f1894b.b();
        this.f1894b.a(i2);
        return this.f1894b.a();
    }
}
