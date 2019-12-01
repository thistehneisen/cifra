package ru.touchin.templates.b;

import i.D;
import i.L;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import retrofit2.e;
import ru.touchin.templates.ApiModel;

/* compiled from: JsonRequestBodyConverter */
public abstract class a<T> implements e<T, L> {

    /* renamed from: a reason: collision with root package name */
    private static final D f11189a = D.b("application/json; charset=UTF-8");

    /* access modifiers changed from: protected */
    public abstract void a(T t, ByteArrayOutputStream byteArrayOutputStream) throws IOException;

    public L convert(T t) throws IOException {
        if (t instanceof ApiModel) {
            ((ApiModel) t).a();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(t, byteArrayOutputStream);
        return L.a(f11189a, byteArrayOutputStream.toByteArray());
    }
}
