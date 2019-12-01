package io.intercom.okhttp3;

import e.a.b.j;

public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i2, String str);

    long queueSize();

    Request request();

    boolean send(j jVar);

    boolean send(String str);
}
