package io.fabric.sdk.android.services.network;

import java.io.InputStream;

/* compiled from: PinningInfoProvider */
public interface i {
    String getKeyStorePassword();

    InputStream getKeyStoreStream();

    long getPinCreationTimeInMillis();

    String[] getPins();
}
