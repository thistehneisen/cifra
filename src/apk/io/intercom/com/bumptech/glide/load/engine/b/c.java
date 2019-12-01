package io.intercom.com.bumptech.glide.load.engine.b;

import io.intercom.com.bumptech.glide.h.h;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
final class c {

    /* renamed from: a reason: collision with root package name */
    private final Map<String, a> f9806a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private final b f9807b = new b();

    /* compiled from: DiskCacheWriteLocker */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        final Lock f9808a = new ReentrantLock();

        /* renamed from: b reason: collision with root package name */
        int f9809b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        private final Queue<a> f9810a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: 0000 */
        public a a() {
            a aVar;
            synchronized (this.f9810a) {
                aVar = (a) this.f9810a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar) {
            synchronized (this.f9810a) {
                if (this.f9810a.size() < 10) {
                    this.f9810a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* access modifiers changed from: 0000 */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) this.f9806a.get(str);
            if (aVar == null) {
                aVar = this.f9807b.a();
                this.f9806a.put(str, aVar);
            }
            aVar.f9809b++;
        }
        aVar.f9808a.lock();
    }

    /* access modifiers changed from: 0000 */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            Object obj = this.f9806a.get(str);
            h.a(obj);
            aVar = (a) obj;
            if (aVar.f9809b >= 1) {
                aVar.f9809b--;
                if (aVar.f9809b == 0) {
                    a aVar2 = (a) this.f9806a.remove(str);
                    if (aVar2.equals(aVar)) {
                        this.f9807b.a(aVar2);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(aVar);
                        sb.append(", but actually removed: ");
                        sb.append(aVar2);
                        sb.append(", safeKey: ");
                        sb.append(str);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot release a lock that is not held, safeKey: ");
                sb2.append(str);
                sb2.append(", interestedThreads: ");
                sb2.append(aVar.f9809b);
                throw new IllegalStateException(sb2.toString());
            }
        }
        aVar.f9808a.unlock();
    }
}
