package io.intercom.retrofit2.converter.gson;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.o;
import io.intercom.okhttp3.ResponseBody;
import io.intercom.retrofit2.Converter;
import java.io.IOException;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final D<T> adapter;
    private final o gson;

    GsonResponseBodyConverter(o oVar, D<T> d2) {
        this.gson = oVar;
        this.adapter = d2;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        try {
            return this.adapter.a(this.gson.a(responseBody.charStream()));
        } finally {
            responseBody.close();
        }
    }
}
