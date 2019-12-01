package io.intercom.okhttp3;

import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.connection.RealConnection;
import io.intercom.okhttp3.internal.connection.RouteDatabase;
import io.intercom.okhttp3.internal.connection.StreamAllocation;
import io.intercom.okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import io.intercom.okhttp3.internal.platform.Platform;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
        executor = threadPoolExecutor;
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j2) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference reference = (Reference) list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                StreamAllocationReference streamAllocationReference = (StreamAllocationReference) reference;
                StringBuilder sb = new StringBuilder();
                sb.append("A connection to ");
                sb.append(realConnection.route().address().url());
                sb.append(" was leaked. Did you forget to close a response body?");
                Platform.get().logCloseableLeak(sb.toString(), streamAllocationReference.callStackTrace);
                list.remove(i2);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j2 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: 0000 */
    public long cleanup(long j2) {
        synchronized (this) {
            long j3 = Long.MIN_VALUE;
            RealConnection realConnection = null;
            int i2 = 0;
            int i3 = 0;
            for (RealConnection realConnection2 : this.connections) {
                if (pruneAndGetAllocationCount(realConnection2, j2) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j4 = j2 - realConnection2.idleAtNanos;
                    if (j4 > j3) {
                        realConnection = realConnection2;
                        j3 = j4;
                    }
                }
            }
            if (j3 < this.keepAliveDurationNs) {
                if (i2 <= this.maxIdleConnections) {
                    if (i2 > 0) {
                        long j5 = this.keepAliveDurationNs - j3;
                        return j5;
                    } else if (i3 > 0) {
                        long j6 = this.keepAliveDurationNs;
                        return j6;
                    } else {
                        this.cleanupRunning = false;
                        return -1;
                    }
                }
            }
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    /* access modifiers changed from: 0000 */
    public Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection realConnection = (RealConnection) it.next();
                if (realConnection.allocations.isEmpty()) {
                    realConnection.noNewStreams = true;
                    arrayList.add(realConnection);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: 0000 */
    public RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i2;
        i2 = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.isEmpty()) {
                i2++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    public ConnectionPool(int i2, long j2, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            public void run() {
                while (true) {
                    long cleanup = ConnectionPool.this.cleanup(System.nanoTime());
                    if (cleanup != -1) {
                        if (cleanup > 0) {
                            long j2 = cleanup / 1000000;
                            long j3 = cleanup - (1000000 * j2);
                            synchronized (ConnectionPool.this) {
                                ConnectionPool.this.wait(j2, (int) j3);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i2;
        this.keepAliveDurationNs = timeUnit.toNanos(j2);
        if (j2 <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("keepAliveDuration <= 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
