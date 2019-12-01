package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

public abstract class CalendarTypeConverter implements TypeConverter<Calendar> {
    private final ThreadLocal<DateFormat> mDateFormat = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return CalendarTypeConverter.this.getDateFormat();
        }
    };

    public abstract DateFormat getDateFormat();

    public Calendar parse(e eVar) throws IOException {
        String c2 = eVar.c(null);
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(((DateFormat) this.mDateFormat.get()).parse(c2));
            return instance;
        } catch (ParseException unused) {
            return null;
        }
    }

    public void serialize(Calendar calendar, String str, boolean z, c cVar) throws IOException {
        if (str != null) {
            cVar.a(str, ((DateFormat) this.mDateFormat.get()).format(Long.valueOf(calendar.getTimeInMillis())));
        } else {
            cVar.f(((DateFormat) this.mDateFormat.get()).format(Long.valueOf(calendar.getTimeInMillis())));
        }
    }
}
