package ru.touchin.templates.a;

import android.text.TextUtils;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

/* compiled from: LoganSquareJodaTimeConverter */
public class b implements TypeConverter<org.joda.time.b> {

    /* renamed from: a reason: collision with root package name */
    private final org.joda.time.e.b f11180a;

    public b(org.joda.time.e.b bVar) {
        this.f11180a = bVar;
    }

    /* renamed from: a */
    public void serialize(org.joda.time.b bVar, String str, boolean z, c cVar) throws IOException {
        String a2 = bVar != null ? bVar.a(this.f11180a) : null;
        if (str != null) {
            if (TextUtils.isEmpty(a2)) {
                a2 = null;
            }
            cVar.a(str, a2);
            return;
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = null;
        }
        cVar.f(a2);
    }

    public org.joda.time.b parse(e eVar) throws IOException {
        String E = eVar.E();
        if (E != null && !E.isEmpty()) {
            try {
                return org.joda.time.b.a(E);
            } catch (RuntimeException e2) {
                l.a.d.b.a.c.a((Throwable) e2);
            }
        }
        return null;
    }
}
