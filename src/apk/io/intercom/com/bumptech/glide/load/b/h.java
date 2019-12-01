package io.intercom.com.bumptech.glide.load.b;

import android.util.Base64;
import io.intercom.com.bumptech.glide.load.b.g.a;
import io.intercom.com.bumptech.glide.load.b.g.c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader */
class h implements a<InputStream> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f9510a;

    h(c cVar) {
        this.f9510a = cVar;
    }

    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public InputStream decode(String str) {
        if (str.startsWith("data:image")) {
            int indexOf = str.indexOf(44);
            if (indexOf == -1) {
                throw new IllegalArgumentException("Missing comma in data URL.");
            } else if (str.substring(0, indexOf).endsWith(";base64")) {
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            } else {
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        } else {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
