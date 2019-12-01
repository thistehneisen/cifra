package i.a.b;

import i.a.e;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: HttpDate */
class d extends ThreadLocal<DateFormat> {
    d() {
    }

    /* access modifiers changed from: protected */
    public DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(e.f8661i);
        return simpleDateFormat;
    }
}
