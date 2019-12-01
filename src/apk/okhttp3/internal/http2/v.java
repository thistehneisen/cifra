package okhttp3.internal.http2;

import j.h;
import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver */
public interface v {

    /* renamed from: a reason: collision with root package name */
    public static final v f10684a = new u();

    void a(int i2, a aVar);

    boolean a(int i2, h hVar, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, List<b> list, boolean z);

    boolean onRequest(int i2, List<b> list);
}
