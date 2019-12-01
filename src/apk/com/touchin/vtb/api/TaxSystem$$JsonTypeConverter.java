package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaxSystem$$JsonTypeConverter implements TypeConverter<TaxSystem> {
    public TaxSystem parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        if (eVar.E().equals("usn6")) {
            return TaxSystem.USN6;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TaxSystem taxSystem, String str, boolean z, c cVar) throws IOException {
        String str2 = "usn6";
        if (str != null) {
            if (taxSystem == null) {
                cVar.d(str);
            } else if (x.f7134a[taxSystem.ordinal()] == 1) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(taxSystem.name());
            }
        } else if (taxSystem == null) {
            cVar.d();
        } else if (x.f7134a[taxSystem.ordinal()] == 1) {
            cVar.f(str2);
        } else {
            throw new IllegalArgumentException(taxSystem.name());
        }
    }
}
