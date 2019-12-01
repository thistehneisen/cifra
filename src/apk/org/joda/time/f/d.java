package org.joda.time.f;

import org.joda.time.g;

/* compiled from: FixedDateTimeZone */
public final class d extends g {
    private static final long serialVersionUID = -3513011772763289092L;
    private final String iNameKey;
    private final int iStandardOffset;
    private final int iWallOffset;

    public d(String str, String str2, int i2, int i3) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i2;
        this.iStandardOffset = i3;
    }

    public String b(long j2) {
        return this.iNameKey;
    }

    public int c(long j2) {
        return this.iWallOffset;
    }

    public int d(long j2) {
        return this.iWallOffset;
    }

    public int e(long j2) {
        return this.iStandardOffset;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!(c().equals(dVar.c()) && this.iStandardOffset == dVar.iStandardOffset && this.iWallOffset == dVar.iWallOffset)) {
            z = false;
        }
        return z;
    }

    public boolean f() {
        return true;
    }

    public long g(long j2) {
        return j2;
    }

    public long h(long j2) {
        return j2;
    }

    public int hashCode() {
        return c().hashCode() + (this.iStandardOffset * 37) + (this.iWallOffset * 31);
    }
}
