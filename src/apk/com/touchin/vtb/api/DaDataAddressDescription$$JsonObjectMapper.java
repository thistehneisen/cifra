package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataAddressDescription$$JsonObjectMapper extends JsonMapper<DaDataAddressDescription> {
    public DaDataAddressDescription parse(e eVar) throws IOException {
        DaDataAddressDescription daDataAddressDescription = new DaDataAddressDescription();
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
            parseField(daDataAddressDescription, c2, eVar);
            eVar.G();
        }
        return daDataAddressDescription;
    }

    public void parseField(DaDataAddressDescription daDataAddressDescription, String str, e eVar) throws IOException {
        if ("city_with_type".equals(str)) {
            daDataAddressDescription.a(eVar.c(null));
        } else if ("street_with_type".equals(str)) {
            daDataAddressDescription.b(eVar.c(null));
        }
    }

    public void serialize(DaDataAddressDescription daDataAddressDescription, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataAddressDescription.b() != null) {
            cVar.a("city_with_type", daDataAddressDescription.b());
        }
        if (daDataAddressDescription.c() != null) {
            cVar.a("street_with_type", daDataAddressDescription.c());
        }
        if (z) {
            cVar.c();
        }
    }
}
