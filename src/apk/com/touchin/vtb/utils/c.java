package com.touchin.vtb.utils;

import android.os.Build;
import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: DeviceUtils.kt */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public static final c f7616a = new c();

    private c() {
    }

    public final String a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        h.a((Object) str2, "model");
        String str3 = "null cannot be cast to non-null type java.lang.String";
        if (str2 != null) {
            String lowerCase = str2.toLowerCase();
            String str4 = "(this as java.lang.String).toLowerCase()";
            h.a((Object) lowerCase, str4);
            h.a((Object) str, "manufacturer");
            if (str != null) {
                String lowerCase2 = str.toLowerCase();
                h.a((Object) lowerCase2, str4);
                if (n.a(lowerCase, lowerCase2, false, 2, null)) {
                    return a(str2);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(a(str));
                sb.append(" ");
                sb.append(str2);
                return sb.toString();
            }
            throw new TypeCastException(str3);
        }
        throw new TypeCastException(str3);
    }

    private final String a(String str) {
        if (str == null || n.a(str)) {
            return "";
        }
        char charAt = str.charAt(0);
        if (!Character.isUpperCase(charAt)) {
            char upperCase = Character.toUpperCase(charAt);
            if (str != null) {
                String substring = str.substring(1);
                h.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(upperCase));
                sb.append(substring);
                str = sb.toString();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return str;
    }
}
