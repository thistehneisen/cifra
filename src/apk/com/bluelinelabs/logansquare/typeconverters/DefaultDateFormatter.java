package com.bluelinelabs.logansquare.typeconverters;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DefaultDateFormatter extends SimpleDateFormat {
    public DefaultDateFormatter() {
        super("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private String getFixedInputString(String str) {
        if (str != null) {
            return str.replaceAll("Z$", "+0000");
        }
        return null;
    }

    public Date parse(String str) throws ParseException {
        return super.parse(getFixedInputString(str));
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return super.parseObject(getFixedInputString(str), parsePosition);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return super.parse(getFixedInputString(str), parsePosition);
    }

    public Object parseObject(String str) throws ParseException {
        return super.parseObject(getFixedInputString(str));
    }
}
