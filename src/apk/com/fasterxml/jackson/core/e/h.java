package com.fasterxml.jackson.core.e;

import java.util.regex.Pattern;

/* compiled from: VersionUtil */
public class h {

    /* renamed from: a reason: collision with root package name */
    private static final Pattern f4389a = Pattern.compile("[-_./;:]");

    public static final void a() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
