package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
public final class r extends D<Date> {

    /* renamed from: a reason: collision with root package name */
    public static final E f10092a = new C0770q();

    /* renamed from: b reason: collision with root package name */
    private final DateFormat f10093b = new SimpleDateFormat("MMM d, yyyy");

    public synchronized Date a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        try {
            return new Date(this.f10093b.parse(bVar.F()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }

    public synchronized void a(d dVar, Date date) throws IOException {
        dVar.d(date == null ? null : this.f10093b.format(date));
    }
}
