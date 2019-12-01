package io.intercom.retrofit2.converter.gson;

import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import io.intercom.okhttp3.RequestBody;
import io.intercom.okhttp3.ResponseBody;
import io.intercom.retrofit2.Converter;
import io.intercom.retrofit2.Converter.Factory;
import io.intercom.retrofit2.Retrofit;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class GsonConverterFactory extends Factory {
    private final o gson;

    private GsonConverterFactory(o oVar) {
        this.gson = oVar;
    }

    public static GsonConverterFactory create() {
        return create(new o());
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.a(a.a(type)));
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.a(a.a(type)));
    }

    public static GsonConverterFactory create(o oVar) {
        if (oVar != null) {
            return new GsonConverterFactory(oVar);
        }
        throw new NullPointerException("gson == null");
    }
}
