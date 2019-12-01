package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import io.intercom.android.sdk.metrics.MetricTracker.Object;
import java.io.IOException;

public final class DaDataError$$JsonObjectMapper extends JsonMapper<DaDataError> {
    public DaDataError parse(e eVar) throws IOException {
        DaDataError daDataError = new DaDataError();
        if (eVar.d() == null) {
            eVar.F();
        }
        if (eVar.d() != g.START_OBJECT) {
            eVar.G();
            return null;
        }
        while (eVar.F() != g.END_OBJECT) {
            String c2 = eVar.c();
            eVar.F();
            parseField(daDataError, c2, eVar);
            eVar.G();
        }
        return daDataError;
    }

    public void parseField(DaDataError daDataError, String str, e eVar) throws IOException {
        if ("family".equals(str)) {
            daDataError.a(eVar.c(null));
        } else if (Object.MESSAGE.equals(str)) {
            daDataError.b(eVar.c(null));
        } else if ("reason".equals(str)) {
            daDataError.c(eVar.c(null));
        }
    }

    public void serialize(DaDataError daDataError, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataError.b() != null) {
            cVar.a("family", daDataError.b());
        }
        if (daDataError.c() != null) {
            cVar.a(Object.MESSAGE, daDataError.c());
        }
        if (daDataError.d() != null) {
            cVar.a("reason", daDataError.d());
        }
        if (z) {
            cVar.c();
        }
    }
}
