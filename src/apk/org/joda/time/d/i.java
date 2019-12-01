package org.joda.time.d;

import org.joda.time.d;
import org.joda.time.h;

/* compiled from: ImpreciseDateTimeField */
public abstract class i extends b {

    /* renamed from: b reason: collision with root package name */
    final long f10807b;

    /* renamed from: c reason: collision with root package name */
    private final h f10808c;

    /* compiled from: ImpreciseDateTimeField */
    private final class a extends c {
        private static final long serialVersionUID = -203813474600094134L;

        a(org.joda.time.i iVar) {
            super(iVar);
        }

        public long a(long j2, int i2) {
            return i.this.a(j2, i2);
        }

        public long b() {
            return i.this.f10807b;
        }

        public boolean c() {
            return false;
        }

        public long a(long j2, long j3) {
            return i.this.a(j2, j3);
        }
    }

    public i(d dVar, long j2) {
        super(dVar);
        this.f10807b = j2;
        this.f10808c = new a(dVar.E());
    }

    public final h a() {
        return this.f10808c;
    }
}
