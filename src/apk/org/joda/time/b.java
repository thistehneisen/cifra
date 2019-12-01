package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.a.d;
import org.joda.time.e.j;

/* compiled from: DateTime */
public final class b extends d implements p, Serializable {
    private static final long serialVersionUID = -5171125899451703815L;

    /* compiled from: DateTime */
    public static final class a extends org.joda.time.d.a {
        private static final long serialVersionUID = -6983323811635733510L;
        private c iField;
        private b iInstant;

        a(b bVar, c cVar) {
            this.iInstant = bVar;
            this.iField = cVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (b) objectInputStream.readObject();
            this.iField = ((d) objectInputStream.readObject()).a(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.g());
        }

        /* access modifiers changed from: protected */
        public a b() {
            return this.iInstant.getChronology();
        }

        public c c() {
            return this.iField;
        }

        /* access modifiers changed from: protected */
        public long f() {
            return this.iInstant.n();
        }
    }

    public b() {
    }

    public static b a(String str) {
        return a(str, j.c().e());
    }

    public static b g() {
        return new b();
    }

    public b c(long j2) {
        return j2 == n() ? this : new b(j2, getChronology());
    }

    public a f() {
        return new a(this, getChronology().g());
    }

    public b p() {
        return this;
    }

    public b(long j2, g gVar) {
        super(j2, gVar);
    }

    public static b a(String str, org.joda.time.e.b bVar) {
        return bVar.a(str);
    }

    public b c(a aVar) {
        a a2 = e.a(aVar);
        return a2 == getChronology() ? this : new b(n(), a2);
    }

    public b(long j2, a aVar) {
        super(j2, aVar);
    }

    public b a(g gVar) {
        return c(getChronology().a(gVar));
    }

    public b(Object obj) {
        super(obj, (a) null);
    }

    public b a(int i2) {
        if (i2 == 0) {
            return this;
        }
        return c(getChronology().C().b(n(), i2));
    }

    public b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, a aVar) {
        super(i2, i3, i4, i5, i6, i7, i8, aVar);
    }
}
