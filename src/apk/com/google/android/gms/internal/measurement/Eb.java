package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb;
import com.google.android.gms.internal.measurement.Eb.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Eb<MessageType extends Eb<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends Na<MessageType, BuilderType> {
    private static Map<Object, Eb<?, ?>> zzaib = new ConcurrentHashMap();
    protected Vc zzahz = Vc.c();
    private int zzaia = -1;

    public static abstract class a<MessageType extends Eb<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends Pa<MessageType, BuilderType> {

        /* renamed from: a reason: collision with root package name */
        private final MessageType f4911a;

        /* renamed from: b reason: collision with root package name */
        protected MessageType f4912b;

        /* renamed from: c reason: collision with root package name */
        private boolean f4913c = false;

        protected a(MessageType messagetype) {
            this.f4911a = messagetype;
            this.f4912b = (Eb) messagetype.a(d.f4918d, (Object) null, (Object) null);
        }

        private final BuilderType b(byte[] bArr, int i2, int i3, C0428rb rbVar) throws zzfi {
            g();
            try {
                C0459wc.a().a(this.f4912b).a(this.f4912b, bArr, 0, i3 + 0, new Sa(rbVar));
                return this;
            } catch (zzfi e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw zzfi.a();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        public final BuilderType a(MessageType messagetype) {
            g();
            a(this.f4912b, messagetype);
            return this;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.f4911a.a(d.f4919e, (Object) null, (Object) null);
            aVar.a((MessageType) (Eb) z());
            return aVar;
        }

        /* access modifiers changed from: protected */
        public final void g() {
            if (this.f4913c) {
                MessageType messagetype = (Eb) this.f4912b.a(d.f4918d, (Object) null, (Object) null);
                a(messagetype, this.f4912b);
                this.f4912b = messagetype;
                this.f4913c = false;
            }
        }

        /* renamed from: h */
        public MessageType z() {
            if (this.f4913c) {
                return this.f4912b;
            }
            this.f4912b.i();
            this.f4913c = true;
            return this.f4912b;
        }

        /* renamed from: i */
        public final MessageType A() {
            MessageType messagetype = (Eb) z();
            if (messagetype.b()) {
                return messagetype;
            }
            throw new zzhq(messagetype);
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            C0459wc.a().a(messagetype).a(messagetype, messagetype2);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Pa a(Na na) {
            a((MessageType) (Eb) na);
            return this;
        }

        public final /* synthetic */ Pa a(byte[] bArr, int i2, int i3, C0428rb rbVar) throws zzfi {
            b(bArr, 0, i3, rbVar);
            return this;
        }

        public final /* synthetic */ C0400mc a() {
            return this.f4911a;
        }
    }

    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType> extends Eb<MessageType, BuilderType> implements C0412oc {
        protected C0446ub<Object> zzaic = C0446ub.f();

        /* access modifiers changed from: 0000 */
        public final C0446ub<Object> o() {
            if (this.zzaic.b()) {
                this.zzaic = (C0446ub) this.zzaic.clone();
            }
            return this.zzaic;
        }
    }

    public static class c<T extends Eb<T, ?>> extends Oa<T> {

        /* renamed from: b reason: collision with root package name */
        private final T f4914b;

        public c(T t) {
            this.f4914b = t;
        }

        public final /* synthetic */ Object a(C0381jb jbVar, C0428rb rbVar) throws zzfi {
            return Eb.a(this.f4914b, jbVar, rbVar);
        }
    }

    /* 'enum' access flag removed */
    public static final class d {

        /* renamed from: a reason: collision with root package name */
        public static final int f4915a = 1;

        /* renamed from: b reason: collision with root package name */
        public static final int f4916b = 2;

        /* renamed from: c reason: collision with root package name */
        public static final int f4917c = 3;

        /* renamed from: d reason: collision with root package name */
        public static final int f4918d = 4;

        /* renamed from: e reason: collision with root package name */
        public static final int f4919e = 5;

        /* renamed from: f reason: collision with root package name */
        public static final int f4920f = 6;

        /* renamed from: g reason: collision with root package name */
        public static final int f4921g = 7;

        /* renamed from: h reason: collision with root package name */
        private static final /* synthetic */ int[] f4922h = {f4915a, f4916b, f4917c, f4918d, f4919e, f4920f, f4921g};

        /* renamed from: i reason: collision with root package name */
        public static final int f4923i = 1;

        /* renamed from: j reason: collision with root package name */
        public static final int f4924j = 2;

        /* renamed from: k reason: collision with root package name */
        private static final /* synthetic */ int[] f4925k = {f4923i, f4924j};

        /* renamed from: l reason: collision with root package name */
        public static final int f4926l = 1;
        public static final int m = 2;
        private static final /* synthetic */ int[] n = {f4926l, m};

        public static int[] a() {
            return (int[]) f4922h.clone();
        }
    }

    public static class e<ContainingType extends C0400mc, Type> extends C0423qb<ContainingType, Type> {
    }

    protected static Kb l() {
        return Hb.f();
    }

    protected static Nb m() {
        return C0325ac.f();
    }

    protected static <E> Mb<E> n() {
        return C0477zc.f();
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i2, Object obj, Object obj2);

    /* access modifiers changed from: 0000 */
    public final void a(int i2) {
        this.zzaia = i2;
    }

    public final boolean b() {
        return a((T) this, Boolean.TRUE.booleanValue());
    }

    public final int c() {
        if (this.zzaia == -1) {
            this.zzaia = C0459wc.a().a(this).b(this);
        }
        return this.zzaia;
    }

    public final /* synthetic */ C0394lc e() {
        return (a) a(d.f4919e, (Object) null, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((Eb) a(d.f4920f, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return C0459wc.a().a(this).b(this, (Eb) obj);
    }

    public final /* synthetic */ C0394lc f() {
        a aVar = (a) a(d.f4919e, (Object) null, (Object) null);
        aVar.a(this);
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    public final int h() {
        return this.zzaia;
    }

    public int hashCode() {
        int i2 = this.zzact;
        if (i2 != 0) {
            return i2;
        }
        this.zzact = C0459wc.a().a(this).d(this);
        return this.zzact;
    }

    /* access modifiers changed from: protected */
    public final void i() {
        C0459wc.a().a(this).c(this);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends Eb<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType j() {
        return (a) a(d.f4919e, (Object) null, (Object) null);
    }

    public final BuilderType k() {
        BuilderType buildertype = (a) a(d.f4919e, (Object) null, (Object) null);
        buildertype.a(this);
        return buildertype;
    }

    public String toString() {
        return C0406nc.a(this, super.toString());
    }

    public final void a(zzee zzee) throws IOException {
        C0459wc.a().a(getClass()).a(this, (C0419pd) C0411ob.a(zzee));
    }

    static <T extends Eb<?, ?>> T a(Class<T> cls) {
        T t = (Eb) zzaib.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (Eb) zzaib.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (Eb) ((Eb) Yc.a(cls)).a(d.f4920f, (Object) null, (Object) null);
            if (t != null) {
                zzaib.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends Eb<?, ?>> void a(Class<T> cls, T t) {
        zzaib.put(cls, t);
    }

    protected static Object a(C0400mc mcVar, String str, Object[] objArr) {
        return new C0471yc(mcVar, str, objArr);
    }

    static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends Eb<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(d.f4915a, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean a2 = C0459wc.a().a(t).a(t);
        if (z) {
            t.a(d.f4916b, (Object) a2 ? t : null, (Object) null);
        }
        return a2;
    }

    protected static Nb a(Nb nb) {
        int size = nb.size();
        return nb.c(size == 0 ? 10 : size << 1);
    }

    protected static <E> Mb<E> a(Mb<E> mb) {
        int size = mb.size();
        return mb.b(size == 0 ? 10 : size << 1);
    }

    static <T extends Eb<T, ?>> T a(T t, C0381jb jbVar, C0428rb rbVar) throws zzfi {
        T t2 = (Eb) t.a(d.f4918d, (Object) null, (Object) null);
        try {
            C0459wc.a().a(t2).a(t2, C0387kb.a(jbVar), rbVar);
            t2.i();
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzfi) {
                throw ((zzfi) e2.getCause());
            }
            throw new zzfi(e2.getMessage()).a(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzfi) {
                throw ((zzfi) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends Eb<T, ?>> T a(T t, byte[] bArr, int i2, int i3, C0428rb rbVar) throws zzfi {
        T t2 = (Eb) t.a(d.f4918d, (Object) null, (Object) null);
        try {
            C0459wc.a().a(t2).a(t2, bArr, 0, i3, new Sa(rbVar));
            t2.i();
            if (t2.zzact == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzfi) {
                throw ((zzfi) e2.getCause());
            }
            throw new zzfi(e2.getMessage()).a(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzfi.a().a(t2);
        }
    }

    protected static <T extends Eb<T, ?>> T a(T t, byte[] bArr, C0428rb rbVar) throws zzfi {
        T a2 = a(t, bArr, 0, bArr.length, rbVar);
        if (a2 == null || a2.b()) {
            return a2;
        }
        throw new zzfi(new zzhq(a2).getMessage()).a(a2);
    }

    public final /* synthetic */ C0400mc a() {
        return (Eb) a(d.f4920f, (Object) null, (Object) null);
    }
}
