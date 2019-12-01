package kotlin.a;

import java.util.Iterator;
import kotlin.e.b.a.a;

/* compiled from: Iterators.kt */
public abstract class t implements Iterator<Integer>, a {
    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
