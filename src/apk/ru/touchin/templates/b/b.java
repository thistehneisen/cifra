package ru.touchin.templates.b;

import i.O;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.util.Collection;
import java.util.Map;
import javax.net.ssl.SSLException;
import l.a.d.b.a.c;
import okhttp3.internal.http2.StreamResetException;
import retrofit2.e;
import ru.touchin.templates.ApiModel;
import ru.touchin.templates.ApiModel.ValidationException;
import ru.touchin.templates.ApiModel.a;

/* compiled from: JsonResponseBodyConverter */
public abstract class b<T> implements e<O, T> {
    /* renamed from: a */
    public T convert(O o) throws IOException {
        try {
            T b2 = b(o);
            o.close();
            if (b2 instanceof ApiModel) {
                a((ApiModel) b2);
            }
            if (b2 instanceof Collection) {
                a((Collection) b2);
            }
            if (b2 instanceof Map) {
                a(((Map) b2).values());
            }
            return b2;
        } catch (IOException e2) {
            if (!(e2 instanceof SocketException) && !(e2 instanceof InterruptedIOException) && !(e2 instanceof SSLException) && !(e2 instanceof StreamResetException)) {
                c.a((Throwable) e2);
            }
            throw e2;
        } catch (Throwable th) {
            o.close();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T b(O o) throws IOException;

    private void a(ApiModel apiModel) throws IOException {
        try {
            apiModel.a();
        } catch (ValidationException e2) {
            c.a((Throwable) e2);
            throw e2;
        }
    }

    private void a(Collection collection) throws IOException {
        try {
            ApiModel.a(collection, a());
        } catch (ValidationException e2) {
            c.a((Throwable) e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public a a() {
        return a.EXCEPTION_IF_ANY_INVALID;
    }
}
