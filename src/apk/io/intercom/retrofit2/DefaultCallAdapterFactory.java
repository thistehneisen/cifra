package io.intercom.retrofit2;

import io.intercom.retrofit2.CallAdapter.Factory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class DefaultCallAdapterFactory extends Factory {
    static final Factory INSTANCE = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Factory.getRawType(type) != Call.class) {
            return null;
        }
        final Type callResponseType = Utils.getCallResponseType(type);
        return new CallAdapter<Object, Call<?>>() {
            public Call<Object> adapt(Call<Object> call) {
                return call;
            }

            public Type responseType() {
                return callResponseType;
            }
        };
    }
}
