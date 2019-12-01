package kotlin.e.b;

import java.io.Serializable;

/* compiled from: Lambda.kt */
public abstract class i<R> implements f<R>, Serializable {
    private final int arity;

    public i(int i2) {
        this.arity = i2;
    }

    public String toString() {
        String a2 = o.a(this);
        h.a((Object) a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
