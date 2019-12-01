package kotlin.i;

import kotlin.e.b.h;

/* compiled from: _Strings.kt */
class u extends t {
    public static Character a(CharSequence charSequence, int i2) {
        h.b(charSequence, "$this$getOrNull");
        if (i2 < 0 || i2 > s.c(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i2));
    }

    public static String a(String str, int i2) {
        h.b(str, "$this$takeLast");
        if (i2 >= 0) {
            int length = str.length();
            String substring = str.substring(length - h.b(i2, length));
            h.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested character count ");
        sb.append(i2);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }
}
