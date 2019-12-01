package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.io.IOException;
import org.joda.time.b;

public final class PaymentInfo$$JsonObjectMapper extends JsonMapper<PaymentInfo> {
    private static TypeConverter<b> org_joda_time_DateTime_type_converter;
    private static final JsonMapper<BasePaymentInfo> parentObjectMapper = LoganSquare.mapperFor(BasePaymentInfo.class);

    private static final TypeConverter<b> getorg_joda_time_DateTime_type_converter() {
        if (org_joda_time_DateTime_type_converter == null) {
            org_joda_time_DateTime_type_converter = LoganSquare.typeConverterFor(b.class);
        }
        return org_joda_time_DateTime_type_converter;
    }

    public PaymentInfo parse(e eVar) throws IOException {
        PaymentInfo paymentInfo = new PaymentInfo();
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
            parseField(paymentInfo, c2, eVar);
            eVar.G();
        }
        return paymentInfo;
    }

    public void parseField(PaymentInfo paymentInfo, String str, e eVar) throws IOException {
        if (AttributeType.DATE.equals(str)) {
            paymentInfo.a((b) getorg_joda_time_DateTime_type_converter().parse(eVar));
        } else {
            parentObjectMapper.parseField(paymentInfo, str, eVar);
        }
    }

    public void serialize(PaymentInfo paymentInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (paymentInfo.d() != null) {
            getorg_joda_time_DateTime_type_converter().serialize(paymentInfo.d(), AttributeType.DATE, true, cVar);
        }
        parentObjectMapper.serialize(paymentInfo, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
