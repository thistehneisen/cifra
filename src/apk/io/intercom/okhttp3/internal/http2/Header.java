package io.intercom.okhttp3.internal.http2;

import e.a.b.j;
import io.intercom.okhttp3.internal.Util;

public final class Header {
    public static final j PSEUDO_PREFIX = j.c(":");
    public static final j RESPONSE_STATUS = j.c(":status");
    public static final j TARGET_AUTHORITY = j.c(":authority");
    public static final j TARGET_METHOD = j.c(":method");
    public static final j TARGET_PATH = j.c(":path");
    public static final j TARGET_SCHEME = j.c(":scheme");
    final int hpackSize;
    public final j name;
    public final j value;

    public Header(String str, String str2) {
        this(j.c(str), j.c(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (!this.name.equals(header.name) || !this.value.equals(header.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.h(), this.value.h());
    }

    public Header(j jVar, String str) {
        this(jVar, j.c(str));
    }

    public Header(j jVar, j jVar2) {
        this.name = jVar;
        this.value = jVar2;
        this.hpackSize = jVar.size() + 32 + jVar2.size();
    }
}
