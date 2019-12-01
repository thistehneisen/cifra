package org.joda.time.e;

import java.io.IOException;

/* compiled from: FormatUtils */
public class i {

    /* renamed from: a reason: collision with root package name */
    private static final double f10897a = Math.log(10.0d);

    public static void a(StringBuffer stringBuffer, int i2, int i3) {
        try {
            a((Appendable) stringBuffer, i2, i3);
        } catch (IOException unused) {
        }
    }

    public static void a(Appendable appendable, int i2, int i3) throws IOException {
        if (i2 < 0) {
            appendable.append('-');
            if (i2 != Integer.MIN_VALUE) {
                i2 = -i2;
            } else {
                while (i3 > 10) {
                    appendable.append('0');
                    i3--;
                }
                appendable.append("2147483648");
                return;
            }
        }
        if (i2 < 10) {
            while (i3 > 1) {
                appendable.append('0');
                i3--;
            }
            appendable.append((char) (i2 + 48));
        } else if (i2 < 100) {
            while (i3 > 2) {
                appendable.append('0');
                i3--;
            }
            int i4 = ((i2 + 1) * 13421772) >> 27;
            appendable.append((char) (i4 + 48));
            appendable.append((char) (((i2 - (i4 << 3)) - (i4 << 1)) + 48));
        } else {
            int i5 = i2 < 1000 ? 3 : i2 < 10000 ? 4 : ((int) (Math.log((double) i2) / f10897a)) + 1;
            while (i3 > i5) {
                appendable.append('0');
                i3--;
            }
            appendable.append(Integer.toString(i2));
        }
    }

    public static void a(Appendable appendable, int i2) throws IOException {
        if (i2 < 0) {
            appendable.append('-');
            if (i2 != Integer.MIN_VALUE) {
                i2 = -i2;
            } else {
                appendable.append("2147483648");
                return;
            }
        }
        if (i2 < 10) {
            appendable.append((char) (i2 + 48));
        } else if (i2 < 100) {
            int i3 = ((i2 + 1) * 13421772) >> 27;
            appendable.append((char) (i3 + 48));
            appendable.append((char) (((i2 - (i3 << 3)) - (i3 << 1)) + 48));
        } else {
            appendable.append(Integer.toString(i2));
        }
    }

    static int a(CharSequence charSequence, int i2) {
        int charAt = charSequence.charAt(i2) - '0';
        return (((charAt << 3) + (charAt << 1)) + charSequence.charAt(i2 + 1)) - 48;
    }

    static String a(String str, int i2) {
        String str2;
        int i3 = i2 + 32;
        if (str.length() <= i3 + 3) {
            str2 = str;
        } else {
            str2 = str.substring(0, i3).concat("...");
        }
        String str3 = "Invalid format: \"";
        if (i2 <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str2);
            sb.append('\"');
            return sb.toString();
        } else if (i2 >= str.length()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str2);
            sb2.append("\" is too short");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str2);
            sb3.append("\" is malformed at \"");
            sb3.append(str2.substring(i2));
            sb3.append('\"');
            return sb3.toString();
        }
    }
}
