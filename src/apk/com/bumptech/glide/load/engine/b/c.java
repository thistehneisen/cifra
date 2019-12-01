package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.h.l;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
final class c {

    /* renamed from: a reason: collision with root package name */
    private final Map<String, a> f3945a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private final b f3946b = new b();

    /* compiled from: DiskCacheWriteLocker */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        final Lock f3947a = new ReentrantLock();

        /* renamed from: b reason: collision with root package name */
        int f3948b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        private final Queue<a> f3949a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: 0000 */
        public a a() {
            a aVar;
            synchronized (this.f3949a) {
                aVar = (a) this.f3949a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        /* access modifiers changed from: 0000 */
        public void a(a aVar) {
            synchronized (this.f3949a) {
                if (this.f3949a.size() < 10) {
                    this.f3949a.offer(aVar);
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
            aVar = (a) this.f3945a.get(str);
            if (aVar == null) {
                aVar = this.f3946b.a();
                this.f3945a.put(str, aVar);
            }
            aVar.f3948b++;
        }
        aVar.f3947a.lock();
    }

    /* access modifiers changed from: 0000 */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            Object obj = this.f3945a.get(str);
            l.a(obj);
            aVar = (a) obj;
            if (aVar.f3948b >= 1) {
                aVar.f3948b--;
                if (aVar.f3948b == 0) {
                    a aVar2 = (a) this.f3945a.remove(str);
                    if (aVar2.equals(aVar)) {
                        this.f3946b.a(aVar2);
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
                sb2.append(aVar.f3948b);
                throw new IllegalStateException(sb2.toString());
            }
        }
        aVar.f3947a.unlock();
    }
}
