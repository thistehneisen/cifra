package io.intercom.retrofit2.converter.gson;

import e.a.b.g;
import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.d;
import io.intercom.okhttp3.MediaType;
import io.intercom.okhttp3.RequestBody;
import io.intercom.retrofit2.Converter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final D<T> adapter;
    private final o gson;

    GsonRequestBodyConverter(o oVar, D<T> d2) {
        this.gson = oVar;
        this.adapter = d2;
    }

    public RequestBody convert(T t) throws IOException {
        g gVar = new g();
        d a2 = this.gson.a((Writer) new OutputStreamWriter(gVar.c(), UTF_8));
        this.adapter.a(a2, t);
        a2.close();
        return RequestBody.create(MEDIA_TYPE, gVar.d());
    }
}
