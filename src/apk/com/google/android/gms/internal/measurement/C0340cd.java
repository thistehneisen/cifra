package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
/* renamed from: com.google.android.gms.internal.measurement.cd reason: case insensitive filesystem */
public final class C0340cd {

    /* renamed from: a reason: collision with root package name */
    private static final Method f5140a = a();

    /* renamed from: b reason: collision with root package name */
    private static final Method f5141b = b();

    /* renamed from: c reason: collision with root package name */
    private final JobScheduler f5142c;

    private C0340cd(JobScheduler jobScheduler) {
        this.f5142c = jobScheduler;
    }

    private static Method a() {
        if (VERSION.SDK_INT >= 24) {
            try {
                return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, String.class, Integer.TYPE, String.class});
            } catch (NoSuchMethodException unused) {
                String str = "JobSchedulerCompat";
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "No scheduleAsPackage method available, falling back to schedule");
                }
            }
        }
        return null;
    }

    private static Method b() {
        if (VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                String str = "JobSchedulerCompat";
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "No myUserId method available");
                }
            }
        }
        return null;
    }

    private static int c() {
        Method method = f5141b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                String str = "JobSchedulerCompat";
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "myUserId invocation illegal", e2);
                }
            }
        }
        return 0;
    }

    private final int a(JobInfo jobInfo, String str, int i2, String str2) {
        Method method = f5140a;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f5142c, new Object[]{jobInfo, str, Integer.valueOf(i2), str2})).intValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e(str2, "error calling scheduleAsPackage", e2);
            }
        }
        return this.f5142c.schedule(jobInfo);
    }

    public static int a(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (f5140a == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobScheduler.schedule(jobInfo);
        }
        return new C0340cd(jobScheduler).a(jobInfo, str, c(), str2);
    }
}
