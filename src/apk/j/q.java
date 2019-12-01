package j;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio */
class q extends C0790c {

    /* renamed from: k reason: collision with root package name */
    final /* synthetic */ Socket f10271k;

    q(Socket socket) {
        this.f10271k = socket;
    }

    /* access modifiers changed from: protected */
    public IOException b(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public void j() {
        String str = "Failed to close timed out socket ";
        try {
            this.f10271k.close();
        } catch (Exception e2) {
            Logger logger = r.f10272a;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f10271k);
            logger.log(level, sb.toString(), e2);
        } catch (AssertionError e3) {
            if (r.a(e3)) {
                Logger logger2 = r.f10272a;
                Level level2 = Level.WARNING;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f10271k);
                logger2.log(level2, sb2.toString(), e3);
                return;
            }
            throw e3;
        }
    }
}
