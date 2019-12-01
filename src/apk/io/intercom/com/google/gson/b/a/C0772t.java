package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: io.intercom.com.google.gson.b.a.t reason: case insensitive filesystem */
/* compiled from: TimeTypeAdapter */
public final class C0772t extends D<Time> {

    /* renamed from: a reason: collision with root package name */
    public static final E f10094a = new C0771s();

    /* renamed from: b reason: collision with root package name */
    private final DateFormat f10095b = new SimpleDateFormat("hh:mm:ss a");

    public synchronized Time a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        try {
            return new Time(this.f10095b.parse(bVar.F()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }

    public synchronized void a(d dVar, Time time) throws IOException {
        dVar.d(time == null ? null : this.f10095b.format(time));
    }
}
