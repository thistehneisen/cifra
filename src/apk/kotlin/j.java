package kotlin;

import java.io.Serializable;
import kotlin.e.a.a;
import kotlin.e.b.h;

/* compiled from: LazyJVM.kt */
final class j<T> implements c<T>, Serializable {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public j(a<? extends T> aVar, Object obj) {
        h.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = l.f10345a;
        if (obj == 0) {
            obj = this;
        }
        this.lock = obj;
    }

    private final Object writeReplace() {
        return new b(getValue());
    }

    public boolean a() {
        return this._value != l.f10345a;
    }

    public T getValue() {
        T t;
        T t2 = this._value;
        if (t2 != l.f10345a) {
            return t2;
        }
        synchronized (this.lock) {
            t = this._value;
            if (t == l.f10345a) {
                a<? extends T> aVar = this.initializer;
                if (aVar != null) {
                    t = aVar.b();
                    this._value = t;
                    this.initializer = null;
                } else {
                    h.a();
                    throw null;
                }
            }
        }
        return t;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ j(a aVar, Object obj, int i2, e eVar) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        this(aVar, obj);
    }
}
