package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.h;
import io.fabric.sdk.android.services.concurrency.p;
import io.fabric.sdk.android.services.concurrency.s;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DependencyPriorityBlockingQueue */
public class i<E extends h & s & p> extends PriorityBlockingQueue<E> {
    final Queue<E> blockedQueue = new LinkedList();
    private final ReentrantLock lock = new ReentrantLock();

    /* access modifiers changed from: 0000 */
    public boolean a(int i2, E e2) {
        try {
            this.lock.lock();
            if (i2 == 1) {
                super.remove(e2);
            }
            boolean offer = this.blockedQueue.offer(e2);
            return offer;
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public E b(int i2, Long l2, TimeUnit timeUnit) throws InterruptedException {
        E e2;
        if (i2 == 0) {
            e2 = (h) super.take();
        } else if (i2 == 1) {
            e2 = (h) super.peek();
        } else if (i2 == 2) {
            e2 = (h) super.poll();
        } else if (i2 != 3) {
            return null;
        } else {
            e2 = (h) super.poll(l2.longValue(), timeUnit);
        }
        return e2;
    }

    public void clear() {
        try {
            this.lock.lock();
            this.blockedQueue.clear();
            super.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.lock.lock();
            return super.contains(obj) || this.blockedQueue.contains(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection) + this.blockedQueue.size();
            while (!this.blockedQueue.isEmpty()) {
                collection.add(this.blockedQueue.poll());
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    public void e() {
        try {
            this.lock.lock();
            Iterator it = this.blockedQueue.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                if (a(hVar)) {
                    super.offer(hVar);
                    it.remove();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.lock.lock();
            return super.remove(obj) || this.blockedQueue.remove(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.lock.lock();
            return this.blockedQueue.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.lock.unlock();
        }
    }

    public int size() {
        try {
            this.lock.lock();
            return this.blockedQueue.size() + super.size();
        } finally {
            this.lock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.lock.lock();
            return a((T[]) super.toArray(tArr), (T[]) this.blockedQueue.toArray(tArr));
        } finally {
            this.lock.unlock();
        }
    }

    public E peek() {
        try {
            return a(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public E take() throws InterruptedException {
        return a(0, null, null);
    }

    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a(3, Long.valueOf(j2), timeUnit);
    }

    public E poll() {
        try {
            return a(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public Object[] toArray() {
        try {
            this.lock.lock();
            return a((T[]) super.toArray(), (T[]) this.blockedQueue.toArray());
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public E a(int i2, Long l2, TimeUnit timeUnit) throws InterruptedException {
        E b2;
        while (true) {
            b2 = b(i2, l2, timeUnit);
            if (b2 == null || a(b2)) {
                return b2;
            }
            a(i2, b2);
        }
        return b2;
    }

    public int drainTo(Collection<? super E> collection, int i2) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection, i2);
            while (!this.blockedQueue.isEmpty() && drainTo <= i2) {
                collection.add(this.blockedQueue.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean a(E e2) {
        return e2.areDependenciesMet();
    }

    /* access modifiers changed from: 0000 */
    public <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
