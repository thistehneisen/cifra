package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.x;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.h reason: case insensitive filesystem */
/* compiled from: ChildHelper */
class C0222h {

    /* renamed from: a reason: collision with root package name */
    final b f1923a;

    /* renamed from: b reason: collision with root package name */
    final a f1924b = new a();

    /* renamed from: c reason: collision with root package name */
    final List<View> f1925c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.h$a */
    /* compiled from: ChildHelper */
    static class a {

        /* renamed from: a reason: collision with root package name */
        long f1926a = 0;

        /* renamed from: b reason: collision with root package name */
        a f1927b;

        a() {
        }

        private void b() {
            if (this.f1927b == null) {
                this.f1927b = new a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            if (i2 >= 64) {
                a aVar = this.f1927b;
                if (aVar != null) {
                    aVar.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f1926a &= ~(1 << i2);
        }

        /* access modifiers changed from: 0000 */
        public boolean c(int i2) {
            if (i2 >= 64) {
                b();
                return this.f1927b.c(i2 - 64);
            }
            return (this.f1926a & (1 << i2)) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean d(int i2) {
            if (i2 >= 64) {
                b();
                return this.f1927b.d(i2 - 64);
            }
            long j2 = 1 << i2;
            boolean z = (this.f1926a & j2) != 0;
            this.f1926a &= ~j2;
            long j3 = j2 - 1;
            long j4 = this.f1926a;
            this.f1926a = Long.rotateRight(j4 & (~j3), 1) | (j4 & j3);
            a aVar = this.f1927b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f1927b.d(0);
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public void e(int i2) {
            if (i2 >= 64) {
                b();
                this.f1927b.e(i2 - 64);
                return;
            }
            this.f1926a |= 1 << i2;
        }

        public String toString() {
            if (this.f1927b == null) {
                return Long.toBinaryString(this.f1926a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1927b.toString());
            sb.append("xx");
            sb.append(Long.toBinaryString(this.f1926a));
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        public int b(int i2) {
            a aVar = this.f1927b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.f1926a);
                }
                return Long.bitCount(this.f1926a & ((1 << i2) - 1));
            } else if (i2 < 64) {
                return Long.bitCount(this.f1926a & ((1 << i2) - 1));
            } else {
                return aVar.b(i2 - 64) + Long.bitCount(this.f1926a);
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            this.f1926a = 0;
            a aVar = this.f1927b;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, boolean z) {
            if (i2 >= 64) {
                b();
                this.f1927b.a(i2 - 64, z);
                return;
            }
            boolean z2 = (this.f1926a & Long.MIN_VALUE) != 0;
            long j2 = (1 << i2) - 1;
            long j3 = this.f1926a;
            this.f1926a = ((j3 & (~j2)) << 1) | (j3 & j2);
            if (z) {
                e(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f1927b != null) {
                b();
                this.f1927b.a(0, z2);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.h$b */
    /* compiled from: ChildHelper */
    interface b {
        int a();

        View a(int i2);

        void a(View view);

        void a(View view, int i2);

        void a(View view, int i2, LayoutParams layoutParams);

        int b(View view);

        void b();

        void b(int i2);

        x c(View view);

        void c(int i2);

        void d(View view);
    }

    C0222h(b bVar) {
        this.f1923a = bVar;
    }

    private int f(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int a2 = this.f1923a.a();
        int i3 = i2;
        while (i3 < a2) {
            int b2 = i2 - (i3 - this.f1924b.b(i3));
            if (b2 == 0) {
                while (this.f1924b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    private void g(View view) {
        this.f1925c.add(view);
        this.f1923a.a(view);
    }

    private boolean h(View view) {
        if (!this.f1925c.remove(view)) {
            return false;
        }
        this.f1923a.d(view);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: 0000 */
    public View b(int i2) {
        int size = this.f1925c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f1925c.get(i3);
            x c2 = this.f1923a.c(view);
            if (c2.getLayoutPosition() == i2 && !c2.isInvalid() && !c2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public View c(int i2) {
        return this.f1923a.a(f(i2));
    }

    /* access modifiers changed from: 0000 */
    public void d(View view) {
        int b2 = this.f1923a.b(view);
        if (b2 >= 0) {
            if (this.f1924b.d(b2)) {
                h(view);
            }
            this.f1923a.c(b2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void e(int i2) {
        int f2 = f(i2);
        View a2 = this.f1923a.a(f2);
        if (a2 != null) {
            if (this.f1924b.d(f2)) {
                h(a2);
            }
            this.f1923a.c(f2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1924b.toString());
        sb.append(", hidden list:");
        sb.append(this.f1925c.size());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, int i2, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = this.f1923a.a();
        } else {
            i3 = f(i2);
        }
        this.f1924b.a(i3, z);
        if (z) {
            g(view);
        }
        this.f1923a.a(view, i3);
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        this.f1924b.a();
        for (int size = this.f1925c.size() - 1; size >= 0; size--) {
            this.f1923a.d((View) this.f1925c.get(size));
            this.f1925c.remove(size);
        }
        this.f1923a.b();
    }

    /* access modifiers changed from: 0000 */
    public void f(View view) {
        int b2 = this.f1923a.b(view);
        if (b2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("view is not a child, cannot hide ");
            sb.append(view);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f1924b.c(b2)) {
            this.f1924b.a(b2);
            h(view);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trying to unhide a view that was not hidden");
            sb2.append(view);
            throw new RuntimeException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public View d(int i2) {
        return this.f1923a.a(i2);
    }

    /* access modifiers changed from: 0000 */
    public boolean e(View view) {
        int b2 = this.f1923a.b(view);
        if (b2 == -1) {
            h(view);
            return true;
        } else if (!this.f1924b.c(b2)) {
            return false;
        } else {
            this.f1924b.d(b2);
            h(view);
            this.f1923a.c(b2);
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(View view, int i2, LayoutParams layoutParams, boolean z) {
        int i3;
        if (i2 < 0) {
            i3 = this.f1923a.a();
        } else {
            i3 = f(i2);
        }
        this.f1924b.a(i3, z);
        if (z) {
            g(view);
        }
        this.f1923a.a(view, i3, layoutParams);
    }

    /* access modifiers changed from: 0000 */
    public int b() {
        return this.f1923a.a();
    }

    /* access modifiers changed from: 0000 */
    public int b(View view) {
        int b2 = this.f1923a.b(view);
        if (b2 != -1 && !this.f1924b.c(b2)) {
            return b2 - this.f1924b.b(b2);
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public boolean c(View view) {
        return this.f1925c.contains(view);
    }

    /* access modifiers changed from: 0000 */
    public int a() {
        return this.f1923a.a() - this.f1925c.size();
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2) {
        int f2 = f(i2);
        this.f1924b.d(f2);
        this.f1923a.b(f2);
    }

    /* access modifiers changed from: 0000 */
    public void a(View view) {
        int b2 = this.f1923a.b(view);
        if (b2 >= 0) {
            this.f1924b.e(b2);
            g(view);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("view is not a child, cannot hide ");
        sb.append(view);
        throw new IllegalArgumentException(sb.toString());
    }
}
