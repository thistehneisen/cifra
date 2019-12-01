package org.joda.time.b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.b.a.C0124a;
import org.joda.time.d;
import org.joda.time.d.o;
import org.joda.time.g;

/* compiled from: ISOChronology */
public final class u extends a {
    private static final u K = new u(t.Z());
    private static final ConcurrentHashMap<g, u> L = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -6212696554273812441L;

    /* compiled from: ISOChronology */
    private static final class a implements Serializable {
        private static final long serialVersionUID = -6212696554273812441L;

        /* renamed from: a reason: collision with root package name */
        private transient g f10756a;

        a(g gVar) {
            this.f10756a = gVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f10756a = (g) objectInputStream.readObject();
        }

        private Object readResolve() {
            return u.b(this.f10756a);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f10756a);
        }
    }

    static {
        L.put(g.f10938a, K);
    }

    private u(org.joda.time.a aVar) {
        super(aVar, null);
    }

    public static u N() {
        return b(g.b());
    }

    public static u O() {
        return K;
    }

    public static u b(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        u uVar = (u) L.get(gVar);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(y.a((org.joda.time.a) K, gVar));
        u uVar3 = (u) L.putIfAbsent(gVar, uVar2);
        return uVar3 != null ? uVar3 : uVar2;
    }

    private Object writeReplace() {
        return new a(k());
    }

    public org.joda.time.a G() {
        return K;
    }

    public org.joda.time.a a(g gVar) {
        if (gVar == null) {
            gVar = g.b();
        }
        if (gVar == k()) {
            return this;
        }
        return b(gVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return k().equals(((u) obj).k());
    }

    public int hashCode() {
        return ("ISO".hashCode() * 11) + k().hashCode();
    }

    public String toString() {
        g k2 = k();
        String str = "ISOChronology";
        if (k2 == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('[');
        sb.append(k2.c());
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        if (L().k() == g.f10938a) {
            aVar.H = new org.joda.time.d.g(v.f10757c, d.x(), 100);
            aVar.f10717k = aVar.H.a();
            aVar.G = new o((org.joda.time.d.g) aVar.H, d.U());
            aVar.C = new o((org.joda.time.d.g) aVar.H, aVar.f10714h, d.S());
        }
    }
}
