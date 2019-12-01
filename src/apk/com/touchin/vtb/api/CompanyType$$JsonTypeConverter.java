package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class CompanyType$$JsonTypeConverter implements TypeConverter<CompanyType> {
    public CompanyType parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("selfEmployed")) {
            return CompanyType.SELF_EMPLOYED;
        }
        if (E.equals("ltd")) {
            return CompanyType.LTD;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(CompanyType companyType, String str, boolean z, c cVar) throws IOException {
        String str2 = "ltd";
        String str3 = "selfEmployed";
        if (str != null) {
            if (companyType == null) {
                cVar.d(str);
                return;
            }
            int i2 = h.f7119a[companyType.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str3);
            } else if (i2 == 2) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(companyType.name());
            }
        } else if (companyType == null) {
            cVar.d();
        } else {
            int i3 = h.f7119a[companyType.ordinal()];
            if (i3 == 1) {
                cVar.f(str3);
            } else if (i3 == 2) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(companyType.name());
            }
        }
    }
}
