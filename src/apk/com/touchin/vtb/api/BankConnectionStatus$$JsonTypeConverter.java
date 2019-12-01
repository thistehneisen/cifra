package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankConnectionStatus$$JsonTypeConverter implements TypeConverter<BankConnectionStatus> {
    public BankConnectionStatus parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("passwordRequired")) {
            return BankConnectionStatus.PASSWORD_REQUIRED;
        }
        if (E.equals("connected")) {
            return BankConnectionStatus.CONNECTED;
        }
        if (E.equals("smsCodeRequired")) {
            return BankConnectionStatus.SMS_CODE_REQUIRED;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(BankConnectionStatus bankConnectionStatus, String str, boolean z, c cVar) throws IOException {
        String str2 = "smsCodeRequired";
        String str3 = "connected";
        String str4 = "passwordRequired";
        if (str != null) {
            if (bankConnectionStatus == null) {
                cVar.d(str);
                return;
            }
            int i2 = f.f7117a[bankConnectionStatus.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str4);
            } else if (i2 == 2) {
                cVar.a(str, str3);
            } else if (i2 == 3) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(bankConnectionStatus.name());
            }
        } else if (bankConnectionStatus == null) {
            cVar.d();
        } else {
            int i3 = f.f7117a[bankConnectionStatus.ordinal()];
            if (i3 == 1) {
                cVar.f(str4);
            } else if (i3 == 2) {
                cVar.f(str3);
            } else if (i3 == 3) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(bankConnectionStatus.name());
            }
        }
    }
}
