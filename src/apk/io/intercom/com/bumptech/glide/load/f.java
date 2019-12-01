package io.intercom.com.bumptech.glide.load;

import io.intercom.com.bumptech.glide.load.c.a.s;
import io.intercom.com.bumptech.glide.load.e.a;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils */
public final class f {
    public static a a(List<e> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return a.UNKNOWN;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a a2 = ((e) list.get(i2)).a(byteBuffer);
            if (a2 != a.UNKNOWN) {
                return a2;
            }
        }
        return a.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    public static a b(List<e> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return a.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new s(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            try {
                a a2 = ((e) list.get(i2)).a(inputStream);
                if (a2 != a.UNKNOWN) {
                    inputStream.reset();
                    return a2;
                }
                inputStream.reset();
                i2++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return a.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    public static int a(List<e> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new s(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            try {
                int a2 = ((e) list.get(i2)).a(inputStream, bVar);
                if (a2 != -1) {
                    inputStream.reset();
                    return a2;
                }
                inputStream.reset();
                i2++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return -1;
    }
}
