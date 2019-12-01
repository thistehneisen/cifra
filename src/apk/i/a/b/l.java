package i.a.b;

import i.H;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: StatusLine */
public final class l {

    /* renamed from: a reason: collision with root package name */
    public final H f8598a;

    /* renamed from: b reason: collision with root package name */
    public final int f8599b;

    /* renamed from: c reason: collision with root package name */
    public final String f8600c;

    public l(H h2, int i2, String str) {
        this.f8598a = h2;
        this.f8599b = i2;
        this.f8600c = str;
    }

    public static l a(String str) throws IOException {
        H h2;
        String str2;
        int i2 = 9;
        String str3 = "Unexpected status line: ";
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                throw new ProtocolException(sb.toString());
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                h2 = H.HTTP_1_0;
            } else if (charAt == 1) {
                h2 = H.HTTP_1_1;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str);
                throw new ProtocolException(sb2.toString());
            }
        } else if (str.startsWith("ICY ")) {
            h2 = H.HTTP_1_0;
            i2 = 4;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str);
            throw new ProtocolException(sb3.toString());
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str3);
                    sb4.append(str);
                    throw new ProtocolException(sb4.toString());
                }
                return new l(h2, parseInt, str2);
            } catch (NumberFormatException unused) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str3);
                sb5.append(str);
                throw new ProtocolException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str3);
            sb6.append(str);
            throw new ProtocolException(sb6.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8598a == H.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f8599b);
        if (this.f8600c != null) {
            sb.append(' ');
            sb.append(this.f8600c);
        }
        return sb.toString();
    }
}
