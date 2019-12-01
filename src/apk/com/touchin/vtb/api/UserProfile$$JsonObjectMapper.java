package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class UserProfile$$JsonObjectMapper extends JsonMapper<UserProfile> {
    private static final JsonMapper<CompanyInfo> COM_TOUCHIN_VTB_API_COMPANYINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(CompanyInfo.class);
    private static final JsonMapper<ConnectedBank> COM_TOUCHIN_VTB_API_CONNECTEDBANK__JSONOBJECTMAPPER = LoganSquare.mapperFor(ConnectedBank.class);

    public UserProfile parse(e eVar) throws IOException {
        UserProfile userProfile = new UserProfile();
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
            parseField(userProfile, c2, eVar);
            eVar.G();
        }
        return userProfile;
    }

    public void parseField(UserProfile userProfile, String str, e eVar) throws IOException {
        if ("companyInfo".equals(str)) {
            userProfile.a((CompanyInfo) COM_TOUCHIN_VTB_API_COMPANYINFO__JSONOBJECTMAPPER.parse(eVar));
        } else if ("connectedBanksList".equals(str)) {
            if (eVar.d() == g.START_ARRAY) {
                ArrayList arrayList = new ArrayList();
                while (eVar.F() != g.END_ARRAY) {
                    arrayList.add((ConnectedBank) COM_TOUCHIN_VTB_API_CONNECTEDBANK__JSONOBJECTMAPPER.parse(eVar));
                }
                userProfile.a((List<ConnectedBank>) arrayList);
                return;
            }
            userProfile.a(null);
        } else if ("id".equals(str)) {
            userProfile.a(eVar.c(null));
        } else if ("phoneNumber".equals(str)) {
            userProfile.b(eVar.c(null));
        }
    }

    public void serialize(UserProfile userProfile, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userProfile.b() != null) {
            cVar.c("companyInfo");
            COM_TOUCHIN_VTB_API_COMPANYINFO__JSONOBJECTMAPPER.serialize(userProfile.b(), cVar, true);
        }
        List<ConnectedBank> c2 = userProfile.c();
        if (c2 != null) {
            cVar.c("connectedBanksList");
            cVar.e();
            for (ConnectedBank connectedBank : c2) {
                if (connectedBank != null) {
                    COM_TOUCHIN_VTB_API_CONNECTEDBANK__JSONOBJECTMAPPER.serialize(connectedBank, cVar, true);
                }
            }
            cVar.b();
        }
        if (userProfile.d() != null) {
            cVar.a("id", userProfile.d());
        }
        if (userProfile.e() != null) {
            cVar.a("phoneNumber", userProfile.e());
        }
        if (z) {
            cVar.c();
        }
    }
}
