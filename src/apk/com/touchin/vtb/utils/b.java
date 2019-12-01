package com.touchin.vtb.utils;

import android.content.Context;
import android.text.format.DateUtils;
import com.touchin.vtb.R;
import java.util.Arrays;
import kotlin.e.b.h;
import kotlin.e.b.q;

/* compiled from: DateUtils.kt */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public static final b f7611a = new b();

    private b() {
    }

    public final String a(org.joda.time.b bVar, k kVar) {
        h.b(bVar, "dateTime");
        h.b(kVar, "format");
        return kVar.a(bVar);
    }

    public final boolean b(long j2) {
        return DateUtils.isToday(j2);
    }

    public final boolean c(long j2) {
        return DateUtils.isToday(j2 + 86400000);
    }

    public final int d(long j2) {
        return (int) (j2 / ((long) 1000));
    }

    public final boolean a(org.joda.time.b bVar) {
        h.b(bVar, "dateTime");
        org.joda.time.b g2 = org.joda.time.b.g();
        h.a((Object) g2, "DateTime.now()");
        return g2.e() == bVar.e();
    }

    public final String a(Context context, int i2) {
        h.b(context, "context");
        q qVar = q.f10310a;
        String quantityString = context.getResources().getQuantityString(R.plurals.seconds_left, i2);
        h.a((Object) quantityString, "context.resources.getQua…econds_left, secondsLeft)");
        Object[] objArr = new Object[0];
        String format = String.format(quantityString, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final String a(long j2) {
        return d(j2) > 10 ? "ss" : "s";
    }
}
