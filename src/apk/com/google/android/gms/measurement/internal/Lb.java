package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.q;
import java.util.concurrent.BlockingQueue;

final class Lb extends Thread {

    /* renamed from: a reason: collision with root package name */
    private final Object f5641a = new Object();

    /* renamed from: b reason: collision with root package name */
    private final BlockingQueue<Mb<?>> f5642b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Ib f5643c;

    public Lb(Ib ib, String str, BlockingQueue<Mb<?>> blockingQueue) {
        this.f5643c = ib;
        q.a(str);
        q.a(blockingQueue);
        this.f5642b = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.f5641a) {
            this.f5641a.notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0065, code lost:
        r1 = r6.f5643c.f5596j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r6.f5643c.f5597k.release();
        r6.f5643c.f5596j.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        if (r6 != r6.f5643c.f5590d) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        r6.f5643c.f5590d = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        if (r6 != r6.f5643c.f5591e) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0094, code lost:
        r6.f5643c.f5591e = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009a, code lost:
        r6.f5643c.e().t().a("Current scheduler thread is neither worker nor network");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a9, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
        return;
     */
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.f5643c.f5597k.acquire();
                z = true;
            } catch (InterruptedException e2) {
                a(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                Mb mb = (Mb) this.f5642b.poll();
                if (mb != null) {
                    Process.setThreadPriority(mb.f5650b ? threadPriority : 10);
                    mb.run();
                } else {
                    synchronized (this.f5641a) {
                        if (this.f5642b.peek() == null && !this.f5643c.f5598l) {
                            try {
                                this.f5641a.wait(30000);
                            } catch (InterruptedException e3) {
                                a(e3);
                            }
                        }
                    }
                    synchronized (this.f5643c.f5596j) {
                        if (this.f5642b.peek() == null) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.f5643c.f5596j) {
                this.f5643c.f5597k.release();
                this.f5643c.f5596j.notifyAll();
                if (this == this.f5643c.f5590d) {
                    this.f5643c.f5590d = null;
                } else if (this == this.f5643c.f5591e) {
                    this.f5643c.f5591e = null;
                } else {
                    this.f5643c.e().t().a("Current scheduler thread is neither worker nor network");
                }
                throw th;
            }
        }
    }

    private final void a(InterruptedException interruptedException) {
        this.f5643c.e().w().a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
