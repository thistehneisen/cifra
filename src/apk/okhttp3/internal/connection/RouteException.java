package okhttp3.internal.connection;

import i.a.e;
import java.io.IOException;

public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public IOException a() {
        return this.firstException;
    }

    public IOException b() {
        return this.lastException;
    }

    /* access modifiers changed from: 0000 */
    public void a(IOException iOException) {
        e.a((Throwable) this.firstException, (Throwable) iOException);
        this.lastException = iOException;
    }
}
