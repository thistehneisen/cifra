package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.load.b.i.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader */
class k implements d<InputStream> {
    k() {
    }

    public InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
