package retrofit2;

import java.io.IOException;

/* compiled from: Call */
public interface b<T> extends Cloneable {
    void a(d<T> dVar);

    void cancel();

    b<T> clone();

    u<T> execute() throws IOException;

    boolean isCanceled();
}
