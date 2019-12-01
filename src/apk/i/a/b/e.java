package i.a.b;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: HttpDate */
public final class e {

    /* renamed from: a reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f8579a = new d();

    /* renamed from: b reason: collision with root package name */
    private static final String[] f8580b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* renamed from: c reason: collision with root package name */
    private static final DateFormat[] f8581c = new DateFormat[f8580b.length];

    public static Date a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f8579a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f8580b) {
            int length = f8580b.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat dateFormat = f8581c[i2];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f8580b[i2], Locale.US);
                    dateFormat.setTimeZone(i.a.e.f8661i);
                    f8581c[i2] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String a(Date date) {
        return ((DateFormat) f8579a.get()).format(date);
    }
}
