package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.services.network.HttpRequest.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* compiled from: HttpRequest */
class f implements b {
    f() {
    }

    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpURLConnection a(URL url, Proxy proxy) throws IOException {
        return (HttpURLConnection) url.openConnection(proxy);
    }
}
