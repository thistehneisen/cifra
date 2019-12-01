package e.b.h;

import e.b.e;
import e.b.f;

/* compiled from: FlowableProcessor */
public abstract class a<T> extends e<T> implements k.a.a<T, T>, f<T> {
    public final a<T> g() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
