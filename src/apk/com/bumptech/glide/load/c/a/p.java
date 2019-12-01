package com.bumptech.glide.load.c.a;

import android.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ExifInterfaceImageHeaderParser */
public final class p implements ImageHeaderParser {
    public ImageType a(InputStream inputStream) throws IOException {
        return ImageType.UNKNOWN;
    }

    public ImageType a(ByteBuffer byteBuffer) throws IOException {
        return ImageType.UNKNOWN;
    }

    public int a(InputStream inputStream, b bVar) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }
}
