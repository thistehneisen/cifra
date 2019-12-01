package io.intercom.okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public interface Interceptor {

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i2, TimeUnit timeUnit);

        Chain withReadTimeout(int i2, TimeUnit timeUnit);

        Chain withWriteTimeout(int i2, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;
}
