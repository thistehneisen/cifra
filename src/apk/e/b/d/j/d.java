package e.b.d.j;

import e.b.d.g.h;
import e.b.g.a;

/* compiled from: BlockingHelper */
public final class d {
    public static void a() {
        if (!a.a()) {
            return;
        }
        if ((Thread.currentThread() instanceof h) || a.b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempt to block on a Scheduler ");
            sb.append(Thread.currentThread().getName());
            sb.append(" that doesn't support blocking operators as they may lead to deadlock");
            throw new IllegalStateException(sb.toString());
        }
    }
}
