package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.c.a.t;
import com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils */
public final class e {
    public static ImageType a(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageType a2 = ((ImageHeaderParser) list.get(i2)).a(byteBuffer);
            if (a2 != ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageType.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    public static ImageType b(List<ImageHeaderParser> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new t(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int i2 = 0;
        int size = list.size();
        while (i2 < size) {
            try {
                ImageType a2 = ((ImageHeaderParser) list.get(i2)).a(inputStream);
                if (a2 != ImageType.UNKNOWN) {
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
        return ImageType.UNKNOWN;
    }

    /* JADX INFO: finally extract failed */
    public static int a(List<ImageHeaderParser> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new t(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int i2 = 0;
        int size = list.size();
        while (i2 < size) {
            try {
                int a2 = ((ImageHeaderParser) list.get(i2)).a(inputStream, bVar);
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
