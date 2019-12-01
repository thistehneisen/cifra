package i;

import java.io.IOException;

/* renamed from: i.j reason: case insensitive filesystem */
/* compiled from: Call */
public interface C0721j extends Cloneable {

    /* renamed from: i.j$a */
    /* compiled from: Call */
    public interface a {
        C0721j a(J j2);
    }

    void a(C0722k kVar);

    void cancel();

    M execute() throws IOException;

    boolean isCanceled();
}
