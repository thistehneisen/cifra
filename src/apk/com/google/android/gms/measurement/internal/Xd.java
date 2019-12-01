package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class Xd extends SSLSocket {

    /* renamed from: a reason: collision with root package name */
    private final SSLSocket f5769a;

    Xd(Vd vd, SSLSocket sSLSocket) {
        this.f5769a = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f5769a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        this.f5769a.bind(socketAddress);
    }

    public final synchronized void close() throws IOException {
        this.f5769a.close();
    }

    public final void connect(SocketAddress socketAddress) throws IOException {
        this.f5769a.connect(socketAddress);
    }

    public final boolean equals(Object obj) {
        return this.f5769a.equals(obj);
    }

    public final SocketChannel getChannel() {
        return this.f5769a.getChannel();
    }

    public final boolean getEnableSessionCreation() {
        return this.f5769a.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites() {
        return this.f5769a.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols() {
        return this.f5769a.getEnabledProtocols();
    }

    public final InetAddress getInetAddress() {
        return this.f5769a.getInetAddress();
    }

    public final InputStream getInputStream() throws IOException {
        return this.f5769a.getInputStream();
    }

    public final boolean getKeepAlive() throws SocketException {
        return this.f5769a.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.f5769a.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.f5769a.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.f5769a.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth() {
        return this.f5769a.getNeedClientAuth();
    }

    public final boolean getOOBInline() throws SocketException {
        return this.f5769a.getOOBInline();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.f5769a.getOutputStream();
    }

    public final int getPort() {
        return this.f5769a.getPort();
    }

    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.f5769a.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.f5769a.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() throws SocketException {
        return this.f5769a.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() throws SocketException {
        return this.f5769a.getSendBufferSize();
    }

    public final SSLSession getSession() {
        return this.f5769a.getSession();
    }

    public final int getSoLinger() throws SocketException {
        return this.f5769a.getSoLinger();
    }

    public final synchronized int getSoTimeout() throws SocketException {
        return this.f5769a.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f5769a.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols() {
        return this.f5769a.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay() throws SocketException {
        return this.f5769a.getTcpNoDelay();
    }

    public final int getTrafficClass() throws SocketException {
        return this.f5769a.getTrafficClass();
    }

    public final boolean getUseClientMode() {
        return this.f5769a.getUseClientMode();
    }

    public final boolean getWantClientAuth() {
        return this.f5769a.getWantClientAuth();
    }

    public final boolean isBound() {
        return this.f5769a.isBound();
    }

    public final boolean isClosed() {
        return this.f5769a.isClosed();
    }

    public final boolean isConnected() {
        return this.f5769a.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.f5769a.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.f5769a.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f5769a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void sendUrgentData(int i2) throws IOException {
        this.f5769a.sendUrgentData(i2);
    }

    public final void setEnableSessionCreation(boolean z) {
        this.f5769a.setEnableSessionCreation(z);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.f5769a.setEnabledCipherSuites(strArr);
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null) {
            String str = "SSLv3";
            if (Arrays.asList(strArr).contains(str)) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f5769a.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove(str);
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        this.f5769a.setEnabledProtocols(strArr);
    }

    public final void setKeepAlive(boolean z) throws SocketException {
        this.f5769a.setKeepAlive(z);
    }

    public final void setNeedClientAuth(boolean z) {
        this.f5769a.setNeedClientAuth(z);
    }

    public final void setOOBInline(boolean z) throws SocketException {
        this.f5769a.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i2, int i3, int i4) {
        this.f5769a.setPerformancePreferences(i2, i3, i4);
    }

    public final synchronized void setReceiveBufferSize(int i2) throws SocketException {
        this.f5769a.setReceiveBufferSize(i2);
    }

    public final void setReuseAddress(boolean z) throws SocketException {
        this.f5769a.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i2) throws SocketException {
        this.f5769a.setSendBufferSize(i2);
    }

    public final void setSoLinger(boolean z, int i2) throws SocketException {
        this.f5769a.setSoLinger(z, i2);
    }

    public final synchronized void setSoTimeout(int i2) throws SocketException {
        this.f5769a.setSoTimeout(i2);
    }

    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.f5769a.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i2) throws SocketException {
        this.f5769a.setTrafficClass(i2);
    }

    public final void setUseClientMode(boolean z) {
        this.f5769a.setUseClientMode(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.f5769a.setWantClientAuth(z);
    }

    public final void shutdownInput() throws IOException {
        this.f5769a.shutdownInput();
    }

    public final void shutdownOutput() throws IOException {
        this.f5769a.shutdownOutput();
    }

    public final void startHandshake() throws IOException {
        this.f5769a.startHandshake();
    }

    public final String toString() {
        return this.f5769a.toString();
    }

    public final void connect(SocketAddress socketAddress, int i2) throws IOException {
        this.f5769a.connect(socketAddress, i2);
    }
}
