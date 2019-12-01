package io.intercom.com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Http request failed with status code: ");
        sb.append(i2);
        this(sb.toString(), i2);
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i2) {
        this(str, i2, null);
    }

    public HttpException(String str, int i2, Throwable th) {
        super(str, th);
        this.statusCode = i2;
    }
}
