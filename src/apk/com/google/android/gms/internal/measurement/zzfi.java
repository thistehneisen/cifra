package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzfi extends IOException {
    private C0400mc zzaiw = null;

    public zzfi(String str) {
        super(str);
    }

    static zzfi b() {
        return new zzfi("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfi c() {
        return new zzfi("CodedInputStream encountered a malformed varint.");
    }

    static zzfi d() {
        return new zzfi("Protocol message contained an invalid tag (zero).");
    }

    static zzfi e() {
        return new zzfi("Protocol message end-group tag did not match expected tag.");
    }

    static zzfh f() {
        return new zzfh("Protocol message tag had invalid wire type.");
    }

    static zzfi g() {
        return new zzfi("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzfi h() {
        return new zzfi("Failed to parse the message.");
    }

    static zzfi i() {
        return new zzfi("Protocol message had invalid UTF-8.");
    }

    public final zzfi a(C0400mc mcVar) {
        this.zzaiw = mcVar;
        return this;
    }

    static zzfi a() {
        return new zzfi("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
