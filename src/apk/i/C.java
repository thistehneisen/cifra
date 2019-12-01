package i;

import java.io.IOException;

/* compiled from: Interceptor */
public interface C {

    /* compiled from: Interceptor */
    public interface a {
        M a(J j2) throws IOException;

        int connectTimeoutMillis();

        int readTimeoutMillis();

        J request();

        int writeTimeoutMillis();
    }

    M a(a aVar) throws IOException;
}
