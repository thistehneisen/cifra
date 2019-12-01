package com.touchin.vtb.api.exceptions;

import com.touchin.vtb.api.ApiError;
import com.touchin.vtb.api.BaseResponse;
import java.io.IOException;
import kotlin.e.b.h;

/* compiled from: ServerException.kt */
public class ServerException extends IOException {
    private final ApiError apiError;

    public ServerException(BaseResponse<?> baseResponse) {
        h.b(baseResponse, "baseResponse");
        super(baseResponse.c());
        ApiError b2 = baseResponse.b();
        h.a((Object) b2, "baseResponse.errorCode");
        this.apiError = b2;
    }

    public final ApiError a() {
        return this.apiError;
    }
}
