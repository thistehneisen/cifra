package com.touchin.vtb.utils;

import java.util.Locale;
import kotlin.e.b.h;

/* compiled from: LocaleUtils.kt */
public final class l {

    /* renamed from: a reason: collision with root package name */
    private static final Locale f7627a;

    /* renamed from: b reason: collision with root package name */
    public static final l f7628b = new l();

    static {
        Locale forLanguageTag = Locale.forLanguageTag("RU");
        h.a((Object) forLanguageTag, "Locale.forLanguageTag(\"RU\")");
        f7627a = forLanguageTag;
    }

    private l() {
    }

    public final Locale a() {
        return f7627a;
    }
}
