package org.joda.time;

/* compiled from: DurationField */
public abstract class h implements Comparable<h> {
    public abstract long a(long j2, int i2);

    public abstract long a(long j2, long j3);

    public abstract i a();

    public abstract long b();

    public long b(long j2, int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return b(j2, (long) i2);
        }
        return a(j2, -i2);
    }

    public abstract boolean c();

    public abstract boolean d();

    public long b(long j2, long j3) {
        if (j3 != Long.MIN_VALUE) {
            return a(j2, -j3);
        }
        throw new ArithmeticException("Long.MIN_VALUE cannot be negated");
    }
}
