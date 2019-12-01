package io.intercom.okhttp3;

import e.a.b.j;
import io.intercom.okhttp3.internal.Util;
import java.nio.charset.Charset;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, Util.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        String a2 = j.a(sb.toString(), charset).a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Basic ");
        sb2.append(a2);
        return sb2.toString();
    }
}
