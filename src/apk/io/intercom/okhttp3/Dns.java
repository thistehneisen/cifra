package io.intercom.okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface Dns {
    public static final Dns SYSTEM = new Dns() {
        public List<InetAddress> lookup(String str) throws UnknownHostException {
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
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
