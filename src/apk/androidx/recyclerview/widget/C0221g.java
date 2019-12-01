package androidx.recyclerview.widget;

/* renamed from: androidx.recyclerview.widget.g reason: case insensitive filesystem */
/* compiled from: BatchingListUpdateCallback */
public class C0221g implements E {

    /* renamed from: a reason: collision with root package name */
    final E f1918a;

    /* renamed from: b reason: collision with root package name */
    int f1919b = 0;

    /* renamed from: c reason: collision with root package name */
    int f1920c = -1;

    /* renamed from: d reason: collision with root package name */
    int f1921d = -1;

    /* renamed from: e reason: collision with root package name */
    Object f1922e = null;

    public C0221g(E e2) {
        this.f1918a = e2;
    }

    public void a() {
        int i2 = this.f1919b;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f1918a.b(this.f1920c, this.f1921d);
            } else if (i2 == 2) {
                this.f1918a.c(this.f1920c, this.f1921d);
            } else if (i2 == 3) {
                this.f1918a.a(this.f1920c, this.f1921d, this.f1922e);
            }
            this.f1922e = null;
            this.f1919b = 0;
        }
    }

    public void b(int i2, int i3) {
        if (this.f1919b == 1) {
            int i4 = this.f1920c;
            if (i2 >= i4) {
                int i5 = this.f1921d;
                if (i2 <= i4 + i5) {
                    this.f1921d = i5 + i3;
                    this.f1920c = Math.min(i2, i4);
                    return;
                }
            }
        }
        a();
        this.f1920c = i2;
        this.f1921d = i3;
        this.f1919b = 1;
    }

    public void c(int i2, int i3) {
        if (this.f1919b == 2) {
            int i4 = this.f1920c;
            if (i4 >= i2 && i4 <= i2 + i3) {
                this.f1921d += i3;
                this.f1920c = i2;
                return;
            }
        }
        a();
        this.f1920c = i2;
        this.f1921d = i3;
        this.f1919b = 2;
    }

    public void a(int i2, int i3) {
        a();
        this.f1918a.a(i2, i3);
    }

    public void a(int i2, int i3, Object obj) {
        if (this.f1919b == 3) {
            int i4 = this.f1920c;
            int i5 = this.f1921d;
            if (i2 <= i4 + i5) {
                int i6 = i2 + i3;
                if (i6 >= i4 && this.f1922e == obj) {
                    int i7 = i5 + i4;
                    this.f1920c = Math.min(i2, i4);
                    this.f1921d = Math.max(i7, i6) - this.f1920c;
                    return;
                }
            }
        }
        a();
        this.f1920c = i2;
        this.f1921d = i3;
        this.f1922e = obj;
        this.f1919b = 3;
    }
}
