package e.a.b;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio */
class s extends C0709c {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Socket f7909a;

    s(Socket socket) {
        this.f7909a = socket;
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        String str = "Failed to close timed out socket ";
        try {
            this.f7909a.close();
        } catch (Exception e2) {
            Logger logger = t.f7910a;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f7909a);
            logger.log(level, sb.toString(), e2);
        } catch (AssertionError e3) {
            if (t.a(e3)) {
                Logger logger2 = t.f7910a;
                Level level2 = Level.WARNING;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f7909a);
                logger2.log(level2, sb2.toString(), e3);
                return;
            }
            throw e3;
        }
    }
}
