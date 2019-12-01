package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class PaymentSystem$$JsonTypeConverter implements TypeConverter<PaymentSystem> {
    public PaymentSystem parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("maestro")) {
            return PaymentSystem.MAESTRO;
        }
        if (E.equals("chinaUnionpay")) {
            return PaymentSystem.CHINA_UNIONPAY;
        }
        if (E.equals("mastercard")) {
            return PaymentSystem.MASTERCARD;
        }
        if (E.equals("discover")) {
            return PaymentSystem.DISCOVER;
        }
        if (E.equals("visa")) {
            return PaymentSystem.VISA;
        }
        if (E.equals("americanExpress")) {
            return PaymentSystem.AMERICAN_EXPRESS;
        }
        if (E.equals("jcbInternational")) {
            return PaymentSystem.JCB_INTERNATIONAL;
        }
        if (E.equals("dinersClub")) {
            return PaymentSystem.DINERS_CLUB;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(PaymentSystem paymentSystem, String str, boolean z, c cVar) throws IOException {
        String str2 = "dinersClub";
        String str3 = "jcbInternational";
        String str4 = "americanExpress";
        String str5 = "visa";
        String str6 = "discover";
        String str7 = "mastercard";
        String str8 = "chinaUnionpay";
        String str9 = "maestro";
        if (str != null) {
            if (paymentSystem == null) {
                cVar.d(str);
                return;
            }
            switch (p.f7127a[paymentSystem.ordinal()]) {
                case 1:
                    cVar.a(str, str9);
                    break;
                case 2:
                    cVar.a(str, str8);
                    break;
                case 3:
                    cVar.a(str, str7);
                    break;
                case 4:
                    cVar.a(str, str6);
                    break;
                case 5:
                    cVar.a(str, str5);
                    break;
                case 6:
                    cVar.a(str, str4);
                    break;
                case 7:
                    cVar.a(str, str3);
                    break;
                case 8:
                    cVar.a(str, str2);
                    break;
                default:
                    throw new IllegalArgumentException(paymentSystem.name());
            }
        } else if (paymentSystem == null) {
            cVar.d();
        } else {
            switch (p.f7127a[paymentSystem.ordinal()]) {
                case 1:
                    cVar.f(str9);
                    break;
                case 2:
                    cVar.f(str8);
                    break;
                case 3:
                    cVar.f(str7);
                    break;
                case 4:
                    cVar.f(str6);
                    break;
                case 5:
                    cVar.f(str5);
                    break;
                case 6:
                    cVar.f(str4);
                    break;
                case 7:
                    cVar.f(str3);
                    break;
                case 8:
                    cVar.f(str2);
                    break;
                default:
                    throw new IllegalArgumentException(paymentSystem.name());
            }
        }
    }
}
