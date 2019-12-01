package org.joda.time.f;

import org.joda.time.g;

/* compiled from: CachedDateTimeZone */
public class a extends g {

    /* renamed from: e reason: collision with root package name */
    private static final int f10911e;
    private static final long serialVersionUID = 5472298452022250685L;

    /* renamed from: f reason: collision with root package name */
    private final transient C0126a[] f10912f = new C0126a[(f10911e + 1)];
    private final g iZone;

    /* renamed from: org.joda.time.f.a$a reason: collision with other inner class name */
    /* compiled from: CachedDateTimeZone */
    private static final class C0126a {

        /* renamed from: a reason: collision with root package name */
        public final long f10913a;

        /* renamed from: b reason: collision with root package name */
        public final g f10914b;

        /* renamed from: c reason: collision with root package name */
        C0126a f10915c;

        /* renamed from: d reason: collision with root package name */
        private String f10916d;

        /* renamed from: e reason: collision with root package name */
        private int f10917e = Integer.MIN_VALUE;

        /* renamed from: f reason: collision with root package name */
        private int f10918f = Integer.MIN_VALUE;

        C0126a(g gVar, long j2) {
            this.f10913a = j2;
            this.f10914b = gVar;
        }

        public String a(long j2) {
            C0126a aVar = this.f10915c;
            if (aVar != null && j2 >= aVar.f10913a) {
                return aVar.a(j2);
            }
            if (this.f10916d == null) {
                this.f10916d = this.f10914b.b(this.f10913a);
            }
            return this.f10916d;
        }

        public int b(long j2) {
            C0126a aVar = this.f10915c;
            if (aVar != null && j2 >= aVar.f10913a) {
                return aVar.b(j2);
            }
            if (this.f10917e == Integer.MIN_VALUE) {
                this.f10917e = this.f10914b.c(this.f10913a);
            }
            return this.f10917e;
        }

        public int c(long j2) {
            C0126a aVar = this.f10915c;
            if (aVar != null && j2 >= aVar.f10913a) {
                return aVar.c(j2);
            }
            if (this.f10918f == Integer.MIN_VALUE) {
                this.f10918f = this.f10914b.e(this.f10913a);
            }
            return this.f10918f;
        }
    }

    static {
        Integer num;
        int i2;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException unused) {
            num = null;
        }
        if (num == null) {
            i2 = 512;
        } else {
            int i3 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i3++;
            }
            i2 = 1 << i3;
        }
        f10911e = i2 - 1;
    }

    private a(g gVar) {
        super(gVar.c());
        this.iZone = gVar;
    }

    public static a b(g gVar) {
        if (gVar instanceof a) {
            return (a) gVar;
        }
        return new a(gVar);
    }

    private C0126a i(long j2) {
        long j3 = j2 & -4294967296L;
        C0126a aVar = new C0126a(this.iZone, j3);
        long j4 = 4294967295L | j3;
        C0126a aVar2 = aVar;
        while (true) {
            long g2 = this.iZone.g(j3);
            if (g2 == j3 || g2 > j4) {
                return aVar;
            }
            C0126a aVar3 = new C0126a(this.iZone, g2);
            aVar2.f10915c = aVar3;
            aVar2 = aVar3;
            j3 = g2;
        }
        return aVar;
    }

    private C0126a j(long j2) {
        int i2 = (int) (j2 >> 32);
        C0126a[] aVarArr = this.f10912f;
        int i3 = f10911e & i2;
        C0126a aVar = aVarArr[i3];
        if (aVar != null && ((int) (aVar.f10913a >> 32)) == i2) {
            return aVar;
        }
        C0126a i4 = i(j2);
        aVarArr[i3] = i4;
        return i4;
    }

    public int c(long j2) {
        return j(j2).b(j2);
    }

    public int e(long j2) {
        return j(j2).c(j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.iZone.equals(((a) obj).iZone);
        }
        return false;
    }

    public boolean f() {
        return this.iZone.f();
    }

    public long g(long j2) {
        return this.iZone.g(j2);
    }

    public long h(long j2) {
        return this.iZone.h(j2);
    }

    public int hashCode() {
        return this.iZone.hashCode();
    }

    public String b(long j2) {
        return j(j2).a(j2);
    }
}
