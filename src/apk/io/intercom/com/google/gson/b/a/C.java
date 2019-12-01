package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class C extends D<Character> {
    C() {
    }

    public Character a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        String F = bVar.F();
        if (F.length() == 1) {
            return Character.valueOf(F.charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expecting character, got: ");
        sb.append(F);
        throw new JsonSyntaxException(sb.toString());
    }

    public void a(d dVar, Character ch) throws IOException {
        dVar.d(ch == null ? null : String.valueOf(ch));
    }
}
