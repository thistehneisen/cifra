package io.intercom.com.google.gson.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: ISO8601Utils */
public class a {

    /* renamed from: a reason: collision with root package name */
    private static final TimeZone f10038a = TimeZone.getTimeZone("UTC");

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cc A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb }] */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TimeZone timeZone;
        String str3 = str;
        ParsePosition parsePosition2 = parsePosition;
        String str4 = "'";
        try {
            int index = parsePosition.getIndex();
            int i8 = index + 4;
            int a2 = a(str3, index, i8);
            if (a(str3, i8, '-')) {
                i8++;
            }
            int i9 = i8 + 2;
            int a3 = a(str3, i8, i9);
            if (a(str3, i9, '-')) {
                i9++;
            }
            int i10 = i9 + 2;
            int a4 = a(str3, i9, i10);
            boolean a5 = a(str3, i10, 'T');
            if (a5 || str.length() > i10) {
                if (a5) {
                    int i11 = i10 + 1;
                    int i12 = i11 + 2;
                    i5 = a(str3, i11, i12);
                    if (a(str3, i12, ':')) {
                        i12++;
                    }
                    i2 = i12 + 2;
                    i4 = a(str3, i12, i2);
                    if (a(str3, i2, ':')) {
                        i2++;
                    }
                    if (str.length() > i2) {
                        char charAt = str3.charAt(i2);
                        if (!(charAt == 'Z' || charAt == '+' || charAt == '-')) {
                            int i13 = i2 + 2;
                            int a6 = a(str3, i2, i13);
                            i3 = (a6 <= 59 || a6 >= 63) ? a6 : 59;
                            if (a(str3, i13, '.')) {
                                int i14 = i13 + 1;
                                i2 = a(str3, i14 + 1);
                                int min = Math.min(i2, i14 + 3);
                                int a7 = a(str3, i14, min);
                                int i15 = min - i14;
                                if (i15 == 1) {
                                    a7 *= 100;
                                } else if (i15 == 2) {
                                    a7 *= 10;
                                }
                                i6 = a7;
                            } else {
                                i2 = i13;
                                i6 = 0;
                            }
                            if (str.length() <= i2) {
                                char charAt2 = str3.charAt(i2);
                                if (charAt2 == 'Z') {
                                    timeZone = f10038a;
                                    i7 = i2 + 1;
                                } else {
                                    if (charAt2 != '+') {
                                        if (charAt2 != '-') {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Invalid time zone indicator '");
                                            sb.append(charAt2);
                                            sb.append(str4);
                                            throw new IndexOutOfBoundsException(sb.toString());
                                        }
                                    }
                                    String substring = str3.substring(i2);
                                    if (substring.length() < 5) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(substring);
                                        sb2.append("00");
                                        substring = sb2.toString();
                                    }
                                    i7 = i2 + substring.length();
                                    if (!"+0000".equals(substring)) {
                                        if (!"+00:00".equals(substring)) {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("GMT");
                                            sb3.append(substring);
                                            String sb4 = sb3.toString();
                                            TimeZone timeZone2 = TimeZone.getTimeZone(sb4);
                                            String id = timeZone2.getID();
                                            if (!id.equals(sb4)) {
                                                if (!id.replace(":", "").equals(sb4)) {
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append("Mismatching time zone indicator: ");
                                                    sb5.append(sb4);
                                                    sb5.append(" given, resolves to ");
                                                    sb5.append(timeZone2.getID());
                                                    throw new IndexOutOfBoundsException(sb5.toString());
                                                }
                                            }
                                            timeZone = timeZone2;
                                        }
                                    }
                                    timeZone = f10038a;
                                }
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, a2);
                                gregorianCalendar.set(2, a3 - 1);
                                gregorianCalendar.set(5, a4);
                                gregorianCalendar.set(11, i5);
                                gregorianCalendar.set(12, i4);
                                gregorianCalendar.set(13, i3);
                                gregorianCalendar.set(14, i6);
                                parsePosition2.setIndex(i7);
                                return gregorianCalendar.getTime();
                            }
                            throw new IllegalArgumentException("No time zone indicator");
                        }
                    }
                    i6 = 0;
                } else {
                    i2 = i10;
                    i6 = 0;
                    i5 = 0;
                    i4 = 0;
                }
                i3 = 0;
                if (str.length() <= i2) {
                }
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(a2, a3 - 1, a4);
                parsePosition2.setIndex(i10);
                return gregorianCalendar2.getTime();
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e2) {
            if (str3 == null) {
                str2 = null;
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append('\"');
                sb6.append(str3);
                sb6.append(str4);
                str2 = sb6.toString();
            }
            String message = e2.getMessage();
            if (message == null || message.isEmpty()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("(");
                sb7.append(e2.getClass().getName());
                sb7.append(")");
                message = sb7.toString();
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Failed to parse date [");
            sb8.append(str2);
            sb8.append("]: ");
            sb8.append(message);
            ParseException parseException = new ParseException(sb8.toString(), parsePosition.getIndex());
            parseException.initCause(e2);
            throw parseException;
        }
    }

    private static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    private static int a(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        String str2 = "Invalid number: ";
        if (i2 < i3) {
            i5 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit >= 0) {
                i4 = -digit;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str.substring(i2, i3));
                throw new NumberFormatException(sb.toString());
            }
        } else {
            i5 = i2;
            i4 = 0;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int digit2 = Character.digit(str.charAt(i5), 10);
            if (digit2 >= 0) {
                i4 = (i4 * 10) - digit2;
                i5 = i6;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str.substring(i2, i3));
                throw new NumberFormatException(sb2.toString());
            }
        }
        return -i4;
    }

    private static int a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }
}
