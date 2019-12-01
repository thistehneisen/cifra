package org.joda.time.b;

import org.joda.time.a;

/* compiled from: BasicGJChronology */
abstract class f extends c {
    private static final int[] da = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] ea = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] fa = new long[12];
    private static final long[] ga = new long[12];
    private static final long serialVersionUID = 538276888268L;

    static {
        long j2 = 0;
        int i2 = 0;
        long j3 = 0;
        while (i2 < 11) {
            j2 += ((long) da[i2]) * 86400000;
            int i3 = i2 + 1;
            fa[i3] = j2;
            j3 += ((long) ea[i2]) * 86400000;
            ga[i3] = j3;
            i2 = i3;
        }
    }

    f(a aVar, Object obj, int i2) {
        super(aVar, obj, i2);
    }

    /* access modifiers changed from: 0000 */
    public int a(int i2, int i3) {
        if (g(i2)) {
            return ea[i3 - 1];
        }
        return da[i3 - 1];
    }

    /* access modifiers changed from: 0000 */
    public long b(int i2, int i3) {
        if (g(i2)) {
            return ga[i3 - 1];
        }
        return fa[i3 - 1];
    }

    /* access modifiers changed from: 0000 */
    public int c(long j2, int i2) {
        if (i2 > 28 || i2 < 1) {
            return d(j2);
        }
        return 28;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r14 < 12825000) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r14 < 20587500) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r14 < 28265625) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007e, code lost:
        if (r14 < 12740625) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
        if (r14 < 20503125) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a6, code lost:
        if (r14 < 28181250) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return 11;
     */
    public int d(long j2, int i2) {
        int f2 = (int) ((j2 - f(i2)) >> 10);
        if (g(i2)) {
            if (f2 < 15356250) {
                if (f2 >= 7678125) {
                    if (f2 >= 10209375) {
                    }
                    return 4;
                } else if (f2 >= 2615625) {
                    if (f2 < 5062500) {
                        return 2;
                    }
                    return 3;
                }
            } else if (f2 < 23118750) {
                if (f2 >= 17971875) {
                }
                return 7;
            } else {
                if (f2 >= 25734375) {
                }
                return 10;
            }
        } else if (f2 < 15271875) {
            if (f2 >= 7593750) {
                if (f2 >= 10125000) {
                }
                return 4;
            } else if (f2 >= 2615625) {
                if (f2 < 4978125) {
                    return 2;
                }
                return 3;
            }
        } else if (f2 < 23034375) {
            if (f2 >= 17887500) {
            }
            return 7;
        } else {
            if (f2 >= 25650000) {
            }
            return 10;
        }
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public long f(long j2, int i2) {
        int i3 = i(j2);
        int b2 = b(j2, i3);
        int e2 = e(j2);
        if (b2 > 59) {
            if (g(i3)) {
                if (!g(i2)) {
                    b2--;
                }
            } else if (g(i2)) {
                b2++;
            }
        }
        return b(i2, 1, b2) + ((long) e2);
    }

    /* access modifiers changed from: 0000 */
    public boolean j(long j2) {
        return e().a(j2) == 29 && w().b(j2);
    }
}
