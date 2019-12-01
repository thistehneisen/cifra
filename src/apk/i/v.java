package i;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns */
public interface v {

    /* renamed from: a reason: collision with root package name */
    public static final v f8768a = C0714c.f8669a;

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
