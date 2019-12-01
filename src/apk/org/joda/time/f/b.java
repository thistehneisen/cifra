package org.joda.time.f;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.joda.time.b.u;
import org.joda.time.g;

/* compiled from: DateTimeZoneBuilder */
public class b {

    /* compiled from: DateTimeZoneBuilder */
    private static final class a extends g {
        private static final long serialVersionUID = 6941492635554961361L;
        final d iEndRecurrence;
        final int iStandardOffset;
        final d iStartRecurrence;

        a(String str, int i2, d dVar, d dVar2) {
            super(str);
            this.iStandardOffset = i2;
            this.iStartRecurrence = dVar;
            this.iEndRecurrence = dVar2;
        }

        static a a(DataInput dataInput, String str) throws IOException {
            return new a(str, (int) b.a(dataInput), d.a(dataInput), d.a(dataInput));
        }

        private d i(long j2) {
            long j3;
            int i2 = this.iStandardOffset;
            d dVar = this.iStartRecurrence;
            d dVar2 = this.iEndRecurrence;
            try {
                j3 = dVar.a(j2, i2, dVar2.b());
            } catch (ArithmeticException | IllegalArgumentException unused) {
                j3 = j2;
            }
            try {
                j2 = dVar2.a(j2, i2, dVar.b());
            } catch (ArithmeticException | IllegalArgumentException unused2) {
            }
            return j3 > j2 ? dVar : dVar2;
        }

        public String b(long j2) {
            return i(j2).a();
        }

        public int c(long j2) {
            return this.iStandardOffset + i(j2).b();
        }

        public int e(long j2) {
            return this.iStandardOffset;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!c().equals(aVar.c()) || this.iStandardOffset != aVar.iStandardOffset || !this.iStartRecurrence.equals(aVar.iStartRecurrence) || !this.iEndRecurrence.equals(aVar.iEndRecurrence)) {
                z = false;
            }
            return z;
        }

        public boolean f() {
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (r5 < 0) goto L_0x0018;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0030  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        public long g(long j2) {
            long j3;
            long a2;
            int i2 = this.iStandardOffset;
            d dVar = this.iStartRecurrence;
            d dVar2 = this.iEndRecurrence;
            try {
                j3 = dVar.a(j2, i2, dVar2.b());
                if (j2 > 0) {
                }
            } catch (ArithmeticException | IllegalArgumentException unused) {
            }
            try {
                a2 = dVar2.a(j2, i2, dVar.b());
                if (j2 <= 0 || a2 >= 0) {
                    j2 = a2;
                }
            } catch (ArithmeticException | IllegalArgumentException unused2) {
            }
            return j3 <= j2 ? j2 : j3;
            j3 = j2;
            a2 = dVar2.a(j2, i2, dVar.b());
            j2 = a2;
            if (j3 <= j2) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if (r7 > 0) goto L_0x001b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
        public long h(long j2) {
            long j3;
            long b2;
            long j4 = j2 + 1;
            int i2 = this.iStandardOffset;
            d dVar = this.iStartRecurrence;
            d dVar2 = this.iEndRecurrence;
            try {
                j3 = dVar.b(j4, i2, dVar2.b());
                if (j4 < 0) {
                }
            } catch (ArithmeticException | IllegalArgumentException unused) {
            }
            try {
                b2 = dVar2.b(j4, i2, dVar.b());
                if (j4 >= 0 || b2 <= 0) {
                    j4 = b2;
                }
            } catch (ArithmeticException | IllegalArgumentException unused2) {
            }
            if (j3 > j4) {
                j4 = j3;
            }
            return j4 - 1;
            j3 = j4;
            b2 = dVar2.b(j4, i2, dVar.b());
            j4 = b2;
            if (j3 > j4) {
            }
            return j4 - 1;
        }
    }

    /* renamed from: org.joda.time.f.b$b reason: collision with other inner class name */
    /* compiled from: DateTimeZoneBuilder */
    private static final class C0127b {

        /* renamed from: a reason: collision with root package name */
        final char f10919a;

        /* renamed from: b reason: collision with root package name */
        final int f10920b;

        /* renamed from: c reason: collision with root package name */
        final int f10921c;

        /* renamed from: d reason: collision with root package name */
        final int f10922d;

        /* renamed from: e reason: collision with root package name */
        final boolean f10923e;

        /* renamed from: f reason: collision with root package name */
        final int f10924f;

        C0127b(char c2, int i2, int i3, int i4, boolean z, int i5) {
            if (c2 == 'u' || c2 == 'w' || c2 == 's') {
                this.f10919a = c2;
                this.f10920b = i2;
                this.f10921c = i3;
                this.f10922d = i4;
                this.f10923e = z;
                this.f10924f = i5;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown mode: ");
            sb.append(c2);
            throw new IllegalArgumentException(sb.toString());
        }

        static C0127b a(DataInput dataInput) throws IOException {
            C0127b bVar = new C0127b((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) b.a(dataInput));
            return bVar;
        }

        private long c(org.joda.time.a aVar, long j2) {
            try {
                return a(aVar, j2);
            } catch (IllegalArgumentException e2) {
                if (this.f10920b == 2 && this.f10921c == 29) {
                    while (!aVar.H().b(j2)) {
                        j2 = aVar.H().a(j2, -1);
                    }
                    return a(aVar, j2);
                }
                throw e2;
            }
        }

        private long d(org.joda.time.a aVar, long j2) {
            int a2 = this.f10922d - aVar.f().a(j2);
            if (a2 == 0) {
                return j2;
            }
            if (this.f10923e) {
                if (a2 < 0) {
                    a2 += 7;
                }
            } else if (a2 > 0) {
                a2 -= 7;
            }
            return aVar.f().a(j2, a2);
        }

        public long b(long j2, int i2, int i3) {
            char c2 = this.f10919a;
            if (c2 == 'w') {
                i2 += i3;
            } else if (c2 != 's') {
                i2 = 0;
            }
            long j3 = (long) i2;
            long j4 = j2 + j3;
            u O = u.O();
            long c3 = c(O, O.r().a(O.r().b(O.w().b(j4, this.f10920b), 0), this.f10924f));
            if (this.f10922d != 0) {
                c3 = d(O, c3);
                if (c3 >= j4) {
                    c3 = d(O, c(O, O.w().b(O.H().a(c3, -1), this.f10920b)));
                }
            } else if (c3 >= j4) {
                c3 = c(O, O.H().a(c3, -1));
            }
            return O.r().a(O.r().b(c3, 0), this.f10924f) - j3;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0127b)) {
                return false;
            }
            C0127b bVar = (C0127b) obj;
            if (!(this.f10919a == bVar.f10919a && this.f10920b == bVar.f10920b && this.f10921c == bVar.f10921c && this.f10922d == bVar.f10922d && this.f10923e == bVar.f10923e && this.f10924f == bVar.f10924f)) {
                z = false;
            }
            return z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[OfYear]\nMode: ");
            sb.append(this.f10919a);
            sb.append(10);
            sb.append("MonthOfYear: ");
            sb.append(this.f10920b);
            sb.append(10);
            sb.append("DayOfMonth: ");
            sb.append(this.f10921c);
            sb.append(10);
            sb.append("DayOfWeek: ");
            sb.append(this.f10922d);
            sb.append(10);
            sb.append("AdvanceDayOfWeek: ");
            sb.append(this.f10923e);
            sb.append(10);
            sb.append("MillisOfDay: ");
            sb.append(this.f10924f);
            sb.append(10);
            return sb.toString();
        }

        public long a(long j2, int i2, int i3) {
            char c2 = this.f10919a;
            if (c2 == 'w') {
                i2 += i3;
            } else if (c2 != 's') {
                i2 = 0;
            }
            long j3 = (long) i2;
            long j4 = j2 + j3;
            u O = u.O();
            long b2 = b(O, O.r().a(O.r().b(O.w().b(j4, this.f10920b), 0), this.f10924f));
            if (this.f10922d != 0) {
                b2 = d(O, b2);
                if (b2 <= j4) {
                    b2 = d(O, b(O, O.w().b(O.H().a(b2, 1), this.f10920b)));
                }
            } else if (b2 <= j4) {
                b2 = b(O, O.H().a(b2, 1));
            }
            return O.r().a(O.r().b(b2, 0), this.f10924f) - j3;
        }

        private long b(org.joda.time.a aVar, long j2) {
            try {
                return a(aVar, j2);
            } catch (IllegalArgumentException e2) {
                if (this.f10920b == 2 && this.f10921c == 29) {
                    while (!aVar.H().b(j2)) {
                        j2 = aVar.H().a(j2, 1);
                    }
                    return a(aVar, j2);
                }
                throw e2;
            }
        }

        private long a(org.joda.time.a aVar, long j2) {
            if (this.f10921c >= 0) {
                return aVar.e().b(j2, this.f10921c);
            }
            return aVar.e().a(aVar.w().a(aVar.e().b(j2, 1), 1), this.f10921c);
        }
    }

    /* compiled from: DateTimeZoneBuilder */
    private static final class c extends g {
        private static final long serialVersionUID = 7811976468055766265L;
        private final String[] iNameKeys;
        private final int[] iStandardOffsets;
        private final a iTailZone;
        private final long[] iTransitions;
        private final int[] iWallOffsets;

        private c(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, a aVar) {
            super(str);
            this.iTransitions = jArr;
            this.iWallOffsets = iArr;
            this.iStandardOffsets = iArr2;
            this.iNameKeys = strArr;
            this.iTailZone = aVar;
        }

        static c a(DataInput dataInput, String str) throws IOException {
            int i2;
            int readUnsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort];
            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                strArr[i3] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (int i4 = 0; i4 < readInt; i4++) {
                jArr[i4] = b.a(dataInput);
                iArr[i4] = (int) b.a(dataInput);
                iArr2[i4] = (int) b.a(dataInput);
                if (readUnsignedShort < 256) {
                    try {
                        i2 = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    i2 = dataInput.readUnsignedShort();
                }
                strArr2[i4] = strArr[i2];
            }
            c cVar = new c(str, jArr, iArr, iArr2, strArr2, dataInput.readBoolean() ? a.a(dataInput, str) : null);
            return cVar;
        }

        public String b(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                return this.iNameKeys[binarySearch];
            }
            int i2 = ~binarySearch;
            if (i2 < jArr.length) {
                return i2 > 0 ? this.iNameKeys[i2 - 1] : "UTC";
            }
            a aVar = this.iTailZone;
            if (aVar == null) {
                return this.iNameKeys[i2 - 1];
            }
            return aVar.b(j2);
        }

        public int c(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                return this.iWallOffsets[binarySearch];
            }
            int i2 = ~binarySearch;
            if (i2 >= jArr.length) {
                a aVar = this.iTailZone;
                if (aVar == null) {
                    return this.iWallOffsets[i2 - 1];
                }
                return aVar.c(j2);
            } else if (i2 > 0) {
                return this.iWallOffsets[i2 - 1];
            } else {
                return 0;
            }
        }

        public int e(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                return this.iStandardOffsets[binarySearch];
            }
            int i2 = ~binarySearch;
            if (i2 >= jArr.length) {
                a aVar = this.iTailZone;
                if (aVar == null) {
                    return this.iStandardOffsets[i2 - 1];
                }
                return aVar.e(j2);
            } else if (i2 > 0) {
                return this.iStandardOffsets[i2 - 1];
            } else {
                return 0;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (c().equals(cVar.c()) && Arrays.equals(this.iTransitions, cVar.iTransitions) && Arrays.equals(this.iNameKeys, cVar.iNameKeys) && Arrays.equals(this.iWallOffsets, cVar.iWallOffsets) && Arrays.equals(this.iStandardOffsets, cVar.iStandardOffsets)) {
                a aVar = this.iTailZone;
                if (aVar != null) {
                }
            }
            z = false;
            return z;
        }

        public boolean f() {
            return false;
        }

        public long g(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            int i2 = binarySearch >= 0 ? binarySearch + 1 : ~binarySearch;
            if (i2 < jArr.length) {
                return jArr[i2];
            }
            if (this.iTailZone == null) {
                return j2;
            }
            long j3 = jArr[jArr.length - 1];
            if (j2 < j3) {
                j2 = j3;
            }
            return this.iTailZone.g(j2);
        }

        public long h(long j2) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j2);
            if (binarySearch >= 0) {
                if (j2 > Long.MIN_VALUE) {
                    j2--;
                }
                return j2;
            }
            int i2 = ~binarySearch;
            if (i2 < jArr.length) {
                if (i2 > 0) {
                    long j3 = jArr[i2 - 1];
                    if (j3 > Long.MIN_VALUE) {
                        return j3 - 1;
                    }
                }
                return j2;
            }
            a aVar = this.iTailZone;
            if (aVar != null) {
                long h2 = aVar.h(j2);
                if (h2 < j2) {
                    return h2;
                }
            }
            long j4 = jArr[i2 - 1];
            return j4 > Long.MIN_VALUE ? j4 - 1 : j2;
        }
    }

    /* compiled from: DateTimeZoneBuilder */
    private static final class d {

        /* renamed from: a reason: collision with root package name */
        final C0127b f10925a;

        /* renamed from: b reason: collision with root package name */
        final String f10926b;

        /* renamed from: c reason: collision with root package name */
        final int f10927c;

        d(C0127b bVar, String str, int i2) {
            this.f10925a = bVar;
            this.f10926b = str;
            this.f10927c = i2;
        }

        static d a(DataInput dataInput) throws IOException {
            return new d(C0127b.a(dataInput), dataInput.readUTF(), (int) b.a(dataInput));
        }

        public long b(long j2, int i2, int i3) {
            return this.f10925a.b(j2, i2, i3);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f10927c != dVar.f10927c || !this.f10926b.equals(dVar.f10926b) || !this.f10925a.equals(dVar.f10925a)) {
                z = false;
            }
            return z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10925a);
            sb.append(" named ");
            sb.append(this.f10926b);
            sb.append(" at ");
            sb.append(this.f10927c);
            return sb.toString();
        }

        public long a(long j2, int i2, int i3) {
            return this.f10925a.a(j2, i2, i3);
        }

        public int b() {
            return this.f10927c;
        }

        public String a() {
            return this.f10926b;
        }
    }

    public static g a(InputStream inputStream, String str) throws IOException {
        if (inputStream instanceof DataInput) {
            return a((DataInput) inputStream, str);
        }
        return a((DataInput) new DataInputStream(inputStream), str);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [org.joda.time.g] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static g a(DataInput dataInput, String str) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 67) {
            return a.b((g) c.a(dataInput, str));
        }
        if (readUnsignedByte == 70) {
            d dVar = new d(str, dataInput.readUTF(), (int) a(dataInput), (int) a(dataInput));
            if (dVar.equals(g.f10938a)) {
                dVar = g.f10938a;
            }
            return dVar;
        } else if (readUnsignedByte == 80) {
            return c.a(dataInput, str);
        } else {
            throw new IOException("Invalid encoding");
        }
    }

    static long a(DataInput dataInput) throws IOException {
        long readUnsignedByte;
        long j2;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i2 = readUnsignedByte2 >> 6;
        if (i2 == 1) {
            readUnsignedByte = (long) (dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8));
            j2 = 60000;
        } else if (i2 == 2) {
            readUnsignedByte = ((((long) readUnsignedByte2) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24)) | ((long) (dataInput.readUnsignedByte() << 16)) | ((long) (dataInput.readUnsignedByte() << 8)) | ((long) dataInput.readUnsignedByte());
            j2 = 1000;
        } else if (i2 == 3) {
            return dataInput.readLong();
        } else {
            readUnsignedByte = (long) ((readUnsignedByte2 << 26) >> 26);
            j2 = 1800000;
        }
        return readUnsignedByte * j2;
    }
}
