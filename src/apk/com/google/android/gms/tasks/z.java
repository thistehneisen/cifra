package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class z<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Object f6234a = new Object();

    /* renamed from: b reason: collision with root package name */
    private Queue<y<TResult>> f6235b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6236c;

    z() {
    }

    public final void a(y<TResult> yVar) {
        synchronized (this.f6234a) {
            if (this.f6235b == null) {
                this.f6235b = new ArrayDeque();
            }
            this.f6235b.add(yVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.f6234a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = (com.google.android.gms.tasks.y) r2.f6235b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.f6236c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r0.a(r3);
     */
    public final void a(g<TResult> gVar) {
        synchronized (this.f6234a) {
            if (this.f6235b != null) {
                if (!this.f6236c) {
                    this.f6236c = true;
                }
            }
        }
    }
}
