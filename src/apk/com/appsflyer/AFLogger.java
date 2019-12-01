package com.appsflyer;

import android.util.Log;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AFLogger {

    /* renamed from: ˋ reason: contains not printable characters */
    private static long f22 = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        

        /* renamed from: ॱ reason: contains not printable characters */
        private int f24;

        private LogLevel(int i2) {
            this.f24 = i2;
        }

        public final int getLevel() {
            return this.f24;
        }
    }

    public static void afDebugLog(String str) {
        if (LogLevel.DEBUG.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.d(AppsFlyerLib.LOG_TAG, m18(str, false));
        }
        s.m191().m201("D", m18(str, true));
    }

    public static void afErrorLog(String str, Throwable th) {
        m16(str, th, false);
    }

    public static void afInfoLog(String str, boolean z) {
        if (LogLevel.INFO.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.i(AppsFlyerLib.LOG_TAG, m18(str, false));
        }
        if (z) {
            s.m191().m201("I", m18(str, true));
        }
    }

    public static void afRDLog(String str) {
        if (LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.v(AppsFlyerLib.LOG_TAG, m18(str, false));
        }
        s.m191().m201("V", m18(str, true));
    }

    public static void afWarnLog(String str) {
        m15(str);
    }

    public static void resetDeltaTime() {
        f22 = System.currentTimeMillis();
    }

    /* renamed from: ˊ reason: contains not printable characters */
    static void m15(String str) {
        if (LogLevel.WARNING.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.w(AppsFlyerLib.LOG_TAG, m18(str, false));
        }
        s.m191().m201("W", m18(str, true));
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static void m16(String str, Throwable th, boolean z) {
        if ((LogLevel.ERROR.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) && z) {
            Log.e(AppsFlyerLib.LOG_TAG, m18(str, false), th);
        }
        s.m191().m205(th);
    }

    /* renamed from: ˏ reason: contains not printable characters */
    static void m17(String str) {
        if (!AppsFlyerProperties.getInstance().isLogsDisabledCompletely()) {
            Log.d(AppsFlyerLib.LOG_TAG, m18(str, false));
        }
        s.m191().m201("F", str);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static String m18(String str, boolean z) {
        if (!z) {
            if (LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
                return str;
            }
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(m14(System.currentTimeMillis() - f22));
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        m16(str, th, z);
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    /* renamed from: ˊ reason: contains not printable characters */
    private static String m14(long j2) {
        long hours = TimeUnit.MILLISECONDS.toHours(j2);
        long millis = j2 - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long millis2 = millis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis2);
        long millis3 = TimeUnit.MILLISECONDS.toMillis(millis2 - TimeUnit.SECONDS.toMillis(seconds));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(millis3)});
    }
}
