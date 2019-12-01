package i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TlsVersion */
public enum Q {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String javaName;

    private Q(String str) {
        this.javaName = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    public static Q a(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != 79201641) {
            if (hashCode != 79923350) {
                switch (hashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            c2 = 2;
                            break;
                        }
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            c2 = 1;
                            break;
                        }
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            c2 = 0;
                            break;
                        }
                }
            } else if (str.equals("TLSv1")) {
                c2 = 3;
                if (c2 == 0) {
                    return TLS_1_3;
                }
                if (c2 == 1) {
                    return TLS_1_2;
                }
                if (c2 == 2) {
                    return TLS_1_1;
                }
                if (c2 == 3) {
                    return TLS_1_0;
                }
                if (c2 == 4) {
                    return SSL_3_0;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected TLS version: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        } else if (str.equals("SSLv3")) {
            c2 = 4;
            if (c2 == 0) {
            }
        }
        c2 = 65535;
        if (c2 == 0) {
        }
    }

    static List<Q> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a2 : strArr) {
            arrayList.add(a(a2));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
