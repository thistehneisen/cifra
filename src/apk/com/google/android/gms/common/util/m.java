package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public class m {

    /* renamed from: a reason: collision with root package name */
    private static final Pattern f4812a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
