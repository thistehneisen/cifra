package kotlin.i;

import java.util.Collection;
import java.util.Iterator;
import kotlin.a.t;
import kotlin.e.b.h;
import kotlin.f.d;

/* compiled from: StringsJVM.kt */
class n extends m {
    public static /* synthetic */ String a(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(str, c2, c3, z);
    }

    public static final String a(String str, char c2, char c3, boolean z) {
        h.b(str, "$this$replace");
        if (!z) {
            String replace = str.replace(c2, c3);
            h.a((Object) replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace;
        }
        return j.a(s.a((CharSequence) str, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(str, str2, str3, z);
    }

    public static final String a(String str, String str2, String str3, boolean z) {
        h.b(str, "$this$replace");
        h.b(str2, "oldValue");
        h.b(str3, "newValue");
        return j.a(s.a((CharSequence) str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(str, str2, z);
    }

    public static final boolean a(String str, String str2, boolean z) {
        h.b(str, "$this$startsWith");
        h.b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return a(str, 0, str2, 0, str2.length(), z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public static boolean a(CharSequence charSequence) {
        boolean z;
        h.b(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            d b2 = s.b(charSequence);
            if (!(b2 instanceof Collection) || !((Collection) b2).isEmpty()) {
                Iterator it = b2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!a.a(charSequence.charAt(((t) it).nextInt()))) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
            }
            z = true;
            if (!z) {
            }
        }
        return true;
    }

    public static final boolean a(String str, int i2, String str2, int i3, int i4, boolean z) {
        h.b(str, "$this$regionMatches");
        h.b(str2, "other");
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }
}
