package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: TypeAdapters */
class S extends D<Locale> {
    S() {
    }

    public Locale a(b bVar) throws IOException {
        String str = null;
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bVar.F(), io.fabric.sdk.android.a.c.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (stringTokenizer.hasMoreElements()) {
            str = stringTokenizer.nextToken();
        }
        if (nextToken2 == null && str == null) {
            return new Locale(nextToken);
        }
        if (str == null) {
            return new Locale(nextToken, nextToken2);
        }
        return new Locale(nextToken, nextToken2, str);
    }

    public void a(d dVar, Locale locale) throws IOException {
        dVar.d(locale == null ? null : locale.toString());
    }
}
