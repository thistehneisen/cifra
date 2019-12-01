package okhttp3.internal.connection;

import i.C0727p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector */
final class c {

    /* renamed from: a reason: collision with root package name */
    private final List<C0727p> f10456a;

    /* renamed from: b reason: collision with root package name */
    private int f10457b = 0;

    /* renamed from: c reason: collision with root package name */
    private boolean f10458c;

    /* renamed from: d reason: collision with root package name */
    private boolean f10459d;

    c(List<C0727p> list) {
        this.f10456a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.f10457b; i2 < this.f10456a.size(); i2++) {
            if (((C0727p) this.f10456a.get(i2)).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public C0727p a(SSLSocket sSLSocket) throws IOException {
        C0727p pVar;
        int i2 = this.f10457b;
        int size = this.f10456a.size();
        while (true) {
            if (i2 >= size) {
                pVar = null;
                break;
            }
            pVar = (C0727p) this.f10456a.get(i2);
            if (pVar.a(sSLSocket)) {
                this.f10457b = i2 + 1;
                break;
            }
            i2++;
        }
        if (pVar != null) {
            this.f10458c = b(sSLSocket);
            i.a.c.f8601a.a(pVar, sSLSocket, this.f10459d);
            return pVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f10459d);
        sb.append(", modes=");
        sb.append(this.f10456a);
        sb.append(", supported protocols=");
        sb.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public boolean a(IOException iOException) {
        this.f10459d = true;
        if (!this.f10458c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return iOException instanceof SSLException;
        }
        return false;
    }
}
