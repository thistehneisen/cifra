package io.intercom.okhttp3.internal.http;

import e.a.b.i;
import io.intercom.okhttp3.MediaType;
import io.intercom.okhttp3.ResponseBody;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final i source;

    public RealResponseBody(String str, long j2, i iVar) {
        this.contentTypeString = str;
        this.contentLength = j2;
        this.source = iVar;
    }

    public long contentLength() {
        return this.contentLength;
    }

    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public i source() {
        return this.source;
    }
}
