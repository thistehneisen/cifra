package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.a.d;

/* compiled from: MutableDateTime */
public class m extends d implements n, Cloneable, Serializable {
    private static final long serialVersionUID = 2852608688135209575L;
    private c iRoundingField;
    private int iRoundingMode;

    /* compiled from: MutableDateTime */
    public static final class a extends org.joda.time.d.a {
        private static final long serialVersionUID = -4481126543819298617L;
        private c iField;
        private m iInstant;

        a(m mVar, c cVar) {
            this.iInstant = mVar;
            this.iField = cVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (m) objectInputStream.readObject();
            this.iField = ((d) objectInputStream.readObject()).a(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.g());
        }

        public m a(int i2) {
            this.iInstant.b(c().b(this.iInstant.n(), i2));
            return this.iInstant;
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

    public m() {
    }

    public void a(g gVar) {
        g a2 = e.a(gVar);
        g a3 = e.a(a());
        if (a2 != a3) {
            long a4 = a3.a(a2, n());
            b(getChronology().a(a2));
            b(a4);
        }
    }

    public void b(long j2) {
        int i2 = this.iRoundingMode;
        if (i2 != 0) {
            if (i2 == 1) {
                j2 = this.iRoundingField.e(j2);
            } else if (i2 == 2) {
                j2 = this.iRoundingField.d(j2);
            } else if (i2 == 3) {
                j2 = this.iRoundingField.h(j2);
            } else if (i2 == 4) {
                j2 = this.iRoundingField.f(j2);
            } else if (i2 == 5) {
                j2 = this.iRoundingField.g(j2);
            }
        }
        super.b(j2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public m(long j2, g gVar) {
        super(j2, gVar);
    }

    public a a(d dVar) {
        if (dVar != null) {
            c a2 = dVar.a(getChronology());
            if (a2.i()) {
                return new a(this, a2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Field '");
            sb.append(dVar);
            sb.append("' is not supported");
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public void b(a aVar) {
        super.b(aVar);
    }
}
