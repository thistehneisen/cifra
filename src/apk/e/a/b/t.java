package e.a.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class t {

    /* renamed from: a reason: collision with root package name */
    static final Logger f7910a = Logger.getLogger(t.class.getName());

    private t() {
    }

    public static i a(B b2) {
        return new w(b2);
    }

    public static A b(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static B c(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static h a(A a2) {
        return new u(a2);
    }

    public static A a(OutputStream outputStream) {
        return a(outputStream, new D());
    }

    public static B b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C0709c c2 = c(socket);
            return c2.source(a(socket.getInputStream(), (D) c2));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static C0709c c(Socket socket) {
        return new s(socket);
    }

    private static A a(OutputStream outputStream, D d2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (d2 != null) {
            return new p(d2, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static A a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C0709c c2 = c(socket);
            return c2.sink(a(socket.getOutputStream(), (D) c2));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static B a(InputStream inputStream) {
        return a(inputStream, new D());
    }

    private static B a(InputStream inputStream, D d2) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (d2 != null) {
            return new q(d2, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static A a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static A a() {
        return new r();
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
