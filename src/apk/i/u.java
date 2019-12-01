package i;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Dns */
public final /* synthetic */ class u {
    public static /* synthetic */ List a(String str) throws UnknownHostException {
        if (str != null) {
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Broken system behaviour for dns lookup of ");
                sb.append(str);
                UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
                unknownHostException.initCause(e2);
                throw unknownHostException;
            }
        } else {
            throw new UnknownHostException("hostname == null");
        }
    }
}
