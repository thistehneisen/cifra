package com.fasterxml.jackson.core.e;

import java.io.IOException;

/* compiled from: DefaultIndenter */
public class c extends com.fasterxml.jackson.core.e.d.c {

    /* renamed from: b reason: collision with root package name */
    public static final String f4370b;

    /* renamed from: c reason: collision with root package name */
    public static final c f4371c = new c("  ", f4370b);
    private static final long serialVersionUID = 1;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    static {
        String str;
        try {
            str = System.getProperty("line.separator");
        } catch (Throwable unused) {
            str = "\n";
        }
        f4370b = str;
    }

    public c() {
        this("  ", f4370b);
    }

    public void a(com.fasterxml.jackson.core.c cVar, int i2) throws IOException {
        cVar.e(this.eol);
        if (i2 > 0) {
            int i3 = i2 * this.charsPerLevel;
            while (true) {
                char[] cArr = this.indents;
                if (i3 > cArr.length) {
                    cVar.a(cArr, 0, cArr.length);
                    i3 -= this.indents.length;
                } else {
                    cVar.a(cArr, 0, i3);
                    return;
                }
            }
        }
    }

    public boolean a() {
        return false;
    }

    public c(String str, String str2) {
        this.charsPerLevel = str.length();
        this.indents = new char[(str.length() * 16)];
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            str.getChars(0, str.length(), this.indents, i2);
            i2 += str.length();
        }
        this.eol = str2;
    }
}
