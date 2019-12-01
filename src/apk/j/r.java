package j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class r {

    /* renamed from: a reason: collision with root package name */
    static final Logger f10272a = Logger.getLogger(r.class.getName());

    private r() {
    }

    public static h a(A a2) {
        return new v(a2);
    }

    public static A b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C0790c c2 = c(socket);
            return c2.a(a(socket.getInputStream(), (C) c2));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static C0790c c(Socket socket) {
        return new q(socket);
    }

    public static g a(z zVar) {
        return new t(zVar);
    }

    private static z a(OutputStream outputStream, C c2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (c2 != null) {
            return new o(c2, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static z a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C0790c c2 = c(socket);
            return c2.a(a(socket.getOutputStream(), (C) c2));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static A a(InputStream inputStream) {
        return a(inputStream, new C());
    }

    private static A a(InputStream inputStream, C c2) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (c2 != null) {
            return new p(c2, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
