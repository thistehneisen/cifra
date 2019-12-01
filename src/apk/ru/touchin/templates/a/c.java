package ru.touchin.templates.a;

import com.bluelinelabs.logansquare.ConverterUtils;
import com.bluelinelabs.logansquare.LoganSquare;
import i.L;
import i.O;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import retrofit2.e;
import retrofit2.w;

/* compiled from: LoganSquareJsonFactory */
public class c extends retrofit2.e.a {

    /* compiled from: LoganSquareJsonFactory */
    public static class a<T> extends ru.touchin.templates.b.b<T> {

        /* renamed from: a reason: collision with root package name */
        private final Type f11181a;

        public a(Type type) {
            this.f11181a = type;
        }

        /* access modifiers changed from: protected */
        public T b(O o) throws IOException {
            Type type = this.f11181a;
            if (!(type instanceof ParameterizedType)) {
                return LoganSquare.parse(o.a(), (Class) this.f11181a);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type type2 = actualTypeArguments[0];
            Type rawType = parameterizedType.getRawType();
            if (rawType == Map.class) {
                return LoganSquare.parseMap(o.a(), (Class) actualTypeArguments[1]);
            }
            if (rawType == List.class) {
                return LoganSquare.parseList(o.a(), (Class) type2);
            }
            return LoganSquare.parse(o.a(), ConverterUtils.parameterizedTypeOf(this.f11181a));
        }
    }

    /* compiled from: LoganSquareJsonFactory */
    public static class b<T> extends ru.touchin.templates.b.a<T> {
        /* access modifiers changed from: protected */
        public void a(T t, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            LoganSquare.serialize(t, (OutputStream) byteArrayOutputStream);
        }
    }

    /* renamed from: ru.touchin.templates.a.c$c reason: collision with other inner class name */
    /* compiled from: LoganSquareJsonFactory */
    public static class C0133c<T> implements e<T, String> {
        public String convert(T t) throws IOException {
            StringWriter stringWriter = new StringWriter();
            try {
                com.fasterxml.jackson.core.c a2 = LoganSquare.JSON_FACTORY.a((Writer) stringWriter);
                LoganSquare.typeConverterFor(t.getClass()).serialize(t, null, false, a2);
                a2.close();
                return stringWriter.toString().replaceAll("\"", "");
            } finally {
                stringWriter.close();
            }
        }
    }

    public e<O, ?> a(Type type, Annotation[] annotationArr, w wVar) {
        return new a(type);
    }

    public e<?, String> b(Type type, Annotation[] annotationArr, w wVar) {
        if (!(type instanceof Class) || ((Class) type).getSuperclass() != Enum.class) {
            return super.b(type, annotationArr, wVar);
        }
        return new C0133c();
    }

    public e<?, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, w wVar) {
        return new b();
    }
}
