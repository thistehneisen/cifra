package org.joda.time.f;

import java.io.InputStream;
import java.security.PrivilegedAction;

/* compiled from: ZoneInfoProvider */
class h implements PrivilegedAction<InputStream> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ String f10931a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ i f10932b;

    h(i iVar, String str) {
        this.f10932b = iVar;
        this.f10931a = str;
    }

    public InputStream run() {
        if (this.f10932b.f10935c != null) {
            return this.f10932b.f10935c.getResourceAsStream(this.f10931a);
        }
        return ClassLoader.getSystemResourceAsStream(this.f10931a);
    }
}
