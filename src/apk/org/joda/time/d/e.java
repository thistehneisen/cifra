package org.joda.time.d;

import org.joda.time.h;
import org.joda.time.i;

/* compiled from: DecoratedDurationField */
public class e extends c {
    private static final long serialVersionUID = 8019982251647420015L;
    private final h iField;

    public e(h hVar, i iVar) {
        super(iVar);
        if (hVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (hVar.d()) {
            this.iField = hVar;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public long a(long j2, int i2) {
        return this.iField.a(j2, i2);
    }

    public long b() {
        return this.iField.b();
    }

    public boolean c() {
        return this.iField.c();
    }

    public final h f() {
        return this.iField;
    }

    public long a(long j2, long j3) {
        return this.iField.a(j2, j3);
    }
}
