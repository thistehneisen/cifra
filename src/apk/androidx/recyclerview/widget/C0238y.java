package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.recyclerview.widget.y reason: case insensitive filesystem */
/* compiled from: GapWorker */
final class C0238y implements Runnable {

    /* renamed from: a reason: collision with root package name */
    static final ThreadLocal<C0238y> f2013a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    static Comparator<b> f2014b = new C0237x();

    /* renamed from: c reason: collision with root package name */
    ArrayList<RecyclerView> f2015c = new ArrayList<>();

    /* renamed from: d reason: collision with root package name */
    long f2016d;

    /* renamed from: e reason: collision with root package name */
    long f2017e;

    /* renamed from: f reason: collision with root package name */
    private ArrayList<b> f2018f = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.y$a */
    /* compiled from: GapWorker */
    static class a implements androidx.recyclerview.widget.RecyclerView.i.a {

        /* renamed from: a reason: collision with root package name */
        int f2019a;

        /* renamed from: b reason: collision with root package name */
        int f2020b;

        /* renamed from: c reason: collision with root package name */
        int[] f2021c;

        /* renamed from: d reason: collision with root package name */
        int f2022d;

        a() {
        }

        /* access modifiers changed from: 0000 */
        public void a(RecyclerView recyclerView, boolean z) {
            this.f2022d = 0;
            int[] iArr = this.f2021c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            i iVar = recyclerView.w;
            if (recyclerView.v != null && iVar != null && iVar.t()) {
                if (z) {
                    if (!recyclerView.n.c()) {
                        iVar.a(recyclerView.v.getItemCount(), (androidx.recyclerview.widget.RecyclerView.i.a) this);
                    }
                } else if (!recyclerView.j()) {
                    iVar.a(this.f2019a, this.f2020b, recyclerView.ra, (androidx.recyclerview.widget.RecyclerView.i.a) this);
                }
                int i2 = this.f2022d;
                if (i2 > iVar.m) {
                    iVar.m = i2;
                    iVar.n = z;
                    recyclerView.f1744l.j();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void b(int i2, int i3) {
            this.f2019a = i2;
            this.f2020b = i3;
        }

        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f2022d * 2;
                int[] iArr = this.f2021c;
                if (iArr == null) {
                    this.f2021c = new int[4];
                    Arrays.fill(this.f2021c, -1);
                } else if (i4 >= iArr.length) {
                    this.f2021c = new int[(i4 * 2)];
                    System.arraycopy(iArr, 0, this.f2021c, 0, iArr.length);
                }
                int[] iArr2 = this.f2021c;
                iArr2[i4] = i2;
                iArr2[i4 + 1] = i3;
                this.f2022d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(int i2) {
            if (this.f2021c != null) {
                int i3 = this.f2022d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f2021c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            int[] iArr = this.f2021c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2022d = 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.y$b */
    /* compiled from: GapWorker */
    static class b {

        /* renamed from: a reason: collision with root package name */
        public boolean f2023a;

        /* renamed from: b reason: collision with root package name */
        public int f2024b;

        /* renamed from: c reason: collision with root package name */
        public int f2025c;

        /* renamed from: d reason: collision with root package name */
        public RecyclerView f2026d;

        /* renamed from: e reason: collision with root package name */
        public int f2027e;

        b() {
        }

        public void a() {
            this.f2023a = false;
            this.f2024b = 0;
            this.f2025c = 0;
            this.f2026d = null;
            this.f2027e = 0;
        }
    }

    C0238y() {
    }

    public void a(RecyclerView recyclerView) {
        this.f2015c.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f2015c.remove(recyclerView);
    }

    public void run() {
        try {
            androidx.core.os.b.a("RV Prefetch");
            if (!this.f2015c.isEmpty()) {
                int size = this.f2015c.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = (RecyclerView) this.f2015c.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j2) + this.f2017e);
                    this.f2016d = 0;
                    androidx.core.os.b.a();
                }
            }
        } finally {
            this.f2016d = 0;
            androidx.core.os.b.a();
        }
    }

    private void b(long j2) {
        int i2 = 0;
        while (i2 < this.f2018f.size()) {
            b bVar = (b) this.f2018f.get(i2);
            if (bVar.f2026d != null) {
                a(bVar, j2);
                bVar.a();
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f2016d == 0) {
            this.f2016d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.qa.b(i2, i3);
    }

    private void a() {
        b bVar;
        int size = this.f2015c.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = (RecyclerView) this.f2015c.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.qa.a(recyclerView, false);
                i2 += recyclerView.qa.f2022d;
            }
        }
        this.f2018f.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f2015c.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.qa;
                int abs = Math.abs(aVar.f2019a) + Math.abs(aVar.f2020b);
                int i6 = i4;
                for (int i7 = 0; i7 < aVar.f2022d * 2; i7 += 2) {
                    if (i6 >= this.f2018f.size()) {
                        bVar = new b();
                        this.f2018f.add(bVar);
                    } else {
                        bVar = (b) this.f2018f.get(i6);
                    }
                    int i8 = aVar.f2021c[i7 + 1];
                    bVar.f2023a = i8 <= abs;
                    bVar.f2024b = abs;
                    bVar.f2025c = i8;
                    bVar.f2026d = recyclerView2;
                    bVar.f2027e = aVar.f2021c[i7];
                    i6++;
                }
                i4 = i6;
            }
        }
        Collections.sort(this.f2018f, f2014b);
    }

    static boolean a(RecyclerView recyclerView, int i2) {
        int b2 = recyclerView.o.b();
        for (int i3 = 0; i3 < b2; i3++) {
            x i4 = RecyclerView.i(recyclerView.o.d(i3));
            if (i4.mPosition == i2 && !i4.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private x a(RecyclerView recyclerView, int i2, long j2) {
        if (a(recyclerView, i2)) {
            return null;
        }
        p pVar = recyclerView.f1744l;
        try {
            recyclerView.r();
            x a2 = pVar.a(i2, false, j2);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    pVar.a(a2, false);
                } else {
                    pVar.b(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.a(false);
        }
    }

    private void a(RecyclerView recyclerView, long j2) {
        if (recyclerView != null) {
            if (recyclerView.N && recyclerView.o.b() != 0) {
                recyclerView.u();
            }
            a aVar = recyclerView.qa;
            aVar.a(recyclerView, true);
            if (aVar.f2022d != 0) {
                try {
                    androidx.core.os.b.a("RV Nested Prefetch");
                    recyclerView.ra.a(recyclerView.v);
                    for (int i2 = 0; i2 < aVar.f2022d * 2; i2 += 2) {
                        a(recyclerView, aVar.f2021c[i2], j2);
                    }
                } finally {
                    androidx.core.os.b.a();
                }
            }
        }
    }

    private void a(b bVar, long j2) {
        x a2 = a(bVar.f2026d, bVar.f2027e, bVar.f2023a ? Long.MAX_VALUE : j2);
        if (a2 != null && a2.mNestedRecyclerView != null && a2.isBound() && !a2.isInvalid()) {
            a((RecyclerView) a2.mNestedRecyclerView.get(), j2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(long j2) {
        a();
        b(j2);
    }
}
