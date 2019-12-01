package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: io.intercom.com.google.gson.b.a.e reason: case insensitive filesystem */
/* compiled from: DateTypeAdapter */
public final class C0758e extends D<Date> {

    /* renamed from: a reason: collision with root package name */
    public static final E f10048a = new C0757d();

    /* renamed from: b reason: collision with root package name */
    private final DateFormat f10049b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c reason: collision with root package name */
    private final DateFormat f10050c = DateFormat.getDateTimeInstance(2, 2);

    public Date a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return a(bVar.F());
        }
        bVar.E();
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return io.intercom.com.google.gson.b.a.a.a.a(r3, new java.text.ParsePosition(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        throw new io.intercom.com.google.gson.JsonSyntaxException(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        return r2.f10049b.parse(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    private synchronized Date a(String str) {
        return this.f10050c.parse(str);
    }

    public synchronized void a(d dVar, Date date) throws IOException {
        if (date == null) {
            dVar.h();
        } else {
            dVar.d(this.f10049b.format(date));
        }
    }
}
