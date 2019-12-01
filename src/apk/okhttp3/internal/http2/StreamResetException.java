package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException {
    public final a errorCode;

    public StreamResetException(a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("stream was reset: ");
        sb.append(aVar);
        super(sb.toString());
        this.errorCode = aVar;
    }
}
