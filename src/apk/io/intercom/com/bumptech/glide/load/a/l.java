package io.intercom.com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher */
public class l extends a<InputStream> {
    public l(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* access modifiers changed from: protected */
    public InputStream a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* access modifiers changed from: protected */
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
