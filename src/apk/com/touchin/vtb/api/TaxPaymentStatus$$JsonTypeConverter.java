package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;

public final class TaxPaymentStatus$$JsonTypeConverter implements TypeConverter<TaxPaymentStatus> {
    public TaxPaymentStatus parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("created")) {
            return TaxPaymentStatus.CREATED;
        }
        if (E.equals(Action.COMPLETED)) {
            return TaxPaymentStatus.COMPLETED;
        }
        if (E.equals("error")) {
            return TaxPaymentStatus.ERROR;
        }
        if (E.equals("smsCodeRequired")) {
            return TaxPaymentStatus.SMS_CODE_REQUIRED;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(TaxPaymentStatus taxPaymentStatus, String str, boolean z, c cVar) throws IOException {
        String str2 = "smsCodeRequired";
        String str3 = "error";
        String str4 = Action.COMPLETED;
        String str5 = "created";
        if (str != null) {
            if (taxPaymentStatus == null) {
                cVar.d(str);
                return;
            }
            int i2 = w.f7133a[taxPaymentStatus.ordinal()];
            if (i2 == 1) {
                cVar.a(str, str5);
            } else if (i2 == 2) {
                cVar.a(str, str4);
            } else if (i2 == 3) {
                cVar.a(str, str3);
            } else if (i2 == 4) {
                cVar.a(str, str2);
            } else {
                throw new IllegalArgumentException(taxPaymentStatus.name());
            }
        } else if (taxPaymentStatus == null) {
            cVar.d();
        } else {
            int i3 = w.f7133a[taxPaymentStatus.ordinal()];
            if (i3 == 1) {
                cVar.f(str5);
            } else if (i3 == 2) {
                cVar.f(str4);
            } else if (i3 == 3) {
                cVar.f(str3);
            } else if (i3 == 4) {
                cVar.f(str2);
            } else {
                throw new IllegalArgumentException(taxPaymentStatus.name());
            }
        }
    }
}
