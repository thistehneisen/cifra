package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TokenAddBody$$JsonObjectMapper extends JsonMapper<TokenAddBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public TokenAddBody parse(e eVar) throws IOException {
        TokenAddBody tokenAddBody = new TokenAddBody();
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
            parseField(tokenAddBody, c2, eVar);
            eVar.G();
        }
        return tokenAddBody;
    }

    public void parseField(TokenAddBody tokenAddBody, String str, e eVar) throws IOException {
        if ("token".equals(str)) {
            tokenAddBody.b(eVar.c(null));
        } else {
            parentObjectMapper.parseField(tokenAddBody, str, eVar);
        }
    }

    public void serialize(TokenAddBody tokenAddBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (tokenAddBody.c() != null) {
            cVar.a("token", tokenAddBody.c());
        }
        parentObjectMapper.serialize(tokenAddBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
