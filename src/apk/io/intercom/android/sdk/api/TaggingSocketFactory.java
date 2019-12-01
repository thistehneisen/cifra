package io.intercom.android.sdk.api;

import android.net.TrafficStats;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

public class TaggingSocketFactory extends SocketFactory {
    private final SocketFactory defaultFactory;
    private final int threadStatsTag;

    public TaggingSocketFactory(SocketFactory socketFactory, int i2) {
        this.defaultFactory = socketFactory;
        this.threadStatsTag = i2;
    }

    private Socket withTag(Socket socket) throws IOException {
        TrafficStats.setThreadStatsTag(this.threadStatsTag);
        return socket;
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.defaultFactory.createSocket();
        withTag(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.defaultFactory.createSocket(str, i2);
        withTag(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        Socket createSocket = this.defaultFactory.createSocket(str, i2, inetAddress, i3);
        withTag(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.defaultFactory.createSocket(inetAddress, i2);
        withTag(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        Socket createSocket = this.defaultFactory.createSocket(inetAddress, i2, inetAddress2, i3);
        withTag(createSocket);
        return createSocket;
    }
}
