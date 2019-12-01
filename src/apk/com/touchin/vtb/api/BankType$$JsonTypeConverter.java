package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankType$$JsonTypeConverter implements TypeConverter<BankType> {
    public BankType parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("openbank")) {
            return BankType.OPENBANK;
        }
        if (E.equals("vtb")) {
            return BankType.VTB;
        }
        if (E.equals("tinkoff")) {
            return BankType.TINKOFF;
        }
        if (E.equals("alpha")) {
            return BankType.ALPHA;
        }
        if (E.equals("sber")) {
            return BankType.SBER;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(BankType bankType, String str, boolean z, c cVar) throws IOException {
        String str2 = "sber";
        String str3 = "alpha";
        String str4 = "tinkoff";
        String str5 = "vtb";
        String str6 = "openbank";
        if (str != null) {
            if (bankType == null) {
                cVar.d(str);
                return;
            }
            int i2 = g.f7118a[bankType.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str6);
            } else if (i2 == 2) {
                cVar.a(str, str5);
            } else if (i2 == 3) {
                cVar.a(str, str4);
            } else if (i2 == 4) {
                cVar.a(str, str3);
            } else if (i2 == 5) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(bankType.name());
            }
        } else if (bankType == null) {
            cVar.d();
        } else {
            int i3 = g.f7118a[bankType.ordinal()];
            if (i3 == 1) {
                cVar.f(str6);
            } else if (i3 == 2) {
                cVar.f(str5);
            } else if (i3 == 3) {
                cVar.f(str4);
            } else if (i3 == 4) {
                cVar.f(str3);
            } else if (i3 == 5) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(bankType.name());
            }
        }
    }
}
