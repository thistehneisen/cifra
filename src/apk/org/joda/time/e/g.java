package org.joda.time.e;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.a;
import org.joda.time.t;

/* compiled from: DateTimePrinter */
public interface g {
    void a(Writer writer, long j2, a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException;

    void a(Writer writer, t tVar, Locale locale) throws IOException;

    void a(StringBuffer stringBuffer, long j2, a aVar, int i2, org.joda.time.g gVar, Locale locale);

    void a(StringBuffer stringBuffer, t tVar, Locale locale);

    int b();
}
