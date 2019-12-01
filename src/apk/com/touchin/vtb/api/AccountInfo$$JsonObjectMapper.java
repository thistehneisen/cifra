package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class AccountInfo$$JsonObjectMapper extends JsonMapper<AccountInfo> {
    private static final JsonMapper<Amount> COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER = LoganSquare.mapperFor(Amount.class);
    private static TypeConverter<AccountType> com_touchin_vtb_api_AccountType_type_converter;
    private static TypeConverter<PaymentSystem> com_touchin_vtb_api_PaymentSystem_type_converter;

    private static final TypeConverter<AccountType> getcom_touchin_vtb_api_AccountType_type_converter() {
        if (com_touchin_vtb_api_AccountType_type_converter == null) {
            com_touchin_vtb_api_AccountType_type_converter = LoganSquare.typeConverterFor(AccountType.class);
        }
        return com_touchin_vtb_api_AccountType_type_converter;
    }

    private static final TypeConverter<PaymentSystem> getcom_touchin_vtb_api_PaymentSystem_type_converter() {
        if (com_touchin_vtb_api_PaymentSystem_type_converter == null) {
            com_touchin_vtb_api_PaymentSystem_type_converter = LoganSquare.typeConverterFor(PaymentSystem.class);
        }
        return com_touchin_vtb_api_PaymentSystem_type_converter;
    }

    public AccountInfo parse(e eVar) throws IOException {
        AccountInfo accountInfo = new AccountInfo();
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
            parseField(accountInfo, c2, eVar);
            eVar.G();
        }
        return accountInfo;
    }

    public void parseField(AccountInfo accountInfo, String str, e eVar) throws IOException {
        if ("accountNumberMask".equals(str)) {
            accountInfo.a(eVar.c(null));
        } else if ("amount".equals(str)) {
            accountInfo.a((Amount) COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.parse(eVar));
        } else if ("connectedBankId".equals(str)) {
            accountInfo.b(eVar.c(null));
        } else if ("id".equals(str)) {
            accountInfo.c(eVar.c(null));
        } else if ("operationsAvailable".equals(str)) {
            accountInfo.a(eVar.k());
        } else if ("paymentSystem".equals(str)) {
            accountInfo.a((PaymentSystem) getcom_touchin_vtb_api_PaymentSystem_type_converter().parse(eVar));
        } else if ("title".equals(str)) {
            accountInfo.d(eVar.c(null));
        } else if ("type".equals(str)) {
            accountInfo.a((AccountType) getcom_touchin_vtb_api_AccountType_type_converter().parse(eVar));
        }
    }

    public void serialize(AccountInfo accountInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (accountInfo.b() != null) {
            cVar.a("accountNumberMask", accountInfo.b());
        }
        if (accountInfo.c() != null) {
            cVar.c("amount");
            COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.serialize(accountInfo.c(), cVar, true);
        }
        if (accountInfo.d() != null) {
            cVar.a("connectedBankId", accountInfo.d());
        }
        if (accountInfo.e() != null) {
            cVar.a("id", accountInfo.e());
        }
        cVar.a("operationsAvailable", accountInfo.f());
        if (accountInfo.g() != null) {
            getcom_touchin_vtb_api_PaymentSystem_type_converter().serialize(accountInfo.g(), "paymentSystem", true, cVar);
        }
        if (accountInfo.h() != null) {
            cVar.a("title", accountInfo.h());
        }
        if (accountInfo.i() != null) {
            getcom_touchin_vtb_api_AccountType_type_converter().serialize(accountInfo.i(), "type", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
