package io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
public final class h {
    public static final SSLSocketFactory a(i iVar) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{new j(new k(iVar.getKeyStoreStream(), iVar.getKeyStorePassword()), iVar)}, null);
        return instance.getSocketFactory();
    }
}
