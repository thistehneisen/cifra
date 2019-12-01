package com.bluelinelabs.logansquare.typeconverters;

import java.text.DateFormat;

public class DefaultCalendarConverter extends CalendarTypeConverter {
    private DateFormat mDateFormat = new DefaultDateFormatter();

    public DateFormat getDateFormat() {
        return this.mDateFormat;
    }
}
