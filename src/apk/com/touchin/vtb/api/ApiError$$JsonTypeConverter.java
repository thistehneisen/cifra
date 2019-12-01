package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class ApiError$$JsonTypeConverter implements TypeConverter<ApiError> {
    public ApiError parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        long D = eVar.D();
        if (D == -2) {
            return ApiError.INTERNAL_SERVER_ERROR;
        }
        if (D == 16) {
            return ApiError.TAX_SYSTEM_NOT_SET;
        }
        if (D == 1002) {
            return ApiError.COMPANY_ACCOUNT_ALREADY_REGISTERED;
        }
        if (D == 1008) {
            return ApiError.MERCHANT_NOT_FOUND;
        }
        if (D == -4) {
            return ApiError.OUTDATED_VERSION;
        }
        if (D == 1005) {
            return ApiError.KPP_REQUIRED;
        }
        if (D == 27) {
            return ApiError.CONFIRMATION_CODE_RENEWED;
        }
        if (D == 1009) {
            return ApiError.AMOUNT_TOO_SMALL;
        }
        if (D == -1) {
            return ApiError.INVALID_PARAMETERS;
        }
        if (D == 13) {
            return ApiError.TASK_ID_NOT_FOUND;
        }
        if (D == 14) {
            return ApiError.TASK_ALREADY_COMPLETED;
        }
        if (D == 25) {
            return ApiError.NO_CONNECTED_COMPANY;
        }
        if (D == 5) {
            return ApiError.CONFIRMATION_CODE_INCORRECT;
        }
        if (D == 15) {
            return ApiError.TASK_ACTIVE;
        }
        if (D == 23) {
            return ApiError.BANK_CONNECTION_ERROR;
        }
        if (D == 1010) {
            return ApiError.AMOUNT_TOO_BIG;
        }
        if (D == 19) {
            return ApiError.ANOTHER_BANK_REQUEST_NOT_COMPLETED;
        }
        if (D == 24) {
            return ApiError.NO_CONNECTED_BANK;
        }
        if (D == 1007) {
            return ApiError.INCORRECT_OGRN_OR_INN;
        }
        if (D == 22) {
            return ApiError.OPERATION_NOT_ALLOWED;
        }
        if (D == 1012) {
            return ApiError.PAYMENT_ALREADY_PROCESSED;
        }
        if (D == 1006) {
            return ApiError.INCORRECT_OGRN;
        }
        if (D == 3) {
            return ApiError.OPERATION_NOT_FOUND;
        }
        if (D == 6) {
            return ApiError.CONFIRMATION_CODE_EXPIRED;
        }
        if (D == 1001) {
            return ApiError.COMPANY_ALREADY_REGISTERED;
        }
        if (D == -3) {
            return ApiError.UNSUPPORTED_VERSION;
        }
        if (D == 18) {
            return ApiError.TICKET_EXPIRED;
        }
        if (D == 9) {
            return ApiError.BANK_CONNECTION_ID_NOT_FOUND;
        }
        if (D == 10) {
            return ApiError.PROFILE_NOT_COMPLETE;
        }
        if (D == 11) {
            return ApiError.BANK_SESSION_EXPIRED;
        }
        if (D == 17) {
            return ApiError.TICKET_ID_NOT_FOUND;
        }
        if (D == 21) {
            return ApiError.INCORRECT_TASK_TYPE;
        }
        if (D == 8) {
            return ApiError.BANK_ALREADY_CONNECTED;
        }
        if (D == 1011) {
            return ApiError.PAYMENT_NOT_FOUND;
        }
        if (D == 2) {
            return ApiError.PROFILE_CONTAINS_PHONE;
        }
        if (D == 4) {
            return ApiError.USER_NOT_REGISTERED;
        }
        if (D == 1) {
            return ApiError.SESSION_ID_NOT_FOUND;
        }
        if (D == 1004) {
            return ApiError.INCORRECT_INN;
        }
        if (D == 1003) {
            return ApiError.MERCHANT_ALREADY_REGISTERED;
        }
        if (D == 7) {
            return ApiError.LOGIN_OR_PASSWORD_INCORRECT;
        }
        if (D == 0) {
            return ApiError.VALID_RESPONSE;
        }
        if (D == 12) {
            return ApiError.ACCOUNT_ID_NOT_FOUND;
        }
        if (D == 20) {
            return ApiError.TAX_SYSTEM_ALREADY_SET;
        }
        if (D == 26) {
            return ApiError.COMPANY_REGISTRATION_IN_PROGRESS;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(ApiError apiError, String str, boolean z, c cVar) throws IOException {
        String str2 = str;
        c cVar2 = cVar;
        if (str2 != null) {
            if (apiError == null) {
                cVar2.d(str2);
                return;
            }
            switch (b.f7113a[apiError.ordinal()]) {
                case 1:
                    cVar2.a(str2, -2);
                    break;
                case 2:
                    cVar2.a(str2, 16);
                    break;
                case 3:
                    cVar2.a(str2, 1002);
                    break;
                case 4:
                    cVar2.a(str2, 1008);
                    break;
                case 5:
                    cVar2.a(str2, -4);
                    break;
                case 6:
                    cVar2.a(str2, 1005);
                    break;
                case 7:
                    cVar2.a(str2, 27);
                    break;
                case 8:
                    cVar2.a(str2, 1009);
                    break;
                case 9:
                    cVar2.a(str2, -1);
                    break;
                case 10:
                    cVar2.a(str2, 13);
                    break;
                case 11:
                    cVar2.a(str2, 14);
                    break;
                case 12:
                    cVar2.a(str2, 25);
                    break;
                case 13:
                    cVar2.a(str2, 5);
                    break;
                case 14:
                    cVar2.a(str2, 15);
                    break;
                case 15:
                    cVar2.a(str2, 23);
                    break;
                case 16:
                    cVar2.a(str2, 1010);
                    break;
                case 17:
                    cVar2.a(str2, 19);
                    break;
                case 18:
                    cVar2.a(str2, 24);
                    break;
                case 19:
                    cVar2.a(str2, 1007);
                    break;
                case 20:
                    cVar2.a(str2, 22);
                    break;
                case 21:
                    cVar2.a(str2, 1012);
                    break;
                case 22:
                    cVar2.a(str2, 1006);
                    break;
                case 23:
                    cVar2.a(str2, 3);
                    break;
                case 24:
                    cVar2.a(str2, 6);
                    break;
                case 25:
                    cVar2.a(str2, 1001);
                    break;
                case 26:
                    cVar2.a(str2, -3);
                    break;
                case 27:
                    cVar2.a(str2, 18);
                    break;
                case 28:
                    cVar2.a(str2, 9);
                    break;
                case 29:
                    cVar2.a(str2, 10);
                    break;
                case 30:
                    cVar2.a(str2, 11);
                    break;
                case 31:
                    cVar2.a(str2, 17);
                    break;
                case 32:
                    cVar2.a(str2, 21);
                    break;
                case 33:
                    cVar2.a(str2, 8);
                    break;
                case 34:
                    cVar2.a(str2, 1011);
                    break;
                case 35:
                    cVar2.a(str2, 2);
                    break;
                case 36:
                    cVar2.a(str2, 4);
                    break;
                case 37:
                    cVar2.a(str2, 1);
                    break;
                case 38:
                    cVar2.a(str2, 1004);
                    break;
                case 39:
                    cVar2.a(str2, 1003);
                    break;
                case 40:
                    cVar2.a(str2, 7);
                    break;
                case 41:
                    cVar2.a(str2, 0);
                    break;
                case 42:
                    cVar2.a(str2, 12);
                    break;
                case 43:
                    cVar2.a(str2, 20);
                    break;
                case 44:
                    cVar2.a(str2, 26);
                    break;
                default:
                    throw new IllegalArgumentException(apiError.name());
            }
        } else if (apiError == null) {
            cVar.d();
        } else {
            switch (b.f7113a[apiError.ordinal()]) {
                case 1:
                    cVar2.h(-2);
                    break;
                case 2:
                    cVar2.h(16);
                    break;
                case 3:
                    cVar2.h(1002);
                    break;
                case 4:
                    cVar2.h(1008);
                    break;
                case 5:
                    cVar2.h(-4);
                    break;
                case 6:
                    cVar2.h(1005);
                    break;
                case 7:
                    cVar2.h(27);
                    break;
                case 8:
                    cVar2.h(1009);
                    break;
                case 9:
                    cVar2.h(-1);
                    break;
                case 10:
                    cVar2.h(13);
                    break;
                case 11:
                    cVar2.h(14);
                    break;
                case 12:
                    cVar2.h(25);
                    break;
                case 13:
                    cVar2.h(5);
                    break;
                case 14:
                    cVar2.h(15);
                    break;
                case 15:
                    cVar2.h(23);
                    break;
                case 16:
                    cVar2.h(1010);
                    break;
                case 17:
                    cVar2.h(19);
                    break;
                case 18:
                    cVar2.h(24);
                    break;
                case 19:
                    cVar2.h(1007);
                    break;
                case 20:
                    cVar2.h(22);
                    break;
                case 21:
                    cVar2.h(1012);
                    break;
                case 22:
                    cVar2.h(1006);
                    break;
                case 23:
                    cVar2.h(3);
                    break;
                case 24:
                    cVar2.h(6);
                    break;
                case 25:
                    cVar2.h(1001);
                    break;
                case 26:
                    cVar2.h(-3);
                    break;
                case 27:
                    cVar2.h(18);
                    break;
                case 28:
                    cVar2.h(9);
                    break;
                case 29:
                    cVar2.h(10);
                    break;
                case 30:
                    cVar2.h(11);
                    break;
                case 31:
                    cVar2.h(17);
                    break;
                case 32:
                    cVar2.h(21);
                    break;
                case 33:
                    cVar2.h(8);
                    break;
                case 34:
                    cVar2.h(1011);
                    break;
                case 35:
                    cVar2.h(2);
                    break;
                case 36:
                    cVar2.h(4);
                    break;
                case 37:
                    cVar2.h(1);
                    break;
                case 38:
                    cVar2.h(1004);
                    break;
                case 39:
                    cVar2.h(1003);
                    break;
                case 40:
                    cVar2.h(7);
                    break;
                case 41:
                    cVar2.h(0);
                    break;
                case 42:
                    cVar2.h(12);
                    break;
                case 43:
                    cVar2.h(20);
                    break;
                case 44:
                    cVar2.h(26);
                    break;
                default:
                    throw new IllegalArgumentException(apiError.name());
            }
        }
    }
}
