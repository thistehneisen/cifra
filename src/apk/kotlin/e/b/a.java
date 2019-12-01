package kotlin.e.b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.g.b;
import kotlin.g.e;

/* compiled from: CallableReference */
public abstract class a implements b, Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final Object f10301a = C0117a.f10303a;

    /* renamed from: b reason: collision with root package name */
    private transient b f10302b;
    protected final Object receiver;

    /* renamed from: kotlin.e.b.a$a reason: collision with other inner class name */
    /* compiled from: CallableReference */
    private static class C0117a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public static final C0117a f10303a = new C0117a();

        private C0117a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f10303a;
        }
    }

    public a() {
        this(f10301a);
    }

    public b c() {
        b bVar = this.f10302b;
        if (bVar != null) {
            return bVar;
        }
        b d2 = d();
        this.f10302b = d2;
        return d2;
    }

    /* access modifiers changed from: protected */
    public abstract b d();

    public Object e() {
        return this.receiver;
    }

    public String f() {
        throw new AbstractMethodError();
    }

    public e g() {
        throw new AbstractMethodError();
    }

    /* access modifiers changed from: protected */
    public b h() {
        b c2 = c();
        if (c2 != this) {
            return c2;
        }
        throw new kotlin.e.b();
    }

    public String i() {
        throw new AbstractMethodError();
    }

    protected a(Object obj) {
        this.receiver = obj;
    }
}
