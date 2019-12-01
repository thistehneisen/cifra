package b.g.g;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
public final class f {

    /* renamed from: a reason: collision with root package name */
    private static final Locale f2618a;

    static {
        String str = "";
        f2618a = new Locale(str, str);
    }

    public static int a(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f2618a)) {
            String a2 = b.a(locale);
            if (a2 == null) {
                return b(locale);
            }
            if (a2.equalsIgnoreCase("Arab") || a2.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }

    private static int b(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }
}
