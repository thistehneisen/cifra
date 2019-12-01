package com.touchin.vtb.utils;

import kotlin.e.b.h;
import org.joda.time.e.b;
import org.joda.time.r;

/* compiled from: DateUtils.kt */
public enum k {
    YEAR(r2),
    DAY_MONTH(r2),
    DAY_MONTH_YEAR(r2),
    DAY_DIGIT_MONTH_YEAR(r2),
    HOURS_MINUTES_SECONDS(r2);
    
    private final b formatter;

    private k(b bVar) {
        this.formatter = bVar;
    }

    public final String a(org.joda.time.b bVar) {
        h.b(bVar, "dateTime");
        String a2 = this.formatter.a((r) bVar);
        h.a((Object) a2, "formatter.print(dateTime)");
        return a2;
    }
}
