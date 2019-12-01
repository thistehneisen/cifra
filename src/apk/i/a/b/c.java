package i.a.b;

import i.J;
import i.M;
import i.M.a;
import j.A;
import j.z;
import java.io.IOException;
import okhttp3.internal.connection.f;

/* compiled from: ExchangeCodec */
public interface c {
    A a(M m) throws IOException;

    z a(J j2, long j3) throws IOException;

    void a(J j2) throws IOException;

    long b(M m) throws IOException;

    void cancel();

    f connection();

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    a readResponseHeaders(boolean z) throws IOException;
}
