package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class AccountType$$JsonTypeConverter implements TypeConverter<AccountType> {
    public AccountType parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        String E = eVar.E();
        if (E.equals("credit")) {
            return AccountType.CREDIT;
        }
        if (E.equals("account")) {
            return AccountType.ACCOUNT;
        }
        if (E.equals("wallet")) {
            return AccountType.WALLET;
        }
        if (E.equals("deposit")) {
            return AccountType.DEPOSIT;
        }
        if (E.equals("cell")) {
            return AccountType.CELL;
        }
        if (E.equals("card")) {
            return AccountType.CARD;
        }
        throw new IllegalArgumentException(eVar.toString());
    }

    public void serialize(AccountType accountType, String str, boolean z, c cVar) throws IOException {
        String str2 = "card";
        String str3 = "cell";
        String str4 = "deposit";
        String str5 = "wallet";
        String str6 = "account";
        String str7 = "credit";
        if (str != null) {
            if (accountType == null) {
                cVar.d(str);
                return;
            }
            switch (C0647a.f7107a[accountType.ordinal()]) {
                case 1:
                    cVar.a(str, str7);
                    break;
                case 2:
                    cVar.a(str, str6);
                    break;
                case 3:
                    cVar.a(str, str5);
                    break;
                case 4:
                    cVar.a(str, str4);
                    break;
                case 5:
                    cVar.a(str, str3);
                    break;
                case 6:
                    cVar.a(str, str2);
                    break;
                default:
                    throw new IllegalArgumentException(accountType.name());
            }
        } else if (accountType == null) {
            cVar.d();
        } else {
            switch (C0647a.f7107a[accountType.ordinal()]) {
                case 1:
                    cVar.f(str7);
                    break;
                case 2:
                    cVar.f(str6);
                    break;
                case 3:
                    cVar.f(str5);
                    break;
                case 4:
                    cVar.f(str4);
                    break;
                case 5:
                    cVar.f(str3);
                    break;
                case 6:
                    cVar.f(str2);
                    break;
                default:
                    throw new IllegalArgumentException(accountType.name());
            }
        }
    }
}
