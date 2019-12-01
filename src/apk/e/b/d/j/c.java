package e.b.d.j;

import e.b.g.a;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureHelper */
public final class c {
    public static long a(long j2, long j3) {
        long j4 = j2 + j3;
        if (j4 < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j3, a(j3, j2)));
        return j3;
    }

    public static long b(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("More produced than requested: ");
                sb.append(j4);
                a.b((Throwable) new IllegalStateException(sb.toString()));
                j4 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }
}
