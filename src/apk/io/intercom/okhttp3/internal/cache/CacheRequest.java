package io.intercom.okhttp3.internal.cache;

import e.a.b.A;
import java.io.IOException;

public interface CacheRequest {
    void abort();

    A body() throws IOException;
}
