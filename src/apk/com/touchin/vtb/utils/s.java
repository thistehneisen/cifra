package com.touchin.vtb.utils;

import io.intercom.android.sdk.views.holder.AttributeType;
import kotlin.e.b.h;
import kotlin.f.d;
import kotlin.i.e;

/* compiled from: ValidationUtils.kt */
public final class s {

    /* renamed from: a reason: collision with root package name */
    public static final s f7640a = new s();

    private s() {
    }

    public final String a(String str) {
        h.b(str, AttributeType.PHONE);
        return new e("[^+0-9]").a(str, "");
    }

    public final String b(String str) {
        h.b(str, AttributeType.PHONE);
        StringBuilder sb = new StringBuilder();
        sb.append("+7 (");
        sb.append(s.a(str, new d(0, 2)));
        sb.append(") ");
        sb.append(s.a(str, new d(3, 5)));
        sb.append('-');
        sb.append(s.a(str, new d(6, 7)));
        sb.append('-');
        sb.append(s.a(str, new d(8, 9)));
        return sb.toString();
    }
}
