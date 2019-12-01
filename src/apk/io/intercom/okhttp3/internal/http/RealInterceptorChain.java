package io.intercom.okhttp3.internal.http;

import io.intercom.okhttp3.Call;
import io.intercom.okhttp3.Connection;
import io.intercom.okhttp3.EventListener;
import io.intercom.okhttp3.Interceptor;
import io.intercom.okhttp3.Interceptor.Chain;
import io.intercom.okhttp3.Request;
import io.intercom.okhttp3.Response;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.connection.RealConnection;
import io.intercom.okhttp3.internal.connection.StreamAllocation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RealInterceptorChain implements Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final HttpCodec httpCodec;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final StreamAllocation streamAllocation;
    private final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation2, HttpCodec httpCodec2, RealConnection realConnection, int i2, Request request2, Call call2, EventListener eventListener2, int i3, int i4, int i5) {
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation2;
        this.httpCodec = httpCodec2;
        this.index = i2;
        this.request = request2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.connectTimeout = i3;
        this.readTimeout = i4;
        this.writeTimeout = i5;
    }

    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public Connection connection() {
        return this.connection;
    }

    public EventListener eventListener() {
        return this.eventListener;
    }

    public HttpCodec httpStream() {
        return this.httpCodec;
    }

    public Response proceed(Request request2) throws IOException {
        return proceed(request2, this.streamAllocation, this.httpCodec, this.connection);
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public Request request() {
        return this.request;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public Chain withConnectTimeout(int i2, TimeUnit timeUnit) {
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, Util.checkDuration("timeout", (long) i2, timeUnit), this.readTimeout, this.writeTimeout);
        return realInterceptorChain;
    }

    public Chain withReadTimeout(int i2, TimeUnit timeUnit) {
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, Util.checkDuration("timeout", (long) i2, timeUnit), this.writeTimeout);
        return realInterceptorChain;
    }

    public Chain withWriteTimeout(int i2, TimeUnit timeUnit) {
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", (long) i2, timeUnit));
        return realInterceptorChain;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public Response proceed(Request request2, StreamAllocation streamAllocation2, HttpCodec httpCodec2, RealConnection realConnection) throws IOException {
        if (this.index < this.interceptors.size()) {
            this.calls++;
            String str = "network interceptor ";
            if (this.httpCodec == null || this.connection.supportsUrl(request2.url())) {
                String str2 = " must call proceed() exactly once";
                if (this.httpCodec == null || this.calls <= 1) {
                    RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation2, httpCodec2, realConnection, this.index + 1, request2, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
                    Interceptor interceptor = (Interceptor) this.interceptors.get(this.index);
                    Response intercept = interceptor.intercept(realInterceptorChain);
                    if (httpCodec2 == null || this.index + 1 >= this.interceptors.size() || realInterceptorChain.calls == 1) {
                        String str3 = "interceptor ";
                        if (intercept == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(interceptor);
                            sb.append(" returned null");
                            throw new NullPointerException(sb.toString());
                        } else if (intercept.body() != null) {
                            return intercept;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(interceptor);
                            sb2.append(" returned a response with no body");
                            throw new IllegalStateException(sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(interceptor);
                        sb3.append(str2);
                        throw new IllegalStateException(sb3.toString());
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(this.interceptors.get(this.index - 1));
                    sb4.append(str2);
                    throw new IllegalStateException(sb4.toString());
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(this.interceptors.get(this.index - 1));
                sb5.append(" must retain the same host and port");
                throw new IllegalStateException(sb5.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
