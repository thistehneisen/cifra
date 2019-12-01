package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public abstract class DateTypeConverter implements TypeConverter<Date> {
    private final ThreadLocal<DateFormat> mDateFormat = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return DateTypeConverter.this.getDateFormat();
        }
    };

    public abstract DateFormat getDateFormat();

    public Date parse(e eVar) throws IOException {
        String c2 = eVar.c(null);
        if (c2 != null) {
            try {
                return ((DateFormat) this.mDateFormat.get()).parse(c2);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public void serialize(Date date, String str, boolean z, c cVar) throws IOException {
        if (str != null && date != null) {
            cVar.a(str, ((DateFormat) this.mDateFormat.get()).format(date));
        } else if (date != null) {
            cVar.f(((DateFormat) this.mDateFormat.get()).format(date));
        } else {
            if (str != null) {
                cVar.c(str);
            }
            cVar.d();
        }
    }
}
