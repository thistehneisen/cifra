package io.intercom.okhttp3.internal.http2;

public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    
    public final int httpCode;

    private ErrorCode(int i2) {
        this.httpCode = i2;
    }

    public static ErrorCode fromHttp2(int i2) {
        ErrorCode[] values;
        for (ErrorCode errorCode : values()) {
            if (errorCode.httpCode == i2) {
                return errorCode;
            }
        }
        return null;
    }
}
