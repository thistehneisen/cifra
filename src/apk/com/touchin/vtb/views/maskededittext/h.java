package com.touchin.vtb.views.maskededittext;

import kotlin.TypeCastException;

/* compiled from: RawText.kt */
public final class h {

    /* renamed from: a reason: collision with root package name */
    private String f7839a = "";

    public final String a() {
        return this.f7839a;
    }

    public final int b() {
        return this.f7839a.length();
    }

    public final void a(g gVar) {
        String str;
        kotlin.e.b.h.b(gVar, "range");
        String str2 = "null cannot be cast to non-null type java.lang.String";
        String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
        String str4 = "";
        if (gVar.b() <= 0 || gVar.b() > this.f7839a.length()) {
            str = str4;
        } else {
            String str5 = this.f7839a;
            int b2 = gVar.b();
            if (str5 != null) {
                str = str5.substring(0, b2);
                kotlin.e.b.h.a((Object) str, str3);
            } else {
                throw new TypeCastException(str2);
            }
        }
        if (gVar.a() >= 0 && gVar.a() < this.f7839a.length()) {
            String str6 = this.f7839a;
            int a2 = gVar.a();
            int length = this.f7839a.length();
            if (str6 != null) {
                str4 = str6.substring(a2, length);
                kotlin.e.b.h.a((Object) str4, str3);
            } else {
                throw new TypeCastException(str2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str4);
        this.f7839a = sb.toString();
    }

    public final int a(String str, int i2, int i3) {
        String str2;
        if (str == null) {
            return 0;
        }
        if (str.length() == 0) {
            return 0;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Start position must be non-negative");
        } else if (i2 <= this.f7839a.length()) {
            int length = str.length();
            String str3 = "";
            String str4 = "null cannot be cast to non-null type java.lang.String";
            String str5 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            if (i2 > 0) {
                String str6 = this.f7839a;
                if (str6 != null) {
                    str2 = str6.substring(0, i2);
                    kotlin.e.b.h.a((Object) str2, str5);
                } else {
                    throw new TypeCastException(str4);
                }
            } else {
                str2 = str3;
            }
            if (i2 >= 0 && i2 < this.f7839a.length()) {
                String str7 = this.f7839a;
                int length2 = str7.length();
                if (str7 != null) {
                    str3 = str7.substring(i2, length2);
                    kotlin.e.b.h.a((Object) str3, str5);
                } else {
                    throw new TypeCastException(str4);
                }
            }
            if (this.f7839a.length() + str.length() > i3) {
                length = i3 - this.f7839a.length();
                if (str != null) {
                    str = str.substring(0, length);
                    kotlin.e.b.h.a((Object) str, str5);
                } else {
                    throw new TypeCastException(str4);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            sb.append(str3);
            this.f7839a = sb.toString();
            return length;
        } else {
            throw new IllegalArgumentException("Start position must be less than the actual text length");
        }
    }

    public final char a(int i2) {
        return this.f7839a.charAt(i2);
    }
}
