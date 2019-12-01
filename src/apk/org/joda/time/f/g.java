package org.joda.time.f;

import java.util.Collections;
import java.util.Set;

/* compiled from: UTCProvider */
public final class g implements f {

    /* renamed from: a reason: collision with root package name */
    private static final Set<String> f10930a = Collections.singleton("UTC");

    public org.joda.time.g a(String str) {
        if ("UTC".equalsIgnoreCase(str)) {
            return org.joda.time.g.f10938a;
        }
        return null;
    }

    public Set<String> a() {
        return f10930a;
    }
}
