package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.q;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a implements ServiceConnection {

    /* renamed from: a reason: collision with root package name */
    private boolean f4507a = false;

    /* renamed from: b reason: collision with root package name */
    private final BlockingQueue<IBinder> f4508b = new LinkedBlockingQueue();

    public IBinder a(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        q.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f4507a) {
            this.f4507a = true;
            IBinder iBinder = (IBinder) this.f4508b.poll(j2, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4508b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
