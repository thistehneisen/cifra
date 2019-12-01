package io.intercom.android.sdk.twig;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Twig {
    public static final int DISABLED = 8;
    private static final int MAX_LOG_LENGTH = 4000;
    private final boolean internalLoggingEnabled;
    private int logLevel;
    private final String tag;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public Twig(int i2, String str, boolean z) {
        this.logLevel = i2;
        if (str == null) {
            str = "Twig";
        }
        this.tag = str;
        this.internalLoggingEnabled = z;
    }

    private String getStackTraceString(Throwable th) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter(stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    private void prepareLog(int i2, Throwable th, String str, Object... objArr) {
        String str2;
        if (i2 >= this.logLevel) {
            String tag2 = getTag();
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                if (th != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("\n");
                    sb.append(getStackTraceString(th));
                    str2 = sb.toString();
                } else {
                    str2 = str;
                }
            } else if (th != null) {
                str2 = getStackTraceString(th);
            } else {
                return;
            }
            log(i2, tag2, str2);
        }
    }

    private void printLog(int i2, String str, String str2) {
        if (i2 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i2, str, str2);
        }
    }

    public void d(String str, Object... objArr) {
        prepareLog(3, null, str, objArr);
    }

    public void e(String str, Object... objArr) {
        prepareLog(6, null, str, objArr);
    }

    /* access modifiers changed from: 0000 */
    public int getLogLevel() {
        return this.logLevel;
    }

    public String getTag() {
        return this.tag;
    }

    public void i(String str, Object... objArr) {
        prepareLog(4, null, str, objArr);
    }

    public void internal(String str) {
        internal(this.tag, str);
    }

    /* access modifiers changed from: 0000 */
    public void log(int i2, String str, Object... objArr) {
        prepareLog(i2, null, str, objArr);
    }

    public void setLogLevel(int i2) {
        this.logLevel = i2;
    }

    public void v(String str, Object... objArr) {
        prepareLog(2, null, str, objArr);
    }

    public void w(String str, Object... objArr) {
        prepareLog(5, null, str, objArr);
    }

    public void wtf(String str, Object... objArr) {
        prepareLog(7, null, str, objArr);
    }

    private void log(int i2, String str, String str2) {
        int min;
        if (str2.length() < MAX_LOG_LENGTH) {
            printLog(i2, str, str2);
            return;
        }
        int i3 = 0;
        int length = str2.length();
        while (i3 < length) {
            int indexOf = str2.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + MAX_LOG_LENGTH);
                printLog(i2, str, str2.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public void d(Throwable th, String str, Object... objArr) {
        prepareLog(3, th, str, objArr);
    }

    public void e(Throwable th, String str, Object... objArr) {
        prepareLog(6, th, str, objArr);
    }

    public void i(Throwable th, String str, Object... objArr) {
        prepareLog(4, th, str, objArr);
    }

    public void internal(String str, String str2) {
        if (this.internalLoggingEnabled) {
            StringBuilder sb = new StringBuilder();
            sb.append("INTERNAL: ");
            sb.append(str2);
            Log.d(str, sb.toString());
        }
    }

    public void v(Throwable th, String str, Object... objArr) {
        prepareLog(2, th, str, objArr);
    }

    public void w(Throwable th, String str, Object... objArr) {
        prepareLog(5, th, str, objArr);
    }

    public void wtf(Throwable th, String str, Object... objArr) {
        prepareLog(7, th, str, objArr);
    }

    public void d(Throwable th) {
        prepareLog(3, th, null, new Object[0]);
    }

    public void e(Throwable th) {
        prepareLog(6, th, null, new Object[0]);
    }

    public void i(Throwable th) {
        prepareLog(4, th, null, new Object[0]);
    }

    public void v(Throwable th) {
        prepareLog(2, th, null, new Object[0]);
    }

    public void w(Throwable th) {
        prepareLog(5, th, null, new Object[0]);
    }

    public void wtf(Throwable th) {
        prepareLog(7, th, null, new Object[0]);
    }
}
