package b.g.g;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat */
public final class b {

    /* renamed from: a reason: collision with root package name */
    private static Method f2591a;

    /* renamed from: b reason: collision with root package name */
    private static Method f2592b;

    static {
        int i2 = VERSION.SDK_INT;
        String str = "addLikelySubtags";
        if (i2 < 21) {
            try {
                Class cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f2591a = cls.getMethod("getScript", new Class[]{String.class});
                    f2592b = cls.getMethod(str, new Class[]{String.class});
                }
            } catch (Exception e2) {
                f2591a = null;
                f2592b = null;
                Log.w("ICUCompat", e2);
            }
        } else if (i2 < 24) {
            try {
                f2592b = Class.forName("libcore.icu.ICU").getMethod(str, new Class[]{Locale.class});
            } catch (Exception e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    public static String a(Locale locale) {
        String str = "ICUCompat";
        int i2 = VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 >= 21) {
            try {
                return ((Locale) f2592b.invoke(null, new Object[]{locale})).getScript();
            } catch (InvocationTargetException e2) {
                Log.w(str, e2);
                return locale.getScript();
            } catch (IllegalAccessException e3) {
                Log.w(str, e3);
                return locale.getScript();
            }
        } else {
            String b2 = b(locale);
            if (b2 != null) {
                return a(b2);
            }
            return null;
        }
    }

    private static String b(Locale locale) {
        String str = "ICUCompat";
        String locale2 = locale.toString();
        try {
            if (f2592b != null) {
                return (String) f2592b.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e2) {
            Log.w(str, e2);
        } catch (InvocationTargetException e3) {
            Log.w(str, e3);
        }
        return locale2;
    }

    private static String a(String str) {
        String str2 = "ICUCompat";
        try {
            if (f2591a != null) {
                return (String) f2591a.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e2) {
            Log.w(str2, e2);
        } catch (InvocationTargetException e3) {
            Log.w(str2, e3);
        }
        return null;
    }
}
