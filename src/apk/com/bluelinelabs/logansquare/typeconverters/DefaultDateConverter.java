package com.bluelinelabs.logansquare.typeconverters;

import java.text.DateFormat;

public class DefaultDateConverter extends DateTypeConverter {
    public DateFormat getDateFormat() {
        return new DefaultDateFormatter();
    }
}
