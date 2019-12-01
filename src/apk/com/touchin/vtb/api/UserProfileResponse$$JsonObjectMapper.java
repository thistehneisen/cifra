package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserProfileResponse$$JsonObjectMapper extends JsonMapper<UserProfileResponse> {
    private static final JsonMapper<UserProfile> COM_TOUCHIN_VTB_API_USERPROFILE__JSONOBJECTMAPPER = LoganSquare.mapperFor(UserProfile.class);

    public UserProfileResponse parse(e eVar) throws IOException {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
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
            parseField(userProfileResponse, c2, eVar);
            eVar.G();
        }
        return userProfileResponse;
    }

    public void parseField(UserProfileResponse userProfileResponse, String str, e eVar) throws IOException {
        if ("userProfile".equals(str)) {
            userProfileResponse.a((UserProfile) COM_TOUCHIN_VTB_API_USERPROFILE__JSONOBJECTMAPPER.parse(eVar));
        }
    }

    public void serialize(UserProfileResponse userProfileResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userProfileResponse.b() != null) {
            cVar.c("userProfile");
            COM_TOUCHIN_VTB_API_USERPROFILE__JSONOBJECTMAPPER.serialize(userProfileResponse.b(), cVar, true);
        }
        if (z) {
            cVar.c();
        }
    }
}
