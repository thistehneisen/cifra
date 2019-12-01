package i.a.b;

import i.B;
import i.J;
import java.net.Proxy.Type;

/* compiled from: RequestLine */
public final class j {
    public static String a(J j2, Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(j2.e());
        sb.append(' ');
        if (b(j2, type)) {
            sb.append(j2.g());
        } else {
            sb.append(a(j2.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(J j2, Type type) {
        return !j2.d() && type == Type.HTTP;
    }

    public static String a(B b2) {
        String c2 = b2.c();
        String e2 = b2.e();
        if (e2 == null) {
            return c2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        sb.append('?');
        sb.append(e2);
        return sb.toString();
    }
}
