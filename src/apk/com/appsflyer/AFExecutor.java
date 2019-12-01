package com.appsflyer;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import b.g.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AFExecutor {

    /* renamed from: ˎ reason: contains not printable characters */
    private static AFExecutor f10;

    /* renamed from: ˏ reason: contains not printable characters */
    private static final ThreadFactory f11 = new ThreadFactory() {

        /* renamed from: com.appsflyer.AFExecutor$3$5 reason: invalid class name */
        class AnonymousClass5 implements Runnable {

            /* renamed from: ˏ reason: contains not printable characters */
            private /* synthetic */ Runnable f16;

            AnonymousClass5(Runnable runnable) {
                this.f16 = runnable;
            }

            /* renamed from: ˋ reason: contains not printable characters */
            static boolean m5(Context context, String str) {
                int a2 = a.a(context, str);
                StringBuilder sb = new StringBuilder("is Permission Available: ");
                sb.append(str);
                sb.append("; res: ");
                sb.append(a2);
                AFLogger.afRDLog(sb.toString());
                return a2 == 0;
            }

            public final void run() {
                if (VERSION.SDK_INT >= 14) {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                }
                this.f16.run();
            }

            AnonymousClass5() {
            }
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(new AnonymousClass5(runnable));
        }
    };

    /* renamed from: ˊ reason: contains not printable characters */
    private ScheduledExecutorService f12;

    /* renamed from: ˋ reason: contains not printable characters */
    private ScheduledExecutorService f13;

    /* renamed from: ॱ reason: contains not printable characters */
    private Executor f14;

    private AFExecutor() {
    }

    public static AFExecutor getInstance() {
        if (f10 == null) {
            f10 = new AFExecutor();
        }
        return f10;
    }

    /* renamed from: ˊ reason: contains not printable characters */
    private static void m2(ExecutorService executorService) {
        String str = "killing non-finished tasks";
        try {
            AFLogger.afRDLog("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog(str);
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.afRDLog("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog(str);
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog(str);
            }
            executorService.shutdownNow();
            throw th;
        }
    }

    public ScheduledExecutorService getSerialExecutor() {
        if (this.f12 == null) {
            this.f12 = Executors.newSingleThreadScheduledExecutor();
        }
        return this.f12;
    }

    public Executor getThreadPoolExecutor() {
        Executor executor = this.f14;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.f14).isTerminated() || ((ThreadPoolExecutor) this.f14).isTerminating()))) {
            if (VERSION.SDK_INT < 11) {
                return Executors.newSingleThreadExecutor();
            }
            this.f14 = Executors.newFixedThreadPool(2, f11);
        }
        return this.f14;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ reason: contains not printable characters */
    public final void m3() {
        try {
            m2(this.f13);
            if (this.f14 instanceof ThreadPoolExecutor) {
                m2((ThreadPoolExecutor) this.f14);
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("failed to stop Executors", th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final ScheduledThreadPoolExecutor m4() {
        ScheduledExecutorService scheduledExecutorService = this.f13;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.f13.isTerminated()) {
            this.f13 = Executors.newScheduledThreadPool(2, f11);
        }
        return (ScheduledThreadPoolExecutor) this.f13;
    }
}
