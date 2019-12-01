package com.touchin.vtb.e;

import i.O;
import j.f;
import java.nio.charset.Charset;
import kotlin.e.b.h;

/* compiled from: ResponseBody.kt */
public final class i {
    public static final String a(O o) {
        h.b(o, "$this$cloneBody");
        j.h d2 = o.d();
        d2.a(Long.MAX_VALUE);
        f n = d2.n();
        if (n != null) {
            f clone = n.clone();
            if (clone != null) {
                return clone.a(Charset.forName("UTF-8"));
            }
        }
        return null;
    }
}
